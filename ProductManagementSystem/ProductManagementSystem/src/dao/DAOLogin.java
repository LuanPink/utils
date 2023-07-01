package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.JDBCHelper;
import model.ModelLogin;

public class DAOLogin {

	public ArrayList<ModelLogin> SelectAll(String...k) {
		ArrayList<ModelLogin> datas = new ArrayList<>();
		String SELECT_ALL_SQL = "SELECT * FROM TAIKHOAN WHERE EMAIL='"+k[0]+"' OR TENTK='"+k[0]+"' AND MATKHAU='"+k[1]+"'";
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
		
		try {
			while (rs.next()) {
				ModelLogin data = new ModelLogin(
						rs.getString("TENTK"), 
						rs.getString("EMAIL"), 
						rs.getString("MATKHAU"), 
						rs.getString("VAITRO"));	
				
				datas.add(data);
			}
			rs.close();
			return datas;
		} catch (Exception e) {

		}

		return null;
	}

}

