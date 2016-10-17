/**  
 * @Title: WeXinMsgService.java
 * @Package com.future.gateway.service
 * Copyright: Copyright (c) 2016 Wuuxiang All Rights Reserved.
 * Company: 吾享(天津)网络科技有限公司
 * 
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 上午11:18:28
 * @version V1.0
 */

package com.future.gateway.service;

import java.util.Map;

/** 
 * @ClassName: WeXinMsgService
 * @Description: 微信消息处理service
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 上午11:18:28
 *
 */
public interface WeXinMsgService {

	String handleMsg(Map<String, String> reqMap);
	
}
