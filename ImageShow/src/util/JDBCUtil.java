package util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;


public class JDBCUtil {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("JDBC driver error !");			
		}
	}
	
	// 获取连接
	public static Connection getConn() {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://localhost:3306/ruler?user=root&" +
					"password=123456";
			connection = DriverManager.getConnection(url);
			System.out.println("JDBC connection successful !");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("JDBC connection error !");
		}
		return connection;
	}
	
	// 关闭连接
	public static void closeConn(ResultSet rs,Statement st,Connection conn) {
		try {
			if(rs!=null) 
				rs.close();
			if(st!=null)
				st.close();
			if(conn!=null)
				conn.close();
		} catch (SQLException e) {
			System.out.println("JDBC close error");
		}
	}
	
	
	/*public static void main(String [] args) {
		Connection conn = JDBCUtil.getConn();
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
	*/
}
