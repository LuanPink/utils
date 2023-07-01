package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelProductColor;
import model.ModelProductMaterial;
import model.ModelProductSize;
import model.ModelProductType;
import model.ModelSupplier;

public class DAOProductMaterial implements DAOProductList<ModelProductMaterial, Object>{

	final String SELECT_ALL_SQL ="SELECT * FROM CHATLIEU";
	@Override
	public ArrayList<ModelProductMaterial> SelectAll() {
		ArrayList<ModelProductMaterial> datas = new ArrayList<ModelProductMaterial>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
			while(rs.next()) {
				ModelProductMaterial data = new ModelProductMaterial(
							rs.getString("MACL"), 
							rs.getString("TENCL"));
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
	public ArrayList<ModelProductMaterial> SelectByName(Object k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Object k) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(ModelProductMaterial e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(ModelProductMaterial e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
