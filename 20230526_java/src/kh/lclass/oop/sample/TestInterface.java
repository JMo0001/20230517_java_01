package kh.lclass.oop.sample;

public interface TestInterface {
	int MAXCNT = 10;					//묵시적으로 public static final
	public static final int MAXCNT2 =20;
	public void method1();				//능력단위별 평가보기
	public String method2();			//평가 안내
	public int method3(int a, int b);	//평가 리뷰
	
	
	
	
	
//	int insertBoard(Car no);
//	int deleteBoard(Car no);
//	int selectOne(int boardNo);
//	Car[] selectList();
//	Car[] selectList(String searchWord);
//	List<Car> selectListList(Stirng searchWord);
//	Car[] searchSelectBoard()
}
