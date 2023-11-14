package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TaiKhoan;

public class DAO_DangNhap {
	public ArrayList<TaiKhoan> getallTaiKhoan(){
		ArrayList<TaiKhoan> dsTK = new ArrayList<TaiKhoan>();
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while(rs.next()) {
				String maTK = rs.getString("maTK");
				String matKhau = rs.getString(2);
				String phanQuyen = rs.getString(3);
				
				TaiKhoan tk = new TaiKhoan(maTK, matKhau, phanQuyen);
				dsTK.add(tk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsTK;
	}
	public boolean checkLogin(String user, String pass){
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from TaiKhoan Where MATAIKHOAN=? and MATKHAU=?";
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, user);
			statement.setString(2, pass);
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
