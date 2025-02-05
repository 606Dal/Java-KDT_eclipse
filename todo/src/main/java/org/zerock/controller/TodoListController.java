package org.zerock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import org.zerock.dto.TodoListDTO;
import org.zerock.service.TodoSercive;

/**
 * Servlet implementation class TodoListController
 */
@WebServlet("/todo/list")
public class TodoListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodoListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// /WEB-INF/views/todo/list.jsp
		String pageStr = request.getParameter("page");
		
		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		
		try {
			List<TodoListDTO> dtoList = TodoSercive.INSTANCE.getList(page);
			request.setAttribute("dtoList", dtoList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/WEB-INF/views/todo/list.jsp").forward(request, response);
	}

}
