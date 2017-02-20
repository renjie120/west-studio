package com.jd.kibana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "report_form")
public class ReportForm {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "name")
	private String name; // 名称

	@Column(name = "project_id")
	private Integer projectId; // 项目

	@Column(name = "form_type")
	private Integer formType; // 表格类型

	@Column(name = "config")
	private String config; // 配置

	@Column(name = "table_id")
	private Integer tableId; 
	
	@Column(name = "statux")
	private Integer statux; 
	
	
	@Column(name = "description")
	private String description; 
	
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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getFormType() {
		return formType;
	}

	public void setFormType(Integer formType) {
		this.formType = formType;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public Integer getStatux() {
		return statux;
	}

	public void setStatux(Integer statux) {
		this.statux = statux;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



}
