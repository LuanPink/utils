package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelHDTH;

public class DAOHDTH implements DAOinterface<ModelHDTH>{

	final String INSERT_SQL = "INSERT INTO HOADONTRAHANG(NGAYTRA,TONGTIEN,GHICHU,MAKH)"
			+ "VALUES(?,?,?,?)";
	final String SELECT_TOP_ONE ="SELECT TOP(1)* FROM HOADONTRAHANG ORDER BY MAHDTRAHANG DESC";
	
	final String SELECT_ALL = "SELECT * FROM HOADONTRAHANG INNER JOIN KHACHHANG ON KHACHHANG.MAKH = HOADONTRAHANG.MAKH";
	
	final String SELECT_BY_ID = "SELECT * FROM HOADONTRAHANG INNER JOIN KHACHHANG ON KHACHHANG.MAKH = HOADONTRAHANG.MAKH WHERE MAHDTRAHANG = ?";
	
	@Override
	public int insert(ModelHDTH t) {
		return JDBCHelper.executeUpdate(INSERT_SQL, t.getNgayTra(),t.getTotalPrice(),t.getNote(),t.getMaKH());
	}

	@Override
	public int update(ModelHDTH t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelHDTH> selectAll() {
		ArrayList<ModelHDTH> datas = new ArrayList<ModelHDTH>();
		ResultSet rs = null;
		rs =JDBCHelper.executeQuery(SELECT_ALL);
		try {
			while (rs.next()) {
				ModelHDTH data = new ModelHDTH(
						rs.getString("MAHDTRAHANG"),
						rs.getString("NGAYTRA"),
						rs.getDouble("TONGTIEN"), 
						rs.getString("GHICHU"),
						rs.getString("MAKH"),
						rs.getString("TENKH"),
						rs.getString("SODIENTHOAI"));
				datas.add(data);
			}
			
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ModelHDTH> selectAllTopOne() {
		ArrayList<ModelHDTH> datas = new ArrayList<ModelHDTH>();
		ResultSet rs = null;
		rs =JDBCHelper.executeQuery(SELECT_TOP_ONE);
		try {
			while (rs.next()) {
				ModelHDTH data = new ModelHDTH(
						rs.getString("MAHDTRAHANG"),
						rs.getString("NGAYTRA"),
						rs.getDouble("TONGTIEN"), 
						rs.getString("GHICHU"),
						rs.getString("MAKH"));
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
	public ArrayList<ModelHDTH> Find(ModelHDTH t) {
		ArrayList<ModelHDTH> datas = new ArrayList<ModelHDTH>();
		ResultSet rs = null;
		rs =JDBCHelper.executeQuery(SELECT_BY_ID,t.getMaHDTraHang());
		try {
			while (rs.next()) {
				ModelHDTH data = new ModelHDTH(
						rs.getString("MAHDTRAHANG"),
						rs.getString("NGAYTRA"),
						rs.getDouble("TONGTIEN"), 
						rs.getString("GHICHU"),
						rs.getString("MAKH"));
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
