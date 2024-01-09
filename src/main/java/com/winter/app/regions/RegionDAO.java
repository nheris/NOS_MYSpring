package com.winter.app.regions;

//import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.winter.app.util.Pager;

@Repository
public class RegionDAO {
	
	@Autowired
	private SqlSession sqlSession;
	//연결하려는 mapper의 namespace속성의 값과 동일한 값, 끝에 . 추가	
	private final String namespace="com.winter.app.regions.RegionDAO.";
	
	//delete
	public int delete(RegionDTO regionDTO) throws Exception {
		return sqlSession.delete(namespace+"delete", regionDTO);
	}
	
	
	//update
	public int update(RegionDTO regionDTO) throws Exception {
		return sqlSession.update(namespace+"update", regionDTO);
		
	}
	
	
	//Insert
	public int add(RegionDTO regionDTO)throws Exception{
		return sqlSession.insert(namespace+"add", regionDTO);
	}
	
	//Detail, 지역번호로 지역이 조회
	public RegionDTO getDetail(RegionDTO regionDTO) throws Exception {
		       //Mapper 보내야하는 parameter가 있을 때
		return sqlSession.selectOne(namespace+"getDetail", regionDTO);//결과물 하나라 one넣음 selectOne(아이디명)
		
		
	}
	//getTotal 메퍼 아이디랑 동일하게
	public Long getTotal() throws Exception{
		return sqlSession.selectOne(namespace+"getTotal");
	}
	
	
	
	//getList, 모든 정보를 출력
	public List<RegionDTO> getList(Pager pager) throws Exception{
		       //Mapper 보내야하는 parameter가 없을 때
		return sqlSession.selectList(namespace+"getList", pager); //여러개라 list
		
		
//mybatis가 대신해줌
//		//코드 중복되니 제거
//		Connection con = DBConnector.getConnector();
//		
//		String sql = "SELECT * FROM REGIONS";
//	
//		PreparedStatement st = con.prepareStatement(sql);
//		
//		ResultSet rs = st.executeQuery();
//		
//		List<RegionDTO> ar = new ArrayList<RegionDTO>();
//		
//		while(rs.next()){ //rs = 1, Europe
//			RegionDTO dto = new RegionDTO();
//			dto.setRegion_id(rs.getInt("REGION_ID"));
//			dto.setRegion_name(rs.getString("REGION_NAME"));
//			ar.add(dto);
//		}
//		
//		DBConnector.disConnect(rs, st, con);
		
		
	}
	
}
