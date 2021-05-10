package co.kr.commentservice;

import co.kr.comment.commentbao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class insertcomment implements icommentservice {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		commentbao dao= commentbao.getinstance();
		dao.insertcomment(Integer.parseInt(request.getParameter("bid")),request.getParameter("uid") ,request.getParameter("comment"));

	}

}
