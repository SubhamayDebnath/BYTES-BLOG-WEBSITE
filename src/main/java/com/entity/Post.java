package com.entity;
import java.sql.*;
public class Post {

	private int bid;
	private String btittle;
	private String bcont;
	private Timestamp bdate;
	private String bpic;
	private int catid;
	private int userid;
	
	public Post()
	{
		super();
	}

	public Post(String btittle, String bcont, Timestamp bdate, String bpic, int catid, int userid) {
		super();
		this.btittle = btittle;
		this.bcont = bcont;
		this.bdate = bdate;
		this.bpic = bpic;
		this.catid = catid;
		this.userid = userid;
	}

	public Post(int bid, String btittle, String bcont, Timestamp bdate, String bpic, int catid, int userid) {
		super();
		this.bid = bid;
		this.btittle = btittle;
		this.bcont = bcont;
		this.bdate = bdate;
		this.bpic = bpic;
		this.catid = catid;
		this.userid = userid;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBtittle() {
		return btittle;
	}

	public void setBtittle(String btittle) {
		this.btittle = btittle;
	}

	public String getBcont() {
		return bcont;
	}

	public void setBcont(String bcont) {
		this.bcont = bcont;
	}

	public Timestamp getBdate() {
		return bdate;
	}

	public void setBdate(Timestamp bdate) {
		this.bdate = bdate;
	}

	public String getBpic() {
		return bpic;
	}

	public void setBpic(String bpic) {
		this.bpic = bpic;
	}

	public int getCatid() {
		return catid;
	}

	public void setCatid(int catid) {
		this.catid = catid;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
	
}
