package test;

import java.util.Calendar;

public class test1 {

	public static void main(String[] args) {
		
		int year=1993;
		int age;
		
		Calendar cal =Calendar.getInstance();
		System.out.println(cal);
		int now = cal.get(Calendar.YEAR);
		
		age=(now-year);
		System.out.println(""+age);
		System.out.println(""+year);
		

	}

}
