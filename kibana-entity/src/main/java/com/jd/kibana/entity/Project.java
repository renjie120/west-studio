
package com.jd.kibana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "project")
public class Project {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "name")
	private String name; // 名称

	@Column(name = "memo")
	private String memo; // 备注

	@Column(name = "color")
	private String color; // 背景色
	
	@Column(name = "create_time")
	private Date createTime; // 时间

	@Column(name = "creater_user")
	private Long createrUser; // 创建人

	@Column(name = "statux")
	private Long statux; // 状态

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreaterUser() {
		return createrUser;
	}

	public void setCreaterUser(Long createrUser) {
		this.createrUser = createrUser;
	}

	public Long getStatux() {
		return statux;
	}

	public void setStatux(Long statux) {
		this.statux = statux;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
