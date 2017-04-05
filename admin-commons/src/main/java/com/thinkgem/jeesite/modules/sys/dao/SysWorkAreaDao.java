/**
 * Copyright &copy; 2012-2014 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.sys.dao;

import com.thinkgem.jeesite.common.persistence.TreeDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.sys.entity.SysWorkArea;

/**
 * 办公场地管理DAO接口
 * @author 吴江
 * @version 2016-04-10
 */
@MyBatisDao
public interface SysWorkAreaDao extends TreeDao<SysWorkArea> {
	
}