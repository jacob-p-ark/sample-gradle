package com.example.demo.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//import com.initech.inisafenet.KeyFixManager;
//import com.initech.inisafenet.exception.INISAFENetException;
//import com.nimbusds.oauth2.sdk.util.StringUtils;
//import com.xforce.wts.util.Base64Util;

//import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@PropertySource("classpath:/config/dass.web.properties")
@Component
public class E2EManager
{
	final byte[] INISAFENET_Vector = new byte[16];
	final String INISAFENET_key = "";
//	static KeyFixManager initechClient;
	String e2eProperties = "";
	static String ENCODING_OPTION_NODECODE = "0000";
	static String ENCODING_OPTION_BASE64 = "0001";
	static String ENCODING_OPTION_URL = "0010";
	static String ENCODING_OPTION_BASE64_URL = "0011";
	
	private static boolean useINISAFENET = true;

	private static String INISAFENET;
	private static void setINISAFENET(String iNISAFENET) {
		INISAFENET = iNISAFENET;
	}

//	public E2EManager(@Value("${dass.webconf.INISafeNet}") String iNISAFENET)
	public E2EManager()
	{
		try {
//			setINISAFENET(iNISAFENET);
//			log.debug("INISAFENET : " + INISAFENET);
//			if(StringUtils.isBlank(INISAFENET)) {
//				useINISAFENET = false;
//				return;
//			}
//
//			byte[] b = null;
//			initechClient = new KeyFixManager("", b, INISAFENET);
		}
		catch(Exception e) {
//			log.error(e.getCause().getMessage());
		}
	}
	
//	public static String decrypt(byte[] encrypted) throws INISAFENetException
//	{
//		if(initechClient == null)
//			new E2EManager(INISAFENET);
//
//		if(!useINISAFENET)
//			return "";
//
//		// 복호화 모드 이니텍 API참조
//		byte[] decData = initechClient.maskDecrypt(encrypted);
//
//		return new String(decData);
//	}
//
//	public static String decrypt_decoding(String encrypted) throws INISAFENetException
//	{
//		if(!useINISAFENET)
//			return "";
//
//		byte[] decode = Base64Util.base64Decode(encrypted);
//		return decrypt(decode);
//	}
//
//	public static byte[] encrypt(String decrypted) throws INISAFENetException
//	{
//		if(initechClient == null)
//			new E2EManager(INISAFENET);
//
//		if(!useINISAFENET)
//			return "".getBytes();
//
//		// 암호화 모드 이니텍 API참조
//		byte[] encData = initechClient.maskEncrypt(decrypted.getBytes());
//		return encData;
//	}
//
//	public static String encrypt_encoding(String decrypted) throws INISAFENetException
//	{
//		if(!useINISAFENET)
//			return "";
//
//		byte[] encData = encrypt(decrypted);
//		return Base64Util.base64Encode(encData);
//	}
//
//	public static byte[] encrypt(byte[] decrypted) throws Exception
//	{
//		if(initechClient == null)
//			new E2EManager(INISAFENET);
//
//		if(!useINISAFENET)
//			return new byte[decrypted.length];
//
//		// 암호화 모드 이니텍 API참조
//		byte[] encData = initechClient.maskEncrypt(decrypted);
//
//		return encData;
//	}

}