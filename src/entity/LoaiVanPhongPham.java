package entity;

public class LoaiVanPhongPham {
	String maLoaiVPP;
	String tenLoaiVPP;
	String moTa;
	double vat;
	public LoaiVanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public LoaiVanPhongPham(String maLoaiVPP, String tenLoaiVPP, String moTa, double vat) {
		super();
		this.maLoaiVPP = maLoaiVPP;
		this.tenLoaiVPP = tenLoaiVPP;
		this.moTa = moTa;
		this.vat = vat;
	}
	
	public LoaiVanPhongPham(String maLoaiVPP) {
		super();
		this.maLoaiVPP = maLoaiVPP;
	}
	public String getMaLoaiVPP() {
		return maLoaiVPP;
	}
	public void setMaLoaiVPP(String maLoaiVPP) {
		this.maLoaiVPP = maLoaiVPP;
	}
	public String getTenLoaiVPP() {
		return tenLoaiVPP;
	}
	public void setTenLoaiVPP(String tenLoaiVPP) {
		this.tenLoaiVPP = tenLoaiVPP;
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
		result = prime * result + ((maLoaiVPP == null) ? 0 : maLoaiVPP.hashCode());
		result = prime * result + ((moTa == null) ? 0 : moTa.hashCode());
		result = prime * result + ((tenLoaiVPP == null) ? 0 : tenLoaiVPP.hashCode());
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
		LoaiVanPhongPham other = (LoaiVanPhongPham) obj;
		if (maLoaiVPP == null) {
			if (other.maLoaiVPP != null)
				return false;
		} else if (!maLoaiVPP.equals(other.maLoaiVPP))
			return false;
		if (moTa == null) {
			if (other.moTa != null)
				return false;
		} else if (!moTa.equals(other.moTa))
			return false;
		if (tenLoaiVPP == null) {
			if (other.tenLoaiVPP != null)
				return false;
		} else if (!tenLoaiVPP.equals(other.tenLoaiVPP))
			return false;
		if (Double.doubleToLongBits(vat) != Double.doubleToLongBits(other.vat))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "LoaiVanPhongPham [maLoaiVPP=" + maLoaiVPP + ", tenLoaiVPP=" + tenLoaiVPP + ", moTa=" + moTa + ", vat="
				+ vat + "]";
	}
	
}
