package entity;

import java.time.LocalDateTime;
import java.util.Date;

public class KhachHang {
	String maKH;
	String tenKH;
	String diaChi;
	String sdt;
	int diemTL;
	LocalDateTime ngayLap;
	String email;
	public KhachHang() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}

	public KhachHang(String maKH, String tenKH, String diaChi, String sdt, int diemTL, LocalDateTime ngayLap, String email) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.diemTL = diemTL;
		this.ngayLap = ngayLap;
		this.email = email;
	}
	
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public int getDiemTL() {
		return diemTL;
	}
	public void setDiemTL(int diemTL) {
		this.diemTL = diemTL;
	}
	public LocalDateTime getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(LocalDateTime ngayLap) {
		this.ngayLap = ngayLap;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
		result = prime * result + diemTL;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((maKH == null) ? 0 : maKH.hashCode());
		result = prime * result + ((ngayLap == null) ? 0 : ngayLap.hashCode());
		result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
		result = prime * result + ((tenKH == null) ? 0 : tenKH.hashCode());
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
		KhachHang other = (KhachHang) obj;
		if (diaChi == null) {
			if (other.diaChi != null)
				return false;
		} else if (!diaChi.equals(other.diaChi))
			return false;
		if (diemTL != other.diemTL)
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (maKH == null) {
			if (other.maKH != null)
				return false;
		} else if (!maKH.equals(other.maKH))
			return false;
		if (ngayLap == null) {
			if (other.ngayLap != null)
				return false;
		} else if (!ngayLap.equals(other.ngayLap))
			return false;
		if (sdt == null) {
			if (other.sdt != null)
				return false;
		} else if (!sdt.equals(other.sdt))
			return false;
		if (tenKH == null) {
			if (other.tenKH != null)
				return false;
		} else if (!tenKH.equals(other.tenKH))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", diaChi=" + diaChi + ", sdt=" + sdt + ", diemTL="
				+ diemTL + ", ngayLap=" + ngayLap + ", email=" + email + "]";
	}
	
}
