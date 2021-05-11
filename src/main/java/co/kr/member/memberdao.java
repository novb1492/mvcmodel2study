package co.kr.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.kr.utill.utill;

public class memberdao {
	
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private	ResultSet rs;

	private memberdao()
	{
		try{
			Context ct = new InitialContext();///context.xmlï¿½Ð±ï¿½ ï¿½ï¿½ï¿½ï¿½
			ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql2");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private static memberdao dao=new memberdao();
	
	public static memberdao getinstance()
	{
		if(dao!=null)
		{
			dao=new memberdao();
		}
		return dao;
	}
	
	public void deletemember(String id)
	{
		String sql="delete from members where id=?";
		
		try {	
			pstmt=intodatabase(sql);
			pstmt.setString(1, id);
			System.out.println(pstmt+"deletemembers");
		
			pstmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
		}
		
	}
	public boolean singup(String id,String pwd ,String name ,String email)
	{
		String sql="insert into members(id,pwd,name,email)values(?,?,?,?)";
		
		int check=0;
		boolean tf=false;
		try {
			
			pstmt=intodatabase(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			System.out.println(pstmt+"singupsql");
		
			check=pstmt.executeUpdate();	
			tf=utill.check(check);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
		}
		return tf;
	}
	public membervo allselect2(String userid)
	{
		System.out.println("try select all "+userid);
		
		String sql="select * from members where id=?";
		membervo vo=null;
		try {
			
			pstmt=intodatabase(sql);
			pstmt.setString(1, userid);
			System.out.println(pstmt+"get all userinfor");
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				 vo=new membervo(rs.getString("id"),rs.getString("name"),rs.getString("pwd"),rs.getString("email"),rs.getTimestamp("created"));
		
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
			utill.close(rs);
		}
		return vo;
	}
	public ArrayList<membervo> allselect(String userid)
	{
		String sql="select * from members where id=?";
		System.out.println("select all infor at "+userid);
		ArrayList<membervo>array=new ArrayList<membervo>();
		
		try {
			
			pstmt=intodatabase(sql);
			pstmt.setString(1, userid);
			System.out.println(pstmt+"·Î±×ÀÎ");
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				membervo vo=new membervo(rs.getString("id"),rs.getString("name"),rs.getString("pwd"),rs.getString("email"),rs.getTimestamp("created"));
				array.add(vo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
		}
		return array;
	}
	public int login(String userid,String userpwd)
	{
		System.out.println("try login id"+userid);
		String sql="select pwd from members where id=?";
		rs=null;
		
		int check=0;
		try {
			pstmt=intodatabase(sql);
			pstmt.setString(1, userid);
			System.out.println(pstmt+"·Î±×ÀÎ");
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				if(rs.getString("pwd").equals(userpwd))
				{
					check=1;
				}
				else
				{
					check=2;
				}
			}
			else
			{
				check=0;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
			utill.close(rs);
		}
		return check;
	}
	
	private PreparedStatement  intodatabase(String sql)
	{
		
		try {	
			conn=ds.getConnection();
			System.out.println(conn+"Á¢¼Ó¿Ï·á");
			pstmt=conn.prepareStatement(sql);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pstmt;
	}
	
	
}
