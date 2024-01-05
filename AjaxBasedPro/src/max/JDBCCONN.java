package max;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCCONN {
	private JDBCCONN(){}
	private static Connection con;
	static {
    try {
    	Class.forName("com.mysql.cj.jdbc.Driver");
     con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");
    }catch(Exception e) {
    	e.printStackTrace();
    }
	}
	
	public static Connection getconn() {
		return con;
		
	}
	
	
	
	
	
	
	
}
