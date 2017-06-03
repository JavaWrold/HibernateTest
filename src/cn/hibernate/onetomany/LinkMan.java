package cn.hibernate.onetomany;

public class LinkMan {
	private Integer lkm_id;
	private String lkm_name;
	private String lkm_gender;
	private String lkm_phone;

	private Custorm custorm;

	public Integer getLkm_id() {
		return lkm_id;
	}

	public void setLkm_id(Integer lkm_id) {
		this.lkm_id = lkm_id;
	}

	public String getLkm_name() {
		return lkm_name;
	}

	public void setLkm_name(String lkm_name) {
		this.lkm_name = lkm_name;
	}

	public String getLkm_gender() {
		return lkm_gender;
	}

	public void setLkm_gender(String lkm_gender) {
		this.lkm_gender = lkm_gender;
	}

	public String getLkm_phone() {
		return lkm_phone;
	}

	public void setLkm_phone(String lkm_phone) {
		this.lkm_phone = lkm_phone;
	}

	public Custorm getCustorm() {
		return custorm;
	}

	public void setCustorm(Custorm custorm) {
		this.custorm = custorm;
	}

}
