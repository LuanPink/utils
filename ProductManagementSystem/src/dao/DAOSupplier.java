package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelSupplier;

public class DAOSupplier implements DAOProductList<ModelSupplier, Object>{

	final String SELECT_ALL_SQL ="SELECT * FROM NHACUNGCAP";
	
	
	final String find = "SELECT * FROM NHACUNGCAP WHERE TENNCC = ?";
	@Override
	public ArrayList<ModelSupplier> SelectAll() {
		ArrayList<ModelSupplier> datas = new ArrayList<ModelSupplier>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
			while(rs.next()) {
				ModelSupplier data = new ModelSupplier(
						rs.getString("MANCC"), 
						rs.getString("TENNCC"), 
						rs.getString("DIACHI"), 
						rs.getString("SODIENTHOAI"), 
						rs.getString("EMAIL"), 
						rs.getString("GHICHU"));
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
	public ArrayList<ModelSupplier> SelectByName(Object k) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(Object k) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int update(ModelSupplier e) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int insert(ModelSupplier e) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public ArrayList<ModelSupplier> Find(ModelSupplier e) {
		ArrayList<ModelSupplier> datas = new ArrayList<ModelSupplier>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(find,e.getId());
			while(rs.next()) {
				ModelSupplier data = new ModelSupplier(
						rs.getString("MANCC"), 
						rs.getString("TENNCC"), 
						rs.getString("DIACHI"), 
						rs.getString("SODIENTHOAI"), 
						rs.getString("EMAIL"), 
						rs.getString("GHICHU"));
				datas.add(data);
			}
			rs.close();
			return datas;
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
	
}
