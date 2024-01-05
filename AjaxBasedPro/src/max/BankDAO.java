  package max;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BankDAO {
public String getBankDetail(String ifsc) {
	try {
		Connection con = JDBCCONN.getconn();
		PreparedStatement ps = con.prepareStatement("select addr,bank_name from Bank where ifsc=?");
		ps.setString(1, ifsc);
        ResultSet rs = ps.executeQuery();	
        while(rs.next()) {
        return	rs.getString("bank_name")+"-"+rs.getString("addr");
        }
	
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	
	return null;
	
}
}
