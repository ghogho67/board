package kr.or.ddit.ament.service;

import java.util.List;

import kr.or.ddit.ament.dao.AmentDao;
import kr.or.ddit.ament.dao.IAmentDao;
import kr.or.ddit.ament.model.AmentVo;

public class AmentService implements IAmentService {
	
	private IAmentDao dao;

	public AmentService() {
		dao = new AmentDao();
	}

	@Override
	public List<AmentVo> selectAment(String detail_id) {
		return dao.selectAment(detail_id);
	}


	@Override
	public int deleteAment(String ament_id) {
		return dao.deleteAment(ament_id);
	}

	@Override
	public int insertAment(AmentVo amentVo) {
		return dao.insertAment(amentVo);
	}


	@Override
	public AmentVo selectAmentVo(String ament_id) {
		return dao.selectAmentVo(ament_id);
	}

}
