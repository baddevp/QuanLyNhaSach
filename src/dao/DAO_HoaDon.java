package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import connectDB.ConnectDB;

public class DAO_HoaDon {
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
	            if (lastMaHD != null && lastMaHD.startsWith("HD") && lastMaHD.length() >= 11) {
	                // Extract the sequence number part from MAKH
	                String sequenceNumberPart = lastMaHD.substring(10);

	                // Convert the extracted part to an integer
	                newMaHD = Integer.parseInt(sequenceNumberPart);
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return newMaHD;
	}
}
