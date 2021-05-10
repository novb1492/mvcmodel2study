package co.kr.frontcontroller;



import java.io.IOException;
import java.util.ArrayList;

import co.kr.service.boardlistservice;
import co.kr.service.boardservice;
import co.kr.service.boardwriteservice;
import co.kr.service.searchservice;
import co.kr.service.viewservice;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import co.kr.comment.commentbao;
import co.kr.comment.commentvo;
import co.kr.commentservice.commentpagingservice;
import co.kr.commentservice.icommentservice;
import co.kr.commentservice.insertcomment;
import co.kr.commentservice.selectcomment;
import co.kr.memberservice.*;


@WebServlet("*.do")///占쏙옙占싣놂옙 占싱뤄옙占쏙옙 占쏙옙占쏙옙占쏙옙 占시쇽옙占쌍댐옙 20210506
public class frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String[] uri2=new String[2];

    public frontcontroller() {
       super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get占쏙옙청");
		dorequest(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post占쏙옙청");
		dorequest(request,response);
	}
	

	private void dorequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		System.out.println("dorequest占쏙옙占쏙옙");
		
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		String viewpage=null;
		boardservice sv=null;
		icommentservice ic=null;
		imemberservice ac=null;
		
		System.out.println("uri"+uri);
		if(uri.equals("/test/login.do"))
		{
			viewpage="login.jsp";
		}
		else if(uri.equals("/test/loginprocess.do"))
		{
			ac=new loginservice();
			int check=ac.execute(request, response);
			if(check==1)
			{

				ac.execute2(request, response); //set session 	
				viewpage="ge.do";
			}
			else
			{
				viewpage="login.do";
			}
		}
		else if(uri.equals("/test/singup.do"))
		{
			viewpage="singup.jsp";
		}
		else if(uri.equals("/test/singupprocess.do"))
		{
			ac= new singupservice();
			int check=ac.execute(request, response);
			uri2[0]="login.do";
			uri2[1]="singup.do";
			viewpage=ch(check, uri2);
		}
		else if(uri.equals("/test/ge.do"))
		{
			System.out.println("占쌉쏙옙占쏙옙占쏙옙占쏙옙");
			sv=new boardlistservice();
			sv.execute(request, response);
			viewpage="board_list.jsp";
			
		}
		else if(uri.equals("/test/search.do"))
		{
			sv=new searchservice();
			sv.execute(request, response);
			viewpage="search.jsp";
		}
		else if(uri.equals("/test/write.do"))
		{
			System.out.println("占쌜억옙占쏙옙 占쏙옙占쏙옙");	
			viewpage="wirte.jsp";
		}
		else if(uri.equals("/test/writeprocess.do"))
		{
			System.out.println("占쏙옙占쌜쇽옙占싹뤄옙");
			
			sv=new boardwriteservice();
			sv.execute(request, response);			
			viewpage="ge.do";
			
		}
		else if(uri.equals("/test/content.do"))
		{
			System.out.println("占쌉시깍옙 占쏙옙占쏙옙");
			sv=new viewservice();
			sv.execute(request, response);
			
			ic= new commentpagingservice();
			ic.execute(request, response);
			viewpage="content.jsp";
		}
		else if(uri.equals("/test/comment.do"))
		{
			ic=new insertcomment();
			ic.execute(request, response);
			viewpage="content.do?id="+request.getParameter("id");
			System.out.println(viewpage);
		}
		//forward占쏙옙 占싱뤄옙占쏙옙
		//占쏙옙占쏙옙  占싱몌옙占쏙옙 test占쏙옙占쏙옙 占쌓뤄옙占쏙옙 占쏙옙占쏙옙占� 占쌕울옙琯占� 占실면서 mvcmodel2 占쏙옙占쏙옙占쏙옙 占쌕뀐옙 占쌓뤄옙占쏙옙 test占쏙옙 占쌔억옙占쏙옙
		RequestDispatcher dp=request.getRequestDispatcher(viewpage);
		dp.forward(request, response);
		
	}
	private String ch (int check,String[] uri2) {
		
		String u=null;
		if(check==1)
		{
			u=uri2[0];
		}
		else
		{
			u=uri2[1];
		}
		return u;
	}
	


}
