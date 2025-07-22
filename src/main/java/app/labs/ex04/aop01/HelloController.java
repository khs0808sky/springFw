package app.labs.ex04.aop01;


public class HelloController {
	
	private IHelloService helloService;
	
	public HelloController() {
		//this.helloService = new HelloService();
	}
	
	public HelloController(IHelloService helloService) {
		this.helloService = helloService;
	}
	
	public void setHelloService(IHelloService helloService) {
		this.helloService = helloService;		
	}
	
	public void hello(String name) {
		System.out.println("HelloController : " + this.helloService.sayHello(name));
	}
}
