package com.sejong.vue.model;

import org.apache.ibatis.type.Alias;

@Alias("Virtualnum")
public class Virtualnum {
	
	private int vtNum;
	private String vnumber;
	private String userId;
	private String path;
	private String useCheck;
	
	public Virtualnum() {
	}

	public Virtualnum(String vnumber, String userId, String path, String useCheck) {
		super();
		this.vnumber = vnumber;
		this.userId = userId;
		this.path = path;
		this.useCheck = useCheck;
	}

	public Virtualnum(int vtNum, String vnumber, String userId, String path, String useCheck) {
		super();
		this.vtNum = vtNum;
		this.vnumber = vnumber;
		this.userId = userId;
		this.path = path;
		this.useCheck = useCheck;
	}

	public int getVtNum() {
		return vtNum;
	}

	public void setVtNum(int vtNum) {
		this.vtNum = vtNum;
	}

	public String getVnumber() {
		return vnumber;
	}

	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getUseCheck() {
		return useCheck;
	}

	public void setUseCheck(String useCheck) {
		this.useCheck = useCheck;
	}

	@Override
	public String toString() {
		return "Virtualnum [vtNum=" + vtNum + ", vnumber=" + vnumber + ", userId=" + userId + ", path=" + path
				+ ", useCheck=" + useCheck + "]";
	}
}
