package entity;

public class HinhAnh {
	String maAnh;
	String tenAnh;
	String url;
	public HinhAnh() {
		super();
		// TODO Auto-generated constructor stub
	}
	public HinhAnh(String maAnh, String tenAnh, String url) {
		super();
		this.maAnh = maAnh;
		this.tenAnh = tenAnh;
		this.url = url;
	}
	
	public HinhAnh(String maAnh) {
		super();
		this.maAnh = maAnh;
	}
	public String getMaAnh() {
		return maAnh;
	}
	public void setMaAnh(String maAnh) {
		this.maAnh = maAnh;
	}
	public String getTenAnh() {
		return tenAnh;
	}
	public void setTenAnh(String tenAnh) {
		this.tenAnh = tenAnh;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maAnh == null) ? 0 : maAnh.hashCode());
		result = prime * result + ((tenAnh == null) ? 0 : tenAnh.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		HinhAnh other = (HinhAnh) obj;
		if (maAnh == null) {
			if (other.maAnh != null)
				return false;
		} else if (!maAnh.equals(other.maAnh))
			return false;
		if (tenAnh == null) {
			if (other.tenAnh != null)
				return false;
		} else if (!tenAnh.equals(other.tenAnh))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "HinhAnh [maAnh=" + maAnh + ", tenAnh=" + tenAnh + ", url=" + url + "]";
	}
	
	
}
