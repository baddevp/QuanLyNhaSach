package entity;

import java.util.Date;

public class HoaDon {
	String maHoaDon;
	Date ngayLapHoaDon;
	double tienNhan;
	NhanVien nhanVien;
	KhachHang khachHang;
	boolean trangThai;
	public HoaDon() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HoaDon(String maHoaDon, Date ngayLapHoaDon, double tienNhan, NhanVien nhanVien, KhachHang khachHang,
			boolean trangThai) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.tienNhan = tienNhan;
		this.nhanVien = nhanVien;
		this.khachHang = khachHang;
		this.trangThai = trangThai;
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((khachHang == null) ? 0 : khachHang.hashCode());
		result = prime * result + ((maHoaDon == null) ? 0 : maHoaDon.hashCode());
		result = prime * result + ((ngayLapHoaDon == null) ? 0 : ngayLapHoaDon.hashCode());
		result = prime * result + ((nhanVien == null) ? 0 : nhanVien.hashCode());
		long temp;
		temp = Double.doubleToLongBits(tienNhan);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (trangThai ? 1231 : 1237);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		if (khachHang == null) {
			if (other.khachHang != null)
				return false;
		} else if (!khachHang.equals(other.khachHang))
			return false;
		if (maHoaDon == null) {
			if (other.maHoaDon != null)
				return false;
		} else if (!maHoaDon.equals(other.maHoaDon))
			return false;
		if (ngayLapHoaDon == null) {
			if (other.ngayLapHoaDon != null)
				return false;
		} else if (!ngayLapHoaDon.equals(other.ngayLapHoaDon))
			return false;
		if (nhanVien == null) {
			if (other.nhanVien != null)
				return false;
		} else if (!nhanVien.equals(other.nhanVien))
			return false;
		if (Double.doubleToLongBits(tienNhan) != Double.doubleToLongBits(other.tienNhan))
			return false;
		if (trangThai != other.trangThai)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", tienNhan=" + tienNhan
				+ ", nhanVien=" + nhanVien + ", khachHang=" + khachHang + ", trangThai=" + trangThai + "]";
	}
	
	
}
