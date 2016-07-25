package com.unbank.mybatis.entity;

import java.util.List;
import java.util.Map;

public class SqlAdapter {

	private Integer prikey;
	private String sql;
	private Map<String, Object> obj;
	private List<Integer> list;

	public SqlAdapter(Map<String, Object> objects) {
		this.obj = objects;
	}

	public SqlAdapter(String sql) {
		this.sql = sql;
	}

	public SqlAdapter(String sql, Map<String, Object> objects) {
		this.sql = sql;
		this.obj = objects;
	}

	public SqlAdapter(List<Integer> list) {
		this.list = list;
	}

	public SqlAdapter() {
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public Map<String, Object> getObj() {
		return obj;
	}

	public void setObj(Map<String, Object> obj) {
		this.obj = obj;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}

	public Integer getPrikey() {
		return prikey;
	}

	public void setPrikey(Integer prikey) {
		this.prikey = prikey;
	}


	

}
