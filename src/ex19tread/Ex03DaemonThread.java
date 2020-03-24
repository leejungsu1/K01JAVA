package ex19tread;
/*쓰레드로 구현하지 않은 클래스*/
/*
	: 하나의 클래스가 작업을 끝내야 다음 클래스의
	작업을 진행할수있다. 즉, 동시에 작업을 진행할수
	없다.
 */
class NotThread {
	String title;
	public NotThread(String title) {
		this.title = title;
	}
	void notThreadMethod() {
		for(int i=1 ; i<=10 ; i++) {
			System.out.println(String.format("%s]i=%d",title,i));
		}
	}
}
/*
독립쓰레드(Non Daemon Thread)
	: 메인쓰레드와 working쓰레드(개발자가 정의한 쓰레드)을
	일컫는 것으로 메인 쓰레드가 종료되어도 계속 실행되며, Dead
	상태가 되어야 실행이 종료되는 쓰레드를 말한다.
	해당 쓰레드를 실행하게 되면 main메소드가 종료된 이후에도
	실행되는것을 볼수있다.
 */
class YesThread extends Thread{
	public YesThread() {}
	/*
	Tread클래스의 생성자를 호출할때 전달하는 매개변수를
	통해 해당 쓰레드의 이름을 지정할수있다. 지정된 이름은
	getName()메소드를 통해 반환할수있다.
	 */
	public YesThread(String threadName) {
		super(threadName);
	}
	void threadMethod() throws InterruptedException{
		for(int i=1 ; i<=10 ; i++) {
			System.out.println(String.format("%s]i=%d",getName(),i));
			sleep(2000);//2초에 한번씩 Block상태가 된다.
		}
	}
	public void run() {
		try {
			threadMethod();
		}
		catch(InterruptedException e) {}
	}
	
}
/*
종속 쓰레드(DaemonThread)
	: 모든 독립쓰레드가 종료되면 자동으로 종료되는 쓰레드를
	말한다. 주로 프로그램의 보조역할로 배경음악, 로그자동저장
	등의 업무를 처리한다.
	프로그램이 종료될대 자동으로 종료되므로 주로 무한루프로
	구성한다. setDaemon(true)메소드로 설정할수있다.
 */
class DaemonThread extends Thread{
	@Override
	public void run() {
		while(true) {
			System.out.println(String.format("[쓰레드명:%s]Jazz가 흘러요~", getName()));
			try {
				sleep(3000);
				System.out.println("3초마다 자동저장");
			}
			catch(InterruptedException e) {
				System.out.println("자동저장시 오류발생");
			}
		}
	}
}

public class Ex03DaemonThread {

	public static void main(String[] args) {
		
		/*
		쓰레드로 구현하지 않은 클래스의 작업
		 */
		NotThread nt1 = new NotThread("첫번째 클래스");
		nt1.notThreadMethod();
		
		NotThread nt2 = new NotThread("두번째 클래스");
		nt2.notThreadMethod();
		
		/*
		독립쓰레드(Non Daemon Thread) 실행
		 */
		YesThread yt1 = new YesThread("1st 쓰레드");
		yt1.setName("첫번째 쓰레드");//쓰레드의 이름지정 두번째방법
		yt1.start();//쓰레드 객체를 Runnable상태로 만들어준다.
		
		YesThread yt2 = new YesThread();/*
						쓰레드 생성시 이름을 지정하지 않으면 JVM이
						자동으로 이름을 부여한다.
		 			*/
		yt2.setPriority(Thread.MAX_PRIORITY);
		yt2.start();
		
		/*
		데몬쓰레드(DaemonThread) 실행
		 */
		DaemonThread dt = new DaemonThread();
		dt.setName("난 데몬 쓰레드");
		dt.setDaemon(true);//독립쓰레드를 데몬쓰레드로 만들어준다.
		dt.start();
		
		System.out.println("현재활성화된 상태의 쓰레드 수"+Thread.activeCount());
		System.out.println("현재실행중인 쓰레드명:"+Thread.currentThread().getName());
		System.out.println("메인함수의 우선순위:"+Thread.currentThread().getPriority());
		System.out.println("메인함수(Main Thread)종료");
	}
}
