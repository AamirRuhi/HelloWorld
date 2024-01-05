package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {
	public int updateDetailByUID(Emp emp)
	{
		 
		try {
			Connection con = ConUtility.getConnn();
			PreparedStatement ps = con.prepareStatement("update Emp set name=?, addr=? where uid=?");
		    ps.setString(1, emp.getName());
		    ps.setString(2, emp.getAdd());
			ps.setInt(3, emp.getUid());
			int i=ps.executeUpdate();
		   return i;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public Emp getDetailByUID(int uid) {
		Emp e1 = new Emp();
		try {
			Connection con = ConUtility.getConnn();
			PreparedStatement ps = con.prepareStatement("select * from Emp where uid=?");
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
			e1.setUid(rs.getInt(1));
			e1.setName(rs.getString(2));
			e1.setAdd(rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return e1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
public List<Integer> getUIDList() {
	 List<Integer> l = new ArrayList<Integer>();
	 
	 try {
		 
		 
		 Connection con = ConUtility.getConnn();
		PreparedStatement ps = con.prepareStatement("select uid from Emp");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
		l.add(rs.getInt(1));
		
		}
	} catch (Exception e) {
	e.printStackTrace();
	}
	return l;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public boolean insertDetail(Emp e) {
	try {
		Connection con=ConUtility.getConnn();
		PreparedStatement ps = con.prepareStatement("insert into Emp values(?,?,?)");
		ps.setInt(1, e.getUid());
		ps.setString(2, e.getName());
		ps.setString(3, e.getAdd());
		int i = ps.executeUpdate();
		if(i>0)
			return true;
	} catch (Exception e2) {
		e2.printStackTrace();
	}
	
	return false;	
	}
   public List<Emp> viewDetail() {
	    
	  List<Emp> l = new ArrayList<Emp>();
	   try {
		   Connection con=ConUtility.getConnn();
		  PreparedStatement ps = con.prepareStatement("select * from Emp");
		  ResultSet rs = ps.executeQuery();
		  while(rs.next()) {
			Emp e2 =new Emp();
		e2.setUid( rs.getInt(1));
		e2.setName(rs.getString(2));
		e2.setAdd(rs.getString(3));
		l.add(e2);
		  }
	} catch (Exception e3) {
		e3.printStackTrace();
	}
	return l;
	   }
}
