package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import interfaces.DAOProductList;
import jdbc.JDBCHelper;
import model.ModelCustomerList;
import model.ModelProduct;
import model.ModelProductColor;
import model.ModelProductDescriber;
import model.ModelProductId;
import model.ModelProductImage;
import model.ModelProductList;
import model.ModelProductMaterial;
import model.ModelProductName;
import model.ModelProductPrice;
import model.ModelProductQuantity;
import model.ModelProductSize;
import model.ModelProductStatus;
import model.ModelProductType;
import model.ModelProductVAT;
import model.ModelProductWarranty;
import model.ModelSupplier;

public class DAOProducts implements DAOProductList<ModelProduct, Object> {

	final String SELECT_ALL_SQL = "SELECT * FROM SANPHAM \r\n"
			+ "INNER JOIN dbo.NHACUNGCAP ON NHACUNGCAP.MaNCC = SanPham.MaNCC\r\n"
			+ "INNER JOIN dbo.LoaiSanPham ON LoaiSanPham.MaLoai = SanPham.MaLoai\r\n"
			+ "INNER JOIN dbo.Size ON Size.MaSize = SanPham.MaSize\r\n"
			+ "INNER JOIN dbo.MauSac ON MauSac.MaMau = SanPham.MaMau\r\n"
			+ "INNER JOIN dbo.ChatLieu ON ChatLieu.MaCL = SanPham.MaCL";

	final String DELETE_SQL = "DELETE dbo.SANPHAM WHERE MASANPHAM = ?";
	
	final String SELECT_BY_PHANLOAI = "SELECT * FROM SANPHAM \r\n"
			+ "			INNER JOIN dbo.NHACUNGCAP ON NHACUNGCAP.MaNCC = SanPham.MaNCC\r\n"
			+ "			INNER JOIN dbo.LoaiSanPham ON LoaiSanPham.MaLoai = SanPham.MaLoai\r\n"
			+ "			INNER JOIN dbo.Size ON Size.MaSize = SanPham.MaSize\r\n"
			+ "			INNER JOIN dbo.MauSac ON MauSac.MaMau = SanPham.MaMau\r\n"
			+ "			INNER JOIN dbo.ChatLieu ON ChatLieu.MaCL = SanPham.MaCL \r\n"
			+ "			INNER JOIN dbo.PHANLOAINAMNU ON PHANLOAINAMNU.MAPHANLOAI = SANPHAM.MAPHANLOAI\r\n"
			+ "			WHERE TENPHANLOAI = ?";
	
	final String SELECT_BY_TENLOAI = "SELECT * FROM SANPHAM \r\n"
			+ "INNER JOIN dbo.NHACUNGCAP ON NHACUNGCAP.MaNCC = SanPham.MaNCC\r\n"
			+ "INNER JOIN dbo.LoaiSanPham ON LoaiSanPham.MaLoai = SanPham.MaLoai\r\n"
			+ "INNER JOIN dbo.Size ON Size.MaSize = SanPham.MaSize\r\n"
			+ "INNER JOIN dbo.MauSac ON MauSac.MaMau = SanPham.MaMau\r\n"
			+ "INNER JOIN dbo.ChatLieu ON ChatLieu.MaCL = SanPham.MaCL WHERE TENLOAI = ?";
	
	
	String SELECT_BY_NAME = "SELECT IMAGE,SANPHAM.MASANPHAM,TENHANG,TENSANPHAM,TRANGTHAI,GIASANPHAM,SOLUONGSANPHAM,SUM(LIKEORNOLIKE) LUOTTHICH FROM dbo.SANPHAM LEFT JOIN dbo.HANG ON HANG.HANGID = SANPHAM.HANGID LEFT JOIN dbo.LIKECOMMENT ON LIKECOMMENT.MASANPHAM = SANPHAM.MASANPHAM GROUP BY IMAGE, SANPHAM.MASANPHAM,TENHANG, TENSANPHAM,TRANGTHAI,GIASANPHAM,SOLUONGSANPHAM,LIKEORNOLIKE HAVING TENSANPHAM LIKE '%%' ORDER BY SANPHAM.MASANPHAM ASC";
	String SQL_insert="SET IDENTITY_INSERT SanPham  ON\r\n"
			+ "insert into SanPham(MaSP,TenSP,Gia,SoLuong,BaoHanh,Thue,MoTa,HinhSP,TrangThai,MaNCC,MaLoai,MaSize,MaMau,MaCL,NgayTao,MAPHANLOAI)\r\n"
			+ "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,GETDATE(),1)";
	@Override
	public ArrayList<ModelProduct> SelectAll() {
		ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_ALL_SQL);

