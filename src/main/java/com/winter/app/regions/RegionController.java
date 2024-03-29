package com.winter.app.regions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //컨트롤러 기능할거임
@RequestMapping(value = "/regions/*") //이주소해당되면 밑에거 실행
public class RegionController {
	//중복되고 여기만 쓰니까 멤버변수,private로 선언
	private RegionDAO regionDAO;
	
	public RegionController() {
		this.regionDAO = new RegionDAO();
	}
	
	//오버로딩
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(HttpServletRequest request) throws Exception{
		//request에 파라미터 꺼내서 db에 insert
		String id = request.getParameter("region_id");
		String name = request.getParameter("region_name");
		
		RegionDTO regionDTO = new RegionDTO();
		regionDTO.setRegion_id(Integer.parseInt(id));
		regionDTO.setRegion_name(name);
		
		int result = this.regionDAO.add(regionDTO);

		String msg = "등록 실패";
		if(result>0) {
			msg = "등록 성공";
		}
		
		request.setAttribute("msg", msg);//파라미터 키,벨류
		request.setAttribute("path", "./list");
		
		return "commons/result";
	}
	
	//밑 value = "test/add" 일경우 위 value = "/regions/**"
	//메서드 안쓰면 method = RequestMethod.GET 디폴트
	@RequestMapping(value = "add")
	public String add() {
		
		// /WEB_INF/views/    .jsp
		return "regions/add";
	}
	
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(HttpServletRequest request) throws Exception{
		
		RegionDAO regionDAO = new RegionDAO();
		RegionDTO regionDTO = new RegionDTO();
		String id = request.getParameter("region_id");//파라미터 이름dto,멤버변수명,디비 컬럼명 일치
		
		regionDTO.setRegion_id(Integer.parseInt(id));
		
		regionDTO = regionDAO.getDetail(regionDTO);
		
		request.setAttribute("dto", regionDTO);//이름 아무거나
		
		return "regions/detail";
	}
	
							///regions/list 위에 주소에서 합침
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request)throws Exception {
		System.out.println("Regions List");
		RegionDAO regionDAO = new RegionDAO();
		List<RegionDTO> ar = regionDAO.getList();
		//ar을 ㅓjsp보내기?위해
		
		request.setAttribute("list", ar);//이름 아무거나하고 ar보냄
		
		return "regions/list";
	}
}
