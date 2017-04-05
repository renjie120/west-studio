package com.jd.kibana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "project_user")
public class ProjectUser {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "project_id")
	private Long projectId; // 创建人

	@Column(name = "statux")
	private Integer statux; // 状态

	@Column(name = "username")
	private String username; // 登录名

	@Column(name = "fullname")
	private String fullname; // 中文名

	@Column(name = "create_date")
	private Date createDate; // 时间

	@Column(name = "role")
	private String role; // 角色

	@Column(name = "avatar")
	private String avatar; // 头像

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Integer getStatux() {
		return statux;
	}

	public void setStatux(Integer statux) {
		this.statux = statux;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

}
