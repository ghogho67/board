package kr.or.ddit.ament.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.ament.model.AmentVo;
import kr.or.ddit.mybatis.MyBatisUtill;

public class AmentDao implements IAmentDao {

	@Override
	public List<AmentVo> selectAment(String detail_id) {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		List<AmentVo> amentList = sqlsession.selectList("ament.selectAment", detail_id);
		sqlsession.close();
		
		return amentList;
	}


	@Override
	public int deleteAment(String ament_id) {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		int deleteAment = sqlsession.delete("ament.deleteAment", ament_id);
		sqlsession.commit();
		sqlsession.close();
		
		return deleteAment;
	}

	@Override
	public int insertAment(AmentVo amentVo) {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		int insertAment = sqlsession.insert("ament.insertAment", amentVo);
		sqlsession.commit();
		sqlsession.close();
		return insertAment;
	}
	

	@Override
	public AmentVo selectAmentVo(String ament_id) {
		SqlSession sqlsession = MyBatisUtill.getSqlSession();
		AmentVo amentVo = sqlsession.selectOne("ament.selectAmentVo", ament_id);
		sqlsession.close();
		return amentVo;
	}

}
