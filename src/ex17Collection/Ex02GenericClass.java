package ex17Collection;

class Apple{
	int weight;
	public Apple(int w) {
		weight = w;
	}
	public void showInfo(){
		System.out.println("사과의 무게는 "+ weight +"입니다.");
	}
}
class Banner{
	int sugar;
	public Banner(int s) {
		sugar = s;
	}
	public void showInfo(){
		System.out.println("바나나의 당도는 "+ sugar +"입니다.");
	}
}
/*
class FruitBox{
	Object item;
	public void store(Object item) {
		this.item = item;
	}
	public Object pullOut() {
		return item;
	}
}

=>기존 Object기반의FruitBox를 아래롸 같이 제네릭 클래스로 정의한다.
자료형에 해당하는 대분 대표문자T(Type)으로 교체하고, 객체생성시
자료형을 결정하기위해"클래스명<T>"형태로 변경한다.
 */
class GenericFruitBox<T>{
	T item;
	public void store(T item ) {
		this.item = item;
	}
	public T pullOut() {
		return item;
	}
}
public class Ex02GenericClass {

	public static void main(String[] args) {
		
		/*
		인스턴스 생성시 T부분을 결정하므로 구형의 편의성이 보장된다.
		각각 Apple, Banner객체를 저장할수있는 인스턴스가
		생성되었다.
		 */
		GenericFruitBox<Apple> appleBox = new GenericFruitBox<Apple>();
		appleBox.store(new Apple(10));
		Apple apple = appleBox.pullOut();
		apple.showInfo();
		
		GenericFruitBox<Banner> bannerBox = new GenericFruitBox<Banner>();
		bannerBox.store(new Banner(20));
		Banner banner = bannerBox.pullOut();
		banner.showInfo();
		
		/*
		OrangeBox는 인스턴스 생성시 Orange를 저장할수있는 용도로
		생성되었기 때문애 다른 객체를 저장할수없다.
		아래코드에서 컴파일 에러가 발생되므로 자료형에도 안전한 코드가 된다.
		 */
		GenericFruitBox<Orange> orangeBox = new GenericFruitBox<Orange>();
//		orangeBox.store("나는 오렌지");<-컴파일에러발생
//		orangeBox.store(apple);
//		orangeBox.store(banner);
	}
}
