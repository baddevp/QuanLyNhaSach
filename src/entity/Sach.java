package entity;

import java.util.Date;

public class Sach extends SanPham {
	int sotrang;
	String loaiBia;
	String tacGia;
	LoaiSach loaiSach;

	public Sach(String maSanPham, String tenSanPham, double giaGoc, HinhAnh hinhAnh, String moTa, Date ngayNhap,
			boolean trangThai, int soLuong, double thue, double giaBan, NhaSanXuat nhaSanXuat, String maKhuyenMai,
			int sotrang, String loaiBia, String tacGia, LoaiSach loaiSach) {
		super();
		this.sotrang = sotrang;
		this.loaiBia = loaiBia;
		this.tacGia = tacGia;
		this.loaiSach = loaiSach;
	}

	public int getSotrang() {
		return sotrang;
	}

	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}

	public String getLoaiBia() {
		return loaiBia;
	}

	public void setLoaiBia(String loaiBia) {
		this.loaiBia = loaiBia;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public LoaiSach getLoaiSach() {
		return loaiSach;
	}

	public void setLoaiSach(LoaiSach loaiSach) {
		this.loaiSach = loaiSach;
	}

	@Override
	public String toString() {
		return "Sach [sotrang=" + sotrang + ", loaiBia=" + loaiBia + ", tacGia=" + tacGia + ", loaiSach=" + loaiSach
				+ "]";
	}

}
