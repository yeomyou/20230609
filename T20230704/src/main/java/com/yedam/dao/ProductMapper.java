package com.yedam.dao;

import java.util.List;

import com.yedam.vo.ProductVO;

public interface ProductMapper {
	public List<ProductVO> selectAllList(); // 전체목록.
	public List<ProductVO> selectLikeList(); // 평점순위 4위 목록.
	public ProductVO selectOne(String prodCode); // 단건조회.
}
