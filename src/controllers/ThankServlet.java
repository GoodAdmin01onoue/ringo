package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class ThankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ThankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    //商品購入後、購入完了画面に飛ばすためだけのメソッド
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}


		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/thank.jsp");
		rd.forward(request, response);
	}

	/*
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/thank.jsp");
		rd.forward(request, response);
	}
	*/

}
