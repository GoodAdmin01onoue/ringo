package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.ProductBean;
import models.SearchDao;


public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
    public SearchServlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//セッションの継続
		HttpSession session = request.getSession(true);
		if(session == null) {
			return;
		}
		
		//セッションが継続していれば以下の処理を行なう
		//HTMLからの値をエンコーディング
		request.setCharacterEncoding("UTF-8");
		
		//HTMLから値をもらう
		String keyWord = request.getParameter("key");
		String keyCat = request.getParameter("category");
		
		//JDBCに接続
		//HTMLからもらった値を元に、DBに問い合わせ
		SearchDao sd = new SearchDao();
		ProductBean search = sd.getResult(keyWord, keyCat);
		
		//DBからの戻り値をリクエストオブジェクトに格納
		request.setAttribute("pro_cd", search.getProCd());
		request.setAttribute("cat_name", search.getCatName());
		request.setAttribute("pro_price", search.getProPrice());
				
		//DBからの戻り値をView（search.jsp）にリクエストオブジェクト経由で渡す
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

}
