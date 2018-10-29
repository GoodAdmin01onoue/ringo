package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TestDao {
	
	public static void main(String[] args) {}

	public List<String> getCat() {

			String url = "jdbc:mysql://localhost/ECRingo";
			String id = "root";
			String pass = "password";

			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			
			List<String> categorys = new ArrayList<>();
			try {

				Class.forName("com.mysql.jdbc.Driver");

				conn = DriverManager.getConnection(url, id, pass);
				String query
				= "select cat_name from category";
				st = conn.createStatement();
				rs = st.executeQuery(query);

				while(rs.next()) {
					categorys.add(rs.getString("cat_name"));
				}
			}
			catch(ClassNotFoundException ex) {
				ex.printStackTrace();
			}
			catch(SQLException ex) {
				ex.printStackTrace();
			}
			finally {
				try {
					if(conn != null) conn.close();
					if(st != null) st.close();
					if(rs != null) rs.close();
				}
				catch(Exception ex) {}
			}
			return categorys;
	}
	
	
	/*
	public void getResult(String keyCat, String keyWord) {
		//■引数を検索条件にDBに問い合わせする
				String url = "jdbc:mysql://localhost/ECRingo";
				String id = "root";
				String pass = "password";
				
				Connection conn = null;
				PreparedStatement pst = null;
				ResultSet rs = null;
				
				List<ProductBean> products = new ArrayList<>();
				
				
				try {
					
					Class.forName("com.mysql.jdbc.Driver");
					
					conn = DriverManager.getConnection(url, id, pass);
					String query 
					= "select product.pro_cd, product.pro_name, product.pro_price from product inner join category on product.cat_id = category.cat_id where category.cat_name = ? and product.pro_name = ?";
					pst = conn.prepareStatement(query);
					pst.setString(1, keyCat);
					pst.setString(2, keyWord);
					rs = pst.executeQuery();
						
					
					
					//■問合せた結果の値をレコードごとにインスタンス化したBeanプロパティに値を格納
					//	インスタンス化されたBeanをListに格納
						while(rs.next()) {
						ProductBean product = new ProductBean();
						product.setProCd(rs.getInt("pro_cd"));
						product.setProName(rs.getString("pro_name"));
						product.setProPrice(rs.getInt("pro_price"));
						products.add(product);
					}
					
						
					
					while(rs.next()) {
						System.out.print(rs.getInt("product.pro_cd"));
						System.out.print(rs.getString("product.pro_name"));
						System.out.print(rs.getInt("product.pro_price"));
						System.out.println();
					}
						
				}
				catch(ClassNotFoundException ex) {
					ex.printStackTrace();
				}
				catch(SQLException ex) {
					ex.printStackTrace();
				}
				finally {
					try {
						if(conn != null) conn.close();
						if(pst != null) pst.close();
						if(rs != null) rs.close();
					}
					catch(Exception ex) {}
				}
				
	}
	*/
}