			while (rs.next()) {
				ModelProduct data = new ModelProduct(
						new ModelProductId(rs.getString("MASP")), 
						new ModelProductName(rs.getString("TENSP")), 
						new ModelProductPrice(rs.getDouble("GIA")), 
						new ModelProductQuantity(rs.getInt("SOLUONG")), 
						new ModelProductWarranty(rs.getString("BAOHANH")), 
						new ModelProductVAT(rs.getString("THUE")), 
						new ModelProductDescriber(rs.getString("MOTA")), 
						new ModelProductImage(rs.getString("HINHSP")), 
						new ModelProductStatus(rs.getBoolean("TRANGTHAI")), 
						new ModelSupplier(rs.getString("MANCC"), rs.getString("TENNCC")), 
						new ModelProductType(rs.getString("MALOAI"), rs.getString("TENLOAI")),
						new ModelProductSize(rs.getString("MASIZE"), rs.getString("TENSIZE")),
						new ModelProductColor(rs.getString("MAMAU"), rs.getString("TENMAU")), 
						new ModelProductMaterial(rs.getString("MACL"), rs.getString("TENCL")));
				datas.add(data);
			}
			rs.close();
			return datas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public ArrayList<ModelProductList> moveData(Object k) {
		ArrayList<ModelProductList> datas = new ArrayList<ModelProductList>();
		String SELECT_BY_NAME = "SELECT IMAGE,SANPHAM.MASANPHAM,TENHANG,TENSANPHAM,TRANGTHAI,GIASANPHAM,SOLUONGSANPHAM,SUM(LIKEORNOLIKE) LUOTTHICH FROM dbo.SANPHAM LEFT JOIN dbo.HANG ON HANG.HANGID = SANPHAM.HANGID LEFT JOIN dbo.LIKECOMMENT ON LIKECOMMENT.MASANPHAM = SANPHAM.MASANPHAM GROUP BY IMAGE, SANPHAM.MASANPHAM,TENHANG, TENSANPHAM,TRANGTHAI,GIASANPHAM,SOLUONGSANPHAM,LIKEORNOLIKE ORDER BY SANPHAM.MASANPHAM ASC OFFSET "+k+" ROWS";
		
		ResultSet rs = null;
		try {
			
			rs = JDBCHelper.executeQuery(SELECT_BY_NAME);

			while (rs.next()) {
				ModelProductList data = new ModelProductList(rs.getInt("MASANPHAM"), rs.getString("IMAGE"), rs.getString("TENSANPHAM"), rs.getString("TENHANG"), rs.getBoolean("TRANGTHAI"), rs.getDouble("GIASANPHAM"), rs.getInt("SOLUONGSANPHAM"), rs.getInt("LUOTTHICH"));
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
	public int delete(Object k) {
		return JDBCHelper.executeUpdate(DELETE_SQL, k);
	}

	@Override
	public int update(ModelProduct e) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public ArrayList<ModelProduct> SelectByName(Object k) {
		ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_BY_PHANLOAI,k);

			while (rs.next()) {
				ModelProduct data = new ModelProduct(
						new ModelProductId(rs.getString("MASP")), 
						new ModelProductName(rs.getString("TENSP")), 
						new ModelProductPrice(rs.getDouble("GIA")), 
						new ModelProductQuantity(rs.getInt("SOLUONG")), 
						new ModelProductWarranty(rs.getString("BAOHANH")), 
						new ModelProductVAT(rs.getString("THUE")), 
						new ModelProductDescriber(rs.getString("MOTA")), 
						new ModelProductImage(rs.getString("HINHSP")), 
						new ModelProductStatus(rs.getBoolean("TRANGTHAI")), 
						new ModelSupplier(rs.getString("MANCC"), rs.getString("TENNCC")), 
						new ModelProductType(rs.getString("MALOAI"), rs.getString("TENLOAI")),
						new ModelProductSize(rs.getString("MASIZE"), rs.getString("TENSIZE")),
						new ModelProductColor(rs.getString("MAMAU"), rs.getString("TENMAU")), 
						new ModelProductMaterial(rs.getString("MACL"), rs.getString("TENCL")));
				datas.add(data);
			}
			rs.close();
			return datas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<ModelProduct> SelectByNameProduct(Object k) {
		String SELECT_BY_NAMEPRODUCT = "SELECT * FROM SANPHAM \r\n"
				+ "INNER JOIN dbo.NHACUNGCAP ON NHACUNGCAP.MaNCC = SanPham.MaNCC\r\n"
				+ "INNER JOIN dbo.LoaiSanPham ON LoaiSanPham.MaLoai = SanPham.MaLoai\r\n"
				+ "INNER JOIN dbo.Size ON Size.MaSize = SanPham.MaSize\r\n"
				+ "INNER JOIN dbo.MauSac ON MauSac.MaMau = SanPham.MaMau\r\n"
				+ "INNER JOIN dbo.ChatLieu ON ChatLieu.MaCL = SanPham.MaCL WHERE TENSP LIKE N'%"+k+"%'";
		ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_BY_NAMEPRODUCT);

			while (rs.next()) {
				ModelProduct data = new ModelProduct(
						new ModelProductId(rs.getString("MASP")), 
						new ModelProductName(rs.getString("TENSP")), 
						new ModelProductPrice(rs.getDouble("GIA")), 
						new ModelProductQuantity(rs.getInt("SOLUONG")), 
						new ModelProductWarranty(rs.getString("BAOHANH")), 
						new ModelProductVAT(rs.getString("THUE")), 
						new ModelProductDescriber(rs.getString("MOTA")), 
						new ModelProductImage(rs.getString("HINHSP")), 
						new ModelProductStatus(rs.getBoolean("TRANGTHAI")), 
						new ModelSupplier(rs.getString("MANCC"), rs.getString("TENNCC")), 
						new ModelProductType(rs.getString("MALOAI"), rs.getString("TENLOAI")),
						new ModelProductSize(rs.getString("MASIZE"), rs.getString("TENSIZE")),
						new ModelProductColor(rs.getString("MAMAU"), rs.getString("TENMAU")), 
						new ModelProductMaterial(rs.getString("MACL"), rs.getString("TENCL")));
				datas.add(data);
			}
			rs.close();
			return datas;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ModelProduct> SelectByKeyName(Object k) {
		ArrayList<ModelProduct> datas = new ArrayList<ModelProduct>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECT_BY_TENLOAI,k);

			while (rs.next()) {
				ModelProduct data = new ModelProduct(
						new ModelProductId(rs.getString("MASP")), 
						new ModelProductName(rs.getString("TENSP")), 
						new ModelProductPrice(rs.getDouble("GIA")), 
						new ModelProductQuantity(rs.getInt("SOLUONG")), 
						new ModelProductWarranty(rs.getString("BAOHANH")), 
						new ModelProductVAT(rs.getString("THUE")), 
						new ModelProductDescriber(rs.getString("MOTA")), 
						new ModelProductImage(rs.getString("HINHSP")), 
						new ModelProductStatus(rs.getBoolean("TRANGTHAI")), 
						new ModelSupplier(rs.getString("MANCC"), rs.getString("TENNCC")), 
						new ModelProductType(rs.getString("MALOAI"), rs.getString("TENLOAI")),
						new ModelProductSize(rs.getString("MASIZE"), rs.getString("TENSIZE")),
						new ModelProductColor(rs.getString("MAMAU"), rs.getString("TENMAU")), 
						new ModelProductMaterial(rs.getString("MACL"), rs.getString("TENCL")));
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
	public int insert(ModelProduct e) {
		// TODO Auto-generated method stub
		JDBCHelper helper=new JDBCHelper();
		Connection connection=helper.getCon();
		try {
			PreparedStatement pst=connection.prepareStatement(SQL_insert);
			pst.setInt(1, Integer.parseInt(e.getId()+""));//
			
			pst.setString(2,e.getProductName()+"");//
			
			
			
			pst.setFloat(3,Float.parseFloat(e.getProductPrice()+""));//
			pst.setInt(4, Integer.parseInt(e.getProductQuantity()+""));//
			pst.setInt(5, Integer.parseInt(e.getProductWarranty()+""));//
			
			
			
			pst.setFloat(6, Float.parseFloat(e.getProductVAT()+""));//
			pst.setString(7, e.getDescriber()+"");//
			pst.setString(8, e.getProductImage()+"");//
			pst.setByte(9, Byte.parseByte(e.getProductStatus()+""));//
			
			
			
			pst.setInt(10, Integer.parseInt(e.getSupplier()+""));//
			pst.setInt(11, Integer.parseInt(e.getProductType()+""));//
			pst.setInt(12,Integer.parseInt(e.getProductSize()+"") );//
			pst.setInt(13, Integer.parseInt(e.getProductColor()+""));//
			pst.setInt(14, Integer.parseInt(e.getProductMaterial()+""));//
			int a=pst.executeUpdate();
			return a;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return 0;
	}
	
}
