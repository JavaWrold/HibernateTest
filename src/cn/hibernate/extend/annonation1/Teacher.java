package cn.hibernate.extend.annonation1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "tea")
public class Teacher extends Roles {
	@Column(name = "tea_name")
	private String tea_name;
	@Column(name = "tea_age")
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
