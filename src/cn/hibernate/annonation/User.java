package cn.hibernate.annonation;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

//ע�Ͳ�ѯ��䣬ֻ��ʹ����ʹ��ע�ʹ����ı�
@NamedQueries(  
	    {  
	        @NamedQuery(  
	        name = "findUserByName",  
	        query = "from User u where u.username= :username"  
	        )  
	    }  
	) 

@Entity
@Table(name = "t_user")
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class User {
	// ���Խ���ʹ�û������ݵİ�װ��
	@Id
	private int uid;
	private String username;
	private String password;
	private String address;

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", address=" + address + "]";
	}
	
}
