package co.kr.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class close {

	public void closesql(Connection conn)
	{
		try {
			
			conn.close();
			System.out.println("close"+conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closesql(PreparedStatement pstmt)
	{
		try {
			
			pstmt.close();
			System.out.println("close"+pstmt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void closesql(ResultSet rs)
	{
		try {
			
			rs.close();
			System.out.println("close"+rs);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
