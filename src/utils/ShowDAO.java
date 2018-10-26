package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShowDAO {

	public int insert(int proId) {

	String url = "jdbc:mysql://localhost/ECRingo";
	String id = "root";
	String pw = "password";
	Connection cnct = null;
	Statement st=null;
	ResultSet rs=null;

	//ResultBeanをインスタンス化
	ResultBean rb=new ResultBean();


	try {

		//ドライバーのロードとインスタンス化を行う
		Class.forName("com.mysql.jdbc.Driver");
		cnct = DriverManager.getConnection(url,id,pw);
		st = cnct.createStatement();
		String i ="SELECT FROM product where pro_cd=proId";
		rs=st.executeQuery(i);

		while(rb.next()) {



			rb.getproName();
			rb.getstockNo();
			rb.getproPrice();
			rb.getproImg();
			rb.getproMsg();

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
	return 0;
}
}




