package max;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// driver class, url, uid,pass, jar
public class ConUtility {
	private ConUtility(){}
	private static Connection con;
	static
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc","root","root");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnn()
	{
		return con;
	}

}
