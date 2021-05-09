package co.kr.service;

import java.util.ArrayList;

import co.kr.model.boardvo;

public class pasingservice {

	private int messageTotalCount; //珥� 寃뚯떆湲� �닔
	private int currentPageNumber; //�쁽�옱 �쐞移섑븳 �럹�씠吏�踰덊샇
	private ArrayList<boardvo> messageList; //DB濡쒕��꽣 �쟾�떖諛쏆� 寃뚯떆湲� 紐⑸줉
	private int pageTotalCount; //珥� �럹�씠吏� �닔
	private int messageCountPerPage; //�븳 �럹�씠吏��떦 �뱾�뼱媛� 寃뚯떆臾� �닔
	private int firstRow; //泥ロ뻾
	private int endRow; //留덉�留� �뻾

	public pasingservice(ArrayList<boardvo> messageList, int messageTotalCount,int currentPageNumber, int messageCountPerPage,int startRow, int endRow) 
	{
		this.messageList = messageList;
		this.messageTotalCount = messageTotalCount;
		this.currentPageNumber = currentPageNumber;
		this.messageCountPerPage = messageCountPerPage;
		this.firstRow = startRow;
		this.endRow = endRow;

		calculatePageTotalCount();
	}
	
	//珥� �럹�씠吏� �닔瑜� 怨꾩궛�븯�뒗 硫붿꽌�뱶
	private void calculatePageTotalCount() {
		if (this.messageTotalCount == 0) 
		{
			this.pageTotalCount = 0;
		} 
		else 
		{
			this.pageTotalCount = this.messageTotalCount / this.messageCountPerPage;
			
			if (this.messageTotalCount % this.messageCountPerPage > 0) 
			{
				this.pageTotalCount++;
			}
		}
	}

	public int getMessageTotalCount() {
		return this.messageTotalCount;
	}

	public int getCurrentPageNumber() {
		return this.currentPageNumber;
	}

	public ArrayList<boardvo> getMessageList() {
		return this.messageList;
	}

	public int getPageTotalCount() {
		return this.pageTotalCount;
	}

	public int getMessageCountPerPage() {
		return this.messageCountPerPage;
	}

	public int getFirstRow() {
		return this.firstRow;
	}

	public int getEndRow() {
		return this.endRow;
	}

	public boolean isEmpty() {
		return this.messageTotalCount == 0;
	}
}
