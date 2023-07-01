package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import jdbc.JDBCHelper;
import model.ModelSetting;

public class DAOSetting {
	public ArrayList<ModelSetting> SelectAll(String ...k){
			ArrayList<ModelSetting> datas = new ArrayList<>();
			String SELECT_ALL_SQL = "SELECT * FROM TAIKHOAN";
			ResultSet rs = null;
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
			try {
				while (rs.next()) {
					ModelSetting data = new ModelSetting(
							rs.getString("ten"),
							rs.getString("email"),
							rs.getString("sdt"),
							rs.getString("pass"));
					datas.add(data);
				}
				rs.close();
				return datas;
			} catch (Exception e) {
				// TODO: handle exception
			}
		return null;
	}
	
}
