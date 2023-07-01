package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelEmployee;

public class DAOEmployee implements DAOinterface<ModelEmployee>{

	final String SELECT_ALL_SQL = "SELECT * FROM dbo.NHANVIEN LEFT JOIN dbo.CHUCVU ON CHUCVU.MaCV = NHANVIEN.MaCV";
	
	final String UPDATE_SQL = "UPDATE NHANVIEN SET TENNV = ?, DIACHI = ?,SODIENTHOAI = ?,GIOITINH = ? , NGAYSINH = ?,EMAIL = ?,LUONG = ?, MACV = ? WHERE MANV = ?";
	
	final String INSERT_SQL = "INSERT INTO NHANVIEN(TENNV,DIACHI,SODIENTHOAI,GIOITINH,NGAYSINH,EMAIL,LUONG,MACV)\r\n"
			+ "VALUES (?,?,?,?,?,?,?,?)";
	
	final String DELETE_SQL = "";
	
	final String SELECT_BY_EMAIL = "SELECT * FROM NHANVIEN WHERE EMAIL = ?";
	
	@Override
	public int insert(ModelEmployee e) {
		return JDBCHelper.executeUpdate(INSERT_SQL, e.getName(),e.getAddRess(),e.getPhone(),e.isGender(),e.getNgaySinh(),e.getEmail(),e.getSalary(),e.getChucVu());
	}

	@Override
	public int update(ModelEmployee e) {
		return JDBCHelper.executeUpdate(UPDATE_SQL, e.getName(),e.getAddRess(),e.getPhone(),e.isGender(),e.getNgaySinh(),e.getEmail(),e.getSalary(),e.getChucVu(),e.getIdEmployee());
	}

	@Override
	public int delete(String t) {
		return JDBCHelper.executeUpdate(DELETE_SQL, t);
	}

	@Override
	public ArrayList<ModelEmployee> selectAll() {
		ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);
		try {
			while(rs.next()) {
				ModelEmployee data = new ModelEmployee(
						rs.getString("MANV"), 
						rs.getString("TENNV"),
						rs.getString("TENCV"), 
						rs.getBoolean("GIOITINH"),
						rs.getString("NGAYSINH"), 
						rs.getString("DIACHI"), 
						rs.getString("SODIENTHOAI"), 
						rs.getString("EMAIL"), 
						rs.getDouble("LUONG"));
				datas.add(data);
			}
			
			rs.close();
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ModelEmployee> Find(ModelEmployee t) {
		String SELECT_BY_NAME = "SELECT * FROM dbo.NHANVIEN LEFT JOIN dbo.CHUCVU ON CHUCVU.MaCV = NHANVIEN.MaCV WHERE TENNV LIKE N'%"+t.getName()+"%'";
		ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_BY_NAME);
		try {
			while(rs.next()) {
				ModelEmployee data = new ModelEmployee(
						rs.getString("MANV"), 
						rs.getString("TENNV"),
						rs.getString("TENCV"), 
						rs.getBoolean("GIOITINH"),
						rs.getString("NGAYSINH"), 
						rs.getString("DIACHI"), 
						rs.getString("SODIENTHOAI"), 
						rs.getString("EMAIL"), 
						rs.getDouble("LUONG"));
				datas.add(data);
			}
			
			rs.close();
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ModelEmployee> selectByEmail(String email) {
		ArrayList<ModelEmployee> datas = new ArrayList<ModelEmployee>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_BY_EMAIL,email);
		try {
			while(rs.next()) {
				ModelEmployee data = new ModelEmployee(
						rs.getString("MANV"), 
						rs.getString("TENNV"),
						"", 
						rs.getBoolean("GIOITINH"),
						rs.getString("NGAYSINH"), 
						rs.getString("DIACHI"), 
						rs.getString("SODIENTHOAI"), 
						rs.getString("EMAIL"), 
						rs.getDouble("LUONG"));
				datas.add(data);
			}
			
			rs.close();
			return datas;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
