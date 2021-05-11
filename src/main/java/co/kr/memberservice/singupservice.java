package co.kr.memberservice;

import co.kr.member.memberdao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class singupservice implements imemberservice {

	@Override
	public boolean execute3(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("intosingup");
		memberdao dao=memberdao.getinstance();
		boolean check=dao.singup(request.getParameter("id"),request.getParameter("pwd"),request.getParameter("name"),request.getParameter("email"));
		return check;
	}

	@Override
	public void execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}


}
