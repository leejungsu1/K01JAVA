package common;

public class Teacher extends Person {
	
	String subject;//담당과목

	public Teacher(String name, int age, String subject) {
		super(name, age);
		this.subject = subject;
	}
	@Override
	public String getInfo() {
		return String.format("%s, 과목:%s", super.getInfo(), subject) ;
	}
	@Override
	public void showInfo() {
		System.out.println(getInfo());
	}
}
