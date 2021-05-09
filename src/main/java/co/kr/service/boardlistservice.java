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

	
	private static final int messagecount=5;
	
	public void execute(HttpServletRequest request,HttpServletResponse response)
	{
		String strpage=request.getParameter("page");
		int currentpage=1;
		if(strpage!=null)
		{
			currentpage=Integer.parseInt(strpage);
		}
		pasingservice articles=getboardariticle(currentpage);	
		request.setAttribute("array", articles);//占쌓뤄옙 占싱뤄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占� 占싫그뤄옙占쏙옙 큰占싹놂옙占쏙옙20210507
	}
	private pasingservice getboardariticle(int currentpagenum)
	{
		pasingservice articles=null;
		boarddao dao=boarddao.getinstance();
		int totalboard=dao.selecttotalcount();
		
		ArrayList<boardvo>array=null;
		int firstrow=0,endrow=0;
		
		if(totalboard>0)
		{
			firstrow=(currentpagenum-1)*messagecount+1;
			endrow=firstrow+messagecount-1;
			array=dao.getborad(firstrow, endrow);
		}
		else
		{
			currentpagenum=0;
		}
		articles=new pasingservice(array,  totalboard, currentpagenum,  messagecount, firstrow, endrow);
		
		return articles;
	}
}
