package ex08class;

//과일 판매자를 추상화한 클래스
class FruitSeller2 {
	
	int numOfApple;//판매자의 사과 보유갯수
	int myMoney;//판매수익
	int apple_price;/*사과의 단가 -> 일반변수로 변경함.
		클래스의 멤버상수로 정의하는 경우 선언과 동시에
		초기화 해야하므로 상수는 초기값이 없는 형태로는
		사용이 불가능함.
	 	*/	
	
	/*
	apple_price를 상수에서 변수로 변경하는 이유는
	상수는 단 한번만 초기화되는 특성때문에 일반적인 멤버메소드
	내에서는 초기화할수없다. 멤버메소드는 개발자가 원할때
	언제든지 호출할수있기 때문에 상수의 특성과는 맞지 않기 
	때문이다.
	 */
	public void initMembers(int money, int appleNum, int price) {
		myMoney = money;
		numOfApple = appleNum;
		apple_price = price;
	}
	
	
	public int saleApple(int money) {
		int num = money / apple_price;
		numOfApple -= num;
		myMoney += money;
		return num;
	}
	
	public void showSaleResult() {
		System.out.println("[판매자]남은 사과 갯수:"+numOfApple);
		System.out.println("[판매자]판매수익:"+myMoney);
	}
}
//구매자를 표현한 클래스
class FruitBuyer2 {
	
	int myMoney;//보유한 금액
	int numOfApple;//구매한 사과의 갯수
	
	/*
	초기화메소드
		: 멤버변수를 초기화할때 사용한다. 2차버전에서는
		생성자대신 사용되고 있으며, 객체 초기화시 여러줄에
		걸쳐 코딩해야 하는 번거로움을 간편하게 해결해줄수있다.
	 */
	public void initMembers(int _mymoney, int _numOfApple) {
		myMoney = _mymoney;
		numOfApple = _numOfApple;
	}
	
	public void buyApple(FruitSeller2 seller, int money) {
		numOfApple += seller.saleApple(money);
		myMoney -= money;
	}
	
	public void showBuyResult() {
		System.out.println("[구매자]현재잔액:"+myMoney);
		System.out.println("[구매자]사과갯수:"+numOfApple);
	}
}

public class E06FruitSalesMain2 {

	public static void main(String[] args) {
		
		/*
		생성자를 통해서 객체 생성과 동시에 초기화되므로
		init(초기화메소드)메소드를 호출할 필요가 없어진다.
		따라서 객체생성코드를 한줄로 줄일수있다.
		 */
		//판매자1
		FruitSeller2 seller1 = new FruitSeller2();
		seller1.initMembers(0, 100, 1000);
		
		//판매자2
		FruitSeller2 seller2 = new FruitSeller2();
		seller2.initMembers(0, 80, 500);
		
		
		FruitBuyer2 buyer = new FruitBuyer2();
		buyer.initMembers(10000, 0);
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		//판매자1, 판매자2에게 각각 5000원을 지불하고 구매
		buyer.buyApple(seller1, 5000);
		buyer.buyApple(seller2, 5000);
		
		System.out.println("구매행위가 일어나기전의 상태");
		seller1.showSaleResult();
		seller2.showSaleResult();
		buyer.showBuyResult();
		
		
	}
}
