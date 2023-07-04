package com.yedam.service;

import java.util.List;

import com.yedam.vo.ProductVO;

public interface ProductService {

	public List<ProductVO> productList(); // 전체목록.
	public List<ProductVO> likeList(); // 평점순위 4위 목록.
	public ProductVO getProduct(String prodCode); // 단건조회.

}
