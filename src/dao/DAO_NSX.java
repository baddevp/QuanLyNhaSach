package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaSanXuat;

public class DAO_NSX {
	public ArrayList<NhaSanXuat> getAllNSX(){
		ArrayList<NhaSanXuat> dsNSX = new ArrayList<NhaSanXuat>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select * from NHASANXUAT";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				String maNSX = rs.getString(1);
				String tenNSX = rs.getString(2);
				String thanhPho = rs.getString(3);
				String email = rs.getString(4);
				String sdt = rs.getString(5);
				
				NhaSanXuat nsx = new NhaSanXuat(maNSX,tenNSX,thanhPho,email,sdt);
				dsNSX.add(nsx);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return dsNSX;
	}
	
	public boolean createNSX(NhaSanXuat nsx) {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement st = null;
		int n=0;
		try {
			st = con.prepareStatement("insert into NHASANXUAT" + " values(?,?,?,?,?)");
			
			st.setString(1, nsx.getMaNSX());
			st.setString(2, nsx.getTenNSX());
			st.setString(3, nsx.getThanhPho());
			st.setString(4, nsx.getEmail());
			st.setString(5, nsx.getSdt());
			
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
	public boolean xoaNSX(String maNSX) {
		int k = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "delete from NHASANXUAT where MANSX = ?";
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, maNSX);
			k = preparedStatement.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return k>0;
	}
}
