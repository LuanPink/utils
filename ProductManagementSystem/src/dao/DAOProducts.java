package dao;

import java.sql.ResultSet;
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
	
	final String UPDATE_QUANTITY_PRODUCT_MINUS = "UPDATE SANPHAM SET SOLUONG = SOLUONG - ? WHERE MASP = ?";
	
	final String UPDATE_QUANTITY_PRODUCT_PLUS = "UPDATE SANPHAM SET SOLUONG = SOLUONG + ? WHERE MASP = ?";
	
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
		return 0;
	}

	public int updateQuantityMinus(ModelProduct e) {
		return JDBCHelper.executeUpdate(UPDATE_QUANTITY_PRODUCT_MINUS, e.getProductQuantity().getQuantity(),e.getId().getId());
	}

	public int updateQuantityPlus(ModelProduct e) {
		return JDBCHelper.executeUpdate(UPDATE_QUANTITY_PRODUCT_PLUS, e.getProductQuantity().getQuantity(),e.getId().getId());
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
		return 0;
	}

}
