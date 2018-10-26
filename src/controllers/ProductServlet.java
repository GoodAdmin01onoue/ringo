package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import utils.ShowDAO;

public class ProductServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自動生成されたメソッド・スタブ

		//セッションの継続
		HttpSession session=req.getSession(false);
		if(session==null) {

			//ログイン画面に戻すか考え中

			return;
	}

		//文字列proIdを整数型に変換
		int proId=Integer.parseInt(req.getParameter("proId"));

		//ShowDAOクラスをインスタンス化
		ShowDAO sd = new ShowDAO();

		sd.insert(proId);


		RequestDispatcher rd=req.getRequestDispatcher("product");
		rd.forward=(req.resp);


	}
}
