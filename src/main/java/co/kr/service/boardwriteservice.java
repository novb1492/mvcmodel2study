package co.kr.service;



import co.kr.member.memberdao;
import co.kr.member.membervo;
import co.kr.model.boarddao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class boardwriteservice implements boardservice{

	
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{

		boarddao dao=boarddao.getinstance();
		
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		memberdao dao3=memberdao.getinstance();
		membervo vo=dao3.allselect2(request.getParameter("id"));
		
	
		
		dao.insert(bname, btitle, bcontent);
	}
}
