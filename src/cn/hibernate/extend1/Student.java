package cn.hibernate.extend1;

// alt+shift s/t
/**
 * @author Administrator
 *
 */
public class Student extends Roles {
	private String stu_name;
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
