package app.labs.ex03.di03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class HelloController {
	
	// 1)
	// @Autowired
	// IHelloService helloService; // Bean 등록된 클래스 객체를 주입 - Type 기반
	// IHelloService niceService; // 변수명은 class명을 기반으로 생성되 id명과 동일하게 지정한다.
	
	// 2)
	// @Autowired
	// @Qualifier("niceService") // 사용할 빈 아이디를 지정한다.
	// IHelloService helloService;
	
	// 3) xml 설정
	@Autowired
	IHelloService helloService;
	
	public void hello(String name) {
		 System.out.println("HelloController : " + helloService.sayHello(name));
		// System.out.println("HelloController : " + niceService.sayHello(name));
	}
}
