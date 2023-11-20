package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class DAO_CTHD {
	public ArrayList<ChiTietHoaDon> getAllCTHD(){
		ArrayList<ChiTietHoaDon> dsCTHD = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CHITIETHOADON";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				HoaDon hoadon = new HoaDon(rs.getString(1));
				SanPham sanpham = new SanPham(rs.getString(2));
				int soLuong = rs.getInt(3);
				
				ChiTietHoaDon cthd = new ChiTietHoaDon(hoadon, sanpham, soLuong);
				dsCTHD.add(cthd);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsCTHD; 
	}
	
	public boolean createCTHD(ChiTietHoaDon cthd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement("insert into " + "CHITIETHOADON values(?,?,?)");
			st.setString(1, cthd.getHoaDon().getMaHoaDon());
			st.setString(2, cthd.getSanPham().getMaSanPham());
			st.setInt(3, cthd.getSoLuong());
			
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
}
