package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import interfaces.DAOinterface;
import jdbc.JDBCHelper;
import model.ModelSignupPerson;

public class DAOsignup implements DAOinterface<ModelSignupPerson>{
	final String sqlInsert="insert into TAIKHOAN(TenTK,MatKhau,Email,SoDienThoai,VaiTro)\r\n"
			+ "values (?,?,?,?,'user')";
	final String sqlUpdate="";
	final String sqlDelete="";
	final String sqlList="";
	final String sqlcheckID="select * from TAIKHOAN where TENTK=?";
	final String sqlcheckmail="select * from TAIKHOAN where EMAIL=?";
	final String sqlcheckphone="select * from TAIKHOAN where SODIENTHOAI=?";
	@Override
	public int insert(ModelSignupPerson t) {
		// TODO Auto-generated method stub
		JDBCHelper.executeUpdate(sqlInsert,t.getTentaikhoan(),t.getMatkhau(),t.getEmail(),t.getSdt());
		return 0;
	}

	@Override
	public int update(ModelSignupPerson t) {
		// TODO Auto-generated method stub
		JDBCHelper.executeUpdate(sqlUpdate,t.getTentaikhoan(),t.getMatkhau(),t.getEmail(),t.getSdt());
		return 0;
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		JDBCHelper.executeUpdate(sqlUpdate,t);
		return 0;
	}

	@Override
	public ArrayList<ModelSignupPerson> selectAll() {
		// TODO Auto-generated method stub
		ResultSet rs=JDBCHelper.executeQuery(sqlList);
		ArrayList<ModelSignupPerson> list=new ArrayList<ModelSignupPerson>();
		try {
			while(rs.next()) {
				ModelSignupPerson signupPerson=new ModelSignupPerson(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
				list.add(signupPerson);
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<ModelSignupPerson> Find(ModelSignupPerson t) {
		// TODO Auto-generated method stub
		return null;
	}
	public boolean checkID(String t) {
		ResultSet rs=JDBCHelper.executeQuery(sqlcheckID,t);
		boolean check=true;
		try {
		 check=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public boolean checkmail(String t) {
		ResultSet rs=JDBCHelper.executeQuery(sqlcheckmail,t);
		boolean check=true;
		try {
		 check=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
	public boolean checkphone(String t) {
		ResultSet rs=JDBCHelper.executeQuery(sqlcheckphone,t);
		boolean check=true;
		try {
		 check=rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
	}
}
