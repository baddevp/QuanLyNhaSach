package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.MauSac;
import entity.NhaSanXuat;

public class DAO_MauSac {
	public ArrayList<MauSac> getAllMauSac(){
		ArrayList<MauSac> dsMS = new ArrayList<MauSac>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from MAUSAC";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maMauSac = rs.getString(1);
				String tenMauSac = rs.getString(2);
				
			MauSac ms = new MauSac(maMauSac,tenMauSac);
				dsMS.add(ms);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsMS; 
	}
	public MauSac getMauSacTheoMa(String ma) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		MauSac mauSac = null;
		try {
			PreparedStatement pstm = con.prepareStatement("select * from MAUSAC where MAMAU = ?");
			pstm.setString(1, ma);
			ResultSet rs = pstm.executeQuery();
			while (rs.next()) {
				mauSac = new MauSac(rs.getString(1), rs.getString(2));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mauSac;
	}
	public boolean createMS(MauSac ms) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement("insert into " + "MAUSAC values(?,?)");
			
			st.setString(1, ms.getMaMau());
			st.setString(2, ms.getTenMau());
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
	public boolean updateMauSac(MauSac ms) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement pstm = null;
		int n = 0;
		try {
			pstm = con.prepareStatement(
					"update NHASANXUAT set TENMAU = ? where MAMAU = ?");
			pstm.setString(2, ms.getMaMau());
			pstm.setString(1, ms.getTenMau());
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
	public boolean xoaMS(String maMauSac) {
		int k = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from MAUSAC where MAMAU = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maMauSac);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}

}
