package cn.hibernate.manytomany;

import java.util.HashSet;
import java.util.Set;

public class User {
	private Integer uid;
	private String username;
	private String password;

	private Set<Role> setUser = new HashSet<Role>();

	public Set<Role> getSetUser() {
		return setUser;
	}

	public void setSetUser(Set<Role> setUser) {
		this.setUser = setUser;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", setUser=" + setUser + "]";
	}

}
