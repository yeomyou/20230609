package com.yedam.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductListControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		ProductService service = new ProductServiceImpl();
		
		List<ProductVO> list = service.productList();

		req.setAttribute("productList", list);
		return "product/prodList.tiles";
	}

}
