/**  
 * @Title: WeXinServiceMsgImpl.java
 * @Package com.future.gateway.service
 * Copyright: Copyright (c) 2016 Wuuxiang All Rights Reserved.
 * Company: 吾享(天津)网络科技有限公司
 * 
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 上午11:18:28
 * @version V1.0
 */

package com.future.gateway.service.impl;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.future.gateway.bean.WeXinMsgTemplate;
import com.future.gateway.service.WeXinMsgService;
import com.future.util.DateUtil;

/** 
 * @ClassName: WeXinServiceMsgImpl
 * @Description: 微信消息处理Service
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 上午11:18:28
 *
 */
@Service("weXinMsgService")
public class WeXinServiceMsgImpl implements WeXinMsgService{

	/**
	 * Description: 处理消息
	 * @author: Mobile Web Group-lff
	 * @date: 2016年10月14日 上午11:52:01
	 * 
	 * @see com.future.gateway.service.WeXinMsgService#handleMsg(java.util.Map)
	 */
	@Override
	public String handleMsg(Map<String, String> m_map) {
		//响应消息
		String resMsg = "";
		/**
		 * 得到消息类型
		 * 重要，以后凡是从接受的消息里面取到的变量，都以m_前缀开始
		 */
		String m_msgType = m_map.get("MsgType").toString();
		//消息类型
		switch (m_msgType) {
			case "text":
				//处理文本消息
				resMsg = handleTextMsg(m_map);
				break;
			case "image":
				//处理图片消息
				resMsg = handleImageMsg(m_map);
				break;
			case "voice":
				//处理语音消息
				resMsg = handleVoiceMsg(m_map);
				break;
			case "video":
				//处理视频消息
				resMsg = handleVideoMsg(m_map);
				break;
			case "shortvideo":
				//处理小视频消息
				resMsg = handleShortVideoMsg(m_map);
				break;
			case "location":
				//处理位置消息
				resMsg = handleLocationMsg(m_map);
				break;
			case "link":
				//处理链接消息
				resMsg = handleLinkMsg(m_map);
				break;
			case "event":
				//处理事件消息,用户在关注与取消关注公众号时，微信会向我们的公众号服务器发送事件消息,开发者接收到事件消息后就可以给用户下发欢迎消息
				resMsg = handleEventMsg(m_map);
			default:
				break;
		}
		//返回响应消息
		return resMsg;
	}

	/**
	 * 构造文本消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleTextMsg(Map<String, String> m_map) {
		
		//发送方帐号
		String m_fromUserName = m_map.get("FromUserName");
		//开发者微信号
		String m_toUserName = m_map.get("ToUserName");
		
		return String.format(WeXinMsgTemplate.TEXT,
				m_fromUserName,
				m_toUserName,
				DateUtil.getTimeStr(),
				"恭喜你连接成功！");
	}
	
	/**
	 * 构造图片消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleImageMsg(Map<String, String> m_map) {
		return "";
	}
	
	/**
	 * 构造语音消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleVoiceMsg(Map<String, String> m_map) {
		return "";
	}
	
	/**
	 * 构造视频消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleVideoMsg(Map<String, String> m_map) {
		return "";
	}
	
	/**
	 * 构造小视频消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleShortVideoMsg(Map<String, String> m_map) {
		return "";
	}
	
	/**
	 * 构造地理位置消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleLocationMsg(Map<String, String> m_map) {
		return "";
	}
	
	/**
	 * 构造链接消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleLinkMsg(Map<String, String> m_map) {
		return "";
	}
	
	/**
	 * 构造事件消息
	 * @param m_map 封装了解析结果的Map
	 * @return 文本消息XML字符串
	 */
	private static String handleEventMsg(Map<String, String> m_map) {
		return "";
	}
	
}
