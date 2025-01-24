package org.example.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

import org.example.snakesladders.GameService;
import org.example.snakesladders.Tile;

/**
 * Servlet implementation class GameController
 */
@Log4j2
@WebServlet("/game")
public class GameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private GameService gameService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameController() {
        super();
        gameService = new GameService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Tile currentTile = gameService.getCurrentTile();
		log.info("do Get() currentTile: " + currentTile);
		request.setAttribute("currentTile", currentTile);
		
		request.getRequestDispatcher("/WEB-INF/views/gameUI.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer diceValue = gameService.rollDice(); // 주사위 값
		int playerPosition = gameService.movePlayer(diceValue); // 값과 타입에 따른 이동
		
		log.info("주사위 값: " + diceValue);
		
		request.setAttribute("diceValue", diceValue);
		request.setAttribute("playerPosition", playerPosition);
		
		response.sendRedirect("/game?diceValue=" + diceValue);
	}

}
