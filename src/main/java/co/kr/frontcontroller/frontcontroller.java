package co.kr.frontcontroller;

import java.io.IOException;
import java.util.ArrayList;

import co.kr.model.boarddao;
import co.kr.model.boardvo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


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
		
		boarddao dao=boarddao.getinstance();

		if(uri.equals("/test/ge.do"))
		{
			System.out.println("°Ô½ÃÆÇÀÔÀå");
			ArrayList<boardvo>array=dao.getborad();
			request.setAttribute("arrays", array);
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
			
			String bname=request.getParameter("bname");
			String btitle=request.getParameter("btitle");
			String bcontent=request.getParameter("bcontent");
			
			dao.insert(bname, btitle, bcontent);
			
			viewpage="ge.do";
			
		}
		else if(uri.equals("/test/content.do"))
		{
			System.out.println("°Ô½Ã±Û ´©¸§");
			//request.getParameter("id");
			dao.getarticle(request.getParameter("id"));
			
			viewpage="content.jsp";
		}
		//forward´Â ÀÌ·¸°Ô
		RequestDispatcher dp=request.getRequestDispatcher(viewpage);
		dp.forward(request, response);
		
	}

}
