package co.kr.memberservice;

import co.kr.member.memberdao;
import co.kr.member.membervo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class loginservice implements imemberservice {
	
	public int execute(HttpServletRequest request,HttpServletResponse response) {
		
		memberdao dao=memberdao.getinstance();
		int check=dao.login(request.getParameter("id"),request.getParameter("pwd"));
		
		System.out.println("pass login excute");
		return check;
	}

	@Override
	public void execute2(HttpServletRequest request, HttpServletResponse response) {
		memberdao dao3=memberdao.getinstance();
		membervo vo=dao3.allselect2(request.getParameter("id"));
		
		HttpSession session = request.getSession(); // ���� �޾ƿ� �̰� ���ʿ��ϴ� mvc2������ �޿�..�ݹ� ã���Ű��� �Ф�20210507
		session.setAttribute("uid",vo.getUserid()); 
		session.setAttribute("uname",vo.getUsername()); 
		session.setAttribute("uemail",vo.getUseremail()); 
		session.setAttribute("ucreated",vo.getUsercreated()); 
		
	}
	
	

}
