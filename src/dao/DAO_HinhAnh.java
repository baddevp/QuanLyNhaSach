package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HinhAnh;

public class DAO_HinhAnh {
	public ArrayList<HinhAnh> getAllImg(){
		ArrayList<HinhAnh> dsIMG = new ArrayList<HinhAnh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HINHANH";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maHinhAnh = rs.getString(1);
				String tenHinhAnh = rs.getString(2);
				String url = rs.getString(3);
				HinhAnh img = new HinhAnh(maHinhAnh,tenHinhAnh,url);
				dsIMG.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsIMG; 
	}

}
