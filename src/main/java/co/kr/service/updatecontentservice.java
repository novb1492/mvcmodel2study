package co.kr.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class updatecontentservice implements boardservice {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("bid", request.getParameter("bid"));
		//request.setAttribute("bname", request.getParameter("bname")); use session
		request.setAttribute("btitle", request.getParameter("btitle"));
		request.setAttribute("bcontent", request.getParameter("bcontent"));
	}

}
