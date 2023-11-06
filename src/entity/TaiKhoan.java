package entity;

public class TaiKhoan {
	String maTaiKhoan;
	String matKhau;
	String phanQuyen;
	
	public TaiKhoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaiKhoan(String maTaiKhoan, String matKhau, String phanQuyen) {
		super();
		this.maTaiKhoan = maTaiKhoan;
		this.matKhau = matKhau;
		this.phanQuyen = phanQuyen;
	}

	
	public String getMaTaiKhoan() {
		return maTaiKhoan;
	}

	public void setMaTaiKhoan(String maTaiKhoan) {
		this.maTaiKhoan = maTaiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getPhanQuyen() {
		return phanQuyen;
	}

	public void setPhanQuyen(String phanQuyen) {
		this.phanQuyen = phanQuyen;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maTaiKhoan == null) ? 0 : maTaiKhoan.hashCode());
		result = prime * result + ((matKhau == null) ? 0 : matKhau.hashCode());
		result = prime * result + ((phanQuyen == null) ? 0 : phanQuyen.hashCode());
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
		TaiKhoan other = (TaiKhoan) obj;
		if (maTaiKhoan == null) {
			if (other.maTaiKhoan != null)
				return false;
		} else if (!maTaiKhoan.equals(other.maTaiKhoan))
			return false;
		if (matKhau == null) {
			if (other.matKhau != null)
				return false;
		} else if (!matKhau.equals(other.matKhau))
			return false;
		if (phanQuyen == null) {
			if (other.phanQuyen != null)
				return false;
		} else if (!phanQuyen.equals(other.phanQuyen))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TaiKhoan [maTaiKhoan=" + maTaiKhoan + ", matKhau=" + matKhau + ", phanQuyen=" + phanQuyen + "]";
	}
	
}
