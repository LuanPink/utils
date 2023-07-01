package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelItemCart;

public class DAOItemCart implements DAOProductList<ModelItemCart, Object> {

	final String SELECT_ALL_SQL = "SELECT * FROM dbo.GIOHANG \r\n"
			+ "INNER JOIN dbo.KHACHHANG ON KHACHHANG.MaKH = GIOHANG.MaKH\r\n"
			+ "INNER JOIN dbo.SanPham ON SanPham.MaSP = GIOHANG.MaSP\r\n"
			+ "INNER JOIN dbo.Size ON Size.MaSize = SanPham.MaSize\r\n"
			+ "INNER JOIN dbo.MauSac ON MauSac.MaMau = SanPham.MaMau\r\n"
			+ "INNER JOIN dbo.ChatLieu On ChatLieu.MaCl = SanPham.MaCl\r\n"
			+ "INNER JOIN dbo.LOAISANPHAM On LOAISANPHAM.MaLoai = SanPham.MaLoai WHERE GIOHANG.MaKH = ? ORDER BY ID DESC";

	final String SELECT_BY_IDPRDUCT = "SELECT * FROM GIOHANG WHERE MASP = ? AND MAKH = ?";

	final String INSERT_SQL = "INSERT INTO GIOHANG(MAKH,MASP,SLSP,GIA,NGAYTAO)VALUES(?,?,?,?,?)";

	final String UPDATE_SQL = "UPDATE GIOHANG SET SLSP = ? WHERE MAKH = ? AND MASP = ?";

	@Override
	public int insert(ModelItemCart e) {
		return JDBCHelper.executeUpdate(INSERT_SQL, e.getIdCustomer(), e.getIdProduct(), e.getQuantity(), e.getPrice(),
				e.getDate());
	}
	
	@Override
	public ArrayList<ModelItemCart> SelectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<ModelItemCart> SelectByName(Object k) {
		ArrayList<ModelItemCart> datas = new ArrayList<ModelItemCart>();
		ResultSet rs = JDBCHelper.executeQuery(SELECT_ALL_SQL, k);
		try {
			while (rs.next()) {
				ModelItemCart data = new ModelItemCart(rs.getString("ID"), rs.getString("MAKH"), rs.getString("HINHSP"),
						rs.getString("MASP"), rs.getString("TENSP"),rs.getString("Thue"), rs.getString("TENSIZE"), rs.getString("TENMAU"),rs.getString("TENCL"),rs.getString("TenLoai"),
						rs.getDouble("GIA"), rs.getInt("SLSP"), rs.getString("NGAYTAO"));
				datas.add(data);
			}

			rs.close();
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public ArrayList<ModelItemCart> SelectByIdProduct(String k1,String k2) {
		ArrayList<ModelItemCart> datas = new ArrayList<ModelItemCart>();
		ResultSet rs = JDBCHelper.executeQuery(SELECT_BY_IDPRDUCT, k1,k2);
		try {
			while (rs.next()) {
				ModelItemCart data = new ModelItemCart(rs.getString("ID"), rs.getString("MAKH"), null,
						rs.getString("MASP"), null,null, null, null,null,null, rs.getDouble("GIA"), rs.getInt("SLSP"), rs.getString("NGAYTAO"));
				datas.add(data);
			}

			rs.close();
			return datas;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public int delete(Object k) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(ModelItemCart e) {
		// TODO Auto-generated method stub
		return JDBCHelper.executeUpdate(UPDATE_SQL,e.getQuantity(),e.getIdCustomer(),e.getIdProduct());
	}

	

}
