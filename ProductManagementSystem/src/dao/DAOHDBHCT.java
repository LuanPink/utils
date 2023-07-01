package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelHDBHCT;
import model.ModelHDBH;

public class DAOHDBHCT implements DAOinterface<ModelHDBHCT>{

	final String INSERT_SQL = "INSERT INTO CHITIETHOADONBANHANG(MAHDBH,MASP,SOLUONG,TONGTIEN,SIZE,MAUSAC,CHATLIEU,LOAI)\r\n"
			+ "VALUES(?,?,?,?,?,?,?,?)";
	
	final String SELECT_ALL_BY_ID = "SELECT *,GIA + GIA * THUE / 100 AS TONGTIENVAT FROM CHITIETHOADONBANHANG\r\n"
			+ "INNER JOIN SANPHAM ON SANPHAM.MASP = CHITIETHOADONBANHANG.MASP\r\n"
			+ "INNER JOIN HOADONBANHANG ON HOADONBANHANG.MAHDBH = CHITIETHOADONBANHANG.MAHDBH \r\n"
			+ "INNER JOIN KHACHHANG ON KHACHHANG.MAKH = HOADONBANHANG.MAKH\r\n"
			+ "WHERE CHITIETHOADONBANHANG.MAHDBH = ?";
	
	final String UPDATE_SQL = "{call sp_Update_HDBHCT(?,?,?,?,?)}";
	
	@Override
	public int insert(ModelHDBHCT t) {
		return JDBCHelper.executeUpdate(INSERT_SQL, t.getMaHDBH(),t.getMaSP(),t.getQuantity(),t.getTotalPrice(),t.getSize(),t.getColor(),t.getMaterial(),t.getType());
	}

	@Override
	public int update(ModelHDBHCT t) {
		return JDBCHelper.executeUpdate(UPDATE_SQL,t.getMaHDBH(), t.getId(),t.getMaSP(),t.getQuantity(),t.getTotalPrice());
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelHDBHCT> selectAll() {
		
		return null;
	}

	@Override
	public ArrayList<ModelHDBHCT> Find(ModelHDBHCT t) {
		ArrayList<ModelHDBHCT> datas = new ArrayList<ModelHDBHCT>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_ALL_BY_ID,t.getMaHDBH());
		try {
			while(rs.next()) {
				ModelHDBHCT data = new ModelHDBHCT(
						rs.getString("MACTHDBH"), 
						rs.getString("MAHDBH"), 
						rs.getString("MAKH"), 
						rs.getString("TENKH"), 
						rs.getString("MASP"), 
						rs.getString("TENSP"),
						rs.getInt("SOLUONG"), 
						rs.getDouble("TONGTIENVAT"), 
						rs.getString("SIZE"), 
						rs.getString("MAUSAC"),
						rs.getString("CHATLIEU"), 
						rs.getString("LOAI"),
						0);
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
