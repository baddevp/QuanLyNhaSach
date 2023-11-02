package entity;

public class ChiTietHoanTra {
	HoaDonHoanTra hoaDonHoanTra;
	SanPham sanPham;
	int soLuongTra;
	public ChiTietHoanTra() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChiTietHoanTra(HoaDonHoanTra hoaDonHoanTra, SanPham sanPham, int soLuongTra) {
		super();
		this.hoaDonHoanTra = hoaDonHoanTra;
		this.sanPham = sanPham;
		this.soLuongTra = soLuongTra;
	}
	public HoaDonHoanTra getHoaDonHoanTra() {
		return hoaDonHoanTra;
	}
	public void setHoaDonHoanTra(HoaDonHoanTra hoaDonHoanTra) {
		this.hoaDonHoanTra = hoaDonHoanTra;
	}
	public SanPham getSanPham() {
		return sanPham;
	}
	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}
	public int getSoLuongTra() {
		return soLuongTra;
	}
	public void setSoLuongTra(int soLuongTra) {
		this.soLuongTra = soLuongTra;
	}
	@Override
	public String toString() {
		return "ChiTietHoanTra [hoaDonHoanTra=" + hoaDonHoanTra + ", sanPham=" + sanPham + ", soLuongTra=" + soLuongTra
				+ "]";
	}
	
	
}
