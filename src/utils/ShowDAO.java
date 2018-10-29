package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowDAO {

	public ProductBean insert(int proId) {



	String url = "jdbc:mysql://localhost/ECRingo";
	String id = "root";
	String pw = "password";
	Connection cnct = null;
	Statement st=null;
	ResultSet rs=null;

	//ResultBeanをインスタンス化
	ProductBean pb=new ProductBean();


	try {

		//ドライバーのロードとインスタンス化を行う
		Class.forName("com.mysql.jdbc.Driver");
		cnct = DriverManager.getConnection(url,id,pw);
		st = cnct.createStatement();
		String i ="SELECT FROM product where pro_cd=proId";
		rs=st.executeQuery(i);

		while(rs.next()) {

		//productテーブルの値を取り出す
		 String pro_name=rs.getString("pro_name");
		 String cat_name=rs.getString("cat_name");
		 int pro_price=rs.getInt(4);
		 int stock_no=rs.getInt(3);
		 String pro_msg=rs.getString("pro_msg");

		 //ProductBeanからデータを格納
		 pb.setproName(pro_name);
		 pb.setcatName(cat_name);
		 pb.setproPrice(pro_price);
		 pb.setstockNo(stock_no);
		 pb.proMsg(pro_msg);



		}




		//引数に指定されたクラスが見つからなかった場合の例外処理
	}catch(ClassNotFoundException ex1) {
		ex1.printStackTrace();

		//接続に失敗した場合の例外処理
	}catch(SQLException ex) {
		ex.printStackTrace();

	}finally {
		try {

			//接続の解除

			if(st!=null) st.close();
			if(cnct!=null) cnct.close();
			if(rs!=null) rs.close();

		}catch(Exception ex) {}
}
	return rb;
}
}




