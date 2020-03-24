package ex16exception;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


class WrongNumberException extends Exception{
	public WrongNumberException() {
		super("[예외발생]1~3사이의 숫자를 입력하세요.");
	}
}
public class QuRockPaperScissors {
	
	public static String GameRule(int n) {
		String answer = "";
		switch (n) {
		case 1:
			answer = "가위";
			break;
		case 2:
			answer = "바위";
			break;
		case 3:
			answer = "보";
			break;
		}
		return answer;
	}

	public static void main(String[] args) throws WrongNumberException {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		
		while(true) {
			int com = ((int)((Math.random()*100) % 3)+1);
			System.out.println(""+ com);
			int user = 0;
			try {
				System.out.print("1(가위), 2(바위), 3(보) 중에 하나를 고르시오.\n");
				user = sc.nextInt();
			}
			catch(InputMismatchException e){
				e.printStackTrace();
			}
			catch(WrongNumberException e) {
				
			}
			
			//사용자 입력이 1~3이 아니면 사용자정의 예외 발생시킴
			if(!(user==1 || user==2 || user==3)) {
				WrongNumberException wne = new WrongNumberException();
				throw wne;
			}
			if(!(user<1 || user>3)) {
				
				System.out.printf("사용자: %s, 컴퓨터: %s ",GameRule(user),GameRule(com));
				switch (user-com) {
				case 0:
					System.out.println("비겼습니다.");
					break;
				case -2:case 1:
					System.out.println("이겼습니다.");
					break;
				case -1:case 2:
					System.out.println("졌습니다.");
					break;
				}
				gameNum++;
			}
			else {
				System.out.println("다시하시오.");
			}
			if(gameNum>=5) {
				int reset = -1;
				while(true) {
					try {
						System.out.print("그만하시겠습니까?(0), 계속 하시겠습니까?(1)");
						reset = sc.nextInt();
					
						if(reset==0 || reset==1) {
							break;
						}
						else {
							System.out.println("잘못입력하셨습니다.");
						}
					}
					catch(InputMismatchException e) {
						e.printStackTrace();
					}
				if(reset==0) {
					System.out.println("게임을 종료합니다.");
					break;
				}
				else if(reset==1) {
					System.out.println("게임을 재시작합니다.");
					gameNum = 0;
				}
			}
		}
	}
}
}