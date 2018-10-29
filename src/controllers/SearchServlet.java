package controllers;

import java.io.IOException;
import java.util.List;

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
    
    /***
     * ログイン画面からセッションを継続し、検索画面に移すためのメソッド
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			return;
		}
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}
	
	
	/***
	 * View(search.jsp)から検索条件の値をもらい、Model(SearchDao)でDB問い合わせ
	 * した結果の値をView(search.jsp)に返すメソッド
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//セッションの継続
		HttpSession session = request.getSession(true);
		if(session == null) {
			return;
		}
		
		//セッションが継続していれば以下の処理を行なう
		
		//■Viewから検索条件の値を持ってくる
		request.setCharacterEncoding("UTF-8");
		String keyWord = request.getParameter("key");
		String keyCat = request.getParameter("category");
		
		//■ModelでDBに問い合わせする
		SearchDao sd = new SearchDao();
		List<ProductBean> results = sd.getResult(keyWord, keyCat);
		
		//■Modelでの問合せ結果をリクエストオブジェクト経由でViewに返す
		//　DBからの戻り値をリクエストオブジェクトに格納
		for(ProductBean product: results) {
		request.setAttribute("pro_cd", product.getProCd());
		request.setAttribute("cat_name", product.getCatName());
		request.setAttribute("pro_price", product.getProPrice());
		}
		//DBからの戻り値をView（search.jsp）にリクエストオブジェクト経由で渡す
		RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
		rd.forward(request, response);
	}

}
