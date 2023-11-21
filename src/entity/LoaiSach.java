package entity;

public class LoaiSach {
	String maLoaiSach;
	String tenLoai;
	String moTa;
	double vat;
	public LoaiSach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiSach(String maLoaiSach, String tenLoai, String moTa, double vat) {
		super();
		this.maLoaiSach = maLoaiSach;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
		this.vat = vat;
	}
	
	
	public LoaiSach(String maLoaiSach) {
		super();
		this.maLoaiSach = maLoaiSach;
	}
	public String getMaLoaiSach() {
		return maLoaiSach;
	}
	public void setMaLoaiSach(String maLoaiSach) {
		this.maLoaiSach = maLoaiSach;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public double getVat() {
		return vat;
	}
	public void setVat(double vat) {
		this.vat = vat;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maLoaiSach == null) ? 0 : maLoaiSach.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((tenLoai == null) ? 0 : tenLoai.hashCode());
		long temp;
		temp = Double.doubleToLongBits(vat);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		LoaiSach other = (LoaiSach) obj;
		if (maLoaiSach == null) {
			if (other.maLoaiSach != null)
				return false;
		} else if (!maLoaiSach.equals(other.maLoaiSach))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (tenLoai == null) {
			if (other.tenLoai != null)
				return false;
		} else if (!tenLoai.equals(other.tenLoai))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoaiSach [maLoaiSach=" + maLoaiSach + ", tenLoai=" + tenLoai + ", moTa=" + moTa + ", vat=" + vat + "]";
	}
	
}
