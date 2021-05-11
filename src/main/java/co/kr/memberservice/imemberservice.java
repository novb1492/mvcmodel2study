package co.kr.memberservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface imemberservice {
	
	int execute(HttpServletRequest request,HttpServletResponse response);
	void execute2(HttpServletRequest request,HttpServletResponse response);
	boolean execute3(HttpServletRequest request,HttpServletResponse response);
}
