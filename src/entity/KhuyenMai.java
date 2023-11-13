package entity;

import java.util.Date;

public class KhuyenMai {
	String maKM;
	String tenKM;
	Date ngayBD;
	Date ngatKT;
	float chietKhau;
	
	public KhuyenMai() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhuyenMai(String maKM, String tenKM, Date ngayBD, Date ngatKT, float chietKhau) {
		super();
		this.maKM = maKM;
		this.tenKM = tenKM;
		this.ngayBD = ngayBD;
		this.ngatKT = ngatKT;
		this.chietKhau = chietKhau;
	}

	public String getMaKM() {
		return maKM;
	}


	public void setMaKM(String maKM) {
		this.maKM = maKM;
	}


	public String getTenKM() {
		return tenKM;
	}


	public void setTenKM(String tenKM) {
		this.tenKM = tenKM;
	}


	public Date getNgayBD() {
		return ngayBD;
	}


	public void setNgayBD(Date ngayBD) {
		this.ngayBD = ngayBD;
	}


	public Date getNgatKT() {
		return ngatKT;
	}


	public void setNgatKT(Date ngatKT) {
		this.ngatKT = ngatKT;
	}


	public float getChietKhau() {
		return chietKhau;
	}


	public void setChietKhau(float chietKhau) {
		this.chietKhau = chietKhau;
	}

	@Override
	public String toString() {
		return "KhuyenMai [maKM=" + maKM + ", tenKM=" + tenKM + ", ngayBD=" + ngayBD + ", ngatKT=" + ngatKT
				+ ", chietKhau=" + chietKhau + "]";
	}
	
	
}
