package cn.hibernate.onetomany;

import java.util.HashSet;
import java.util.Set;

public class Custorm {
	// �ͻ�id
	private Integer cid;
	// �ͻ�����
	private String custName;
	// �ͻ�����
	private String custLevel;
	// �ͻ���Դ
	private String custSource;
	// �ͻ��绰
	private String custPhone;
	// �ͻ��ֻ�
	private String custMobile;

	private Set<LinkMan> setLinkMans = new HashSet<LinkMan>();

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustLevel() {
		return custLevel;
	}

	public void setCustLevel(String custLevel) {
		this.custLevel = custLevel;
	}

	public String getCustSource() {
		return custSource;
	}

	public void setCustSource(String custSource) {
		this.custSource = custSource;
	}

	public String getCustPhone() {
		return custPhone;
	}

	public void setCustPhone(String custPhone) {
		this.custPhone = custPhone;
	}

	public String getCustMobile() {
		return custMobile;
	}

	public void setCustMobile(String custMobile) {
		this.custMobile = custMobile;
	}

	public Set<LinkMan> getSetLinkMans() {
		return setLinkMans;
	}

	public void setSetLinkMans(Set<LinkMan> setLinkMans) {
		this.setLinkMans = setLinkMans;
	}

}
