package entity;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

public class HoaDonHoanTra {
	String maYeuCauTraHang;
	LocalDateTime ngayLapHoaDonTH;
	String lyDoTraHang;
	double tongHoanTra;
	NhanVien nhanVien;
	KhachHang khachHang;
	HoaDon hoaDon;
	public HoaDonHoanTra() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDonHoanTra(String maYeuCauTraHang, LocalDateTime ngayLapHoaDonTH, String lyDoTraHang, double tongHoanTra, NhanVien nhanVien,
			KhachHang khachHang, HoaDon hoaDon) {
		super();
		this.maYeuCauTraHang = maYeuCauTraHang;
		this.ngayLapHoaDonTH = ngayLapHoaDonTH;
		this.lyDoTraHang = lyDoTraHang;
		this.tongHoanTra = tongHoanTra;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.hoaDon = hoaDon;
	}
	public double getTongHoanTra() {
		return tongHoanTra;
	}
	public void setTongHoanTra(double tongHoanTra) {
		this.tongHoanTra = tongHoanTra;
	}
	public String getMaYeuCauTraHang() {
		return maYeuCauTraHang;
	}
	public void setMaYeuCauTraHang(String maYeuCauTraHang) {
		this.maYeuCauTraHang = maYeuCauTraHang;
	}
	public LocalDateTime getNgayLapHoaDonTH() {
		return ngayLapHoaDonTH;
	}
	public void setNgayLapHoaDonTH(LocalDateTime ngayLapHoaDonTH) {
		this.ngayLapHoaDonTH = ngayLapHoaDonTH;
	}
	public String getLyDoTraHang() {
		return lyDoTraHang;
	}
	public void setLyDoTraHang(String lyDoTraHang) {
		this.lyDoTraHang = lyDoTraHang;
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
	public HoaDon getHoaDon() {
		return hoaDon;
	}
	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(hoaDon, khachHang, lyDoTraHang, maYeuCauTraHang, ngayLapHoaDonTH, nhanVien);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDonHoanTra other = (HoaDonHoanTra) obj;
		return Objects.equals(hoaDon, other.hoaDon) && Objects.equals(khachHang, other.khachHang)
				&& Objects.equals(lyDoTraHang, other.lyDoTraHang)
				&& Objects.equals(maYeuCauTraHang, other.maYeuCauTraHang)
				&& Objects.equals(ngayLapHoaDonTH, other.ngayLapHoaDonTH) && Objects.equals(nhanVien, other.nhanVien);
	}
	@Override
	public String toString() {
		return "HoaDonHoanTra [maYeuCauTraHang=" + maYeuCauTraHang + ", ngayLapHoaDonTH=" + ngayLapHoaDonTH
				+ ", lyDoTraHang=" + lyDoTraHang + ", tongHoanTra=" + tongHoanTra + ", nhanVien=" + nhanVien
				+ ", khachHang=" + khachHang + ", hoaDon=" + hoaDon + "]";
	}
	
}
