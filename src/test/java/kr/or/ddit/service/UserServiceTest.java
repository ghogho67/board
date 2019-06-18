package kr.or.ddit.service;

import static org.junit.Assert.*;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	private IUserService userService;
	
	@Before
	public void setup(){
		userService = new UserService();
		logger.debug("setup");
	}
	
	
	@Test
	public void test() {
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVo vo = userService.getUser(userId);
		
		

		/***Then***/
		assertEquals(userId, vo.getUserId());
		logger.debug("vo : {}", vo);

	}

}
