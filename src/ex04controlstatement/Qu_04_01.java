package ex04controlstatement;

import java.io.IOException;

public class Qu_04_01 {
	/*
	하나의 문자를 입력받아 사용자가 입력한 값이 숫자인지 판단하여 숫자라면 
	2의배수인지를 다시 판단하여서 2의배수인 경우에만 "2의 배수 입니다"라고 
	출력하여라. 그 외에는 "2의 배수가 아닙니다" 라고 출력한다.
	힌트] '0'의 아스키코드값은 48 입니다. 
	(System.in.read()를 사용하세요)
	 */
	public static void main(String[] args) throws IOException {
		
		System.out.print("하나의 문자를 입력하세요.");
		int i = System.in.read();
		
		//아스키코드값을 알고있는 경우 구현방법
		//boolean isNumber = (ascii>=48 && ascii<=57);
		//아스키코드값을 모를때 구현방법
		if(i>='0' && i<='9') {
			System.out.println("숫자입니다.");
			
			/*
			숫자형문자가 가지고 있는 아스키코드값에서 48(0의 아스키코드)
			을 빼면 해당문자의 정수가 된다.
			 */
			if(i%2 == 0 && i != '0') {
				System.out.println("2의 배수입니다.");
			}
			else {
				System.out.println("2의 배수가 아닙니다.");
			}
		}
		else {
			System.out.println("숫자가 아닙니다.");
		}
	}
}
