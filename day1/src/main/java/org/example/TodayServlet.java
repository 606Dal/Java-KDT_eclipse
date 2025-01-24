package org.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.ToString;

import java.io.IOException;

import org.apache.naming.java.javaURLContextFactory;

/**
 * Servlet implementation class TodayServlet
 */
@WebServlet("/today")
@ToString
public class TodayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TodayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int num = (int)(Math.random() * 4 + 1);
		
		//한글 깨짐 방지
		response.setContentType("text/html; charset=UTF-8");
		
		java.io.PrintWriter out = response.getWriter();
		
		out.write("<div>");
		out.write("<h1>당신의 오늘 운세는<h1>");
		out.write("<img src='/imgs/"+ num +".jpg'>");
		out.write("</div>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
