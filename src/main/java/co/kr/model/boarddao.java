package co.kr.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.kr.utill.utill;



public class boarddao {

	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private	ResultSet rs;
	private boarddao()
	{
		try{
			Context ct = new InitialContext();///context.xml�б� ����
			ds=(DataSource)ct.lookup("java:comp/env/jdbc/mysql2");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	private static boarddao dao=new boarddao();
	
	public static boarddao getinstance()
	{
		if(dao!=null)
		{
			dao=new boarddao();
		}
		return dao;
	}
	
	public boardvo getarticle(String id)
	{
		uphit(id);
		
		boardvo vo=null;
		String sql="select *from board where id=?";
		
		try {
			
			conn=ds.getConnection();//�����ͺ��̽� ����
			System.out.println(conn);

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			System.out.println(pstmt);
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
			vo=new boardvo(rs.getInt("id"), rs.getString("name"), rs.getString("title"), rs.getString("content"),rs.getTimestamp("date"),rs.getInt("hit"));		
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
	private void uphit(String id) {
		
		String sql="update board set hit=hit+1 where id=?";
		

		try {
			
			conn=ds.getConnection();//�����ͺ��̽� ����
			System.out.println(conn);

			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,  id);
			System.out.println(pstmt);
			
			int i=pstmt.executeUpdate();
			check(i);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
		}
	}
	public ArrayList<boardvo> getborad()
	{
		ArrayList<boardvo> array=new ArrayList<>();
		
		String sql="select *from board order by id desc";
		
		try {
			
			conn=ds.getConnection();//�����ͺ��̽� ����
			System.out.println(conn);

			pstmt=conn.prepareStatement(sql);
			System.out.println(pstmt);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				boardvo article= new boardvo(rs.getInt("id"), rs.getString("name"), rs.getString("title"), rs.getString("content"),rs.getTimestamp("date"),rs.getInt("hit"));
				array.add(article);
			}
			System.out.println(array.get(0));
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
		}

		return array;
		
	}
	public void insert(String bname,String btitle,String bcontent)
	{
		
		System.out.println(btitle+"title");
		String sql="insert into board(name,title,content)values(?,?,?)";
		try {
			
			conn=ds.getConnection();//�����ͺ��̽� ����
			System.out.println(conn);

			pstmt=conn.prepareStatement(sql);
	
			pstmt.setString(1,bname);
			pstmt.setString(2,btitle);
			pstmt.setString(3,bcontent);
			System.out.println(pstmt);
			
			int i=pstmt.executeUpdate();
			check(i);
						
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
		}
		
	}
	private void check(int i) {
		
		System.out.println(i+"check");	
		if(i==1)
		{
			System.out.println("sucess");
		}
		else
		{
			System.out.println("fail");
		}	
	}
}
