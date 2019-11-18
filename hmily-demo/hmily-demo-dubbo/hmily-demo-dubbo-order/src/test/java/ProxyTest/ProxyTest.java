package ProxyTest;

import java.lang.reflect.Proxy;

public class ProxyTest {
	public static void main(String[] args) {
		Person s = new  Student("张三");
		PersonHandler stuHandler = new PersonHandler<Person>(s);
		Person stuProxy = (Person) stuHandler.newProxyInstance(s);
		stuProxy.setName("账务");
		
	}
}
