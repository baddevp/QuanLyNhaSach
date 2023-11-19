package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class DAO_HoaDon {
	
	public ArrayList<HoaDon> getAllHD(){
		ArrayList<HoaDon> dsHD = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HOADON";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maHD = rs.getString(1);
				java.util.Date ngayLapHD = rs.getDate(2);
				double tienNhan = rs.getDouble(3);
				double tongTien = rs.getDouble(4);
				NhanVien nhanvien = new NhanVien(rs.getString(5));
				KhachHang khachhang = new KhachHang(rs.getString(6));
				boolean trangThai = rs.getBoolean(7);
				
				HoaDon hd = new HoaDon(maHD, ngayLapHD, tienNhan, tongTien, nhanvien, khachhang, trangThai);
				dsHD.add(hd);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsHD; 
	}
	
	public boolean createHD(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement("insert into " + "HOADON values(?,?,?,?,?,?,?)");
			
			st.setString(1, hd.getMaHoaDon());
			st.setDate(2, new java.sql.Date(hd.getNgayLapHoaDon().getTime()));
			st.setDouble(3, hd.getTienNhan());
			st.setDouble(4, hd.getTongTien());
			st.setString(5, hd.getNhanVien().getTenNV());
			st.setString(6, hd.getKhachHang().getMaKH());
			st.setBoolean(7, hd.isTrangThai());
			
			n = st.executeUpdate();
		    } catch (SQLException e) {
		    // TODO: handle exception
		        e.printStackTrace();
	    } finally {
		    try {
			    st.close();
		    } catch (SQLException e2) {
			    // TODO: handle exception
			    e2.printStackTrace();
		    }
		}
	    return n>0;
    }
	
	public int getCurrentSequenceNumber() {
		int newMaHD = 0;
		try {
			ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT MAX(MAHOADON) FROM HOADON";
	        Statement stm = con.createStatement();
	        ResultSet rs = stm.executeQuery(sql);
	        
	        if (rs.next()) {
	            String lastMaHD = rs.getString(1);

	            // Check if lastMaKH is not null and has the expected format
	            if (lastMaHD != null && lastMaHD.startsWith("HD") && lastMaHD.length() >= 15) {
	                // Extract the sequence number part from MAKH
	                String sequenceNumberPart = lastMaHD.substring(14);

	                // Convert the extracted part to an integer
	                newMaHD = Integer.parseInt(sequenceNumberPart);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return newMaHD;
	}
}
