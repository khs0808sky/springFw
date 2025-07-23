package app.labs.ex04.aop02;

import org.springframework.stereotype.Service;

@Service
public class HelloService implements IHelloService {

	@Override
	public String sayHello(String name) {
		// 1) 코드 이용 - 재솰용성이 부족하다.
		// System.out.println(">>> Log : " + new java.util.Date());
		
		// 2) OOP 코드분리 - 재활용, sayHello의 원래의 기능과 상관없는 코드
		// HelloLog.log();
		
		// 3) Proxy D.P.
		
		System.out.println("HelloService.sayHello() 메서드 실행");
		String message = "Hello~~~" + name;
		return message;
	}

	@Override
	public String sayGoodbye(String name) {
		System.out.println("HelloService.sayGoodbye() 메서드 실행");
		String message = "Goodbye~~~" + name;
		return message;
	}

}
