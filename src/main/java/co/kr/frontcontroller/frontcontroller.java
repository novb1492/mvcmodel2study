package co.kr.frontcontroller;



import java.io.IOException;
import java.util.ArrayList;

import com.mysql.cj.Session;

import co.kr.model.boarddao;
import co.kr.model.boardvo;
import co.kr.service.boardlistservice;
import co.kr.service.boardservice;
import co.kr.service.boardwriteservice;
import co.kr.service.viewservice;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import co.kr.member.*;


@WebServlet("*.do")///ï¿½ï¿½ï¿½Æ³ï¿½ ï¿½Ì·ï¿½ï¿½ï¿½ ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ ï¿½Ã¼ï¿½ï¿½Ö´ï¿½ 20210506
public class frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public frontcontroller() {
       super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get¿äÃ»");
		dorequest(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post¿äÃ»");
		dorequest(request,response);
	}
	

	private void dorequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		System.out.println("dorequestµé¾î¿È");
		
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		String viewpage=null;
		boardservice sv=null;

		if(uri.equals("/test/login.do"))
		{
			viewpage="login.jsp";
		}
		else if(uri.equals("/test/loginprocess.do"))
		{
			memberdao dao=memberdao.getinstance();
			int check=dao.login(request.getParameter("id"),request.getParameter("pwd"));
			System.out.println(check+"failorsuc");
			request.setAttribute("id",request.getParameter("id"));
			if(check==1)
			{
			viewpage="ge.do";
			}
			else
			{
				viewpage="login.do";
			}
		}
	
		else if(uri.equals("/test/ge.do"))
		{
			System.out.println("°Ô½ÃÆÇÀÔÀå");
			sv=new boardlistservice();
			sv.execute(request, response);
			viewpage="board_list.jsp";
			
		}
		else if(uri.equals("/test/write.do"))
		{
			System.out.println("±Û¾²±â ÀÔÀå");
			viewpage="wirte.jsp";
		}
		else if(uri.equals("/test/writeprocess.do"))
		{
			System.out.println("±ÛÀÛ¼º¿Ï·á");
			
			sv=new boardwriteservice();
			sv.execute(request, response);			
			viewpage="ge.do";
			
		}
		else if(uri.equals("/test/content.do"))
		{
			System.out.println("°Ô½Ã±Û ´©¸§");
			sv=new viewservice();
			sv.execute(request, response);
			viewpage="content.jsp";
		}
		//forward´Â ÀÌ·¸°Ô
		//¿ø·¡  ÀÌ¸§ÀÌ test¿´À½ ±×·¡¼­ ±êÇãºê ´Ù¿î·Îµå µÇ¸é¼­ mvcmodel2 Æú´õ·Î ¹Ù²ñ ±×·¡¼­ test·Î ÇØ¾ßÇÔ
		RequestDispatcher dp=request.getRequestDispatcher(viewpage);
		dp.forward(request, response);
		
	}

}
