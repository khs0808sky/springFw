package app.labs.ex04.aop02;

// 메서드가 모두 정적인 경우 유틸클래스라고 한다.
public class HelloLog {
	
	public static void log() {
		System.out.println(">>> Log : " + new java.util.Date());
	}
}
