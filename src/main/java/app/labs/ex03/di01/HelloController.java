package app.labs.ex03.di01;

public class HelloController {
	// 의존성 설정
	// 1) 멤버필드를 이용
	// private IHelloService helloService = new HelloService();
	
	// 2) 생성자(COnstructor)
	private IHelloService helloService;
	
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	// 3) Setter
	public HelloController() {}
	
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	public void hello(String name) {
		System.out.println("HelloController : " + helloService.sayHello(name));
	}
	
}
