package cn.hibernate.extend.annonation2;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/*Hibernate每个子类一张表（使用注释）实例*/
// 角色类
@Entity
@Table(name = "t_roles4")
@Inheritance(strategy = InheritanceType.JOINED)
public class Roles {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	// 角色
	@Column(name = "role")
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
