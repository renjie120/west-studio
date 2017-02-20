/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.TreeEntity;

/**
 * 办公场地管理Entity
 * @author 吴江
 * @version 2016-04-10
 */
public class SysWorkArea extends TreeEntity<SysWorkArea> {
	
	private static final long serialVersionUID = 1L;
	private SysWorkArea parent;		// 父级编号
	private String parentIds;		// 所有父级编号
	private String name;		// 名称
//	private String sort;		// 排序
	private String code;		// 区域编码
	private String type;		// 区域类型
	
	public SysWorkArea() {
		super();
	}

	public SysWorkArea(String id){
		super(id);
	}

	@JsonBackReference
	@NotNull(message="父级编号不能为空")
	public SysWorkArea getParent() {
		return parent;
	}

	public void setParent(SysWorkArea parent) {
		this.parent = parent;
	}
	
	@Length(min=1, max=2000, message="所有父级编号长度必须介于 1 和 2000 之间")
	public String getParentIds() {
		return parentIds;
	}

	public void setParentIds(String parentIds) {
		this.parentIds = parentIds;
	}
	
	@Length(min=1, max=100, message="名称长度必须介于 1 和 100 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=100, message="区域编码长度必须介于 0 和 100 之间")
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Length(min=0, max=1, message="区域类型长度必须介于 0 和 1 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public String getParentId() {
		return parent != null && parent.getId() != null ? parent.getId() : "0";
	}
}