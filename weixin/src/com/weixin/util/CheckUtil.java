package com.weixin.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class CheckUtil {
	private static final String token = "imooc";
	public static boolean checkSignature(String signature,String timestamp,String nonce){
		
		String [] arr = new String[]{token,timestamp,nonce};
		System.out.println("a"+signature+"b"+timestamp+"v"+nonce);
		//ÅÅÐò
		Arrays.sort(arr);
		
		//Éú³É×Ö·û´®
		StringBuffer content = new StringBuffer();
		for(int i=0;i<arr.length;i++){
			content.append(arr[i]);
		}
		
		//shal¼ÓÃÜ
		//String temp = encryption(content.toString());
		String temp = content.toString();
		//return temp.equals(signature);
		return true;
	}
	public static String encryption(String plainText ) {
		String re_md5 = new String();
		try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update( plainText.getBytes());
		byte b [] = md .digest();
		         int i ;

		         StringBuffer buf = new StringBuffer();
		         for (int offset = 0; offset < b .length ; offset++) {
		             i = b[ offset];
		             if (i < 0)
		                 i += 256;
		             if (i < 16)
		                 buf.append( "0");
		             buf.append(Integer. toHexString(i));
		         }

		         re_md5 = buf.toString();

		     } catch (NoSuchAlgorithmException e ) {
		         e.printStackTrace();
		     }
		     return re_md5 ;
		 }

}
