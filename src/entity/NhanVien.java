package entity;

import java.util.Date;

public class NhanVien {
	String maNV;
	String tenNV;
	Date ngaySinh;
	String diaChi;
	Date ngayVaoLam;
	String sdt;
	String cccd;
	Boolean gioiTinh;
	ChucVu chucVu;
	HinhAnh hinhAnh;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String tenNV) {
		super();
		this.tenNV = tenNV;
	}

	public NhanVien(String maNV, String tenNV, Date ngaySinh, String diaChi, Date ngayVaoLam, String sdt, String cccd,
			Boolean gioiTinh, ChucVu chucVu, HinhAnh hinhAnh) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
		this.ngayVaoLam = ngayVaoLam;
		this.sdt = sdt;
		this.cccd = cccd;
		this.gioiTinh = gioiTinh;
		this.chucVu = chucVu;
		this.hinhAnh = hinhAnh;
	}
	
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public Boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(Boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public ChucVu getChucVu() {
		return chucVu;
	}
	public void setChucVu(ChucVu chucVu) {
		this.chucVu = chucVu;
	}
	public HinhAnh getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(HinhAnh hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cccd == null) ? 0 : cccd.hashCode());
		result = prime * result + ((chucVu == null) ? 0 : chucVu.hashCode());
		result = prime * result + ((diaChi == null) ? 0 : diaChi.hashCode());
		result = prime * result + ((gioiTinh == null) ? 0 : gioiTinh.hashCode());
		result = prime * result + ((hinhAnh == null) ? 0 : hinhAnh.hashCode());
		result = prime * result + ((maNV == null) ? 0 : maNV.hashCode());
		result = prime * result + ((ngaySinh == null) ? 0 : ngaySinh.hashCode());
		result = prime * result + ((ngayVaoLam == null) ? 0 : ngayVaoLam.hashCode());
		result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
		result = prime * result + ((tenNV == null) ? 0 : tenNV.hashCode());
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
		NhanVien other = (NhanVien) obj;
		if (cccd == null) {
			if (other.cccd != null)
				return false;
		} else if (!cccd.equals(other.cccd))
			return false;
		if (chucVu == null) {
			if (other.chucVu != null)
				return false;
		} else if (!chucVu.equals(other.chucVu))
			return false;
		if (diaChi == null) {
			if (other.diaChi != null)
				return false;
		} else if (!diaChi.equals(other.diaChi))
			return false;
		if (gioiTinh == null) {
			if (other.gioiTinh != null)
				return false;
		} else if (!gioiTinh.equals(other.gioiTinh))
			return false;
		if (hinhAnh == null) {
			if (other.hinhAnh != null)
				return false;
		} else if (!hinhAnh.equals(other.hinhAnh))
			return false;
		if (maNV == null) {
			if (other.maNV != null)
				return false;
		} else if (!maNV.equals(other.maNV))
			return false;
		if (ngaySinh == null) {
			if (other.ngaySinh != null)
				return false;
		} else if (!ngaySinh.equals(other.ngaySinh))
			return false;
		if (ngayVaoLam == null) {
			if (other.ngayVaoLam != null)
				return false;
		} else if (!ngayVaoLam.equals(other.ngayVaoLam))
			return false;
		if (sdt == null) {
			if (other.sdt != null)
				return false;
		} else if (!sdt.equals(other.sdt))
			return false;
		if (tenNV == null) {
			if (other.tenNV != null)
				return false;
		} else if (!tenNV.equals(other.tenNV))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi
				+ ", ngayVaoLam=" + ngayVaoLam + ", sdt=" + sdt + ", cccd=" + cccd + ", gioiTinh=" + gioiTinh
				+ ", chucVu=" + chucVu + ", hinhAnh=" + hinhAnh + "]";
	}
	
	
}
