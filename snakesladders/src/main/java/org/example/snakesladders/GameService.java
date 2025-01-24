package org.example.snakesladders;

import java.util.ArrayList;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class GameService {

	private int playerPosition;
	private ArrayList<Tile> tiles;
	private Tile currentTile;

	public GameService() {
		this.playerPosition = 1; // 1번 타일에서 시작.
		setupTile();
		currentTile = tiles.get(0);
	}

	private void setupTile() {

		tiles = new ArrayList<Tile>();
		// 타일 100개 생성
		for (int i = 1; i <= 100; i++) {
			tiles.add(new Tile(i));
		}

		// 사다리
		tiles.get(3).setDesc(" 12 - 노인에게 길을 비켜주어 노인에게 칭찬받았다.");
		tiles.get(3).setType("사다리");
		tiles.get(3).setMoving(12);

		tiles.get(17).setDesc(" 20 - 나무를 심어서 후에 숲을 만들었다.");
		tiles.get(17).setType("사다리");
		tiles.get(17).setMoving(20);

		tiles.get(19).setDesc(" 54 - 경찰에게 범죄자가 있다고 신고한 뒤 표창장을 받았다.");
		tiles.get(19).setType("사다리");
		tiles.get(19).setMoving(54);

		tiles.get(23).setDesc(" 12 - 환자를 치료하는 연습을 한 뒤 의사가 되었다.");
		tiles.get(23).setType("사다리");
		tiles.get(23).setMoving(12);

		tiles.get(31).setDesc(" 24 - 공부를 열심히 해서 좋은 대학에 진학해 졸업했다.");
		tiles.get(31).setType("사다리");
		tiles.get(31).setMoving(24);

		tiles.get(33).setDesc(" 12 - 열심히 일하여 후에 큰돈을 모았다.");
		tiles.get(33).setType("사다리");
		tiles.get(33).setMoving(12);

		tiles.get(39).setDesc(" 20 - 닭에게 모이를 줘서 달걀을 많이 얻었다.");
		tiles.get(39).setType("사다리");
		tiles.get(39).setMoving(20);

		tiles.get(69).setDesc(" 18 - 농사를 열심히 지어서 많은 작물을 얻었다.");
		tiles.get(69).setType("사다리");
		tiles.get(69).setMoving(18);

		tiles.get(79).setDesc(" 20 - 달리기에서 1등을 했다.");
		tiles.get(79).setType("사다리");
		tiles.get(79).setMoving(20);

		// 뱀
		tiles.get(21).setDesc(" 20 - 스케이트를 지정 장소가 아닌 언 호수에서 타다가 얼음이 깨져 빠졌다.");
		tiles.get(21).setType("뱀");
		tiles.get(21).setMoving(20);

		tiles.get(43).setDesc(" 18 - 개를 발로 찼다가 개한테 쫓기게 된다(...).");
		tiles.get(43).setType("뱀");
		tiles.get(43).setMoving(18);

		tiles.get(67).setDesc(" 16 - 과식해서 배탈이 났다.");
		tiles.get(67).setType("뱀");
		tiles.get(67).setMoving(16);

		tiles.get(83).setDesc(" 22 - 기찻길에서 놀다가 기차에 치일 위기에 처한다.");
		tiles.get(83).setType("뱀");
		tiles.get(83).setMoving(22);

		tiles.get(93).setDesc(" 30 - 지푸라기에 불을 붙이는 불장난을 하는 바람에 화재가 났다.");
		tiles.get(93).setType("뱀");
		tiles.get(93).setMoving(30);

		tiles.get(95).setDesc(" 14 - 나무를 너무 많이 베어서 홍수가 나 휩쓸린다.");
		tiles.get(95).setType("뱀");
		tiles.get(95).setMoving(14);

	} // end setupTile()

	// 주사위 던지기 메서드
	public int rollDice() {
		log.info("rollDice() 호출...");
		return (int) (Math.random() * 6) + 1;
	}

	// 플레이어 이동
	public int movePlayer(int diceValue) {
		log.info("movePlayer() 호출...");
		
		playerPosition += diceValue;
		if (playerPosition > 100) {
			playerPosition = 100;
		}

		// 타일 정보에 desc가 있다면 다른 곳으로 이동
		if (currentTile.getDesc() != null) {

			int moving = currentTile.getMoving();
			String type = currentTile.getType();

			if (type.equals("사다리")) {
				playerPosition = playerPosition + moving;
			} else {
				playerPosition = playerPosition - moving;
			}
		} //end if
		
		log.info("playerPosition : " + playerPosition);
		return playerPosition;
	} //movePlayer()

	public Tile getCurrentTile() {
		currentTile = tiles.get(playerPosition - 1); // 타일의 index랑 맞추기 위해 -1
		return currentTile;
	}

	public int getPlayerPosition() {
		return playerPosition;
	}

}
