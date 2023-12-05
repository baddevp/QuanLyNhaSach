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

import connectDB.ConnectDB;
import entity.HoaDon;
import entity.HoaDonHoanTra;
import entity.KhachHang;
import entity.NhanVien;

public class DAO_HoaDonTraHang {
	DAO_NhanVien dao_NhanVien = new DAO_NhanVien();
	DAO_KhachHang  dao_KhachHang = new DAO_KhachHang();
	DAO_HoaDon dao_HoaDon = new DAO_HoaDon();
	
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

	public ArrayList<HoaDonHoanTra> getAllHD(){
		ArrayList<HoaDonHoanTra> dsHD = new ArrayList<HoaDonHoanTra>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HOADONTRAHANG";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maYCHT = rs.getString("MAYEUCAUTRAHANG");
//				java.util.Date ngayLapHD = rs.getDate(2);
				LocalDateTime ngayLapHD = chuyenDateTimeSangLocal(rs.getString("NGAYLAPHOADONTH"));
				String lyDo = rs.getString(3);
				
				double tienHT = rs.getDouble("TIENHOANTRA");
				NhanVien nv = dao_NhanVien.getNhanVienTheoMa2(rs.getString("MANV"));
				KhachHang kh = dao_KhachHang.getKhachHangTheoMa(rs.getString("MAKH"));
				HoaDon hd = dao_HoaDon.getHDTheoMaHD(rs.getString("MAHD"));
				
				HoaDonHoanTra hdht = new HoaDonHoanTra(maYCHT, ngayLapHD, lyDo, tienHT, nv, kh, hd);
				dsHD.add(hdht);
			
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsHD; 
	}
	
	public boolean createHD(HoaDonHoanTra hdht) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement("insert into " + "HOADONTRAHANG values(?,?,?,?,?,?,?)");
			
			st.setString(1, hdht.getMaYeuCauTraHang());
			st.setString(2, chuyenLocalSangDateTime(hdht.getNgayLapHoaDonTH()));
			st.setString(3, hdht.getLyDoTraHang());
			st.setDouble(4, hdht.getTongHoanTra());
			st.setString(5, hdht.getNhanVien().getMaNV());
			st.setString(6, hdht.getKhachHang().getMaKH());
			st.setString(7, hdht.getHoaDon().getMaHoaDon());
			
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
	        String sql = "SELECT MAX(MAYEUCAUTRAHANG) FROM HOADONTRAHANG";
	        Statement stm = con.createStatement();
	        ResultSet rs = stm.executeQuery(sql);
	        
