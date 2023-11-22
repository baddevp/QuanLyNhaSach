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
import entity.LoaiVanPhongPham;
import entity.MauSac;
import entity.NhaSanXuat;
import entity.VanPhongPham;

public class DAO_QuanLyVPP {
	private DAO_NSX dao_NSX= new DAO_NSX();
	private DAO_MauSac dao_ms= new DAO_MauSac();
	private DAO_HinhAnh dao_HA= new DAO_HinhAnh();
	private DAO_QuanLyLoaiVPP dao_LoaiVPP= new DAO_QuanLyLoaiVPP();
	public ArrayList<VanPhongPham> getALLVPP() {
		ArrayList<VanPhongPham> ds = new ArrayList<VanPhongPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from VANPHONGPHAM");
			while (rs.next()) {
				NhaSanXuat nsx = dao_NSX.getNSXTheoMa(rs.getString("MANSX"));
				HinhAnh ha = dao_HA.getHinhAnhTheoMa(rs.getString("MAANH"));
				LoaiVanPhongPham lvpp = dao_LoaiVPP.getLoaiTheoMa(rs.getString("MALOAIVPP"));
				MauSac ms = dao_ms.getMauSacTheoMa(rs.getString("MAMAU"));
				
				ds.add(new VanPhongPham(rs.getString("MAVPP"), rs.getString("TENVPP"),rs.getDouble("GIAGOC"), ha, rs.getString("MOTA"), rs.getDate("NGAYNHAP"), rs.getBoolean("TRANGTHAI"),rs.getInt("SOLUONG"),
						rs.getDouble("THUE"), rs.getDouble("GIABAN"), nsx ,rs.getString("MAKHUYENMAI"),rs.getString("THUONGHIEU"),rs.getString("XUATXU"),ms,lvpp));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public VanPhongPham getVPPTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		VanPhongPham vpp = null;
		try {
			PreparedStatement pstm = con.prepareStatement("select * from VANPHONGPHAM where MAVPP = ?");
			pstm.setString(1, ma);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				NhaSanXuat nsx = dao_NSX.getNSXTheoMa(rs.getString("MANSX"));
				HinhAnh ha = dao_HA.getHinhAnhTheoMa(rs.getString("MAANH"));
				LoaiVanPhongPham lvpp = dao_LoaiVPP.getLoaiTheoMa(rs.getString("MALOAIVPP"));
				MauSac ms = dao_ms.getMauSacTheoMa(rs.getString("MAMAU"));
				vpp = new VanPhongPham(rs.getString("MASACH"), rs.getString("TENSACH"),rs.getDouble("GIAGOC"), ha, rs.getString("MOTA"), rs.getDate("NGAYNHAP"), rs.getBoolean("TRANGTHAI"),rs.getInt("SOLUONG"),
						rs.getDouble("THUE"), rs.getDouble("GIABAN"), nsx ,rs.getString("MAKHUYENMAI"),rs.getString("THUONGHIEU"),rs.getString("XUATXU"),ms,lvpp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vpp;
	}

	public VanPhongPham getVPPTheoTen(String ten) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		VanPhongPham vpp = null;
		try {
			pstm = con.prepareStatement("select * from VANPHONGPHAM where TENVPP = ?");
			pstm.setString(1, ten);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				NhaSanXuat nsx = dao_NSX.getNSXTheoMa(rs.getString("MANSX"));
				HinhAnh ha = dao_HA.getHinhAnhTheoMa(rs.getString("MAANH"));
				LoaiVanPhongPham lvpp = dao_LoaiVPP.getLoaiTheoMa(rs.getString("MALOAIVPP"));
				MauSac ms = dao_ms.getMauSacTheoMa(rs.getString("MAMAU"));
				vpp = new VanPhongPham(rs.getString("MASACH"), rs.getString("TENSACH"),rs.getDouble("GIAGOC"), ha, rs.getString("MOTA"), rs.getDate("NGAYNHAP"), rs.getBoolean("TRANGTHAI"),rs.getInt("SOLUONG"),
						rs.getDouble("THUE"), rs.getDouble("GIABAN"), nsx ,rs.getString("MAKHUYENMAI"),rs.getString("THUONGHIEU"),rs.getString("XUATXU"),ms,lvpp);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vpp;
	}

	public boolean addVPP(VanPhongPham vpp) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("insert into VANPHONGPHAM values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			pstm.setString(1, vpp.getMaSanPham());
			pstm.setString(2, vpp.getTenSanPham());
			pstm.setDouble(3, vpp.getGiaGoc());
			pstm.setString(4, vpp.getHinhAnh().getMaAnh());
			pstm.setString(5, vpp.getMoTa());
			pstm.setDate(6,  new java.sql.Date(vpp.getNgayNhap().getTime()));
			pstm.setBoolean(7, vpp.isTrangThai());
			pstm.setInt(8, vpp.getSoLuong());
			pstm.setDouble(9, vpp.getThue());
			pstm.setDouble(10, vpp.getGiaBan());
			pstm.setString(11, vpp.getNhaSanXuat().getMaNSX());
			pstm.setString(12, vpp.getKhuyenMai());
			pstm.setString(13, vpp.getThuongHieu());
			pstm.setString(14, vpp.getXuatXu());
			pstm.setString(15, vpp.getMaMau().getMaMau());
			pstm.setString(16, vpp.getLoaiVanPhongPham().getMaLoaiVPP());
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

	public boolean updateVPP(VanPhongPham VPP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("update VANPHONGPHAM set TENSACH = ?, GIAGOC = ?, MAANH = ?, MOTA = ?, NGAYNHAP = ?, TRANGTHAI = ?, "
					+ "SOLUONG = ?, THUE = ?, GIABAN = ?, MANSX = ?, MAKHUYENMAI = ?, THUONGHIEU = ?, XUATXU = ?, MAMAU = ?, MALOAIVPP = ? where MAVPP = ?");
			pstm.setString(16, VPP.getMaSanPham());
			pstm.setString(1, VPP.getTenSanPham());
			pstm.setDouble(2, VPP.getGiaGoc());
			pstm.setString(3, VPP.getNhaSanXuat().getMaNSX());
			pstm.setString(4, VPP.getMoTa());
			pstm.setDate(5, (Date) VPP.getNgayNhap());
			pstm.setBoolean(6, VPP.isTrangThai());
			pstm.setInt(7, VPP.getSoLuong());
			pstm.setDouble(8, VPP.getThue());
			pstm.setDouble(9, VPP.getGiaBan());
			pstm.setString(10, VPP.getNhaSanXuat().getMaNSX());
			pstm.setString(11, VPP.getKhuyenMai());
			pstm.setString(12, VPP.getThuongHieu());
			pstm.setString(13, VPP.getXuatXu());
			pstm.setString(14, VPP.getMaMau().getMaMau());
			pstm.setString(15, VPP.getLoaiVanPhongPham().getMaLoaiVPP());
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

	public boolean deleteVPP(String maSach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("delete from VANPHONGPHAM where MAVPP = ?");
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
	
	
	public String getMaAnhByMa_VPP(String maVPP) {
        String maAnh = null;

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAANH FROM VANPHONGPHAM WHERE MAVPP = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maVPP);
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
	
	public String getMaLoaiVPPByMa_VPP(String maVPP) {
        String loaiVPP = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MALOAIVPP FROM VANPHONGPHAM WHERE MAVPP = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maVPP);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        loaiVPP = resultSet.getString(1);              
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return loaiVPP;
    }
	
	public String getMaNSXByMa_VPP(String maVPP) {
        String nsx = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MANSX FROM VANPHONGPHAM WHERE MAVPP = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maVPP);
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
	
	public String getTrangThaiByMa_VPP(String maVPP) { 
        String trangThai = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT TRANGTHAI FROM VANPHONGPHAM WHERE MAVPP = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maVPP);
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
	
	public String getMaLoaiVPPByMaMauSac_VPP(String maVPP) {
        String maMau = null;
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAMAU FROM VANPHONGPHAM WHERE MAVPP = ?";
            try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                preparedStatement.setString(1, maVPP);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        maMau = resultSet.getString(1);              
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maMau;
    }
	//
	public void capNhatSoLuongTonTrongCSDL(String maSP, int soLuong) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
	    try {
	        String sql = "UPDATE VANPHONGPHAM SET SOLUONG = SOLUONG - ? WHERE MAVPP = ?";

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
