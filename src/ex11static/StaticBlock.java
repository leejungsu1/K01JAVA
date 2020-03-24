package ex11static;

/*
static블럭
	: 동일 클래스안의 메소드보다 먼저 실행되는 static블럭을
	main메소드의 실행코드가 없어도 먼저 실행된다.
	단, 다른 클래스에 main이 있는 경우에는 main이 순차적으로
	실행되다가 static블럭이 있는 클래스가 객체화될때
	실행되게 된다. 이 때 생성자보다 static블럭이 먼저 실행된다.
 */
public class StaticBlock {
	//인스턴스형 멤버
	int instanceVar;
	void instanceMethod() {}
	
	//정적멤버
	static int staticVar;
	static void staticMethod() {
		int localVar;
		System.out.println("정적메소드");
	}
	
	//static블럭
	static {
		//static블럭안에서는 정적멤버인 staticVar에 접근가능
		staticVar = 1000;
		
		/*
		static 블럭안에서만 사용할수있는 지역변수 선언.
		블럭내에서만 제한적으로 사용이 가능하다.
		 */
		int localVar;
		localVar = 1000;
		System.out.println("localVar="+localVar);//[허용됨]
		
		/*
		static블럭내에서는 인스턴스형 멤버를 사용할수없다.
		 */
		//System.out.println("instanceVar="+instanceVar);//에러발생
		//intanceMethod();//에러발생
		
		/*
		정적멤버만 접근이 가능하다.
		 */
		System.out.println("staticVar="+staticVar);
		staticMethod();
		
		//main메소드보다 먼저 실행되는지 확인용 출력문
		System.out.println("=====static block=====");
	}
	
	//생성자 메소드
	/*
	외부파일의main메소드에서 실행되는 경우 해당 클래스의 객체가
	생성자를 통해 생성되기전에 static블럭이 먼저 실행된다.
	 */
	public StaticBlock() {
		staticVar = -1;
		System.out.println("====StaticBlock의 생성자====");
	}
	
	public static void main(String[] args) {
		
		/*
		E02StaticBlockMain.java에서 실행할때는 주석처리후 실행하세요.
		main메소드가 외부파일에 있을때 실행을 테스트하기 위함.
		 */
		//System.out.println("===메인메소드===");
		
		//static블럭내에서만 선언된 지역변수이므로 main에서 사용불가
		//System.out.println("localVar="+localVar);
	}
}
