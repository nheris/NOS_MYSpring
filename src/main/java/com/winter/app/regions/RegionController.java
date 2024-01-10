package com.winter.app.regions;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.winter.app.util.Pager;

@Controller
@RequestMapping(value = "/regions/*") 
public class RegionController {

	@Autowired
	private RegionService regionService;
	
	@RequestMapping(value = "delete", method = RequestMethod.POST)
	public String delete(RegionDTO regionDTO, Model model)throws Exception{
		int result = regionService.delete(regionDTO);
		String message="삭제 실패";
		if(result>0) {
			message="삭제 성공";
		}
		model.addAttribute("msg", message);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public ModelAndView update(RegionDTO regionDTO, ModelAndView mv)throws Exception{
		
		int result = regionService.update(regionDTO);
		
		String message="수정 실패";
		if(result>0) {
			message="수정 성공";
		}
		mv.addObject("msg", message);
		mv.addObject("path", "./list");
		
		mv.setViewName("commons/result");
		
		return mv;
		
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(RegionDTO regionDTO, Model model)throws Exception{
		regionDTO = regionService.getDetail(regionDTO);
		model.addAttribute("dto", regionDTO);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
													 	//파일 담고있는 클래스, 파라미터 이름과 동일하게 선언	
	public String add(RegionDTO regionDTO, Model model, MultipartFile photo) throws Exception {
		int result = regionService.add(regionDTO, photo);
//		System.out.println(photo.getName()); //파라미터이름
//		System.out.println(photo.getOriginalFilename());//파일이름
//		int result=0;
		
		String msg="등록 실패";
		if(result>0) {
			msg = "등록 성공";
		}
		
		model.addAttribute("msg", msg);
		model.addAttribute("path", "./list");
		
		return "commons/result";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		// /WEB-INF/views/   .jsp
		return "regions/add";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	//파라미터의 이름과 타입을 동일하게 선언
	//id
	public String detail(Long region_id, Model model) throws Exception {
		RegionDTO regionDTO = new RegionDTO();
		//String id = request.getParameter("region_id");
		
		regionDTO.setRegion_id(region_id);
		
		regionDTO = regionService.getDetail(regionDTO);
		
		//request.setAttribute("dto", regionDTO);
		model.addAttribute("dto", regionDTO);
		
		return "regions/detail";
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Pager pager)throws Exception {
		//1. 직접만듦
		ModelAndView mv = new ModelAndView();
		
		List<RegionDTO> ar = regionService.getList(pager);
		//ar을 ㅓjsp보내기?위해
		
		mv.addObject("pager", pager);
		
		mv.addObject("list", ar);//이름 아무거나하고 ar보냄
		mv.setViewName("regions/list");
		
		//return "regions/list";
		return mv;
	}
//	@Autowired
//	private RegionDAO regionDAO;	
////	public RegionController() { @Autowired써서 안쓸거임
////		this.regionDAO = new RegionDAO();
////	}
//	
//	//오버로딩
//	@RequestMapping(value = "add", method = RequestMethod.POST)
//	public String add(RegionDTO regionDTO, Model model) throws Exception{
//		//request에 파라미터 꺼내서 db에 insert
////		String id = request.getParameter("region_id");
////		String name = request.getParameter("region_name");
////		
////		RegionDTO regionDTO = new RegionDTO();
////		regionDTO.setRegion_id(Integer.parseInt(id));
////		regionDTO.setRegion_name(name);
//		
//		int result = this.regionDAO.add(regionDTO);
//
//		String msg = "등록 실패";
//		if(result>0) {
//			msg = "등록 성공";
//		}
//		
////		request.setAttribute("msg", msg);//파라미터 키,벨류
////		request.setAttribute("path", "./list");
//		model.addAttribute("msg", msg);//파라미터 키,벨류
//		model.addAttribute("path", "./list");
//		
//		return "commons/result";
//	}
//	
//	//밑 value = "test/add" 일경우 위 value = "/regions/**"
//	//메서드 안쓰면 method = RequestMethod.GET 디폴트
//	@RequestMapping(value = "add", method = RequestMethod.GET)
//	public String add() {
//		
//		// /WEB_INF/views/    .jsp
//		return "regions/add";
//	}
//	
//	
//	@RequestMapping(value = "detail", method = RequestMethod.GET)
//						//파라미터이름과 타입 동일하게 선언
//						//id라는 파라미터 들어오면 region_id에 담으시오
//	public String detail(Integer region_id, Model model) throws Exception{
//						//null 들어와도 끌어오게 Integer로
//		
//		RegionDAO regionDAO = new RegionDAO();
//		RegionDTO regionDTO = new RegionDTO();
//		//매개변수 String region하면_id 스프링이 대신해줌 대신 매개변수와 파라미터명 같아야함
//		//String id = request.getParameter("region_id");//파라미터 이름dto,멤버변수명,디비 컬럼명 일치
//		
//		//regionDTO.setRegion_id(Integer.parseInt(id));
//		regionDTO.setRegion_id(region_id);
//		
//		regionDTO = regionDAO.getDetail(regionDTO);
//		
//		//request.setAttribute("dto", regionDTO);//이름 아무거나
//		model.addAttribute("dto", regionDTO);
//		
//		
//		return "regions/detail";
//	}
//	
	//void, Sting,ModelAndView
				///regions/list 위에 주소에서 합침

}
