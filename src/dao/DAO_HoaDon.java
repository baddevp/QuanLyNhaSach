package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class DAO_HoaDon {
	DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	DAO_KhachHang  dao_KhachHang = new DAO_KhachHang();
	
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
//				java.util.Date ngayLapHD = rs.getDate(2);
				LocalDateTime ngayLapHD = chuyenDateTimeSangLocal(rs.getString("NGAYLAPHOADON"));
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
			st.setString(2, chuyenLocalSangDateTime(hd.getNgayLapHoaDon()));
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
	          //HD20112023002013
	            if (lastMaHD != null && lastMaHD.startsWith("HD") && lastMaHD.length() >= 14) {
	                // Extract the sequence number part from MAKH
	                String sequenceNumberPart = lastMaHD.substring(13);

	                // Convert the extracted part to an integer
	                newMaHD = Integer.parseInt(sequenceNumberPart);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return newMaHD;
	}
	//test


	//
	public int getmaHDtudong(String loaiMa) {
		 int newMaAnh = 0; // Giá trị mặc định nếu không có dữ liệu trong bảng

		    try {
		        ConnectDB.getInstance();
		        Connection con = ConnectDB.getConnection();
		        
		        // Loại mã cụ thể (SAH, NV, ...)
		        // Thay đổi loại mã tùy theo yêu cầu

		        String sql = "SELECT MAX(MAHOADON) FROM HOADON WHERE MAHOADON LIKE '" + loaiMa + "%'";
		        Statement stm = con.createStatement();
		        ResultSet rs = stm.executeQuery(sql);

		        if (rs.next()) {
		            String lastMaHD = rs.getString(1);

		            if (lastMaHD != null) {                        // VD: Mã là SAHyyyxxxx
		                String prefix = lastMaHD.substring(0, 3); // Lấy phần prefix (VD: "SAH")
		                String middlePart = lastMaHD.substring(3, 6); // Lấy phần giữa (VD: "yyy")
		                //HD02122023002013
		                String number = lastMaHD.substring(13, 16).trim(); // Lấy phần cuối "xxxx"
		                
		                //newMaAnh = prefix + middlePart + numberStr
		                newMaAnh = Integer.parseInt(number);
		                System.out.println(number + " - " + newMaAnh);
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return newMaAnh;
	} 
	//
	public int getNextInvoiceNumber(String currentDate) throws SQLException {
		//HD02122023002013
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
		String sql = "SELECT MAX(RIGHT(MAHOADON, 3)) FROM HOADON WHERE LEFT(MAHOADON, 8) = ?";
		 try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			 preparedStatement.setString(1, "HD" + currentDate);
			 
			 try (ResultSet resultSet = preparedStatement.executeQuery()) {
				 if(resultSet.next()) {
					 int currentMaxNumber = resultSet.getInt(1);
					 return currentMaxNumber +1;
				 } else {
					 return 1;
				 }
			 }
		 }
	}
	//
	public String getLastMaHD(String formattedDate) throws SQLException {
	    String sql = "SELECT MAX(MAHOADON) FROM (SELECT TOP 1 MAHOADON FROM HOADON WHERE MAHOADON LIKE ? ORDER BY CONVERT(DATE, SUBSTRING(MAHOADON, 3, 8), 103) DESC, CAST(SUBSTRING(MAHOADON, 11, 3) AS INT) ASC) AS SubQuery";

	    ConnectDB.getInstance();
	    Connection con = ConnectDB.getConnection();

	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	        statement.setString(1, "HD" + formattedDate + "%");

	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                return resultSet.getString(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}




	public void updateLastMaHD(String formattedDate, String newMaHD, String maNhanVien) throws SQLException {
	    String sql = "INSERT INTO HOADON (MAHOADON, MANV) VALUES (?, ?)";
	    ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
	    try (PreparedStatement statement = con.prepareStatement(sql)) {
	        statement.setString(1, newMaHD);
	        statement.setString(2, maNhanVien);
	        statement.executeUpdate();
	    }
	}
	//
		 //Lấy tất cả hóa đơn đã thanh toán
		 public ArrayList<HoaDon> getHoaDonDaThanhToan() {
				ArrayList<HoaDon> dsHoaDon = new ArrayList<HoaDon>();
				Connection con = ConnectDB.getInstance().getConnection();
				try {
					Statement stm = con.createStatement();
					ResultSet rs = stm.executeQuery("select * from HoaDon where TONGTIEN > 0");
					while (rs.next()) {
						NhanVien nv = dao_NhanVien.getNhanVienTheoMa2(rs.getString("MANV"));
						KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(rs.getString("MAKH"));
						String maHD = rs.getString("MAHOADON");
						LocalDateTime ngayLapHD = chuyenDateTimeSangLocal(rs.getString("NGAYLAPHOADON"));
						double tienNhan = rs.getDouble("TIENNHAN");
						double tongTien = rs.getDouble("TONGTIEN");
						boolean trangThai = rs.getBoolean("TRANGTHAI");
						HoaDon hd = new HoaDon(maHD, ngayLapHD, tienNhan, tongTien, nv, khachHang, trangThai);
						dsHoaDon.add(hd);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return dsHoaDon;
			}
	 	//Lấy thông tin hóa đơn theo mã
	public HoaDon getHDTheoMaHD(String maHDTim) {
		HoaDon hd = new HoaDon();
		Connection con = ConnectDB.getInstance().getConnection();
		try {
			PreparedStatement pstm = con.prepareStatement("select * from HOADON where MAHOADON =?");
			pstm.setString(1, maHDTim);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				NhanVien nv = dao_NhanVien.getNhanVienTheoMa2(rs.getString("MANV"));
				KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(rs.getString("MAKH"));
				String maHD = rs.getString("MAHOADON");
				LocalDateTime ngayLapHD =  chuyenDateTimeSangLocal(rs.getString("NGAYLAPHOADON"));
				double tienNhan = rs.getDouble("TIENNHAN");
				double tongTien = rs.getDouble("TONGTIEN");
				boolean trangThai = rs.getBoolean("TRANGTHAI");
				hd = new HoaDon(maHD, ngayLapHD, tienNhan, tongTien, nv, khachHang, trangThai);
					
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hd;
	}
	
	public ArrayList<HoaDon> getTheoMaHD(String maHDTim) {
		ArrayList<HoaDon> list = new ArrayList<HoaDon>();
		
		Connection con = ConnectDB.getInstance().getConnection();
		try {
			PreparedStatement pstm = con.prepareStatement("select * from HOADON where MAHOADON =?");
			pstm.setString(1, maHDTim);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				NhanVien nv = dao_NhanVien.getNhanVienTheoMa2(rs.getString("MANV"));
				KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(rs.getString("MAKH"));
				String maHD = rs.getString("MAHOADON");
				LocalDateTime ngayLapHD =  chuyenDateTimeSangLocal(rs.getString("NGAYLAPHOADON"));
				double tienNhan = rs.getDouble("TIENNHAN");
				double tongTien = rs.getDouble("TONGTIEN");
				boolean trangThai = rs.getBoolean("TRANGTHAI");
				HoaDon hd = new HoaDon(maHD, ngayLapHD, tienNhan, tongTien, nv, khachHang, trangThai);
				list.add(hd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

		public  ArrayList<HoaDon> layDanhSachHoaDonCho() {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();

        try {
        	ConnectDB.getInstance();
	        Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAHOADON FROM HOADON WHERE TRANGTHAI = 'false'";
            PreparedStatement preparedStatement = con.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String maHoaDon = resultSet.getString("MAHOADON");
                HoaDon h = new HoaDon(maHoaDon);
                danhSachHoaDon.add(h);
            }

            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return danhSachHoaDon;
    }
	
	public boolean updateHD(HoaDon hd) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		try {
			st = con.prepareStatement(
					"update HOADON set NGAYLAPHOADON=?, TIENNHAN=?,TONGTIEN=?,MANV=?,MAKH=?, TRANGTHAI=? where MAHOADON=?");
		
			st.setString(7, hd.getMaHoaDon());
			st.setString(1, chuyenLocalSangDateTime(hd.getNgayLapHoaDon()));
			st.setDouble(2, hd.getTienNhan());
			st.setDouble(3, hd.getTongTien());
			st.setString(4, hd.getNhanVien().getTenNV());
			st.setString(5, hd.getKhachHang().getMaKH());
			st.setBoolean(6, hd.isTrangThai());
			
			int n = st.executeUpdate();
			if(n > 0)
				return true;
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean xoaHDCho(String maHD) {
		int k = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from HOADON where MAHOADON = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maHD);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
}
