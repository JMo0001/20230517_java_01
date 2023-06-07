package kh.lclass.vo;

public class TestVo {
	private int boardNum;
	private String boardWriter;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	//생성자
	public TestVo(int num) {
//		boardNum = num+1000;
		boardNum = (int)System.currentTimeMillis() + num;
	}
	public TestVo(int a, String writer) {
		this(a); // this가 누구? >> TestVo(int num)
		//boardNum = a+1000;
		boardWriter = writer;
	}
	//all arguments == 초기값 설정(생성시에 반드시 받아야 하는 매개인자)
	public TestVo(int boardNum, String boardWriter, String boardtitle, 
			String boardContent, String boardDate) {
//		this.boardNum = boardNum+1000;
//		this.boardWriter = boardWriter;
		this.boardTitle = boardtitle;
		this.boardContent = boardContent;
		this.boardDate = boardDate;
	}

	//getter-setter
	//toString
	public int getBoardNum() {
		return boardNum;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public void setBoardTitle(String boardTitle	) {
		this.boardTitle = boardTitle;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	
}
