package kr.or.ddit.ament.service;

import java.util.List;

import kr.or.ddit.ament.model.AmentVo;

public interface IAmentService {
	
	List<AmentVo> selectAment(String detail_id);
	
	
	int deleteAment(String ament_id);
	
	int insertAment(AmentVo amentVo);
	
	
	AmentVo selectAmentVo(String ament_id);

}
