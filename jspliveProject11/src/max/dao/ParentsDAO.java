package max.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import max.JDBCConnection;
import max.bean.ChildBean;
import max.bean.FatherBean;
import max.dto.ChildDTO;
import max.dto.FatherDTO;

public class ParentsDAO {
	
	
	public  Map<String , Object> viewdetails()
	{
		Connection con = JDBCConnection.getConnn();
		ArrayList<FatherDTO> flist = new ArrayList<FatherDTO>();
		ArrayList<ChildDTO> clist = new ArrayList<ChildDTO>();
		
	  Map<String , Object> m=new	HashMap<String, Object>();
		try {
			PreparedStatement ps = con.prepareStatement("select f.fid, f.name,f.gndr,f.dob,s.state_name,d.district_name from f_mst1 as f inner join mst_state as s on f.stcode :: int=s.state_code inner join mst_district as d on f.distcode=d.district_code");
		  ResultSet rs = ps.executeQuery();
		  while(rs.next())
		  {
			  FatherDTO f = new FatherDTO();
			  f.setName(rs.getString("name"));
			  f.setDistName(rs.getString("district_name"));
			  f.setDob(rs.getString("dob"));
			  f.setFid(rs.getInt("fid"));
			  f.setGndr(rs.getString("gndr"));
			  f.setStName(rs.getString("state_name"));
			  flist.add(f);
		  }
		  
		  if(flist.size()>0)
		  {
			ps=  con.prepareStatement("select * from c_mst1");
			rs=ps.executeQuery();
			while(rs.next())
			{
				ChildDTO childDTO=new ChildDTO();
				childDTO.setAdhar(rs.getString("adhar"));
				childDTO.setAge(rs.getString("age"));
				childDTO.setCid(rs.getInt("cid"));
				childDTO.setFid(rs.getInt("fid"));
				childDTO.setName(rs.getString("name"));
				clist.add(childDTO);
			}
		  }
		  m.put("flst", flist);
		  m.put("clst", clist);
		  
		} catch (Exception e) {
			// TODO: handle exception
		}
		return m;
	}
	
	
	
	
	
	
	
	public boolean insertParentsDetails(FatherBean fb, ChildBean cb)
	{    Connection com = JDBCConnection.getConnn();
	
	    int cid=JDBCConnection.getMaxCID(com);
		try {
			com.setAutoCommit(false);
			PreparedStatement ps = com.prepareStatement("insert into f_mst1 values (?,?,?,?,?,?)");
			ps.setInt(1, cid);
			ps.setString(2, fb.getName());
			ps.setString(3, fb.getGndr());
			ps.setString(4, fb.getStCode());
			ps.setString(5, fb.getDistCode());
			ps.setString(6, fb.getDob());
			
		int i=ps.executeUpdate();
		if(i>0)
		{
			String[] a = cb.getAdhar();
			  String[] ag = cb.getAge();
			 String[] n = cb.getName();
			 int k=cid;
			ps=com.prepareStatement("insert into c_mst1 values (?,?,?,?,?)");
			for(int j=0;j<a.length;j++)
			{
				ps.setInt(1, ++k);
				ps.setString(2, n[j]);
				ps.setString(3, ag[j]);
				ps.setString(4, n[j]);
				ps.setInt(5, cid);
				ps.addBatch();
			}
			
		}
			
		 int[] t = ps.executeBatch();
		 if(t.length>0)
		 {
			 com.commit();
			 return true;
		 }
		 else
		 {
			 com.rollback();
		 }
		} catch (Exception e) {
			try {
				com.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		finally{
			try {
				com.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		return false;
	}

}
