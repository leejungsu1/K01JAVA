package ex10accessmodifier;
/*
윈도우 기본프로그램인 그림판은 좌상단이 0,0 이고 우하단으로 갈수록 좌표값이 커진다.
멤버변수가 정보은닉이 되지않아 멤버변수에 직접 접근이 가능하고, 잘못된 값을 입력할 소지가 있다.
멤버변수의 직접접근을 차단하고, 생성자 메소드를 이용하여 멤버변수를 초기화할수 있도록 한다.
x, y 좌표는 0 ~ 100 사이의 값을 가진다. 즉 좌표값이 마이너스 or 100을 초과하면 ‘좌표 범위가 잘못되었다’라고 print해줘야 한다.
우하단의 좌표값이 좌상단의 좌표값보다 작아서는 안된다. 이 경우 ‘좌표 지정이 잘못되었다’ 라고 print해줘야 한다.
좌표R값이 정상일때만 넓이가 출력된다.

실행결과]
넓이:81
좌상단 좌표 범위가 잘못되었습니다.
우하단 좌표 범위가 잘못되었습니다.
좌표값 오류로 넓이를 계산할수 없습니다.
좌측 우측 좌표지정이 잘못되었습니다.
좌표값 오류로 넓이를 계산할수 없습니다.
 */
//class Rectangle
//{
//	//멤버변수
//   	int ulx, uly;//좌상단(upper left x, upper left y)
//   	int lrx, lry;//우하단(lower right x, lower right y)

   	//생성자
//   	public Rectangle(int ulx, int uly, int lrx, int lry) {
//   		
//   		if(0<= ulx, uly, lrx, lry <=100)
//   			this.ulx = ulx;
//   			this.uly = uly;
//   			this.lrx = lrx;
//   			this.lry = lry;
//   		else
//   			System.out.println("좌표범위가 잘못되었다.");
//   		/* 
//		좌표값이 정상범위안에 있는지 판단하여 초기화한다.
//		*/
//   	}   	   	
//   	public void showArea(){
//   		if(0<int ulx, int uly<int lrx,int lry)
//   			(lry-uly) * (lrx-ulx)
//   		else
//   			System.out.println("좌표지정이 잘못되었다.");
//   		/* 사각형의 넓이를 구하는 메소드 정의 */
//   	}  	
//}
//
//class QuRectangle_1
//{
//   	public static void main(String[] args)
//   	{
//		//여기부터
//     		Rectangle rec = new Rectangle();
//     		rec.ulx=22;
//     		rec.uly=22;
//     		rec.lrx=10;
//     		rec.lry=10;
//		//여기까지는 정보은닉후 실행되지 않게 해야한다....
//
//		//아래 생성자로만 객체생성후 초기화 되도록 처리한다...
//		Rectangle rec1 = new Rectangle(1,1,10,10);
//		rec1.showArea();
//		
//		Rectangle rec2 = new Rectangle(-2,-2,101,101);
//		rec2.showArea();
//		
//		Rectangle rec3 = new Rectangle(10,10,1,1);
//		rec3.showArea();
//   	}
//}

