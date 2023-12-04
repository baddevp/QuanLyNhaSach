package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.ChiTietHoanTra;
import entity.HoaDon;
import entity.HoaDonHoanTra;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class DAO_ChiTietHoanTra {
	
	DAO_HoaDonTraHang dao_HoaDon = new DAO_HoaDonTraHang();
	public ArrayList<ChiTietHoanTra> getAllCTHD(){
		ArrayList<ChiTietHoanTra> dsCTHD = new ArrayList<ChiTietHoanTra>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from CHITIETHOANTRA";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				HoaDonHoanTra hd = dao_HoaDon.getHDHTTheoMaHDTH(rs.getString("MAYCTH"));
				SanPham sanpham = new SanPham(rs.getString(2));
				int soLuong = rs.getInt(3);
				
				ChiTietHoanTra ctht = new ChiTietHoanTra(hd, sanpham, soLuong);
				dsCTHD.add(ctht);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsCTHD; 
	}
	
	public boolean createCTHT(ChiTietHoanTra cthd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement("insert into " + "CHITIETHOANTRA values(?,?,?)");
			st.setString(1, cthd.getHoaDonHoanTra().getMaYeuCauTraHang());
			st.setString(2, cthd.getSanPham().getMaSanPham());
			st.setInt(3, cthd.getSoLuongTra());
			
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
	
	//Lấy danh sách chi tiết hóa đơn theo mã
	public ArrayList<ChiTietHoanTra> getDSTHTheoMaHD(String maHD) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		ArrayList<ChiTietHoanTra> ds = new ArrayList<ChiTietHoanTra>();
		PreparedStatement pstm = null;
		try {
			pstm = con.prepareStatement("select * from CHITIETHOANTRA where MAYCTH = ?");
			pstm.setString(1, maHD);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				HoaDonHoanTra hd = dao_HoaDon.getHDHTTheoMaHDTH(rs.getString("MAYCTH"));
				SanPham sanpham = new SanPham(rs.getString("MASP"));
				int soLuong = rs.getInt(3);
				ChiTietHoanTra ctht = new ChiTietHoanTra(hd, sanpham, soLuong);
				ds.add(ctht);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		}
		return ds;
	}
}
