/**
 * @Title: XmlUtil.java
 * @Package com.future.util
 * Copyright: Copyright (c) 2016 Wuuxiang All Rights Reserved.
 * Company: 吾享(天津)网络科技有限公司
 * 
 * @author Mobile Web Group-lff
 * @date 2016年10月13日 下午2:34:54
 * @version V1.0
 */

package com.future.util;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** 
 * @ClassName: XmlUtil
 * @Description: xml解析工具类
 * @author Mobile Web Group-lff
 * @date 2016年10月13日 下午2:34:54
 *
 */

public class XmlUtil {

	//log
	private static Logger log = LoggerFactory.getLogger(XmlUtil.class);
	
	/**
	 * xmlToMap(xml转换为map)
	 * @author Mobile Web Group-lff
	 * @date 2016年10月14日 下午3:15:39
	 *
	 * @param request
	 * @return
	 * @throws IOException
	 * @throws DocumentException
	 * @return Map<String,String>
	 */
	public static Map<String, String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
		// 将解析结果存储在HashMap中
		Map<String,String> map = new HashMap<String,String>();
		// 从request中取得输入流
		BufferedInputStream bis = new BufferedInputStream(request.getInputStream());
		SAXReader reader = new SAXReader();
		Document document = reader.read(bis);
		// 得到xml根元素
		Element root = document.getRootElement();
		// 得到根元素的所有子节点
		@SuppressWarnings("unchecked")
		List<Element> elementList = root.elements();
		// 遍历所有子节点
		for (Element e : elementList) {
			map.put(e.getName(), e.getText());
		}
		log.info("接收到微信消息：=" + map.toString());
		// 释放资源
		bis.close();
		return map;
	}
	
	public static String mapToXmlText(Map<String, String> map) {
        String result;
        String msgType = map.get("MsgType").toString();
        System.out.println("MsgType:" + msgType);

        String fromUserName = map.get("FromUserName");
            // 开发者微信号
            String toUserName = map.get("ToUserName");
            result = String
                    .format(
                            "<xml>" +
                                    "<ToUserName><![CDATA[%s]]></ToUserName>" +
                                    "<FromUserName><![CDATA[%s]]></FromUserName>" +
                                    "<CreateTime>%s</CreateTime>" +
                                    "<MsgType><![CDATA[text]]></MsgType>" +
                                    "<Content><![CDATA[%s]]></Content>" +
                                    "</xml>",
                            fromUserName, toUserName, String.valueOf(new Date().getTime()),
                            "hello ifrozen");

        return result;
	}
	
	
}
