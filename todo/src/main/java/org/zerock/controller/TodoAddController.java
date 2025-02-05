package org.zerock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import org.zerock.dto.TodoAddDTO;
import org.zerock.service.TodoSercive;

/**
 * Servlet implementation class TodoAddController
 */
@WebServlet("/todo/add")
public class TodoAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/todo/add.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TodoAddController dopost..............");
		
		// 전달되는 모든 데이터 인코딩 처리 한글 처리용
		request.setCharacterEncoding("UTF-8");
		
		// request 는 InputStream(Read) 용도
		String tilteStr = request.getParameter("title");
		String writerStr = request.getParameter("writer");
		
		System.out.println("title: " + tilteStr);
		System.out.println("writer: " + writerStr);
		
		TodoAddDTO addDTO = new TodoAddDTO();
		addDTO.setTitle(tilteStr);
		addDTO.setWriter(writerStr);
		
		System.out.println("addDTO: " + addDTO);
		// 일단 이걸로 처리.
		try {
			TodoSercive.INSTANCE.add(addDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// /todo/list 경로로 브라우저에게 이동하라고 명령.
		response.sendRedirect("/todo/list?result=add");
	}

}
