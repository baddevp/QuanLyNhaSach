package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HinhAnh;
import entity.LoaiSach;
import entity.NhaSanXuat;
import entity.Sach;

public class DAO_QuanLySach {
	private DAO_NSX dao_NSX= new DAO_NSX();
	private DAO_HinhAnh dao_HA= new DAO_HinhAnh();
	private DAO_QuanLyLoaiSach dao_LoaiSach= new DAO_QuanLyLoaiSach();
	public ArrayList<Sach> getALLSach() {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from SACH");
			while (rs.next()) {
				NhaSanXuat nsx = new NhaSanXuat(rs.getString("MANSX"));
				HinhAnh ha = new HinhAnh(rs.getString("MAANH"));
				LoaiSach ls = dao_LoaiSach.getLoaiTheoMa(rs.getString("MALOAISACH"));
				
				ds.add(new Sach(rs.getString("MASACH"), rs.getString("TENSACH"),rs.getDouble("GIAGOC"), ha, rs.getString("MOTA"), rs.getDate("NGAYNHAP"), rs.getBoolean("TRANGTHAI"),rs.getInt("SOLUONG"),
						rs.getDouble("THUE"), rs.getDouble("GIABAN"), nsx ,rs.getString("MAKHUYENMAI"),rs.getInt("SOTRANG"),rs.getString("LOAIBIA"),rs.getString("TACGIA"),ls));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public Sach getSachTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		
		Sach sach = null;
		try {
			PreparedStatement pstm = con.prepareStatement("select * from SACH where MASACH = ?");
			pstm.setString(1, ma);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				NhaSanXuat nsx = dao_NSX.getNSXTheoMa(rs.getString("MANSX"));
				HinhAnh ha = dao_HA.getHinhAnhTheoMa(rs.getString("MAANH"));
				LoaiSach ls = dao_LoaiSach.getLoaiTheoMa(rs.getString("MALOAISACH"));
				sach = new Sach(rs.getString("MASACH"), rs.getString("TENSACH"),rs.getDouble("GIAGOC"), ha, rs.getString("MOTA"), rs.getDate("NGAYNHAP"), rs.getBoolean("TRANGTHAI"),rs.getInt("SOLUONG"),
						rs.getDouble("THUE"), rs.getDouble("GIABAN"), nsx ,rs.getString("MAKHUYENMAI"),rs.getInt("SOTRANG"),rs.getString("LOAIBIA"),rs.getString("TACGIA"),ls);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sach;
	}

	public Sach getSachTheoTen(String ten) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		Sach sach = null;
		try {
			pstm = con.prepareStatement("select * from SACH where TENSACH = ?");
			pstm.setString(1, ten);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				NhaSanXuat nsx = dao_NSX.getNSXTheoMa(rs.getString("MANSX"));
				HinhAnh ha = dao_HA.getHinhAnhTheoMa(rs.getString("MAANH"));
				LoaiSach ls = dao_LoaiSach.getLoaiTheoMa(rs.getString("MALOAISACH"));
				sach = new Sach(rs.getString("MASACH"), rs.getString("TENSACH"),rs.getDouble("GIAGOC"), ha, rs.getString("MOTA"), rs.getDate("NGAYNHAP"), rs.getBoolean("TRANGTHAI"),rs.getInt("SOLUONG"),
						rs.getDouble("THUE"), rs.getDouble("GIABAN"), nsx ,rs.getString("MAKHUYENMAI"),rs.getInt("SOTRANG"),rs.getString("LOAIBIA"),rs.getString("TACGIA"),ls);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sach;
	}

	public boolean addSach(Sach sach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("insert into SACH values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, sach.getMaSanPham());
			pstm.setString(2, sach.getTenSanPham());
			pstm.setDouble(3, sach.getGiaGoc());
			pstm.setString(4, sach.getHinhAnh().getMaAnh());
			pstm.setString(5, sach.getMoTa());
			pstm.setDate(6,  new java.sql.Date(sach.getNgayNhap().getTime()));
			pstm.setBoolean(7, sach.isTrangThai());
			pstm.setInt(8, sach.getSoLuong());
			pstm.setDouble(9, sach.getThue());
			pstm.setDouble(10, sach.getGiaBan());
			pstm.setString(11, sach.getNhaSanXuat().getMaNSX());
			pstm.setString(12, sach.getKhuyenMai());
			pstm.setInt(13, sach.getSotrang());
			pstm.setString(14, sach.getLoaiBia());
			pstm.setString(15, sach.getTacGia());
			pstm.setString(16, sach.getLoaiSach().getMaLoaiSach());
			
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean updateSach(Sach sach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("update SACH set TENSACH = ?, GIAGOC = ?, MAANH = ?, MOTA = ?, NGAYNHAP = ?, TRANGTHAI = ?, "
					+ "SOLUONG = ?, THUE = ?, GIABAN = ?, MANSX = ?, MAKHUYENMAI = ?, SOTRANG = ?, LOAIBIA = ?, TACGIA = ?, MALOAISACH = ? where MASACH = ?");
			pstm.setString(16, sach.getMaSanPham());
			pstm.setString(1, sach.getTenSanPham());
			pstm.setDouble(2, sach.getGiaGoc());
			pstm.setString(3, sach.getNhaSanXuat().getMaNSX());
			pstm.setString(4, sach.getMoTa());
			pstm.setDate(5, (Date) sach.getNgayNhap());
			pstm.setBoolean(6, sach.isTrangThai());
			pstm.setInt(7, sach.getSoLuong());
			pstm.setDouble(8, sach.getThue());
			pstm.setDouble(9, sach.getGiaBan());
			pstm.setString(10, sach.getNhaSanXuat().getMaNSX());
			pstm.setString(11, sach.getKhuyenMai());
			pstm.setInt(12, sach.getSotrang());
			pstm.setString(13, sach.getLoaiBia());
			pstm.setString(14, sach.getTacGia());
			pstm.setString(15, sach.getLoaiSach().getMaLoaiSach());
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean deleteSach(String maSach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("delete from SACH where MASACH = ?");
			pstm.setString(1, maSach);
			n = pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstm.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
		return n > 0;
	}
	
	
	public String getMaAnhByMaSach(String maSach) {
        String maAnh = null;

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAANH FROM SACH WHERE MASACH = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maSach);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        maAnh = resultSet.getString("MAANH");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maAnh;
    }
	
	public String getMaLoaiSachByMaSach(String maSach) {
        String loaiSach = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MALOAISACH FROM SACH WHERE MASACH = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maSach);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        loaiSach = resultSet.getString(1);              
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loaiSach;
    }
	
	public String getMaNSXByMaSach(String maSach) {
        String nsx = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MANSX FROM SACH WHERE MASACH = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maSach);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        nsx = resultSet.getString(1);              
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return nsx;
    }
	
	public String getTrangThaiByMaNV(String maS) { 
        String trangThai = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TRANGTHAI FROM SACH WHERE MASACH = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maS);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        boolean trangThaiBoolean = resultSet.getBoolean(1);
                        trangThai = trangThaiBoolean ? "Còn hàng" : "Hết hàng";
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return trangThai;
    }

	public ArrayList<Sach> getAllSachByStatus(boolean status) {
        ArrayList<Sach> ds = new ArrayList<Sach>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            PreparedStatement pstm = con.prepareStatement("select * from SACH where TRANGTHAI = ?");
            pstm.setBoolean(1, status);
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                NhaSanXuat nsx = new NhaSanXuat(rs.getString("MANSX"));
                HinhAnh ha = new HinhAnh(rs.getString("MAANH"));
                LoaiSach ls = new LoaiSach(rs.getString("MALOAISACH"));

                ds.add(new Sach(rs.getString("MASACH"), rs.getString("TENSACH"), rs.getDouble("GIAGOC"), ha,
                        rs.getString("MOTA"), rs.getDate("NGAYNHAP"), rs.getBoolean("TRANGTHAI"),
                        rs.getInt("SOLUONG"), rs.getDouble("THUE"), rs.getDouble("GIABAN"), nsx,
                        rs.getString("MAKHUYENMAI"), rs.getInt("SOTRANG"), rs.getString("LOAIBIA"),
                        rs.getString("TACGIA"), ls));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }
   //
	public void capNhatSoLuongTonTrongCSDL(String maSP, int soLuong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
	    try {
	        String sql = "UPDATE SACH SET SOLUONG = SOLUONG - ? WHERE MASACH = ?";

	        // Tạo đối tượng PreparedStatement
	        pstm = con.prepareStatement(sql);

	        // Thiết lập tham số cho câu SQL
	        pstm.setInt(1, soLuong);
	        pstm.setString(2, maSP);

	        // Thực hiện câu SQL để cập nhật số lượng tồn trong CSDL
	        pstm.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } 
	}
}
