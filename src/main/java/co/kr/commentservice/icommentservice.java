package co.kr.commentservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface icommentservice {

	void execute(HttpServletRequest request,HttpServletResponse response);
}
