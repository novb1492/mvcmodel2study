package co.kr.commentservice;

import java.util.ArrayList;

import co.kr.comment.commentvo;

public class cpagingservice {

	private int commentTotalCount; //珥� 寃뚯떆湲� �닔
	private int currentPageNumber; //�쁽�옱 �쐞移섑븳 �럹�씠吏�踰덊샇
	private ArrayList<commentvo> commentList; //DB濡쒕��꽣 �쟾�떖諛쏆� 寃뚯떆湲� 紐⑸줉
	private int pageTotalCount; //珥� �럹�씠吏� �닔
	private int commentCountPerPage; //�븳 �럹�씠吏��떦 �뱾�뼱媛� 寃뚯떆臾� �닔
	private int firstRow; //泥ロ뻾
	private int endRow; //留덉�留� �뻾

	public cpagingservice(ArrayList<commentvo> commentList, int commentTotalCount,int currentPageNumber, int commentCountPerPage,int startRow, int endRow) 
	{
		this.commentList = commentList;
		this.commentTotalCount = commentTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.commentCountPerPage = commentCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;

		this.calculatePageTotalCount();
	}
	
	//珥� �럹�씠吏� �닔瑜� 怨꾩궛�븯�뒗 硫붿꽌�뱶
	private void calculatePageTotalCount() {
		if (this.commentTotalCount == 0) 
		{
			this.pageTotalCount = 0;
		} 
		else 
		{
			this.pageTotalCount = this.commentTotalCount / this.commentCountPerPage;
			
			if (this.commentTotalCount % this.commentCountPerPage > 0) 
			{
				this.pageTotalCount++;
			}
		}
	}

	public int getCommentTotalCount() {
		return commentTotalCount;
	}

	public void setCommentTotalCount(int commentTotalCount) {
		this.commentTotalCount = commentTotalCount;
	}

	public int getCurrentPageNumber() {
		return currentPageNumber;
	}

	public void setCurrentPageNumber(int currentPageNumber) {
		this.currentPageNumber = currentPageNumber;
	}

	public ArrayList<commentvo> getCommentList() {
		return commentList;
	}

	public void setCommentList(ArrayList<commentvo> commentList) {
		this.commentList = commentList;
	}

	public int getPageTotalCount() {
		return pageTotalCount;
	}

	public void setPageTotalCount(int pageTotalCount) {
		this.pageTotalCount = pageTotalCount;
	}

	public int getCommentCountPerPage() {
		return commentCountPerPage;
	}

	public void setCommentCountPerPage(int commentCountPerPage) {
		this.commentCountPerPage = commentCountPerPage;
	}

	public int getFirstRow() {
		return firstRow;
	}

	public void setFirstRow(int firstRow) {
		this.firstRow = firstRow;
	}

	public int getEndRow() {
		return endRow;
	}

	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	
	
}
