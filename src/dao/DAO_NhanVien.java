package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.ChucVu;
import entity.HinhAnh;
import entity.NhanVien;

public class DAO_NhanVien {
	public ArrayList<NhanVien> getAllNV(){
		ArrayList<NhanVien> dsNV = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NHANVIEN";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				Date ngaySinh = rs.getDate(3);
				String diaChi = rs.getString(4);
				Date NgayvaoLam = rs.getDate(5);
				String sdt = rs.getString(6);
				String cccd = rs.getString(7);
				boolean gioitinh = rs.getBoolean(8);
				ChucVu maCV = new ChucVu(rs.getString(9));
				HinhAnh maHinhAnh = new HinhAnh(rs.getString(10));
				
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, diaChi, NgayvaoLam, sdt, cccd, gioitinh, maCV, maHinhAnh);
				dsNV.add(nv);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsNV; 
	}
	
	
}
