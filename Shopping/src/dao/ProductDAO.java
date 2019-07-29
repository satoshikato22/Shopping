package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Product;

public class ProductDAO extends DAO{

	public List<Product> search(String keyword) throws Exception{
		List<Product> list = new ArrayList<>();

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
	      // データベースへ接続
	      con = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:8889/EC", "admin", "admin");

		PreparedStatement st = con.prepareStatement("select * from product where name like ?");
		st.setString(1, "%"+keyword+"%");
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			Product p = new Product();
			p.setId(rs.getInt("id"));
			p.setName(rs.getString("name"));
			p.setPrice(rs.getInt("price"));
			list.add(p);
		}
		st.close();
		con.close();

		return list;
	}

	public int insert(Product product)throws Exception{
		Connection con = getConnection();

		PreparedStatement st = con.prepareStatement(
				"insert into product values(null,?,?)");
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		int line = st.executeUpdate();

		st.close();
		con.close();
		return line;


	}
}
