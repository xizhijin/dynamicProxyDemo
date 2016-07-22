package com.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectHandler implements InvocationHandler {

	// 　这个就是我们要代理的真实对象
	private Object subject;

	// 构造方法，给我们要代理的真实对象赋初值
	public SubjectHandler(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		
	    //在代理真实对象前我们可以添加一些自己的操作
        System.out.println("Info:------------------------------------------------------");
        System.out.println("Object:" + object.getClass().getName());
        System.out.println("Method:" + method);
        System.out.println(args.getClass());
        System.out.println("Info:------------------------------------------------------");
        
        //当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
        method.invoke(subject, args);
		
		return null;
	}

}
