package com.jd.kibana.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "project_page")
public class ProjectPage {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "name")
	private String name; // 名称

	@Column(name = "url")
	private String url; // url

	@Column(name = "statux")
	private Long statux; // 状态

	@Column(name = "project_id")
	private Long projectId; // 项目

	@Column(name = "sortx")
	private Long sortx; // 排序

	@Column(name = "schemax")
	private String schemax; // 描述

	@Column(name = "componnet")
	private String componnet; // 组件

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getStatux() {
		return statux;
	}

	public void setStatux(Long statux) {
		this.statux = statux;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Long getSortx() {
		return sortx;
	}

	public void setSortx(Long sortx) {
		this.sortx = sortx;
	}

	public String getSchemax() {
		return schemax;
	}

	public void setSchemax(String schemax) {
		this.schemax = schemax;
	}

	public String getComponnet() {
		return componnet;
	}

	public void setComponnet(String componnet) {
		this.componnet = componnet;
	}

}
