package com.winter.app.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.winter.app.util.DBConnector;

public class ProductDAO {
	//상품 목록
	public List<ProductDTO> getList() throws Exception{
		return null;
	}
	//상품 디테일
	public ProductDTO getDetail(ProductDTO productDTO) throws Exception{
		return productDTO;
	}
	//상품 등록
	public int insert(ProductDTO productDTO) throws Exception{
		int result = 0;
		return result;
	}
	//상품 수정
	public int update(ProductDTO productDTO) throws Exception{
		int result = 0;
		return result;
	}
	//싱품 삭제
	public int delete(ProductDTO productDTO) throws Exception{
		int result = 0;
		return result;
	}
	
}


