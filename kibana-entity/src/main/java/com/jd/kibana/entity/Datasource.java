package com.jd.kibana.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "datasource")
public class Datasource {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "datasource_type")
	private String datasourceType; // 类型

	@Column(name = "name")
	private String name; // 类型
	
	@Column(name = "url")
	private String url; // url

	@Column(name = "uer_name")
	private String uerName; // 账号

	@Column(name = "password")
	private String password; // 密码

	@Column(name = "driver")
	private String driver; // 驱动

	@Column(name = "token")
	private String token; // token

	@Column(name = "statux")
	private Long statux; // 状态

	@Column(name = "protocol")
	private String protocol; // 协议

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDatasourceType() {
		return datasourceType;
	}

	public void setDatasourceType(String datasourceType) {
		this.datasourceType = datasourceType;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUerName() {
		return uerName;
	}

	public void setUerName(String uerName) {
		this.uerName = uerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getStatux() {
		return statux;
	}

	public void setStatux(Long statux) {
		this.statux = statux;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
