package ex04controlstatement;

public class Qu_04_08 {
	/*
	다음과 같은 모양을 출력하는 프로그램을 for문으로 작성하시오.
	출력]	
	 	* * * * *
	 	* * * *
	 	* * *
	 	* *
	 	*
	 */
	public static void main(String[] args) {
		
		for(int x=1; x<=5; x++) {
			for(int y=1; y<=5; y++) {
				if(x+y<=6) {
					System.out.print("* ");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}
}
