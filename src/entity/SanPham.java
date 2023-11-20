package entity;

import java.util.Date;

public class SanPham {
	String maSanPham;
	String tenSanPham;
	double giaGoc;
	HinhAnh hinhAnh;
	String moTa;
	Date ngayNhap;
	boolean trangThai;
	int soLuong;
	double thue;
	double giaBan;
	NhaSanXuat nhaSanXuat;
	String maKhuyenMai;
	public SanPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SanPham(String maSanPham, String tenSanPham, double giaGoc, HinhAnh hinhAnh, String moTa, Date ngayNhap,
			boolean trangThai, int soLuong, double thue, double giaBan, NhaSanXuat nhaSanXuat, String maKhuyenMai) {
		super();
		this.maSanPham = maSanPham;
		this.tenSanPham = tenSanPham;
		this.giaGoc = giaGoc;
		this.hinhAnh = hinhAnh;
		this.moTa = moTa;
		this.ngayNhap = ngayNhap;
		this.trangThai = trangThai;
		this.soLuong = soLuong;
		this.thue = thue;
		this.giaBan = giaBan;
		this.nhaSanXuat = nhaSanXuat;
		this.maKhuyenMai = maKhuyenMai;
	}
	
	public SanPham(String maSanPham) {
		super();
		this.maSanPham = maSanPham;
	}
	public String getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public double getGiaGoc() {
		return giaGoc;
	}
	public void setGiaGoc(double giaGoc) {
		this.giaGoc = giaGoc;
	}
	public HinhAnh getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(HinhAnh hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public Date getNgayNhap() {
		return ngayNhap;
	}
	public void setNgayNhap(Date ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	public boolean isTrangThai() {
		return trangThai;
	}
	public void setTrangThai(boolean trangThai) {
		this.trangThai = trangThai;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public double getThue() {
		return thue;
	}
	public void setThue(double thue) {
		this.thue = thue;
	}
	public double getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}
	public NhaSanXuat getNhaSanXuat() {
		return nhaSanXuat;
	}
	public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}
	public String getKhuyenMai() {
		return maKhuyenMai;
	}
	public void setKhuyenMai(String khuyenMai) {
		this.maKhuyenMai = khuyenMai;
	}
	
	@Override
	public String toString() {
		return "SanPham [maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", giaGoc=" + giaGoc + ", hinhAnh="
				+ hinhAnh + ", moTa=" + moTa + ", ngayNhap=" + ngayNhap + ", trangThai=" + trangThai + ", soLuong="
				+ soLuong + ", thue=" + thue + ", giaBan=" + giaBan + ", nhaSanXuat=" + nhaSanXuat + ", khuyenMai="
				+ maKhuyenMai + "]";
	}
	
	
}
