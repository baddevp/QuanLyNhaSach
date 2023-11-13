package entity;

import java.util.Date;

public class HoaDon {
	String maHoaDon;
	Date ngayLapHoaDon;
	double tienNhan;
	NhanVien nhanVien;
	KhachHang khachHang;
	boolean trangThai;
	KhuyenMai khuyenMai;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHoaDon, Date ngayLapHoaDon, double tienNhan, NhanVien nhanVien, KhachHang khachHang,
			boolean trangThai, KhuyenMai khuyenMai) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tienNhan = tienNhan;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
		this.khuyenMai = khuyenMai;
	}
	public String getMaHoaDon() {
		return maHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		this.maHoaDon = maHoaDon;
	}
	public Date getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}
	public void setNgayLapHoaDon(Date ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}
	public double getTienNhan() {
		return tienNhan;
	}
	public void setTienNhan(double tienNhan) {
		this.tienNhan = tienNhan;
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
	public KhuyenMai getKhuyenMai() {
		return khuyenMai;
	}
	public void setKhuyenMai(KhuyenMai khuyenMai) {
		this.khuyenMai = khuyenMai;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tienNhan=" + tienNhan
				+ ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", trangThai=" + trangThai + ", khuyenMai="
				+ khuyenMai + "]";
	}
	
	
	
}
