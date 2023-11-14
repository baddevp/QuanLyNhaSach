package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.HinhAnh;
import entity.NhaSanXuat;

public class DAO_HinhAnh {
	public ArrayList<HinhAnh> getAllImg(){
		ArrayList<HinhAnh> dsIMG = new ArrayList<HinhAnh>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from HINHANH";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maHinhAnh = rs.getString(1);
				String tenHinhAnh = rs.getString(2);
				String url = rs.getString(3);
				HinhAnh img = new HinhAnh(maHinhAnh,tenHinhAnh,url);
				dsIMG.add(img);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsIMG; 
	}
	
	public boolean themHinhAnh(HinhAnh img) {
        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            
            // Sử dụng PreparedStatement để thêm dữ liệu 
            String sql = "INSERT INTO HINHANH (MAANH, TENANH, URL) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, img.getMaAnh());
            pstmt.setString(2, img.getTenAnh());
            pstmt.setString(3, img.getUrl());
            
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
	
	public String generateNewMaChucVu() {
        String newMaChucVu = "HA00001"; // Giá trị mặc định nếu không có dữ liệu trong bảng

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAX(MAANH) FROM HINHANH";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String lastMaChucVu = rs.getString(1);

                if (lastMaChucVu != null) {
                    int number = Integer.parseInt(lastMaChucVu.substring(2).trim()) + 1;
                    String numberStr = String.format("%05d", number);
                    newMaChucVu = "HA" + numberStr;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newMaChucVu;
    }
	public HinhAnh getHinhAnhTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		HinhAnh ha = null;
		try {
			PreparedStatement pstm = con.prepareStatement("select * from HINHANH where MAANH = ?");
			pstm.setString(1, ma);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				ha = new HinhAnh(rs.getString(1), rs.getString(2),rs.getString(3));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ha;
	}
	public String generateNewMaChucVusdsd() {
        String newMaChucVu = "Image00001"; // Giá trị mặc định nếu không có dữ liệu trong bảng

        try {
            ConnectDB.getInstance();
            Connection con = ConnectDB.getConnection();
            String sql = "SELECT MAX(TENANH) FROM HINHANH";
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(sql);

            if (rs.next()) {
                String lastMaChucVu = rs.getString(1);

                if (lastMaChucVu != null) {
                    int number = Integer.parseInt(lastMaChucVu.substring(5).trim()) + 1;
                    String numberStr = String.format("%05d", number);
                    newMaChucVu = "Image" + numberStr;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newMaChucVu;
    }

}
