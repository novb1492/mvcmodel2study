package co.kr.commentservice;

import java.util.ArrayList;

import co.kr.comment.commentbao;
import co.kr.comment.commentvo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class commentpagingservice implements icommentservice {

	private static final int commentcount=5;
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strpage=request.getParameter("page");
		System.out.println("1");
		int currentpage=1;
		if(strpage!=null)
		{
			currentpage=Integer.parseInt(strpage);
		}
		cpagingservice comments=getcomments(currentpage,Integer.parseInt(request.getParameter("id")));	
		request.setAttribute("array", comments);//占쌓뤄옙 占싱뤄옙占쏙옙 占쏙옙占쏙옙占쏙옙占쏙옙占� 占싫그뤄옙占쏙옙 큰占싹놂옙占쏙옙20210507

	}
	private cpagingservice getcomments(int currentpagenum,int bid)
	{
		cpagingservice arraycomment=null;
		commentbao dao=commentbao.getinstance();
		int totalboard=dao.selecttotalcount(bid);
		
		ArrayList<commentvo>array=null;
		int firstrow=0,endrow=0;
		
		if(totalboard>0)
		{
			firstrow=(currentpagenum-1)*commentcount+1;
			endrow=firstrow+commentcount-1;
			array=dao.selectcomment(bid,firstrow, endrow);
		}
		else
		{
			currentpagenum=0;
		}
		arraycomment=new cpagingservice(array, endrow, currentpagenum, totalboard, firstrow, endrow);
		
		return arraycomment;
	}

}
