package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import max.JDBCConnection;
import max.bean.DistBean;
import max.bean.StateBean;

public class LacationDAO {
	
	
	
	public StateBean getStateName(String stShortName)
	{    StateBean sb = new StateBean();
	System.out.println("innn");
		try {
			Connection con = JDBCConnection.getConnn();
PreparedStatement ps = 
con.prepareStatement("select * from mst_state where state_short_name = ?");
		ps.setString(1, stShortName.toUpperCase());
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			
			sb.setStCode(""+rs.getInt("state_code"));
			sb.setStName(rs.getString("state_name"));
			sb.setStShortName(stShortName);
			return sb;
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	

	public  List<DistBean> getDistList(String stCode)
	{
		List<DistBean> l=new ArrayList<DistBean>();
		try {
			Connection con = JDBCConnection.getConnn();
			PreparedStatement ps = con.prepareStatement("select * from mst_district where state_code = ? order by district_name");
	ps.setString(1, stCode);
			ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		DistBean db = new DistBean();
		db.setDistCode(rs.getString("district_code"));
		db.setDistName(rs.getString("district_name"));
		db.setStCode(rs.getString("state_code"));
		l.add(db);
	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}
	
	
	
	
	
	
	
	public List<StateBean> getStateList()
	{
		List<StateBean> l=new ArrayList<StateBean>();
		try {
			Connection con = JDBCConnection.getConnn();
			PreparedStatement ps = con.prepareStatement("select * from mst_state order by state_name");
	ResultSet rs = ps.executeQuery();
	while(rs.next())
	{
		StateBean sb = new StateBean();
		sb.setStCode(""+rs.getInt("state_code"));
		sb.setStName(rs.getString("state_name"));
		sb.setStShortName(rs.getString("state_short_name"));
		l.add(sb);
	}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

}
