package com.jd.kibana.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "report_chart")
public class ReportChart {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; // id

	@Column(name = "name")
	private String name; // 名称

	@Column(name = "subtitle")
	private String subtitle; // 子标题

	@Column(name = "project_id")
	private Long projectId; // 项目

	@Column(name = "chart_type")
	private String chartType; // 图类型

	@Column(name = "config")
	private String config; // 配置

	@Column(name = "data_table_id")
	private Long dataTableId; // id

	@Column(name = "y_axis_text")
	private String yAxisText; //

	@Column(name = "data_unit")
	private String dataUnit; //
	@Column(name = "statux")
	private Long statux; // 状态

	@Column(name = "description")
	private String description; //

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

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

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getChartType() {
		return chartType;
	}

	public void setChartType(String chartType) {
		this.chartType = chartType;
	}

	public String getConfig() {
		return config;
	}

	public void setConfig(String config) {
		this.config = config;
	}

	public Long getDataTableId() {
		return dataTableId;
	}

	public void setDataTableId(Long dataTableId) {
		this.dataTableId = dataTableId;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}

	public String getyAxisText() {
		return yAxisText;
	}

	public void setyAxisText(String yAxisText) {
		this.yAxisText = yAxisText;
	}

	public String getDataUnit() {
		return dataUnit;
	}

	public void setDataUnit(String dataUnit) {
		this.dataUnit = dataUnit;
	}

	public Long getStatux() {
		return statux;
	}

	public void setStatux(Long statux) {
		this.statux = statux;
	}

}
