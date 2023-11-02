package entity;

import java.util.Date;

public class VanPhongPham extends SanPham {
	String thuongHieu;
	String xuatXu;
	MauSac maMau;
	LoaiVanPhongPham loaiVanPhongPham;
	public VanPhongPham() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VanPhongPham(String thuongHieu, String xuatXu, MauSac maMau, LoaiVanPhongPham loaiVanPhongPham) {
		super();
		this.thuongHieu = thuongHieu;
		this.xuatXu = xuatXu;
		this.maMau = maMau;
		this.loaiVanPhongPham = loaiVanPhongPham;
	}
	public String getThuongHieu() {
		return thuongHieu;
	}
	public void setThuongHieu(String thuongHieu) {
		this.thuongHieu = thuongHieu;
	}
	public String getXuatXu() {
		return xuatXu;
	}
	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}
	public MauSac getMaMau() {
		return maMau;
	}
	public void setMaMau(MauSac maMau) {
		this.maMau = maMau;
	}
	public LoaiVanPhongPham getLoaiVanPhongPham() {
		return loaiVanPhongPham;
	}
	public void setLoaiVanPhongPham(LoaiVanPhongPham loaiVanPhongPham) {
		this.loaiVanPhongPham = loaiVanPhongPham;
	}
	@Override
	public String toString() {
		return "VanPhongPham [thuongHieu=" + thuongHieu + ", xuatXu=" + xuatXu + ", maMau=" + maMau
				+ ", loaiVanPhongPham=" + loaiVanPhongPham + "]";
	}
	
	
	
}