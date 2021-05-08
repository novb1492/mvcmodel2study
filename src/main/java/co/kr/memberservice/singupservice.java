package co.kr.memberservice;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class singupservice implements imemberservice {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		
		System.out.println("intosingup");
		
		String sql="insert into members(id,name,pwd,email)values(?,?,?,?)";
		
		return 0;
	}

	@Override
	public void execute2(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

}
