package com.jd.kibana.web;

import com.jd.common.web.LoginContext;

public class BaseController {

	
	public String getUserName()
	{
		LoginContext loginContext = LoginContext.getLoginContext();
		
		String username = loginContext.getPin();
		
		return username;
	}
}
