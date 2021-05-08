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
		
		/*memberdao dao3=memberdao.getinstance();
		membervo vo=dao3.allselect2(request.getParameter("id"));
		
		HttpSession session = request.getSession(); // ���� �޾ƿ� �̰� ���ʿ��ϴ� mvc2������ �޿�..�ݹ� ã���Ű��� �Ф�20210507
		session.setAttribute("uid",vo.getUserid()); 
		session.setAttribute("uname",vo.getUsername()); 
		session.setAttribute("uemail",vo.getUseremail()); 
		session.setAttribute("ucreated",vo.getUsercreated()); */
		// 
		request.setAttribute("arrays2", array2);
		request.setAttribute("arrays", array);//�׷� �̷��� ��������� �ȱ׷��� ū�ϳ���20210507
	}
}
