package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {


	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//logion.jspに移動
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/login.jsp");
		rd.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//リクエストの文字コードを指定
		request.setCharacterEncoding("UTF-8");
		//パラメータを取得
		String user_name = request.getParameter("user_name");
		String user_pass = request.getParameter("user_pass");





	}
}
