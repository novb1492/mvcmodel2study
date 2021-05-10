package co.kr.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.kr.member.close;
import co.kr.member.memberdao;
import co.kr.model.boardvo;

public class commentbao {

	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private	ResultSet rs;
	private close c=new close();
	
	private commentbao()
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
	
	private static commentbao dao=new commentbao();
	
	public static commentbao getinstance()
	{
		if(dao!=null)
		{
			dao=new commentbao();
		}
		return dao;
	}
	public void insertcomment(int bid ,String uid,String comment)
	{
		 String sql="insert into comment(bid,uid,comment)values(?,?,?)";
		 
		 try {	
				conn=ds.getConnection();//�����ͺ��̽� ����
				System.out.println(conn);

				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,bid);
				pstmt.setString(2, uid);
				pstmt.setString(3, comment);
				System.out.println(pstmt+"insertcomment");
				
				int rn=pstmt.executeUpdate();
			if(rn==1)
			{
				System.out.println("suc");
			}
			else
			{
				System.out.println("fail");
			}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			finally {
				c.closesql(conn);
				c.closesql(pstmt);
	
			}

		 
	}
	public ArrayList<commentvo> select(int bid)
	{
		ArrayList<commentvo>array=new ArrayList<commentvo>();
		
		String sql="select * from comment where bid = ?  ";
		
		try {	
			conn=ds.getConnection();//�����ͺ��̽� ����
			System.out.println(conn);

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,bid);
			//pstmt.setInt(2, firstrow-1);
			//pstmt.setInt(3, endrow-firstrow+1);
			System.out.println(pstmt);
			
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				commentvo vo= new commentvo(rs.getInt("bid"),rs.getString("uid"),rs.getString("comment"),rs.getTimestamp("created"));	
				array.add(vo);
				System.out.println("inrs");
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			c.closesql(conn);
			c.closesql(pstmt);
			c.closesql(rs);
		}

		return array;
		
	}
}
