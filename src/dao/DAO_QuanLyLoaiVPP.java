package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiVanPhongPham;

public class DAO_QuanLyLoaiVPP {
	public ArrayList<LoaiVanPhongPham> getALLLoaiVPP() {
		ArrayList<LoaiVanPhongPham> ds = new ArrayList<LoaiVanPhongPham>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from LOAIVANPHONGPHAM");
			while (rs.next()) {
				ds.add(new LoaiVanPhongPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public LoaiVanPhongPham getLoaiTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiVanPhongPham loai = null;
		try {
			PreparedStatement pstm = con.prepareStatement("select * from LOAIVANPHONGPHAM where MALOAIVPP = ?");
			pstm.setString(1, ma);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				loai = new LoaiVanPhongPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loai;
	}

	public LoaiVanPhongPham getLoaiTheoTen(String ten) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		LoaiVanPhongPham loai = null;
		try {
			pstm = con.prepareStatement("select * from LOAIVANPHONGPHAM where TENLOAIVPP = ?");
			pstm.setString(1, ten);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				loai = new LoaiVanPhongPham(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loai;
	}

	public boolean addLoaiVPP(LoaiVanPhongPham loaiVanPhongPham) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("insert into LOAIVANPHONGPHAM values(?,?,?,?)");
			pstm.setString(1, loaiVanPhongPham.getMaLoaiVPP());
			pstm.setString(2, loaiVanPhongPham.getTenLoaiVPP());
			pstm.setString(3, loaiVanPhongPham.getMoTa());
			pstm.setDouble(4, loaiVanPhongPham.getVat());
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

	public boolean updateLoaiVPP(LoaiVanPhongPham loaiVPP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement(
					"update LOAIVANPHONGPHAM set TENLOAIVPP = ?, VAT = ?, MOTA = ? where MALOAIVPP = ?");
			pstm.setString(1, loaiVPP.getTenLoaiVPP());
			pstm.setDouble(2, loaiVPP.getVat());
			pstm.setString(3, loaiVPP.getMoTa());
			pstm.setString(4, loaiVPP.getMaLoaiVPP());
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

	public boolean deleteLoaiVPP(String maLoaiVPP) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("delete from LOAIVANPHONGPHAM where MALOAIVPP = ?");
			pstm.setString(1, maLoaiVPP);
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
	
	public String TuPhatSinhMaLoaiVPP() {
        String newMaLoaiSach = "LV001"; // Giá trị mặc định nếu không có dữ liệu trong bảng

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAX(MALOAIVPP) FROM LOAIVANPHONGPHAM";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String lastMaChucVu = rs.getString(1);

                if (lastMaChucVu != null) {
                    int number = Integer.parseInt(lastMaChucVu.substring(2).trim()) + 1;
                    String numberStr = String.format("%03d", number);
                    newMaLoaiSach = "LV" + numberStr;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newMaLoaiSach;
    }
}
