package entity;

import java.util.Date;

public class VanPhongPham extends SanPham {
	String thuongHieu;
	String xuatXu;
	MauSac maMau;
	LoaiVanPhongPham loaiVanPhongPham;
	public VanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VanPhongPham(String maSanPham, String tenSanPham, double giaGoc, HinhAnh hinhAnh, String moTa, Date ngayNhap,
			boolean trangThai, int soLuong, double thue, double giaBan, NhaSanXuat nhaSanXuat, String maKhuyenMai,
			String thuongHieu, String xuatXu, MauSac maMau, LoaiVanPhongPham loaiVanPhongPham) {
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
		this.thuongHieu = thuongHieu;
		this.xuatXu = xuatXu;
		this.maMau = maMau;
		this.loaiVanPhongPham = loaiVanPhongPham;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public MauSac getMaMau() {
		return maMau;
	}
	public void setMaMau(MauSac maMau) {
		this.maMau = maMau;
	}
	public LoaiVanPhongPham getLoaiVanPhongPham() {
		return loaiVanPhongPham;
	}
	public void setLoaiVanPhongPham(LoaiVanPhongPham loaiVanPhongPham) {
		this.loaiVanPhongPham = loaiVanPhongPham;
	}
	@Override
	public String toString() {
		return "VanPhongPham [thuongHieu=" + thuongHieu + ", xuatXu=" + xuatXu + ", maMau=" + maMau
				+ ", loaiVanPhongPham=" + loaiVanPhongPham + "]";
	}
	
	
	
}
