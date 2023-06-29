package com.yedam.member.control;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.service.MemberServcieImpl;
import com.yedam.member.service.MemberService;

public class ChartDataControl implements Control {

	@Override
	public String exec(HttpServletRequest req, HttpServletResponse resp) {
		//{"name : "홍길동", "age":20, "phone":"010-1111-1111"}
		String json = "{\"name\":\"홍길동\", \"age\":20, \"phone\":\"010-1111-1111\"}";
		json="";
		
		MemberService service = new MemberServcieImpl();
		List<Map<String, Object>> list = service.getData();
		json = "[";
		int cnt = 1;
		for(Map<String,Object> map : list) {
			json+= "{\"" + map.get("DEPARTMENT_NAME")+"\": " + map.get("CNT") + "}";
			if(cnt++ != list.size()) {
				json+=",";
			}
		}
		json+="]";
		return json+".json";
		
	}

}
