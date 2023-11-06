package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaSanXuat;

public class DAO_NSX {
	public ArrayList<NhaSanXuat> getAllNSX(){
		ArrayList<NhaSanXuat> dsNSX = new ArrayList<NhaSanXuat>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NHASANXUAT";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNSX = rs.getString(1);
				String tenNSX = rs.getString(2);
				String thanhPho = rs.getString(3);
				String email = rs.getString(4);
				String sdt = rs.getString(5);
				
				NhaSanXuat nsx = new NhaSanXuat(maNSX,tenNSX,thanhPho,email,sdt);
				dsNSX.add(nsx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsNSX;
	}
}
