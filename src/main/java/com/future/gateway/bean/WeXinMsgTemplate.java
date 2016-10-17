/**  
 * @Title: WeXinMsgTemplate.java
 * @Package com.future.gateway.bean
 * Copyright: Copyright (c) 2016 Wuuxiang All Rights Reserved.
 * Company: 吾享(天津)网络科技有限公司
 * 
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 下午4:45:05
 * @version V1.0
 */

package com.future.gateway.bean;

/** 
 * @ClassName: WeXinMsgTemplate
 * @Description: 微信消息格式模板
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 下午4:45:05
 *
 */

public class WeXinMsgTemplate {
	
	//文本消息
	public static final String TEXT = "<xml>"
									+ "<ToUserName><![CDATA[%s]]></ToUserName>"
									+ "<FromUserName><![CDATA[%s]]></FromUserName>"
									+ "<CreateTime>%s</CreateTime>"
									+ "<MsgType><![CDATA[text]]></MsgType>"
									+ "<Content><![CDATA[%s]]></Content>"
									+ "</xml>";

	//图片消息
	public static final String IMAGE = "<xml>"
									+ "<ToUserName><![CDATA[%s]]></ToUserName>"
									+ "<FromUserName><![CDATA[%s]]></FromUserName>"
									+ "<CreateTime>%s</CreateTime>"
									+ "<MsgType><![CDATA[image]]></MsgType>"
									+ "<Image>"
									+ "<MediaId><![CDATA[%s]]></MediaId>"
									+ "</Image>"
									+ "</xml>";

	//语音消息
	public static final String VOICE = "<xml>"
									+ "<ToUserName><![CDATA[%s]]></ToUserName>"
									+ "<FromUserName><![CDATA[%s]]></FromUserName>"
									+ "<CreateTime>%s</CreateTime>"
									+ "<MsgType><![CDATA[voice]]></MsgType>"
									+ "<Voice>"
									+ "<MediaId><![CDATA[%s]]></MediaId>"
									+ "</Voice>"
									+ "</xml>";

	//视频消息
	public static final String VIDEO = "<xml>"
									+ "<ToUserName><![CDATA[%s]]></ToUserName>"
									+ "<FromUserName><![CDATA[%s]]></FromUserName>"
									+ "<CreateTime>%s</CreateTime>"
									+ "<MsgType><![CDATA[video]]></MsgType>"
									+ "<Video>"
									+ "<MediaId><![CDATA[%s]]></MediaId>"
									+ "<Title><![CDATA[%s]]></Title>"
									+ "<Description><![CDATA[%s]]></Description>"
									+ "</Video>"
									+ "</xml>";
	
	//音乐消息
	public static final String MUSIC = "<xml>"
									+ "<ToUserName><![CDATA[%s]]></ToUserName>"
									+ "<FromUserName><![CDATA[%s]]></FromUserName>"
									+ "<CreateTime>%s</CreateTime>"
									+ "<MsgType><![CDATA[music]]></MsgType>"
									+ "<Music>"
									+ "<Title><![CDATA[%s]]></Title>"
									+ "<Description><![CDATA[%s]]></Description>"
									+ "<MusicUrl><![CDATA[%s]]></MusicUrl>"
									+ "<HQMusicUrl><![CDATA[%s]]></HQMusicUrl>"
									+ "<ThumbMediaId><![CDATA[%s]]></ThumbMediaId>"
									+ "</Music>"
									+ "</xml>";
	
	//图文消息
	public static final String NEWS = "<xml>"
									+ "<ToUserName><![CDATA[%s]]></ToUserName>"
									+ "<FromUserName><![CDATA[%s]]></FromUserName>"
									+ "<CreateTime>%s</CreateTime>"
									+ "<MsgType><![CDATA[news]]></MsgType>"
									+ "<ArticleCount>%s</ArticleCount>"
									+ "<Articles>"
									+ "<item>"
									+ "<Title><![CDATA[%s]]></Title>"
									+ "<Description><![CDATA[%s]]></Description>"
									+ "<PicUrl><![CDATA[%s]]></PicUrl>"
									+ "<Url><![CDATA[%s]]></Url>"
									+ "</item>"
									+ "<item>"
									+ "<Title><![CDATA[%s]]></Title>"
									+ "<Description><![CDATA[%s]]></Description>"
									+ "<PicUrl><![CDATA[%s]]></PicUrl>"
									+ "<Url><![CDATA[%s]]></Url>"
									+ "</item>"
									+ "</Articles>"
									+ "</xml>";
	
}
