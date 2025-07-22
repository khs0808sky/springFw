package app.labs.ex04.aop01;

public class HelloServiceProxy extends HelloService {
	
	@Override
	public String sayHello(String name) {
		HelloLog.log(); // 공통관심사
		
		String result = super.sayHello(name); // 핵심관심사
		
		return result;
	}
}
