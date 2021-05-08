package co.kr.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.kr.model.boarddao;
import co.kr.member.membervo;
import co.kr.utill.utill;

public class memberdao {
	
	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private	ResultSet rs;
	private close c=new close();
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
	public int singup(String id,String pwd ,String name ,String email)
	{
		String sql="insert into members(id,pwd,name,email)values(?,?,?,?)";
		
		int check=0;
		try {
			
			conn=ds.getConnection();
			System.out.println(conn+"Á¢¼Ó¿Ï·á ·Î±×ÀÎ");
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			System.out.println(pstmt+"·Î±×ÀÎ");
		
			check=pstmt.executeUpdate();	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			c.closesql(conn);
			c.closesql(pstmt);
		}
		return check;
	}
	public membervo allselect2(String userid)
	{
		String sql="select * from members where id=?";

		System.out.println(userid);
		membervo vo=null;
		try {
			
			conn=ds.getConnection();
			System.out.println(conn+"Á¢¼Ó¿Ï·á ·Î±×ÀÎ");
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			System.out.println(pstmt+"·Î±×ÀÎ");
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				 vo=new membervo(rs.getString("id"),rs.getString("name"),rs.getString("pwd"),rs.getString("email"),rs.getTimestamp("created"));
		
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			c.closesql(conn);
			c.closesql(pstmt);
			c.closesql(rs);
		}
		return vo;
	}
	public ArrayList<membervo> allselect(String userid)
	{
		String sql="select * from members where id=?";
		conn= null;
		pstmt=null;
		rs=null;
		System.out.println(userid);
		ArrayList<membervo>array=new ArrayList<membervo>();
		try {
			
			conn=ds.getConnection();
			System.out.println(conn+"Á¢¼Ó¿Ï·á ·Î±×ÀÎ");
			
			pstmt=conn.prepareStatement(sql);
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
			c.closesql(conn);
			c.closesql(pstmt);
		}
		return array;
	}
	public int login(String userid,String userpwd)
	{

		String sql="select pwd from members where id=?";
		conn= null;
		pstmt=null;
		rs=null;
		System.out.println(userid);
		int check=0;
		try {
			
			conn=ds.getConnection();
			System.out.println(conn+"Á¢¼Ó¿Ï·á ·Î±×ÀÎ");
			
			pstmt=conn.prepareStatement(sql);
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
			c.closesql(conn);
			c.closesql(pstmt);
			c.closesql(rs);
		}
		return check;
	}
	
	
}
