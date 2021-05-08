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
import co.kr.memberservice.*;


@WebServlet("*.do")///���Ƴ� �̷��� ������ �ü��ִ� 20210506
public class frontcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public frontcontroller() {
       super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get��û");
		dorequest(request,response);
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("post��û");
		dorequest(request,response);
	}
	

	private void dorequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		
		System.out.println("dorequest����");
		
		request.setCharacterEncoding("utf-8");
		
		String uri=request.getRequestURI();
		String viewpage=null;
		boardservice sv=null;
		imemberservice ac=null;
		
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
			ac.execute2(request, response);
			viewpage="/test/login.do";
		}
		else if(uri.equals("/test/ge.do"))
		{
			System.out.println("�Խ�������");
			sv=new boardlistservice();
			sv.execute(request, response);
			viewpage="board_list.jsp";
			
		}
		else if(uri.equals("/test/write.do"))
		{
			System.out.println("�۾��� ����");	
			viewpage="wirte.jsp";
		}
		else if(uri.equals("/test/writeprocess.do"))
		{
			System.out.println("���ۼ��Ϸ�");
			
			sv=new boardwriteservice();
			sv.execute(request, response);			
			viewpage="ge.do";
			
		}
		else if(uri.equals("/test/content.do"))
		{
			System.out.println("�Խñ� ����");
			sv=new viewservice();
			sv.execute(request, response);
		
			viewpage="content.jsp";
		}
		//forward�� �̷���
		//����  �̸��� test���� �׷��� ����� �ٿ�ε� �Ǹ鼭 mvcmodel2 ������ �ٲ� �׷��� test�� �ؾ���
		RequestDispatcher dp=request.getRequestDispatcher(viewpage);
		dp.forward(request, response);
		
	}

}
