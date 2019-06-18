package kr.or.ddit.utill;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtill {

	private static final String UPLOAD_PATH = "d:\\upload\\";
	private static final Logger logger = LoggerFactory
			.getLogger(PartUtill.class);
	
	/**
	* Method : getFileName
	* 작성자 : PC21
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한다.
	*/
	public static String getFileName(String contentDisposition) {
//		form-data; name="profile"; filename="sally.png" 이렇게 나오는데 이름을 다시한번 구분한다.
		String result[] = contentDisposition.split(";");
		String[] fileName = result[2].split("\"");
		
//		for (int i = 0; i < result.length; i++) {
//			logger.debug("result[] : {}", result[i]);
//		}
		
		
		return fileName[1];
	}

	/**
	* Method : getExt
	* 작성자 : PC21
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로 부터 확장자를 받아오는 메서드
	*/
	public static String getExt(String fileName) {
		
//		String ext = ""
		String[] file = fileName.split("\\.");
		if(file.length == 1){
			return "";
		}else{
			return "."+file[file.length-1];
		}
	}
	
	
	
	/**
	* Method : checkUploadFolder
	* 작성자 : PC21
	* 변경이력 :
	* @param yyyy
	* @param mm
	* Method 설명 : 년, 월 업로드 폴더가 존재하는지 체크, 없을 경우 폴더 생성
	*/
	public static void checkUploadFolder(String yyyy, String mm){
		File yyyyFolder = new File(UPLOAD_PATH+ yyyy);
		//신규년도로 넘어 갔을때 해당 년도의 폴더를 생성한다.
		if(!yyyyFolder.exists()){
			yyyyFolder.mkdir();
		}
		//월에 해당하는 폴더가 있는지 확인
		File mmFolder = new File(UPLOAD_PATH+ yyyy + File.separator + mm);
		if(!mmFolder.exists()){
			mmFolder.mkdir();
		}
	}
	
	
	/**
	* Method : getUploadPath
	* 작성자 : PC21
	* 변경이력 :
	* @param yyyy
	* @param mm
	* @return
	* Method 설명 : 업로드 경로를 반환
	*/
	public static String getUploadPath(){
		// 업로드할 폴더 확인
		
		// 연도에 해당하는 폴더가 있는지, 연도안에 월에 해당하는 폴더가 있는 지 확인
		Date dt = new Date();
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyyMM");
		String ym = sdf2.format(dt);
		String year = ym.substring(0, 4);
		String month = ym.substring(4);
		
		PartUtill.checkUploadFolder(year, month);
		return UPLOAD_PATH+ year + File.separator + month;  // File.separator = \\
		
		
		
		
		
	}
	
	

}