	        if (rs.next()) {
	            String lastMaHD = rs.getString(1);

	            // Check if lastMaKH is not null and has the expected format
	            if (lastMaHD != null && lastMaHD.startsWith("TH") && lastMaHD.length() >= 14) {
	                // TH 15 11 20 23 00 1 001
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
	
	//
	public int getmaHDtudong(String loaiMa) {
		 int newMaAnh = 0; // Giá trị mặc định nếu không có dữ liệu trong bảng

		    try {
		        ConnectDB.getInstance();
		        Connection con = ConnectDB.getConnection();
		        
		        // Loại mã cụ thể (SAH, NV, ...)
		        // Thay đổi loại mã tùy theo yêu cầu

		        String sql = "SELECT MAX(MAYEUCAUTRAHANG) FROM HOADONTRAHANG WHERE MAYEUCAUTRAHANG LIKE '" + loaiMa + "%'";
		        Statement stm = con.createStatement();
		        ResultSet rs = stm.executeQuery(sql);

		        if (rs.next()) {
		            String lastMaHD = rs.getString(1);

		            if (lastMaHD != null) {                        // VD: Mã là SAHyyyxxxx
		                String prefix = lastMaHD.substring(0, 3); // Lấy phần prefix (VD: "SAH")
		                String middlePart = lastMaHD.substring(3, 6); // Lấy phần giữa (VD: "yyy")
		                
		                String number = lastMaHD.substring(6).trim(); // Lấy phần cuối "xxxx"
		                
		                //newMaAnh = prefix + middlePart + numberStr
		                newMaAnh = Integer.parseInt(number);
		            }
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return newMaAnh;
	} 
	//
	public int getNextInvoiceNumber(String currentDate) throws SQLException {
		
		ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
		String sql = "SELECT MAX(RIGHT(MAYEUCAUTRAHANG, 3)) FROM HOADONTRAHANG WHERE LEFT(MAYEUCAUTRAHANG, 8) = ?";
		 try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			 preparedStatement.setString(1, "TH" + currentDate);
			 
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
		 //Lấy tất cả hóa đơn đã thanh toán
		 public ArrayList<HoaDonHoanTra> getHoaDonDaThanhToan() {
				ArrayList<HoaDonHoanTra> dsHoaDon = new ArrayList<HoaDonHoanTra>();
				Connection con = ConnectDB.getInstance().getConnection();
				try {
					Statement stm = con.createStatement();
					ResultSet rs = stm.executeQuery("select * from HOADONTRAHANG where TIENTHOANTRA > 0");
					while (rs.next()) {
						NhanVien nv = dao_NhanVien.getNhanVienTheoMa2(rs.getString("MANV"));
						KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(rs.getString("MAKH"));
						HoaDon hd = dao_HoaDon.getHDTheoMaHD(rs.getString("MAHD"));
						String maYCHT = rs.getString("MAYEUCAUTRAHANG");
						String lyDo = rs.getString("LYDOTRAHANG");
						LocalDateTime ngayLapHD = chuyenDateTimeSangLocal(rs.getString("NGAYLAPHOADONTH"));
						double tienHoanTra= rs.getDouble("TIENHOANTRA");
						
						HoaDonHoanTra hdht = new HoaDonHoanTra(maYCHT, ngayLapHD, lyDo, tienHoanTra, nv, khachHang, hd);
						dsHoaDon.add(hdht);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return dsHoaDon;
			}
		 	//Lấy thông tin hóa đơn theo mã
			public HoaDonHoanTra getHDHTTheoMaHDTH(String maHDTim) {
				HoaDonHoanTra hdht = new HoaDonHoanTra();
				Connection con = ConnectDB.getInstance().getConnection();
				try {
					PreparedStatement pstm = con.prepareStatement("select * from HOADONTRAHANG where MAYEUCAUTRAHANG =?");
					pstm.setString(1, maHDTim);
					ResultSet rs = pstm.executeQuery();
					while (rs.next()) {
						NhanVien nv = dao_NhanVien.getNhanVienTheoMa2(rs.getString("MANV"));
						KhachHang khachHang = dao_KhachHang.getKhachHangTheoMa(rs.getString("MAKH"));
						HoaDon hd = dao_HoaDon.getHDTheoMaHD(rs.getString("MAHD"));
						LocalDateTime ngayLapHD =  chuyenDateTimeSangLocal(rs.getString("NGAYLAPHOADONTH"));
						double tongTien = rs.getDouble("TIENHOANTRA");
						String lyDo = rs.getString("LYDOTRAHANG");
						hdht = new HoaDonHoanTra(maHDTim, ngayLapHD, lyDo, tongTien, nv, khachHang, hd);
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return hdht;
			}
			//Kiểm tra hóa đơn đã trả hàng chưa
			public String kiemTraTraHang(HoaDon hd) {
				Connection con = ConnectDB.getInstance().getConnection();
				try {
					PreparedStatement pstm = con.prepareStatement("SELECT MAHD from HOADONTRAHANG where MAHD =?");
					pstm.setString(1, hd.getMaHoaDon());
					ResultSet rs = pstm.executeQuery();
					while (rs.next()) {
						String maHD = rs.getString(1);
						if(maHD.equals(hd.getMaHoaDon()) ) {
							return "Đã trả"; // Chưa trả hàng
						}
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return "Chưa trả"; // Đã trả hàng rồi
			}
			//Lấy mã trả hàng khi biết mã hóa đơn
			public String getMaTHTheoMaHD(String maHD) {
				ConnectDB.getInstance();
				Connection con = ConnectDB.getConnection();
				String maYCTH = null;
				PreparedStatement pstm = null;
				try {
					pstm = con.prepareStatement("select MAYEUCAUTRAHANG from HOADONTRAHANG where MAHD = ?");
					pstm.setString(1, maHD);
					ResultSet rs = pstm.executeQuery();
					while (rs.next()) {
						maYCTH = rs.getString(1);
						
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
				}
				return maYCTH;
			}
}