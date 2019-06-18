package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.ament.dao.AmentDao;
import kr.or.ddit.ament.dao.IAmentDao;
import kr.or.ddit.ament.model.AmentVo;
import kr.or.ddit.ament.service.AmentService;
import kr.or.ddit.ament.service.IAmentService;
import kr.or.ddit.dao.AmentDaoTest;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmentServiceTest {

	private IAmentService service;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AmentDaoTest.class);
	
	@Before
	public void setup(){
		service = new AmentService();
	}
	
	
	@Test
	public void selectAment() {
		/***Given***/
		String detail_id = "1";
		

		/***When***/
		List<AmentVo> amentList = service.selectAment(detail_id);
		
		/***Then***/
		assertEquals("", amentList);

	}
	
	
	
	
	@Test
	public void deleteAment() {
		/***Given***/
		
		String ament_id = "1";

		/***When***/
		int a = service.deleteAment(ament_id);
		
		/***Then***/
		assertEquals(0, a);
		

	}

}
