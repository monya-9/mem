package com.dev.model;

public class MemVO {
	private String id;
	private String pw;
	private String nickname;
	private String email;
	private Integer pnum;

	public MemVO() {

	}

	public MemVO(String id, String pw, String nickname, String email, Integer pnum) {
		super();
		this.id = id;
		this.pw = pw;
		this.nickname = nickname;
		this.email = email;
		this.pnum = pnum;
	}

	@Override
	public String toString() {
		return "MemVo [id=" + id + ", pw=" + pw + ", nickname=" + nickname + ", email=" + email + ", pnum=" + pnum
				+ "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPnum() {
		return pnum;
	}

	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}

}
