package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelProductSize;
import model.ModelProductType;
import model.ModelSupplier;

public class DAOProductSize implements DAOProductList<ModelProductSize, Object>{

	final String SELECT_ALL_SQL ="SELECT * FROM SIZE";
	@Override
	public ArrayList<ModelProductSize> SelectAll() {
		ArrayList<ModelProductSize> datas = new ArrayList<ModelProductSize>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
			while(rs.next()) {
					ModelProductSize data = new ModelProductSize(
							rs.getString("MASIZE"), 
							rs.getString("TENSIZE"));
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
	public ArrayList<ModelProductSize> SelectByName(Object k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Object k) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(ModelProductSize e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(ModelProductSize e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
