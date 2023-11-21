package entity;

public class MauSac {
	String maMau;
	String tenMau;
	public MauSac() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MauSac(String maMau, String tenMau) {
		super();
		this.maMau = maMau;
		this.tenMau = tenMau;
	}
	
	public MauSac(String maMau) {
		super();
		this.maMau = maMau;
	}
	public String getMaMau() {
		return maMau;
	}
	public void setMaMau(String maMau) {
		this.maMau = maMau;
	}
	public String getTenMau() {
		return tenMau;
	}
	public void setTenMau(String tenMau) {
		this.tenMau = tenMau;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maMau == null) ? 0 : maMau.hashCode());
		result = prime * result + ((tenMau == null) ? 0 : tenMau.hashCode());
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
		MauSac other = (MauSac) obj;
		if (maMau == null) {
			if (other.maMau != null)
				return false;
		} else if (!maMau.equals(other.maMau))
			return false;
		if (tenMau == null) {
			if (other.tenMau != null)
				return false;
		} else if (!tenMau.equals(other.tenMau))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "MauSac [maMau=" + maMau + ", tenMau=" + tenMau + "]";
	}
	
}
