package co.kr.service;

import co.kr.model.boarddao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class updatecontentprocess implements boardservice {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		boarddao dao=boarddao.getinstance();
		dao.updatecontentprocess(Integer.parseInt(request.getParameter("bid")),request.getParameter("btitle"),request.getParameter("bcontent"));

	}

}
