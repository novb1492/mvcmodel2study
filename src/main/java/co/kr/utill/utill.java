package co.kr.utill;

import java.sql.*;

public class utill {
	public static void close(Connection conn)
	{
		try {
			if(conn!=null)
			{
				conn.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(Statement stmt)//prepare ¹ÞÀ»¼ö ÀÖ´Ù
	{
		try {
			if(stmt!=null)
			{
				stmt.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void close(ResultSet rs)
	{
		try {
			if(rs!=null)
			{
				rs.close();
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	


}
