/**  
 * @Title: DateUtil.java
 * @Package com.future.util
 * Copyright: Copyright (c) 2016 Wuuxiang All Rights Reserved.
 * Company: 吾享(天津)网络科技有限公司
 * 
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 上午10:34:28
 * @version V1.0
 */

package com.future.util;

import java.util.Date;

/** 
 * @ClassName: DateUtil
 * @Description: 日期工具类
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 上午10:34:28
 *
 */

public class DateUtil {

	public static String getTimeStr(){
		
		return String.valueOf(new Date().getTime());
	}
	
	
}
