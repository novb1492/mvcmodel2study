package co.kr.service;

import co.kr.model.boarddao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class deletecontentservice implements boardservice {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		boarddao dao= boarddao.getinstance();
		dao.deletecontent(Integer.parseInt(request.getParameter("bid")));

	}

}
