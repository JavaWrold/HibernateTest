package cn.hibernate.extend1;

/*Hibernateʹ��xml�ļ���ÿ������һ�ű�*/
// ��ɫ��
public class Roles {
	private int id;
	// ��ɫ
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