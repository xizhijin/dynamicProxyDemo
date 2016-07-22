package com.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ClientTest {

	public static void main(String[] args) {
		// ����Ҫ�������ʵ����
		Subject realSubject = new RealSubject();

		// ����Ҫ�����ĸ���ʵ���󣬾ͽ��ö��󴫽�ȥ�������ͨ������ʵ�����������䷽����
		InvocationHandler handler = new SubjectHandler(realSubject);

		/*
		 * ͨ��Proxy��newProxyInstance�������������ǵĴ�������������������������� 
		 * ��һ������handler.getClass().getClassLoader()����������ʹ��handler������ClassLoader�������������ǵĴ������
		 * �ڶ�������realSubject.getClass().getInterfaces()����������Ϊ��������ṩ�Ľӿ�����ʵ������ʵ�еĽӿ�,��ʾ��Ҫ������Ǹ���ʵ���������Ҿ��ܵ�������ӿ��еķ�����
		 * ����������handler�� �������ｫ������������������Ϸ���InvocationHandler k���������
		 */
		Subject subject = (Subject) Proxy.newProxyInstance(handler.getClass().getClassLoader(), realSubject.getClass().getInterfaces(), handler);

		System.out.println(subject.getClass().getName());
		System.out.println("\n\n");
		subject.rent();
		System.out.println("\n\n");
		subject.hello("world");
	}

}
