package com.unbank.entity;

import java.util.Date;

public class TreeModel {

	private int treeid;
	private String id;
	private String uniqueid;
	private String wdcode;

	private String dbcode;
	private String name;
	private String isParent;
	private String pid;
	private Date time;

	public int getTreeid() {
		return treeid;
	}

	public void setTreeid(int treeid) {
		this.treeid = treeid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUniqueid() {
		return uniqueid;
	}

	public void setUniqueid(String uniqueid) {
		this.uniqueid = uniqueid;
	}

	public String getWdcode() {
		return wdcode;
	}

	public void setWdcode(String wdcode) {
		this.wdcode = wdcode;
	}

	public String getDbcode() {
		return dbcode;
	}

	public void setDbcode(String dbcode) {
		this.dbcode = dbcode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIsParent() {
		return isParent;
	}

	public void setIsParent(String isParent) {
		this.isParent = isParent;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

}
