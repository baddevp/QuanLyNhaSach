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
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.SanPham;

public class DAO_CTHD {

	DAO_QuanLySach dao_quanLySach = new DAO_QuanLySach();
	DAO_QuanLyVPP dao_quanLyVPP = new DAO_QuanLyVPP();
	DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
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
	
	public ArrayList<ChiTietHoaDon> getDSTheoMaHD(String maHD) {
		ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement pstm = con.prepareStatement("select * from CHITIETHOADON where MAHD = ?");
			pstm.setString(1, maHD);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				HoaDon hd = dao_HoaDon.getHDTheoMaHD(rs.getString("MAHD"));
				String maSP = rs.getString("MASP"); 
				
				if(isSach(maSP)) {
					SanPham sanpham = dao_quanLySach.getThongTinSanPhamTheoMa(maSP);
					int soLuong = rs.getInt(3);
					ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sanpham, soLuong);
					ds.add(cthd);
				}else {
					SanPham sanpham = dao_quanLyVPP.getThongTinSanPhamTheoMa(maSP);
					int soLuong = rs.getInt(3);
					ChiTietHoaDon cthd = new ChiTietHoaDon(hd, sanpham, soLuong);
					ds.add(cthd);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ds;
	}
	
	public boolean xoaSPTrongCTHD(String maHD) {
		int k = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from CHITIETHOADON where MAHD = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHD);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
	//Kiểm tra sách
	public boolean isVanPhongPham(String maSP) {
	    return maSP.startsWith("VPP");
	}
	//Kiểm tra văn phòng phẩm
	public boolean isSach(String maSP) {
	    return maSP.startsWith("SAH");
	}
}
