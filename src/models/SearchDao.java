package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchDao {

	public static void main(String[] args) {}
	
	
    public ProductBean getResult(String keyWord, String keyCat) {
		
    	ProductBean rb = new ProductBean();
    	
		
		String url = "jdbc:mysql://localhost/ECRingo";
		String id = "root";
		String pass = "password";
		
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			conn = DriverManager.getConnection(url, id, pass);
			
			//if(keyWord != null) {
				String query 
				= "select category.pro_cd, product.pro_name, product.pro_price from product inner join category on product.cat_id = category.cat_id where category.cat_name = ? and product.pro_name = ?";
				pst = conn.prepareStatement(query);
				pst.setString(1, keyCat);
				pst.setString(2, keyWord);
				rs = pst.executeQuery();
			//}
			/*else {
				String query = "select pro_cd, pro_name, pro_price from product where product = ?";
				pst = conn.prepareStatement(query);
				pst.setString(1, keyCat);
				rs = pst.executeQuery();
			}*/
			
			while(rs.next()) {
			rb.setProCd(rs.getInt("pro_cd"));
			rb.setProName(rs.getString("pro_name"));
			rb.setProPrice(rs.getInt("pro_price"));
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
		
		return rb;
	}


}
