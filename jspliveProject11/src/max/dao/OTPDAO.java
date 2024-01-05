package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import max.JDBCConnection;

public class OTPDAO {
	public int getOTP(String mobile,int otp)
	{
		try {
			Connection con = JDBCConnection.getConnn();
			PreparedStatement ps = con.prepareStatement("update lgn_mst set otp=? where mobile=?");
			ps.setInt(1, otp);
			ps.setString(2, mobile);
		int i=	ps.executeUpdate();
		  if(i>0)
			  return otp;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
