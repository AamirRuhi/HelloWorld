package max;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCConnection {
	private JDBCConnection(){}
	static Connection con=null;
      
	public static Connection getConnn()
	{
		return con;
	}
	
	static
	{
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
  con = DriverManager.getConnection("jdbc:mysql://localhost:3306/abc", "root", "root");
		
   
} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	public static int countWrongTimePass(Connection com,String uid)
	{
		try {
			PreparedStatement ps = com.prepareStatement("select  max(logcount) as lc from lgn_mst where uid=?");
		   ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String t=rs.getString("lc");
			return Integer.parseInt(t)+1;
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public static int getMaxCID(Connection com)
	{
		try {
			PreparedStatement ps = com.prepareStatement("select  max(cid) as cd from c_mst1");
		  
			ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			String t=rs.getString("cd");
			return Integer.parseInt(t)+1;
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	

}
