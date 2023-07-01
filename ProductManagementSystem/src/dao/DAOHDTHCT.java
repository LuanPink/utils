package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelHDTHCT;

public class DAOHDTHCT implements DAOinterface<ModelHDTHCT>{

	final String INSERT_SQL = "INSERT INTO HOADONTRAHANGCHITIET(MAHDTH,MASP,SOLUONG,SIZE,MAUSAC,CHATLIEU,TONGTIEN)"
			+ "VALUES(?,?,?,?,?,?,?)";
	final String SELECT_BY_ID = "SELECT *,HOADONTRAHANGCHITIET.SOLUONG AS SOLUONGTH,HOADONTRAHANGCHITIET.TONGTIEN AS TONGTIENTH FROM HOADONTRAHANGCHITIET \r\n"
			+ "INNER JOIN SANPHAM ON SANPHAM.MASP = HOADONTRAHANGCHITIET.MASP\r\n"
			+ "INNER JOIN HOADONTRAHANG ON HOADONTRAHANGCHITIET.MAHDTH = HOADONTRAHANG.MAHDTRAHANG\r\n"
			+ "INNER JOIN KHACHHANG ON KHACHHANG.MAKH = HOADONTRAHANG.MAKH WHERE HOADONTRAHANGCHITIET.MAHDTH = ?";
	@Override
	public int insert(ModelHDTHCT t) {
		return JDBCHelper.executeUpdate(INSERT_SQL, t.getMaHDTH(),t.getMaSP(),t.getQuantity(),t.getSize(),t.getColor(),t.getMaterial(),t.getTotalPrice());
	}

	@Override
	public int update(ModelHDTHCT t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelHDTHCT> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ModelHDTHCT> Find(ModelHDTHCT t) {
		ArrayList<ModelHDTHCT> datas = new ArrayList<ModelHDTHCT>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(SELECT_BY_ID,t.getMaHDTH());
		try {
			while(rs.next()) {
				ModelHDTHCT data = new ModelHDTHCT(
						rs.getString("MAHDTHCT"),
						rs.getString("MAHDTH"), 
						rs.getString("MAKH"),
						rs.getString("TENKH"),
						rs.getString("MASP"),
						rs.getString("TENSP"), 
						rs.getInt("SOLUONGTH"), 
						rs.getString("SIZE"), 
						rs.getString("MAUSAC"),
						rs.getString("CHATLIEU"),
						rs.getDouble("TONGTIENTH"));
				
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
