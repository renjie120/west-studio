/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.service.TreeService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.sys.entity.SysWorkArea;
import com.thinkgem.jeesite.modules.sys.dao.SysWorkAreaDao;

/**
 * 办公场地管理Service
 * @author 吴江
 * @version 2016-04-10
 */
@Service
@Transactional(readOnly = true)
public class SysWorkAreaService extends TreeService<SysWorkAreaDao, SysWorkArea> {

	public SysWorkArea get(String id) {
		return super.get(id);
	}
	
	public List<SysWorkArea> findList(SysWorkArea sysWorkArea) {
		if (StringUtils.isNotBlank(sysWorkArea.getParentIds())){
			sysWorkArea.setParentIds(","+sysWorkArea.getParentIds()+",");
		}
		return super.findList(sysWorkArea);
	}
	
	@Transactional(readOnly = false)
	public void save(SysWorkArea sysWorkArea) {
		super.save(sysWorkArea);
	}
	
	@Transactional(readOnly = false)
	public void delete(SysWorkArea sysWorkArea) {
		super.delete(sysWorkArea);
	}
	
}