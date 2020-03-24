package ex16exception;
import java.util.InputMismatchException;
/*
가위바위보 게임에 다음 조건에 맞는 예외처리 구문을 추가하시오
숫자대신 문자를 입력할 경우 발생되는 예외를 처리하시오. (가위바위보 입력시, 재시작여부 입력시)
게임과 관련없는 숫자를 입력했을때 사용자정의 예외클래스를 통해 처리하시오.
예외처리 클래스명 : WrongNumberException
 */
import java.util.Random;
import java.util.Scanner;


class WrongNumberException extends Exception{
	public WrongNumberException() {
		super("잘못입력하셨습니다.");
	}
}
public class QuizQuRockPaperScissors {
	
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

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner sc = new Scanner(System.in);
		int gameNum = 0;
		
		while(true) {
			int com = ((int)((Math.random()*100) % 3)+1);
			System.out.println(""+ com);
			
			System.out.print("1, 2, 3 중에 하나를 고르시오.\n");
			int user = 0;
			try {
				int userNum = GameNum();
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
					int reset = 0;
					while(true) {
						System.out.print("그만하시겠습니까?(0), 계속 하시겠습니까?(1)");
					
						try {
							int restartNum = GamesetNum();
							System.out.println("당신의 선택은"+ restartNum +" 입니다.");
						}
						catch(WrongNumberException e) {
							System.out.println("[예외발생]"+ e.getMessage());
						}
						if(reset==0 || reset==1) {
							break;
						}
						else {
							System.out.println("잘못입력하셨습니다.");
						}
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
			catch(WrongNumberException e) {
				System.out.println("[예외발생]"+ e.getMessage());
			}
		}
	}
	public static int GamesetNum() throws WrongNumberException {
		Scanner sc = new Scanner(System.in);
		int reset = 0;
		try {
			reset = sc.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		
		if(!(reset==0 || reset==1)) {
			WrongNumberException ex = new WrongNumberException();
			throw ex;
		}
		return reset;
	}
	public static int GameNum() throws WrongNumberException {
		Scanner sc = new Scanner(System.in);
		int user = 0;
		try {
			user = sc.nextInt();
		}
		catch(InputMismatchException e) {
			e.printStackTrace();
		}
		
		if(!(user==1 || user==2 || user==3)) {
			WrongNumberException ex = new WrongNumberException();
			throw ex;
		}
		return user;
	}
}
