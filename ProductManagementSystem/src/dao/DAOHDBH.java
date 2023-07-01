package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelHDBH;

public class DAOHDBH implements DAOinterface<ModelHDBH>{

	final String INSERT_SQL = "INSERT INTO HOADONBANHANG(MAKH,MANV,NGAYBAN,TONGTIEN)"
			+ "VALUES(?,?,?,?)";
	
	final String SELECT_SQL = "SELECT * FROM HOADONBANHANG \r\n"
			+ "INNER JOIN KHACHHANG ON KHACHHANG.MAKH = HOADONBANHANG.MAKH\r\n"
			+ "INNER JOIN NHANVIEN ON NHANVIEN.MANV = HOADONBANHANG.MANV";
	
	final String SELECT_TOP_ONE = "SELECT TOP (1)* FROM HOADONBANHANG ORDER BY MAHDBH DESC";
	@Override
	public int insert(ModelHDBH t) {
		return JDBCHelper.executeUpdate(INSERT_SQL, t.getMaKH(),t.getMaNV(),t.getNgayBan(),t.getTolalPrice());
	}

	@Override
	public int update(ModelHDBH t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	public ArrayList<ModelHDBH> selectTopOne() {
		ArrayList<ModelHDBH> datas = new ArrayList<ModelHDBH>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_TOP_ONE);
		try {
			while(rs.next()) {
				ModelHDBH data = new ModelHDBH(
						rs.getString("MAHDBH"), 
						rs.getString("MAKH"), 
						rs.getString("MANV"), 
						rs.getString("NGAYBAN"), 
						rs.getDouble("TONGTIEN"));
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
	public ArrayList<ModelHDBH> selectAll() {
		ArrayList<ModelHDBH> datas = new ArrayList<ModelHDBH>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_SQL);
		try {
			while(rs.next()) {
				ModelHDBH data = new ModelHDBH(
						rs.getString("MAHDBH"), 
						rs.getString("MAKH"), 
						rs.getString("MANV"), 
						rs.getString("TENKH"),
						rs.getString("TENNV"),
						rs.getString("SODIENTHOAI"),
						rs.getString("NGAYBAN"), 
						rs.getDouble("TONGTIEN"));
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
	public ArrayList<ModelHDBH> Find(ModelHDBH t) {
		String find = "SELECT * FROM HOADONBANHANG \r\n"
				+ "INNER JOIN KHACHHANG ON KHACHHANG.MAKH = HOADONBANHANG.MAKH\r\n"
				+ "INNER JOIN NHANVIEN ON NHANVIEN.MANV = HOADONBANHANG.MANV WHERE MAHDBH = ?";
		ArrayList<ModelHDBH> datas = new ArrayList<ModelHDBH>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(find,t.getMaHDBH());
		try {
			while(rs.next()) {
				ModelHDBH data = new ModelHDBH(
						rs.getString("MAHDBH"), 
						rs.getString("MAKH"), 
						rs.getString("MANV"), 
						rs.getString("TENKH"),
						rs.getString("TENNV"),
						rs.getString("SODIENTHOAI"),
						rs.getString("NGAYBAN"), 
						rs.getDouble("TONGTIEN"));
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
