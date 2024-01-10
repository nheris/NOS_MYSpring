package com.winter.app.regions;

import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.winter.app.util.Pager;

//DAO 보내기 전 전처리, 후처리
@Service
public class RegionService {
	
	@Autowired
	private RegionDAO regionDAO;
	@Autowired
	//내장 객체 중 application =자바에서 ServletContext?
	private ServletContext servletContext;
	
	
	//delete
	public int delete(RegionDTO regionDTO) throws Exception {
		return regionDAO.delete(regionDTO);
	}
	//update
	public int update(RegionDTO regionDTO)throws Exception{
		return regionDAO.update(regionDTO);
	}
	
	//insert
	public int add(RegionDTO regionDTO, MultipartFile file)throws Exception{
		//return regionDAO.add(regionDTO);
		
		
		int result = regionDAO.add(regionDTO);
		//파일 저장 누가? 해당 운영체제가 
		//1. 어디에 저장할 것인가? (운영체제 상관없이 하기위해 프젝안 폴더로) 운영체제에 있는 실제 경로
		String path = servletContext.getRealPath("/resources/upload");
		System.out.println(path);
		
		//            /resources/upload/regions
		File f = new File(path, "regions");
		//경로에 폴더 없을경우
		if(!f.exists()) {
			//폴더 만들어
			f.mkdirs();
		}
		
		//2. 어떤 파일명으로 저장할 것인가? 중복이름안되게끔보장 ,확장자
			//1) 시간 사용
		Calendar ca = Calendar.getInstance();
		String filename = ca.getTimeInMillis()+"_"+file.getOriginalFilename();
		System.out.println(filename);
			//2) UUID 클래스 사용
		filename = UUID.randomUUID().toString()+"_"+file.getOriginalFilename();
		System.out.println(filename);
		
		//3. 파일을 저장
			//1) FileCopyUtils 클래스 사용
		f = new File(f, filename);
		FileCopyUtils.copy(file.getBytes(), f);//path 주소로 사진 들어와있는지 확인랴ㅣ
		
			//2) 
		
		//4. DB에 정보 저장
		RegionFileDTO dto = new RegionFileDTO();
		dto.setFileName(filename);
		dto.setOriName(file.getOriginalFilename());
		dto.setRegion_id(regionDTO.getRegion_id());
		result = regionDAO.addFile(dto);
		
		return result;
	}
	
	//detail
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		return regionDAO.getDetail(regionDTO);
	}
	//list
	public List<RegionDTO> getList(Pager pager) throws Exception{
		pager.makeRow();
		
		Long totalCount=regionDAO.getTotal(pager);
		System.out.println(totalCount); //list페이지 들어가면 콘솔 112
		
		pager.makeNum(totalCount);

		
		List<RegionDTO> ar = this.regionDAO.getList(pager);
		
		return ar;
	}
}
