package ex04controlstatement;

import java.io.IOException;

public class Qu_04_02 {
	/*
	하나의 문자를 입력받아 숫자인지 여부를 판단하는 프로그램을 삼항연산자를 이용하여 구현하시오.	
	(System.in.read()를 사용하세요)
	*/
	public static void main(String[] args) throws IOException {
		
		System.out.print("하나의 문자를 입력하시오.");
		int su = System.in.read();
		/*
		삼항연산자 형식 :
		변수 = (조건식) ? 참일때값 : 거짓일때값;
		 */
		
		String suresult = (su>='0' && su<='9') ? 
				"숫자이다." : "숫자가 아니다.";
		System.out.println("입력한 문자 "+(char)su+"는 "+suresult);
	}
}
