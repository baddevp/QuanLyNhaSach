package entity;

public class NhaSanXuat {
	String maNSX;
	String tenNSX;
	String thanhPho;
	String email;
	String sdt;
	public NhaSanXuat() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NhaSanXuat(String maNSX, String tenNSX, String thanhPho, String email, String sdt) {
		super();
		this.maNSX = maNSX;
		this.tenNSX = tenNSX;
		this.thanhPho = thanhPho;
		this.email = email;
		this.sdt = sdt;
	}
	
	public NhaSanXuat(String maNSX) {
		super();
		this.maNSX = maNSX;
	}
	public String getMaNSX() {
		return maNSX;
	}
	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}
	public String getTenNSX() {
		return tenNSX;
	}
	public void setTenNSX(String tenNSX) {
		this.tenNSX = tenNSX;
	}
	public String getThanhPho() {
		return thanhPho;
	}
	public void setThanhPho(String thanhPho) {
		this.thanhPho = thanhPho;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((maNSX == null) ? 0 : maNSX.hashCode());
		result = prime * result + ((sdt == null) ? 0 : sdt.hashCode());
		result = prime * result + ((tenNSX == null) ? 0 : tenNSX.hashCode());
		result = prime * result + ((thanhPho == null) ? 0 : thanhPho.hashCode());
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
		NhaSanXuat other = (NhaSanXuat) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (maNSX == null) {
			if (other.maNSX != null)
				return false;
		} else if (!maNSX.equals(other.maNSX))
			return false;
		if (sdt == null) {
			if (other.sdt != null)
				return false;
		} else if (!sdt.equals(other.sdt))
			return false;
		if (tenNSX == null) {
			if (other.tenNSX != null)
				return false;
		} else if (!tenNSX.equals(other.tenNSX))
			return false;
		if (thanhPho == null) {
			if (other.thanhPho != null)
				return false;
		} else if (!thanhPho.equals(other.thanhPho))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "NhaSanXuat [maNSX=" + maNSX + ", tenNSX=" + tenNSX + ", thanhPho=" + thanhPho + ", email=" + email
				+ ", sdt=" + sdt + "]";
	}
	
}
