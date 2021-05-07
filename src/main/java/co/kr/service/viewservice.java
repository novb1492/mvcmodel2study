package co.kr.service;

import co.kr.model.boarddao;
import co.kr.model.boardvo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class viewservice implements boardservice{
	
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		boarddao dao=boarddao.getinstance();
		boardvo vo=dao.getarticle(request.getParameter("id"));
		request.setAttribute("content", vo);
	}

}
