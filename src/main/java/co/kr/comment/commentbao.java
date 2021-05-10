package co.kr.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import co.kr.utill.utill;

public class commentbao {

	private DataSource ds;
	private Connection conn;
	private PreparedStatement pstmt;
	private	ResultSet rs;
	private utill u=new utill();
	
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
	
	public int selecttotalcount(int bid)
	{
		String sql="select count(*) from comment where bid = ?";
		int n=0;
		
		try {	
			conn=ds.getConnection();//�����ͺ��̽� ����
			System.out.println(conn);

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, bid);
			System.out.println(pstmt);
			
			rs=pstmt.executeQuery();
			rs.next();
			n=rs.getInt(1);///���� ������ �������¹��̳� �������� sql�� �����ϱ���
			System.out.println("totalboard"+rs.getInt(1));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
			utill.close(rs);
		}

		return n;
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
				utill.close(conn);
				utill.close(pstmt);
	
			}

		 
	}
	public ArrayList<commentvo> selectcomment(int bid ,int firstrow,int endrow)
	{
		ArrayList<commentvo>array=new ArrayList<commentvo>();
		
		String sql="select * from comment where bid = ? order by cid desc limit ?,?";
		
		try {	
			conn=ds.getConnection();//�����ͺ��̽� ����
			System.out.println(conn);

			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,bid);
			pstmt.setInt(2, firstrow-1);
			pstmt.setInt(3, endrow-firstrow+1);
			System.out.println(pstmt);
			
			rs=pstmt.executeQuery();
			while(rs.next())
			{
				commentvo vo= new commentvo(rs.getInt("bid"),rs.getString("uid"),rs.getString("comment"),rs.getTimestamp("created"));	
				array.add(vo);
				System.out.println("inrs");
			}		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			utill.close(conn);
			utill.close(pstmt);
			utill.close(rs);
		}

		return array;
		
	}
}
