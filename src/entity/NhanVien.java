package entity;

import java.util.Date;
import java.util.Objects;

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
	String email;
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String tenNV) {
		super();
		this.tenNV = tenNV;
	}

	public NhanVien(String maNV, String tenNV, Date ngaySinh, String diaChi, Date ngayVaoLam, String sdt, String cccd,
			Boolean gioiTinh, ChucVu chucVu, HinhAnh hinhAnh, String email) {
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
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cccd, chucVu, diaChi, email, gioiTinh, hinhAnh, maNV, ngaySinh, ngayVaoLam, sdt, tenNV);
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
		return Objects.equals(cccd, other.cccd) && Objects.equals(chucVu, other.chucVu)
				&& Objects.equals(diaChi, other.diaChi) && Objects.equals(email, other.email)
				&& Objects.equals(gioiTinh, other.gioiTinh) && Objects.equals(hinhAnh, other.hinhAnh)
				&& Objects.equals(maNV, other.maNV) && Objects.equals(ngaySinh, other.ngaySinh)
				&& Objects.equals(ngayVaoLam, other.ngayVaoLam) && Objects.equals(sdt, other.sdt)
				&& Objects.equals(tenNV, other.tenNV);
	}

	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi
				+ ", ngayVaoLam=" + ngayVaoLam + ", sdt=" + sdt + ", cccd=" + cccd + ", gioiTinh=" + gioiTinh
				+ ", chucVu=" + chucVu + ", hinhAnh=" + hinhAnh + ", email=" + email + "]";
	}

	
}
