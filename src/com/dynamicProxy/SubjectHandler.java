package com.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class SubjectHandler implements InvocationHandler {

	// �������������Ҫ�������ʵ����
	private Object subject;

	// ���췽����������Ҫ�������ʵ���󸳳�ֵ
	public SubjectHandler(Object subject) {
		this.subject = subject;
	}

	@Override
	public Object invoke(Object object, Method method, Object[] args) throws Throwable {
		
	    //�ڴ�����ʵ����ǰ���ǿ������һЩ�Լ��Ĳ���
        System.out.println("Info:------------------------------------------------------");
        System.out.println("Object:" + object.getClass().getName());
        System.out.println("Method:" + method);
        System.out.println(args.getClass());
        System.out.println("Info:------------------------------------------------------");
        
        //��������������ʵ����ķ���ʱ������Զ�����ת��������������handler�����invoke���������е���
        method.invoke(subject, args);
		
		return null;
	}

}
