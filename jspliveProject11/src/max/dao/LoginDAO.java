package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import max.EncryptionPasswordANDVerification;
import max.JDBCConnection;
import max.timeUtility;

public class LoginDAO {
	
	public void updateLock()
	{
		try {
			
			Connection con = JDBCConnection.getConnn();
			PreparedStatement ps = con.prepareStatement("update lgn_mst set status = ? ,logcount=? where status=?");
			ps.setString(1, "Y");
			ps.setString(2, "0");
			ps.setString(3, "L");
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public int logout(String uid)
	{
		try {
			Connection con = JDBCConnection.getConnn();
			PreparedStatement ps = con.prepareStatement("update lgn_mst set status=?, logcount=? where uid = ?");
		  ps.setString(1, "Y");
		  ps.setString(2, "0");
		 ps.setString(3, uid);
		int i= ps.executeUpdate();
		   return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	public String login(String uid,String pass,String mobile,int otp)
	{
		try {
			Connection con = JDBCConnection.getConnn();
			PreparedStatement ps = con.prepareStatement("select status, otp,pass from lgn_mst where uid=?");
			ps.setString(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String p=rs.getString("pass");
				
				  if(p.equalsIgnoreCase(EncryptionPasswordANDVerification.encryptionPassword(pass)))
				  {
					  int t=rs.getInt("otp");
					  if(t==otp)
					  {
						 String st= rs.getString("status");
						  if(st.equalsIgnoreCase("N"))
							  return "User Already Login";
						  if(st.equalsIgnoreCase("L"))
							  return "LOCK User PLZ Cont Adimint";
						  if(st.equalsIgnoreCase("Y"))
						  {
							  ps=con.prepareStatement("update lgn_mst set status = ? where uid = ?");
							  ps.setString(1, "N");
							  ps.setString(2, uid);
							  ps.executeUpdate();
							  return "WelCome";
						  }
					  }
				  }
				else
				{
					int t=JDBCConnection.countWrongTimePass(con, uid);
					ps=con.prepareStatement("update lgn_mst set logcount = ?,status=? where uid=?");
					
					  if(t<=2)
					  {
							ps.setString(1, String.valueOf(t));
							ps.setString(2, "Y");
							ps.setString(3, uid);
							 ps.executeUpdate();
							 return "Pass wrong";
					  }
					  else
					  {
						ps.setString(1, timeUtility.getTime()); 
						ps.setString(2, "L");
						ps.setString(3, uid);
						 ps.executeUpdate();
						return "User Lock 24 hr PLZ ";
					  }
					  
					
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "uid wrong";
	}
	
}
