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
	DAO_QuanLySach dao_quanLySach = new DAO_QuanLySach();
	DAO_QuanLyVPP dao_quanLyVPP = new DAO_QuanLyVPP();
	DAO_HoaDonTraHang dao_HoaDon = new DAO_HoaDonTraHang();
	public ArrayList<ChiTietHoanTra> getAllCTHT(){
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
	
	//Lấy danh sách chi tiết hóa đơn theo mã trả hàng
	public ArrayList<ChiTietHoanTra> getDSTHTheoMaYCHT(String maHD) {
		ArrayList<ChiTietHoanTra> ds = new ArrayList<ChiTietHoanTra>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			PreparedStatement pstm = con.prepareStatement("select * from CHITIETHOANTRA where MAYCTH = ?");
			pstm.setString(1, maHD);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				HoaDonHoanTra hd = dao_HoaDon.getHDHTTheoMaHDTH(rs.getString("MAYCTH"));
				String maSP = rs.getString("MASP"); 
				
				if(isSach(maSP)) {
					SanPham sanpham = dao_quanLySach.getThongTinSanPhamTheoMa(maSP);
					int soLuong = rs.getInt(3);
					ChiTietHoanTra cthd = new ChiTietHoanTra(hd, sanpham, soLuong);
					ds.add(cthd);
				}else {
					SanPham sanpham = dao_quanLyVPP.getThongTinSanPhamTheoMa(maSP);
					int soLuong = rs.getInt(3);
					ChiTietHoanTra cthd = new ChiTietHoanTra(hd, sanpham, soLuong);
					ds.add(cthd);
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return ds;
	}
	//Update chi tiết trả hàng
	public boolean updateChiTietTraHang(ChiTietHoanTra hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(
					"update CHITIETHOANTRA set SOLUONGTRA = ? where MASP=? AND MAYCTH = ?");
			st.setInt(1, hd.getSoLuongTra());
			st.setString(2, hd.getSanPham().getMaSanPham());
			st.setString(3, hd.getHoaDonHoanTra().getMaYeuCauTraHang());
			int n = st.executeUpdate();
			if(n > 0)
				return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//Kiểm tra sách
	public boolean isVanPhongPham(String maSP) {
	    return maSP.startsWith("VPP");
	}
	//Kiểm tra văn phòng phẩm
	public boolean isSach(String maSP) {
	    return maSP.startsWith("SAH");
	}
	//Kiểm tra sản phẩm đó đã tra chưa
	public boolean kiemTraSanPhamTrongCTHD(HoaDonHoanTra hd, String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		String maSP = null;
		try {
			st = con.prepareStatement(
					"SELECT MASP FROM CHITIETHOANTRA WHERE MASP = ? AND MAYCTH = ?");
			
			st.setString(1, ma);
			st.setString(2, hd.getMaYeuCauTraHang());
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				maSP = rs.getString(1);
				if(maSP != null)
					return true;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
