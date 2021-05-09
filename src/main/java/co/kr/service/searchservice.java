package co.kr.service;

import java.util.ArrayList;

import co.kr.model.boarddao;
import co.kr.model.boardvo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class searchservice implements boardservice {

	
	private static final int messagecount=5;
	
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		if(request.getParameter("title")!="")//blank search 
		{
			String strpage=request.getParameter("page");
			int currentpage=1;
			
			if(strpage!=null)
			{
				currentpage=Integer.parseInt(strpage);
			}
			pasingservice page=getboardariticle(currentpage,request.getParameter("title"));
			request.setAttribute("array", page);
		}
	}
	private pasingservice getboardariticle(int currentpagenum,String title)
	{
		pasingservice articles=null;
		boarddao dao=boarddao.getinstance();
		int totalboard=dao.selecttotalcount(title);
		
		ArrayList<boardvo>array=null;
		int firstrow=0,endrow=0;
		
		if(totalboard>0)
		{
			firstrow=(currentpagenum-1)*messagecount+1;
			endrow=firstrow+messagecount-1;
			array=dao.search(title,firstrow, endrow);
		}
		else
		{
			currentpagenum=0;
		}
		articles=new pasingservice(array,  totalboard, currentpagenum,  messagecount, firstrow, endrow);
		
		return articles;
	}

}
