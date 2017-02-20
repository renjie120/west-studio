package com.jd.kibana.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "data_view")
public class DataView {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "tables")
	private String tables; // 关联表

	@Column(name = "name")
	private String name;

	@Column(name = "script")
	private String script; // 脚本

	@Column(name = "schema")
	private String schema; // 元数据

	@Column(name = "cache")
	private Long cache; // 缓存

	@Column(name = "params")
	private String params; // 参数

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTables() {
		return tables;
	}

	public void setTables(String tables) {
		this.tables = tables;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public Long getCache() {
		return cache;
	}

	public void setCache(Long cache) {
		this.cache = cache;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
