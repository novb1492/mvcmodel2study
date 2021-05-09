package co.kr.service;

import java.util.ArrayList;

import co.kr.model.boarddao;
import co.kr.model.boardvo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class searchservice implements boardservice {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		boarddao dao= boarddao.getinstance();
		
		ArrayList<boardvo>array=dao.search(request.getParameter("title"));
		request.setAttribute("array", array);

	}

}
