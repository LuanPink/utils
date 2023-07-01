package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelProductType;

public class DAOProductType implements DAOProductList<ModelProductType, Object>{

	final String SELECT_ALL_SQL ="SELECT * FROM LOAISANPHAM";
	@Override
	public ArrayList<ModelProductType> SelectAll() {
		ArrayList<ModelProductType> datas = new ArrayList<ModelProductType>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
			while(rs.next()) {
				ModelProductType data = new ModelProductType(
						rs.getString("MALOAI"), 
						rs.getString("TENLOAI"), 
						rs.getString("MOTA"));
						
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
	public ArrayList<ModelProductType> SelectByName(Object k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Object k) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(ModelProductType e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(ModelProductType e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
