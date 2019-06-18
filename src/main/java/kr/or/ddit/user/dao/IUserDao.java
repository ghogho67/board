package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IUserDao {
	
	//인터페이스에는 접근자를 작성하지 않는다.
		/**
		* Method : userList
		* 작성자 : PC21
		* 변경이력 :
		* @return
		* Method 설명 : 사용자 전체 조회
		*/
		List<UserVo> userList();
		
		/**
		* Method : getUser
		* 작성자 : PC21
		* 변경이력 :
		* @return
		* Method 설명 : 특정 사용자 조회
		*/
		UserVo getUser(String userId);
		
		
		
		
}
