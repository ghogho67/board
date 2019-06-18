package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IUserService {
	private IUserDao dao;
	
	public UserService() {
		dao = new UserDao();
	}

	@Override
	public List<UserVo> userList() {
		
		return dao.userList();
	}

	@Override
	public UserVo getUser(String userId) {
		return dao.getUser(userId);
	}

	
	

}
