package com.yedam.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Control {
	public String exec(HttpServletRequest req, HttpServletResponse resp);
}
