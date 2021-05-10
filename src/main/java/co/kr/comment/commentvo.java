package co.kr.comment;

import java.sql.Timestamp;

public class commentvo {

	private int bid;
	private String uid;
	private String comment;
	private Timestamp created;
	
	public commentvo() {}
	public commentvo(int bid ,String uid,String comment,Timestamp created)
	{
		this.bid=bid;
		this.uid=uid;
		this.comment=comment;
		this.created=created;
	}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getCreated() {
		return created;
	}
	public void setCreated(Timestamp created) {
		this.created = created;
	}
	
}
