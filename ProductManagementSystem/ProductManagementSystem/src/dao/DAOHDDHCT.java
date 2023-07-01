package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelHDDHCT;

public class DAOHDDHCT implements DAOinterface<ModelHDDHCT>{

	final String INSERT_SQL = "INSERT INTO HOADONDOIHANGCHITIET(MAHDDH,MASP,SOLUONG,SIZE,MAUSAC,CHATLIEU,TONGTIEN)\r\n"
			+ "		VALUES(?,?,?,?,?,?,?);";
	
	final String find = "SELECT * FROM HOADONDOIHANGCHITIET WHERE MAHDDH = ?";
	
	@Override
	public int insert(ModelHDDHCT t) {
		return JDBCHelper.executeUpdate(INSERT_SQL,t.getMaHDDH(),t.getMaSP(),t.getQuantity(),t.getSize(),t.getColor(),t.getMaterial(),t.getTotalPrice());
	}

	@Override
	public int update(ModelHDDHCT t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelHDDHCT> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ModelHDDHCT> Find(ModelHDDHCT t) {
		ArrayList<ModelHDDHCT> datas = new ArrayList<ModelHDDHCT>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(find, t.getMaHDDH());
		try {
			while(rs.next()) {
				ModelHDDHCT data = new ModelHDDHCT(
						rs.getString("MAHDDHCT"), 
						rs.getString("MAHDDH"), 
						rs.getString("MASP"), 
						rs.getInt("SOLUONG"), 
						rs.getString("SIZE"),
						rs.getString("MAUSAC"), 
						rs.getString("CHATLIEU"), 
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
