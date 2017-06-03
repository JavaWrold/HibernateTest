package cn.hibernate.extend2;

/*Hibernate每个具体类一张表映射(使用XML)*/
// 角色类
public class Roles {
	private int id;
	// 角色
	private String role;

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int id, String role) {
		super();
		this.id = id;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
