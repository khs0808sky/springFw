package app.labs.ex03.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	@Autowired
	// IHelloService helloService; // Bean 등록된 클래스 객체를 주입 - Type 기반
	IHelloService niceService; // Bean 등록된 클래스 객체를 주입 - Type 기반
	
	public void hello(String name) {
		// System.out.println("HelloController : " + helloService.sayHello(name));
		System.out.println("HelloController : " + niceService.sayHello(name));
	}
}
