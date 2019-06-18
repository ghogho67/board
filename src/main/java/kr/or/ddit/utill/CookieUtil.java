package kr.or.ddit.utill;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class CookieUtil {

	public static String cookieString; //분석할 쿠키 문자열
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	/**
	* Method : setCookieString
	* 작성자 : PC21
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 set 한다.
	*/
	public static void setCookiesstring(String cookieString){
		CookieUtil.cookieString = cookieString;
		
	}


	/**
	* Method : getCookie
	* 작성자 : PC21
	* 변경이력 :
	* @param cookie
	* @return
	* Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 가져온다.
	*/
//	public static String getCookie(String cookie) {
		//"userId=brown; remember=true; test=testValue"; 값을 갖고와야된다
//		String[] cookievalue = CookieUtil.cookieString.split(";");
//		String[] cookiekey = CookieUtil.cookieString.split("=");
//		String b = null;
//		for (int i = 0; i < cookievalue.length; i++) {
//			if(cookievalue[i].contains(cookie)){
//				int index = cookievalue[i].indexOf("=");
//				b = cookievalue[i].substring(index+1);
//			}
//				
//			}
//		}
//		
//		//cookie = "userId"
//		String a = b[0];
//		
		public static String getCookie(String cookie) {
		//"userId=brown; remember=true; test=testValue"; 값을 갖고와야된다
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		String cookieValue = "";
		for (String str : cookieArray) {
			if(str.startsWith(cookie+"=")){// +("=")이 없으면 cookie값이 userI 를써도 맞다 그렇기때문에 기입한다.
											//cookie 값이 맞을때 라고 보면될듯
//			if(str.split("=").equals(cookie+"=")){
				String[] cookieStr = str.split("="); // 값을 뽑아 보내준다.
				cookieValue = cookieStr[1]; // [userId=brown]  [remember=true] [test=testValue] 이걸 한번더 짤랐으니깐
											//[userId][brown]  [remember][true] [test][testValue] 가 된니깐 1번째꺼 받는다.
				break;
			}
		}
		return cookieValue;
	}
	
}
