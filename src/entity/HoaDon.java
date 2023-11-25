package entity;

import java.time.LocalDateTime;
import java.util.Date;

public class HoaDon {
	String maHoaDon;
	LocalDateTime ngayLapHoaDon;
	double tienNhan;
	double tongTien;
	NhanVien nhanVien;
	KhachHang khachHang;
	boolean trangThai;
	
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HoaDon(String maHoaDon, LocalDateTime ngayLapHoaDon, double tienNhan, double tongTien, NhanVien nhanVien,
			KhachHang khachHang, boolean trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tienNhan = tienNhan;
		this.tongTien = tongTien;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
	}

	public HoaDon(String maHoaDon) {
		super();
		this.maHoaDon = maHoaDon;
	}

	public String getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDateTime getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDateTime ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public double getTienNhan() {
		return tienNhan;
	}

	public void setTienNhan(double tienNhan) {
		this.tienNhan = tienNhan;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public boolean isTrangThai() {
		return trangThai;
	}

	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tienNhan=" + tienNhan
				+ ", tongTien=" + tongTien + ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", trangThai="
				+ trangThai + "]";
	}
	
	
}
