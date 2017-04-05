package com.jd.kibana.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "data_table")
public class DataTable {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "datasource_id")
	private Long datasourceId; // 数据源

	@Column(name = "name")
	private String name; // 名称

	@Column(name = "script")
	private String script; // 脚本

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

	public Long getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(Long datasourceId) {
		this.datasourceId = datasourceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScript() {
		return script;
	}

	public void setScript(String script) {
		this.script = script;
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

}
