/**  
 * @Title: BaseController.java
 * @Package com.future.controller
 * Copyright: Copyright (c) 2016 Wuuxiang All Rights Reserved.
 * Company: 吾享(天津)网络科技有限公司
 * 
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 下午4:04:33
 * @version V1.0
 */

package com.future.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

/** 
 * @ClassName: BaseController
 * @Description: controller基类
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 下午4:04:33
 *
 */

public class BaseController {

	/**
	 * getRequestParams(请求参数)
	 * @author Mobile Web Group-lff
	 * @date 2016年10月14日 下午4:07:29
	 *
	 * @param request
	 * @return
	 * @return Map<String,String>
	 */
	protected Map<String, String> getRequestParams(HttpServletRequest request) {
		Map<String, String> params = new HashMap<String, String>();
		if (null != request) {
			Set<String> paramsKey = request.getParameterMap().keySet();
			for (String key : paramsKey) {
				params.put(key, request.getParameter(key));
			}
		}
		return params;
	}
}
