package co.kr.service;

import java.util.ArrayList;

import co.kr.member.memberdao;
import co.kr.member.membervo;
import co.kr.model.boarddao;
import co.kr.model.boardvo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class boardlistservice implements boardservice {

	
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		boarddao dao=boarddao.getinstance();
		ArrayList<boardvo>array=dao.getborad();
		
		memberdao dao2=memberdao.getinstance();
		ArrayList<membervo>array2=dao2.allselect(request.getParameter("id"));
		

		
		request.setAttribute("arrays2", array2);
		request.setAttribute("arrays", array);//그래 이렇게 나눠줘야지 안그러면 큰일날듯20210507
	}
}
