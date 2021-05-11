package co.kr.memberservice;



import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class logoutservice implements imemberservice {

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void execute2(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		
		 session.invalidate();

	}

	@Override
	public boolean execute3(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
