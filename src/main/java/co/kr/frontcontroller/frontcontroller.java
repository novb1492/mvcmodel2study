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


@WebServlet("*.do")///미쳤네 이렇게 가지고 올수있다 20210506
public class frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public frontcontroller() {
       super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get요청");
		dorequest(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post요청");
		dorequest(request,response);
	}
	

	private void dorequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		System.out.println("dorequest입장");
		
		request.setCharacterEncoding("utf-8");
		
		
		String uri=request.getRequestURI();
		String viewpage=null;
		
		boarddao dao=boarddao.getinstance();

		if(uri.equals("/test/ge.do"))
		{
			System.out.println("이;동");
			ArrayList<boardvo>array=dao.getborad();
			request.setAttribute("arrays", array);
			viewpage="board_list.jsp";
			
		}
		else if(uri.equals("/test/write.do"))
		{
			System.out.println("이동");
			viewpage="wirte.jsp";
		}
		else if(uri.equals("/test/writeprocess.do"))
		{
			System.out.println("게시글등록");
			
			String bname=request.getParameter("bname");
			String btitle=request.getParameter("btitle");
			String bcontent=request.getParameter("bcontent");
			
			dao.insert(bname, btitle, bcontent);
			
			viewpage="ge.do";
			
		}
		//forward하는법
		RequestDispatcher dp=request.getRequestDispatcher(viewpage);
		dp.forward(request, response);
		
	}

}
