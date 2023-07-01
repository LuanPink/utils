package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelProductColor;
import model.ModelProductSize;
import model.ModelProductType;
import model.ModelSupplier;

public class DAOProductColor implements DAOProductList<ModelProductColor, Object>{

	final String SELECT_ALL_SQL ="SELECT * FROM MAUSAC";
	@Override
	public ArrayList<ModelProductColor> SelectAll() {
		ArrayList<ModelProductColor> datas = new ArrayList<ModelProductColor>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
			while(rs.next()) {
				ModelProductColor data = new ModelProductColor(
							rs.getString("MAMAU"), 
							rs.getString("TENMAU"));
				datas.add(data);
			}
			rs.close();
			return datas;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public ArrayList<ModelProductColor> SelectByName(Object k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Object k) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(ModelProductColor e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(ModelProductColor e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
