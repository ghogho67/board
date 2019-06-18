package kr.or.ddit.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.ament.dao.AmentDao;
import kr.or.ddit.ament.dao.IAmentDao;
import kr.or.ddit.ament.model.AmentVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmentDaoTest {

	private IAmentDao dao;
	
	private static final Logger logger = LoggerFactory
			.getLogger(AmentDaoTest.class);
	
	@Before
	public void setup(){
		dao = new AmentDao();
	}
	
	
	@Test
	public void selectAment() {
		/***Given***/
		String detail_id = "1";
		

		/***When***/
		List<AmentVo> amentList = dao.selectAment(detail_id);
		
		/***Then***/
		assertEquals("", amentList);

	}
	
	
	@Test
	public void deleteAment() {
		/***Given***/
		
		String ament_id = "1";

		/***When***/
		int a = dao.deleteAment(ament_id);
		
		/***Then***/
		assertEquals(0, a);
		

	}
	


}
