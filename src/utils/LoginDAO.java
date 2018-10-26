package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {


	public void logincheck(String name, String password) {

		//DBに接続や、SQL文に実行に使用する変数の設定
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			//ドライバの登録
			Class.forName("com.mysql.jdbc.Driver");

			//DBへの接続
			conn = DriverManager.getConnection(

					"jdbc:mysql:localhost",
					"root",
					"password"
					);

			//SQLの設定
			String query = "SELECT * FROM user WHERE user_name = ? AND login_pw = ?";
			//SQL文を渡す
			pstmt = conn.prepareStatement(query);

			//値をセット
			pstmt.setString(1, name);
			pstmt.setString(2, password);

			//SQL文の実行と結果の格納
			rs = pstmt.executeQuery();

			while(rs.next()) {

				String user_name = rs.getString("user_id");
				String user_password = rs.getString("login_pw");
				
				

			}



		} catch(ClassNotFoundException e) {
			//ドライバの登録などにエラーが出た場合、詳細出力
			e.printStackTrace();
		} catch(SQLException e) {
			//DBへの接続時などにエラーが出た場合、詳細出力
			e.printStackTrace();
		} finally {

			try {
				//rs、pstmt、connを順番に切断
				if(rs != null) { rs.close();}
				if(pstmt != null) { rs.close();}
				if(conn != null) { rs.close();}

			} catch(Exception e) {}

		}



	}
}
