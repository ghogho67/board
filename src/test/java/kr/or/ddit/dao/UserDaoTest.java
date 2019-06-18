package kr.or.ddit.dao;

import static org.junit.Assert.*;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	private IUserDao dao;
	
	@Before
	public void setup(){
		dao = new UserDao();
		logger.debug("setup");
	}
	
	
	@Test
	public void test() {
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVo vo = dao.getUser(userId);
		
		

		/***Then***/
		assertEquals(userId, vo.getUserId());
		logger.debug("vo : {}", vo);

	}
	
	
}
