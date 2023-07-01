package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelDoanhThu;

public class DAODoanhThu implements DAOinterface<ModelDoanhThu>{

	final String Select_By_Year = "{call sp_DOANHTHU(?)}";
	
	@Override
	public int insert(ModelDoanhThu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ModelDoanhThu t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<ModelDoanhThu> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ModelDoanhThu> Find(ModelDoanhThu t) {
		return null;
	}
	
	public ArrayList<ModelDoanhThu> Find(int t) {
		ArrayList<ModelDoanhThu> datas = new ArrayList<ModelDoanhThu>();
		ResultSet rs = null;
		rs = JDBCHelper.executeQuery(Select_By_Year, t);
		try {
			while(rs.next()) {
				ModelDoanhThu data = new ModelDoanhThu(rs.getInt("THANG"), rs.getLong("SANPHAMBAN"), rs.getLong("TONGGIABAN"),rs.getLong("TONGNHAPHANG"), rs.getLong("LOINHUAN"));
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
