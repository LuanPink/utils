package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.html.parser.Entity;

import interfaces.DAOCustomersList;
import jdbc.JDBCHelper;
import model.ModelCustomerList;

public class DAOCustomers implements DAOCustomersList<ModelCustomerList, String> {
	final String SelectAll = "SELECT KHACHHANG.MaKH,TenKH,SoDienThoai,Email,Hinh,GioiTinh,SUM(Gia) AS TONGTIEN,COUNT(dbo.LikeSanPham.MaKH) AS LUOTTHICH,COUNT(dbo.BinhLuan.MaKH) AS LUOTBINHLUAN,COUNT(HoaDonBanHang.MaKH) AS LUOTMUA FROM dbo.KHACHHANG\r\n"
			+ "LEFT JOIN dbo.BinhLuan ON BinhLuan.MaKH = KHACHHANG.MaKH\r\n"
			+ "LEFT JOIN dbo.LikeSanPham ON LikeSanPham.MaKH = KHACHHANG.MaKH\r\n"
			+ "LEFT JOIN dbo.SanPham ON SanPham.MaSP = LikeSanPham.MaSP\r\n"
			+ "LEFT JOIN dbo.HoaDonBanHang ON HoaDonBanHang.MaKH = KHACHHANG.MaKH\r\n"
			+ "GROUP BY KHACHHANG.MaKH,TenKH,SoDienThoai,Email,Hinh,GioiTinh";

	final String SelectAllByEmailOrUsername = "SELECT KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI, COUNT(PRODUCTCOMMENT.MASANPHAM) AS LUOTMUA,SUM(SANPHAM.GIASANPHAM) AS TONGTIEN, COUNT(LIKECOMMENT.LIKEORNOLIKE) AS LUOTTHICH, COUNT(RATINGCOMMENT.MASANPHAM) AS LUOTDANHGIA\r\n"
			+ "FROM KHACHHANG\r\n"
			+ "LEFT JOIN PRODUCTCOMMENT ON KHACHHANG.MAKHACHHANG = PRODUCTCOMMENT.MAKHACHHANG\r\n"
			+ "LEFT JOIN LIKECOMMENT ON KHACHHANG.MAKHACHHANG = LIKECOMMENT.MAKHACHHANG\r\n"
			+ "LEFT JOIN SANPHAM ON SANPHAM.MASANPHAM = LIKECOMMENT.MASANPHAM\r\n"
			+ "LEFT JOIN RATINGCOMMENT ON KHACHHANG.MAKHACHHANG = RATINGCOMMENT.MAKHACHHANG\r\n"
			+ "GROUP BY KHACHHANG.IMAGE,KHACHHANG.TENKHACHHANG, KHACHHANG.EMAIL, KHACHHANG.SODIENTHOAI HAVING TENKHACHHANG LIKE N'%?%'";

	final String SELECT_ALL_CUSTOMER = "SELECT * FROM dbo.KHACHHANG";
	
	final String find = "SELECT * FROM dbo.KHACHHANG WHERE EMAIL = ?";
	

	public ArrayList<ModelCustomerList> SelectCustomer() {
		ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_CUSTOMER);

			while (rs.next()) {
				ModelCustomerList data = new ModelCustomerList(rs.getString("MAKH"),rs.getString("TENKH"), rs.getString("EMAIL"), rs.getString("SODIENTHOAI"), rs.getString("HINH"));
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
	public ArrayList<ModelCustomerList> SelectAll() {
		ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SelectAll);

			while (rs.next()) {
				ModelCustomerList data = new ModelCustomerList(rs.getString("HINH"), rs.getString("TENKH"),
						rs.getString("EMAIL"), rs.getString("SODIENTHOAI"),rs.getBoolean("GIOITINH"), rs.getString("LUOTMUA"),
						rs.getDouble("TONGTIEN"), rs.getInt("LUOTBINHLUAN"), rs.getInt("LUOTTHICH"));
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
	public ArrayList<ModelCustomerList> SelectByName(String k) {
		ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
		 String SelectAllByEmailOrUsername = "SELECT KHACHHANG.MaKH,TenKH,SoDienThoai,Email,Hinh,GioiTinh,SUM(Gia) AS TONGTIEN,COUNT(dbo.LikeSanPham.MaKH) AS LUOTTHICH,COUNT(dbo.BinhLuan.MaKH) AS LUOTBINHLUAN,COUNT(HoaDonBanHang.MaKH) AS LUOTMUA FROM dbo.KHACHHANG\r\n"
		 		+ "LEFT JOIN dbo.BinhLuan ON BinhLuan.MaKH = KHACHHANG.MaKH\r\n"
		 		+ "LEFT JOIN dbo.LikeSanPham ON LikeSanPham.MaKH = KHACHHANG.MaKH\r\n"
		 		+ "LEFT JOIN dbo.SanPham ON SanPham.MaSP = LikeSanPham.MaSP\r\n"
		 		+ "LEFT JOIN dbo.HoaDonBanHang ON HoaDonBanHang.MaKH = KHACHHANG.MaKH\r\n"
		 		+ "GROUP BY KHACHHANG.MaKH,TenKH,SoDienThoai,Email,Hinh,GioiTinh HAVING TenKH LIKE N'%"+k+"%'";
		ResultSet rs = null;
		try {
			rs =JDBCHelper.executeQuery(SelectAllByEmailOrUsername);
			
			while (rs.next()) {
				ModelCustomerList data = new ModelCustomerList(rs.getString("HINH"), rs.getString("TENKH"),
						rs.getString("EMAIL"), rs.getString("SODIENTHOAI"),rs.getBoolean("GIOITINH"), rs.getString("LUOTMUA"),
						rs.getDouble("TONGTIEN"), rs.getInt("LUOTBINHLUAN"), rs.getInt("LUOTTHICH"));
				datas.add(data);
			}
			rs.close();
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ModelCustomerList> SelectByEmail(String k) {
		ArrayList<ModelCustomerList> datas = new ArrayList<ModelCustomerList>();
		ResultSet rs = null;
		try {
			rs =JDBCHelper.executeQuery(find,k);
			
			while (rs.next()) {
				ModelCustomerList data = new ModelCustomerList(rs.getString("MAKH"),rs.getString("TENKH"), rs.getString("EMAIL"), rs.getString("SODIENTHOAI"), rs.getString("HINH"));
				
				System.out.println(rs.getString("MAKH"));
				datas.add(data);
			}
			rs.close();
			return datas;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
