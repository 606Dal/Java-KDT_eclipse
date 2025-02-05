package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.zerock.dto.TodoAddDTO;
import org.zerock.dto.TodoListDTO;

import lombok.Cleanup;

public enum TodoDAO {

	INSTANCE;

	// bad code
	public String makeConnection() throws Exception {

		// db 연결
		// 수동으로 치지말고 복사하는 게 제일 좋음.
		// Class.forName("org.mariadb.jdbc.Driver");

		// (JDBC URL, 계정, 패스워드) // close 중요함.
		/*
		 * @Cleanup Connection conn = DriverManager.getConnection(
		 * "jdbc:mariadb://localhost:포트번호/webdb" ,"계정" ,"비번");
		 * //System.out.println(conn); // 연결 확인 용
		 */
		@Cleanup
		Connection conn = ConnectionUtil.INSTANCE.getConnection();

		System.out.println(conn);

		@Cleanup
		PreparedStatement pstmt = conn.prepareStatement("select now()"); // 문자열 ; 세미콜론 없도록 주의.

		@Cleanup
		ResultSet resultSet = pstmt.executeQuery();

		resultSet.next();

		return resultSet.getString(1);
	}

	public void insert(TodoAddDTO todoAddDTO) throws Exception {

		// 마지막에 ";" 안에 안 들어가게 주의.
		// 내부적으로는 ?가 변수로 :v1 :v2 이렇게 이 함수의 파라미터가 됨.
		String sql = "insert into tbl_todo (title, writer) values (?,?)";

		@Cleanup
		Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup
		PreparedStatement pstmt = conn.prepareStatement(sql);
		// 얘는 1부터 시작.
		pstmt.setString(1, todoAddDTO.getTitle());
		pstmt.setString(2, todoAddDTO.getWriter());

		// DML - insert, update, delete 결과가 몇 개의 행이 영향을 받았는지 int 값이 나옴
		int count = pstmt.executeUpdate();
		// 정상적인 경우 1이 나옴
		if (count != 1) {
			throw new Exception("INSERT PROBLEM NOT 1");
		}

		// 원래는 클로즈 다 들어감.

	}

	// 목록 출력 _ 페이징 처리
	public List<TodoListDTO> list(int page) throws Exception {
		// 내부의 마지막에 ; 있으면 안 됨.
		String query = """
				select
					tno, title, writer, regDate
				from
					tbl_todo
				where
					tno > 0
				order by
					tno desc
				limit 10 OFFSET ? """;
				//limit 10 OFFSET """ + (page -1) * 10;
		
		@Cleanup
		Connection conn = ConnectionUtil.INSTANCE.getConnection();
		@Cleanup
		PreparedStatement pstmt = conn.prepareStatement(query);
		// DB에는 SQL 컴파일이 완료된 후 전달한 값을 파라미터 화 함.
		// 얘는 미리 준비를 해주기 때문에 뒤에 값이 자꾸 변경되도 빠르게 실행이 됨.
		pstmt.setInt(1, (page -1) * 10); // ? 물음표에 값을 보냄.
		
		@Cleanup
		ResultSet rs = pstmt.executeQuery();
		
		List<TodoListDTO> list = new ArrayList<TodoListDTO>();
		
		/*
		 * ** 중요한 부분 - ResultSet을 하면 메타데이터가 먼저 나옴. 그래서 while의 시작이 rs.next().
		 * 메타데이터부분(컬럼)은 while 안 돌리고 내용물만
		 * rs.next() 하면 반환값이 true/false. next를 하면 커서가 한 row씩 옮겨가며 나옴. db의 한 행이 한 뭉텅이.
		 * next 하다가 가져올 내용이 없으면 false 나오면서 종료.
		 */
		while(rs.next()) {
			//int tno = rs.getInt(1); // 0은 메타데이터. int로 받아도 되고 스트링으로 받아도 됨.
			//위에 대신 빌더 사용함 => 변수를 덜 만들어도 됨.
			TodoListDTO dto = TodoListDTO.builder()
					.tno(rs.getInt("tno"))
					.title(rs.getString("title"))
					.writer(rs.getString("writer"))
					.regDate(rs.getTimestamp("regDate").toLocalDateTime())
					.build();
			// regDate는 localDateTime으로 가져와야 함.
					
			list.add(dto); // 만들어진 객체를 담음.
		} //end while
		
		
		return list;
	}

}
