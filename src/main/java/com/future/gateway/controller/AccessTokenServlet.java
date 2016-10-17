package com.future.gateway.controller;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.future.gateway.bean.AccessToken;
import com.future.util.HttpUtil;

/** 
 * @ClassName: AccessTokenServlet
 * @Description: 定时获取accessToken
 * @author Mobile Web Group-lff
 * @date 2016年10月14日 上午10:15:45
 */
@WebServlet(urlPatterns = {"/accessToken"}, loadOnStartup = 1)
public class AccessTokenServlet extends HttpServlet {

	private static final long serialVersionUID = 1584098956813696189L;
	//log
	private static Logger log = LoggerFactory.getLogger(AccessTokenServlet.class);
	//读取配置文件
	private static final ResourceBundle resourceBundle = ResourceBundle.getBundle("wxmp");
	
	/**
	 * Description: 启动一个定时线程，来定期获取accessToken
	 * @author: Mobile Web Group-lff
	 * @date: 2016年10月14日 上午10:26:36
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		//开启一个新的线程
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					try {
						//获取accessToken
						setAccessToken(resourceBundle.getString("wxmp.appId"), resourceBundle.getString("wxmp.appSecret"));
						//获取成功
						if (AccessToken.accessToken != null) {
							//获取到access_token 休眠6000秒,大约2个小时左右
							Thread.sleep(6000 * 1000);
						} else {
							//获取失败,3秒后再次获取
							Thread.sleep(1000 * 3); //获取的access_token为空 休眠3秒
						}
					} catch (Exception e) {
						e.printStackTrace();
						try {
							Thread.sleep(1000 * 10); //发生异常休眠10秒
						} catch (Exception e1) {
						}
					}
				}
			}
		}).start();
	}

	/**
	 * 获取access_token
	 *
	 * @param appId
	 * @param appSecret
	 * @return AccessToken
	 */
	private void setAccessToken(String appId, String appSecret) {
		
		//此请求为https的get请求，返回的数据格式为{"access_token":"ACCESS_TOKEN","expires_in":7200}
		String Url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, appSecret);
		String result = HttpUtil.getHttpsResponse(Url, "GET");
		
		//使用FastJson将Json字符串解析成Json对象
		JSONObject json = JSON.parseObject(result);
		log.info("获取到的access_token=" + json.toJSONString());
		
		//设置accessToken
		AccessToken.accessToken = json.getString("access_token");
		AccessToken.expiresin = json.getIntValue("expires_in");
	}
}