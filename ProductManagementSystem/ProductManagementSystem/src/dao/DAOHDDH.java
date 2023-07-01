package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelHDDH;

public class DAOHDDH implements DAOinterface<ModelHDDH>{

	final String INSERT_SQL = "INSERT INTO HOADONDOIHANG(NGAYDOI,TONGTIEN,MAKH)"
			+ "VALUES(?,?,?)";
	
	final String SELECT_TOP_ONE = "SELECT TOP(1)* FROM HOADONDOIHANG ORDER BY MAHDDH DESC";
	final String SELECT_ALL = "SELECT * FROM HOADONDOIHANG";
	
	final String find = "SELECT * FROM HOADONDOIHANG WHERE MAHDDH = ?";
	@Override
	public int insert(ModelHDDH t) {
		return JDBCHelper.executeUpdate(INSERT_SQL, t.getNgayDoi(),t.getTotal(),t.getMaKH());
	}

	@Override
	public int update(ModelHDDH t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelHDDH> selectAll() {
		ArrayList<ModelHDDH> datas = new ArrayList<ModelHDDH>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_ALL);
		try {
			while(rs.next()) {
				ModelHDDH data = new ModelHDDH(rs.getString("MAHDDH"), rs.getString("NGAYDOI"), rs.getDouble("TONGTIEN"), rs.getString("MAKH"));
				datas.add(data);
			}
			
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ModelHDDH> selectTopOne() {
		ArrayList<ModelHDDH> datas = new ArrayList<ModelHDDH>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_TOP_ONE);
		try {
			while(rs.next()) {
				ModelHDDH data = new ModelHDDH(rs.getString("MAHDDH"), rs.getString("NGAYDOI"), rs.getDouble("TONGTIEN"), rs.getString("MAKH"));
				datas.add(data);
			}
			
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ModelHDDH> Find(ModelHDDH t) {
		ArrayList<ModelHDDH> datas = new ArrayList<ModelHDDH>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(find,t.getMaHDDH());
		try {
			while(rs.next()) {
				ModelHDDH data = new ModelHDDH(rs.getString("MAHDDH"), rs.getString("NGAYDOI"), rs.getDouble("TONGTIEN"), rs.getString("MAKH"));
				datas.add(data);
			}
			
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
