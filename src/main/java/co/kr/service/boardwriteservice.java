package co.kr.service;



import co.kr.model.boarddao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class boardwriteservice implements boardservice{

	
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{

		boarddao dao=boarddao.getinstance();
		
		String bname=request.getParameter("bname");
		String btitle=request.getParameter("btitle");
		String bcontent=request.getParameter("bcontent");
		
		dao.insert(bname, btitle, bcontent);
	}
}
