package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;

public class CustomerDAO extends DAO{

	public Customer search(String login,String password) throws Exception{
		Customer customer = null;

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = null;
	      // データベースへ接続
	      con = DriverManager.getConnection(
	    		  "jdbc:mysql://localhost:8889/EC", "admin", "admin");

		PreparedStatement st;
		st = con.prepareStatement("select * from customer where login=? and password=?");

		st.setString(1, login);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();

		while(rs.next()) {
			customer = new Customer();
			customer.setId(rs.getInt("id"));
			customer.setLogin(rs.getString("login"));
			customer.setPassword(rs.getString("password"));
		}
		st.close();
		con.close();
		return customer;
	}
}
