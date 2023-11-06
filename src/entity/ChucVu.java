package entity;

public class ChucVu {
	String maChucVu;
	String tenChucVu;
	public ChucVu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ChucVu(String maChucVu, String tenChucVu) {
		super();
		this.maChucVu = maChucVu;
		this.tenChucVu = tenChucVu;
	}
	
	public ChucVu(String maChucVu) {
		super();
		this.maChucVu = maChucVu;
	}
	public String getMaChucVu() {
		return maChucVu;
	}
	public void setMaChucVu(String maChucVu) {
		this.maChucVu = maChucVu;
	}
	public String getTenChucVu() {
		return tenChucVu;
	}
	public void setTenChucVu(String tenChucVu) {
		this.tenChucVu = tenChucVu;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maChucVu == null) ? 0 : maChucVu.hashCode());
		result = prime * result + ((tenChucVu == null) ? 0 : tenChucVu.hashCode());
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
		ChucVu other = (ChucVu) obj;
		if (maChucVu == null) {
			if (other.maChucVu != null)
				return false;
		} else if (!maChucVu.equals(other.maChucVu))
			return false;
		if (tenChucVu == null) {
			if (other.tenChucVu != null)
				return false;
		} else if (!tenChucVu.equals(other.tenChucVu))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ChucVu [maChucVu=" + maChucVu + ", tenChucVu=" + tenChucVu + "]";
	}
	
	
}
