package ProxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class PersonHandler<T> implements InvocationHandler {
	
	 private T mTarget;

	 public PersonHandler(T target) {
	        mTarget = target;
	 }
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("start");
		Object result = arg1.invoke(mTarget, arg2);
		System.out.println(arg0.getClass().toString());
		System.out.println("finish");
		return result;
	}
	
	public Object newProxyInstance(Object target) {
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

}
