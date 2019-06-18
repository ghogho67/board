package kr.or.ddit.ament.dao;

import java.util.List;

import kr.or.ddit.ament.model.AmentVo;

public interface IAmentDao {
	
	List<AmentVo> selectAment(String detail_id);
	
	int deleteAment(String ament_id);
	
	int insertAment(AmentVo amentVo);

	AmentVo selectAmentVo(String ament_id);

}
