package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import connectDB.ConnectDB;
import entity.ChucVu;
import entity.HinhAnh;
import entity.KhachHang;
import entity.MauSac;
import entity.NhanVien;

public class DAO_KhachHang {
	// hàm chuyển đổi từ sql vào java ngày giờ
	public static LocalDateTime chuyenDateTimeSangLocal(String chuoiSQL) {
		if (chuoiSQL == null)
			return null;
		String dateSQL = chuoiSQL.substring(0, 10);
		String timeSQL = chuoiSQL.substring(11, 19);
		LocalDate date = LocalDate.parse(dateSQL);
		LocalTime time = LocalTime.parse(timeSQL);
		return LocalDateTime.of(date, time);
	}

	// hàm chuyển đổi từ java vào sql ngày giờ
	public static String chuyenLocalSangDateTime(LocalDateTime chuoiJava) {
		if (chuoiJava == null)
			return null;
		String str = chuoiJava.toString();
		return str.substring(0, 10) + " " + str.substring(11, 19);
	}
	public ArrayList<KhachHang> getAllKH(){
		ArrayList<KhachHang> dsKH = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KHACHHANG";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				int diemTL = rs.getInt(5);
				LocalDateTime ngayLap = chuyenDateTimeSangLocal(rs.getString(6) );
				String email = rs.getString(7);
				
				KhachHang kh = new KhachHang(maKH, tenKH, diaChi, sdt, diemTL, ngayLap, email);
				dsKH.add(kh);
		
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsKH; 
	}
	
	public ArrayList<KhachHang> getKhachHangTheoSDT(String sdtTim){
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KHACHHANG where sdt = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sdtTim);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				int diemTL = rs.getInt(5);
				LocalDateTime ngayLap = chuyenDateTimeSangLocal(rs.getString(6) );
				String email = rs.getString(7);
				
				KhachHang kh = new KhachHang(ma, tenKH, diaChi, sdt, diemTL, ngayLap, email);
				list.add(kh);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public KhachHang getKhachHangTheoMa(String maKH){
		KhachHang kh = new KhachHang();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from KHACHHANG where MAKH = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maKH);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String ma = rs.getString(1);
				String tenKH = rs.getString(2);
				String diaChi = rs.getString(3);
				String sdt = rs.getString(4);
				int diemTL = rs.getInt(5);
				LocalDateTime ngayLap = chuyenDateTimeSangLocal(rs.getString(6) );
				String email = rs.getString(7);
				
				kh = new KhachHang(ma, tenKH, diaChi, sdt, diemTL, ngayLap, email);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kh;
	}
	
	
	public boolean createKH(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement("insert into " + "KHACHHANG values(?,?,?,?,?,?,?)");
			
			st.setString(1, kh.getMaKH());
			st.setString(2, kh.getTenKH());
			st.setString(3, kh.getDiaChi());
			st.setString(4, kh.getSdt());
			st.setInt(5, kh.getDiemTL());
			st.setString(6, chuyenLocalSangDateTime(kh.getNgayLap()));
			st.setString(7, kh.getEmail());
			
			
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
	    int newMaKH = 0;
	    try {
	        ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
	        String sql = "SELECT MAX(MAKH) FROM KHACHHANG";
	        Statement stm = con.createStatement();
	        ResultSet rs = stm.executeQuery(sql);

	        if (rs.next()) {
	            String lastMaKH = rs.getString(1);

	            // Check if lastMaKH is not null and has the expected format
	            if (lastMaKH != null && lastMaKH.startsWith("KH") && lastMaKH.length() >= 11) {
	                // KH 15 11 20 23 002
	                String sequenceNumberPart = lastMaKH.substring(10);

	                // Convert the extracted part to an integer
	                newMaKH = Integer.parseInt(sequenceNumberPart);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return newMaKH;
	}
	
	public boolean xoaKH(String maKH) {
		int k = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from KHACHHANG where MAKH = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maKH);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
	
	public boolean updateKH(KhachHang kh) {
		ConnectDB.getInstance();
		Connection con =  ConnectDB.getConnection();
		String sql = "update KHACHHANG set MAKH=?, TENKH=?, DIACHI=?, SDT=?, DIEMTL=?, EMAIL=? where MAKH = ?";
		int k =0;
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			
			
			preparedStatement.setString(1, kh.getMaKH());
			preparedStatement.setString(2, kh.getTenKH());
			preparedStatement.setString(3, kh.getDiaChi());
			preparedStatement.setString(4, kh.getSdt());
			preparedStatement.setInt(5, kh.getDiemTL());
			preparedStatement.setString(6, kh.getEmail());
			preparedStatement.setString(7, kh.getMaKH());
			
			
			k = preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return k>0; 
	}
	
	public void updateDiemTL(int diemTichLuyMoi, String sdt) {
		ConnectDB.getInstance();
		Connection con =  ConnectDB.getConnection();
		try {
            // Cập nhật điểm tích lũy trong cơ sở dữ liệu
            String updateQuery = "UPDATE KHACHHANG SET DIEMTL = ? WHERE SDT = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(updateQuery)) {
                preparedStatement.setInt(1, diemTichLuyMoi);
                preparedStatement.setString(2, sdt);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
}
