package cn.hibernate.component;

//Hibernate×é¼şÓ³Éä
public class People {
	private int pid;
	private String name;
	private Address address;

	public People() {
		super();
		// TODO Auto-generated constructor stub
	}

	public People(int pid, String name, Address address) {
		super();
		this.pid = pid;
		this.name = name;
		this.address = address;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "People [pid=" + pid + ", name=" + name + ", address=" + address + "]";
	}

}
