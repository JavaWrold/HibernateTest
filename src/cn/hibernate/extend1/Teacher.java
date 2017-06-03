package cn.hibernate.extend1;

public class Teacher extends Roles {
	private String tea_name;
	private int tea_age;

	public Teacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getTea_name() {
		return tea_name;
	}

	public void setTea_name(String tea_name) {
		this.tea_name = tea_name;
	}

	public int getTea_age() {
		return tea_age;
	}

	public void setTea_age(int tea_age) {
		this.tea_age = tea_age;
	}

	public Teacher(String tea_name, int tea_age) {
		super();
		this.tea_name = tea_name;
		this.tea_age = tea_age;
	}
}
