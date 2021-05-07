package co.kr.member;

import java.sql.Timestamp;

public class membervo {
	
	private String userid;
	private String username;
	private String userpwd;
	private String useremail;
	private Timestamp usercreated;
	
	public membervo() {}

	public membervo(String userid,String username,String userpwd,String useremail,Timestamp usercreated) 
	{
		this.userid = userid;
		this.username = username;
		this.userpwd = userpwd;
		this.useremail = useremail;
		this.usercreated = usercreated;	
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public Timestamp getUsercreated() {
		return usercreated;
	}

	public void setUsercreated(Timestamp usercreated) {
		this.usercreated = usercreated;
	}
	
	
}
