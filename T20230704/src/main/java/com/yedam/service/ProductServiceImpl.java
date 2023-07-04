package com.yedam.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataPool;
import com.yedam.dao.ProductMapper;
import com.yedam.vo.ProductVO;

public class ProductServiceImpl implements ProductService{
	SqlSession session = DataPool.getInstance().openSession(true);
	ProductMapper mapper = session.getMapper(ProductMapper.class);
	@Override
	public List<ProductVO> productList() {
		return mapper.selectAllList();
	}

	@Override
	public List<ProductVO> likeList() {
		return mapper.selectLikeList();
	}

	@Override
	public ProductVO getProduct(String prodCode) {
		return mapper.selectOne(prodCode);
	}

}
