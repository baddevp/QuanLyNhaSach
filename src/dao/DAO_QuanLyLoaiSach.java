package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiSach;

public class DAO_QuanLyLoaiSach {
	public ArrayList<LoaiSach> getALLLoaiSach() {
		ArrayList<LoaiSach> ds = new ArrayList<LoaiSach>();
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from LOAISACH");
			while (rs.next()) {
				ds.add(new LoaiSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ds;
	}

	public LoaiSach getLoaiTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		LoaiSach loai = null;
		try {
			PreparedStatement pstm = con.prepareStatement("select * from LOAISACH where MALOAISACH = ?");
			pstm.setString(1, ma);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				loai = new LoaiSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loai;
	}

	public LoaiSach getLoaiTheoTen(String ten) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		LoaiSach loai = null;
		try {
			pstm = con.prepareStatement("select * from LOAISACH where TENLOAISACH = ?");
			pstm.setString(1, ten);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				loai = new LoaiSach(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDouble(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return loai;
	}

	public boolean addLoaiSach(LoaiSach loaisach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("insert into LOAISACH values(?,?,?,?)");
			pstm.setString(1, loaisach.getMaLoaiSach());
			pstm.setString(2, loaisach.getTenLoai());
			pstm.setString(3, loaisach.getMoTa());
			pstm.setDouble(4, loaisach.getVat());
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

	public boolean updateLoaiSach(LoaiSach loaiSach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement(
					"update LOAISACH set TENLOAI = ?, VAT = ?, MOTA = ? where MALOAISACH = ?");
			pstm.setString(1, loaiSach.getTenLoai());
			pstm.setDouble(2, loaiSach.getVat());
			pstm.setString(3, loaiSach.getMoTa());
			pstm.setString(4, loaiSach.getMaLoaiSach());
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

	public boolean deleteLoaiSach(String maLoaiSach) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement("delete from LOAISACH where MALOAISACH = ?");
			pstm.setString(1, maLoaiSach);
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
	
	public String TuPhatSinhMaLoaiSach() {
        String newMaLoaiSach = "LS001"; // Giá trị mặc định nếu không có dữ liệu trong bảng

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAX(MALOAISACH) FROM LOAISACH";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String lastMaChucVu = rs.getString(1);

                if (lastMaChucVu != null) {
                    int number = Integer.parseInt(lastMaChucVu.substring(2).trim()) + 1;
                    String numberStr = String.format("%03d", number);
                    newMaLoaiSach = "LS" + numberStr;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newMaLoaiSach;
    }
}
