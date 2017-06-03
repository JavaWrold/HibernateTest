package cn.hibernate.extend.annonation1;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

// alt+shift s/t
/**
 * @author Administrator
 *
 */

@Entity
@DiscriminatorValue(value = "stu")
public class Student extends Roles {
	@Column(name = "stu_name")
	private String stu_name;
	@Column(name = "stu_age")
	private int stu_age;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String stu_name, int stu_age) {
		super();
		this.stu_name = stu_name;
		this.stu_age = stu_age;
	}

	public String getStu_name() {
		return stu_name;
	}

	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}

	public int getStu_age() {
		return stu_age;
	}

	public void setStu_age(int stu_age) {
		this.stu_age = stu_age;
	}

}
