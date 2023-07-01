package dao;

import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.DaoRatingCommentList;
import jdbc.JDBCHelper;
import model.ModelCustomerList;
import model.ModelRatingComment;

public class DAORatingComment implements DaoRatingCommentList<ModelRatingComment> {

	final String SELECTALL = "SELECT KHACHHANG.IMAGE, TENKHACHHANG,EMAIL,TENSANPHAM,NOIDUNG,TIME FROM RATINGCOMMENT \r\n"
			+ "INNER JOIN KHACHHANG ON KHACHHANG.MAKHACHHANG = RATINGCOMMENT.MAKHACHHANG\r\n"
			+ "INNER JOIN dbo.SANPHAM ON SANPHAM.MASANPHAM = RATINGCOMMENT.MASANPHAM";

	@Override
	public ArrayList<ModelRatingComment> SellectAll() {
		ArrayList<ModelRatingComment> datas = new ArrayList<ModelRatingComment>();
		ResultSet rs = null;
		try {
			rs = JDBCHelper.executeQuery(SELECTALL);

			while (rs.next()) {
				ModelRatingComment data = new ModelRatingComment(rs.getString("IMAGE"), rs.getString("TENKHACHHANG"), rs.getString("EMAIL"), null, rs.getString("TENSANPHAM"), rs.getString("NOIDUNG"), rs.getString("TIME"));
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
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}
