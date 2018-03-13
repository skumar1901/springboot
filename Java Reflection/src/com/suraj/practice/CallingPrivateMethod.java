package com.suraj.practice;

import java.lang.reflect.Method;

public class CallingPrivateMethod {
public static void main(String[] args) throws Exception {
	Class c=Class.forName("com.suraj.practice.SimpleObject");
	SimpleObject s=(SimpleObject) c.newInstance();
	Method m=c.getDeclaredMethod("show", null);
	m.setAccessible(true);
	m.invoke(s, null);
}
}
