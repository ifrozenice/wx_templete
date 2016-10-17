package com.future.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/** 
 * @ClassName: SignUtil
 * @Description: 微信服务器认证
 * @author Mobile Web Group-lff
 * @date 2016年8月31日 下午7:43:40
 *
 */
public class SignUtil {

	/**
	 * checkSignature(微信服务器认证)
	 * @author Mobile Web Group-lff
	 * @date 2016年8月31日 下午7:56:49
	 *
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param token
	 * @return boolean
	 */
	public static boolean checkSignature(String signature, String timestamp, String nonce, String token) {  
		String[] tmpArr = { token, timestamp, nonce };
		Arrays.sort(tmpArr);
		StringBuffer tmpArrBf = new StringBuffer();
		for (int i = 0; i < tmpArr.length; i++) {
			tmpArrBf.append(tmpArr[i]);
		}
		String encStr = encrypt(tmpArrBf.toString(), "SHA-1").toLowerCase();
		if (encStr.equalsIgnoreCase(signature)) {
			return true;
		} else {
			return false;
		}
		
	} 
	
	/**
	 * 将字符串进行加密
	 *
	 * @param str 需要加密的字符串
	 * @param encName 加密的算法
	 * @return 加密后的内容
	 */
	public static String encrypt(String str, String encName) {
		
		String encStr = null;
		try {
			MessageDigest digest = MessageDigest.getInstance(encName);
			byte[] bytes = digest.digest(str.getBytes());
			StringBuffer buf = new StringBuffer(bytes.length * 2);
			for (int i = 0; i < bytes.length; i++) {
				if ((bytes[i] & 0xff) < 0x10) {
					buf.append("0");
				}
				buf.append(Long.toString(bytes[i] & 0xff, 16));
			}
			encStr = buf.toString().toUpperCase();
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encStr;
	}
}
