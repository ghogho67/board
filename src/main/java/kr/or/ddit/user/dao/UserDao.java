package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtill;
import kr.or.ddit.user.model.UserVo;

import org.apache.ibatis.session.SqlSession;

public class UserDao implements IUserDao {

	@Override
	public List<UserVo> userList() {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		List<UserVo> userlist = sqlSession.selectList("user.userList");
		sqlSession.close();
		return userlist;
	}

	@Override
	public UserVo getUser(String userId) {
		SqlSession sqlSession = MyBatisUtill.getSqlSession();
		UserVo vo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();
		return vo;
	}


	
	
}
