package com.winter.app.regions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.winter.app.MyTest;
import com.winter.app.util.Pager;

public class RegionDAOTest extends MyTest{

	@Autowired
	private RegionDAO regionDAO;
	
	//@Test
	public void addTest()throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		
		for(int i=0;i<100;i++) {
			regionDTO.setRegion_name("Test"+i);
			int result = regionDAO.add(regionDTO);
			if(i%10==0) {
				Thread.sleep(500);//0.5초
				
			}
		}
		System.out.println("100개 입력 완료");
		//assertEquals(1, result);
		
		
	}
	
	@Test
	public void getListTest() throws Exception{
		Pager pager = new Pager();
		pager.setPage(2L);
		pager.makeRow();
		List<RegionDTO> ar = regionDAO.getList(pager);
		System.out.println(ar.get(0).getRegion_name());//Test89
		assertNotEquals(10, ar.size()); //0이 아니기 희망
	}
	
	
	//@Test
	public void getDetailTest() throws Exception{
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(1);
		regionDTO = regionDAO.getDetail(regionDTO);
		
		assertNotNull(regionDTO);
	}

}
