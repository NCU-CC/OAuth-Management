package tw.edu.ncu.cc.manage.util;

import java.io.Serializable;

import tw.edu.ncu.cc.manage.entity.RoleEnum;

public class PersonInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String PERSON_INFO = "personInfo";
	
	private int id;
	private RoleEnum type;

	private String account;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public RoleEnum getType() {
		return type;
	}

	public void setType(RoleEnum type) {
		this.type = type;
	}
}
