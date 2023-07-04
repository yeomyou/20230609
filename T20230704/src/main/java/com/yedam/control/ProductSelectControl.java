package com.yedam.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.service.ProductService;
import com.yedam.service.ProductServiceImpl;
import com.yedam.vo.ProductVO;

public class ProductSelectControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		ProductService service = new ProductServiceImpl();
		String prodCode = req.getParameter("prodCode");
		
		List<ProductVO> list = service.likeList();
		
		req.setAttribute("likeList", list);
		
		ProductVO vo = service.getProduct(prodCode);
		
		req.setAttribute("selectProd", vo);
		
		return "product/prodInfo.tiles";
		
	}

}
