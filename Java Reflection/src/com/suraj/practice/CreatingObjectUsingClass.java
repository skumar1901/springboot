package com.suraj.practice;
class Test{
	public void show() {
		System.out.println("hi");
	}
}
public class CreatingObjectUsingClass {
public static void main(String[] args) throws Exception {
	Class c=Class.forName("com.suraj.practice.Test");
	Test t=(Test) c.newInstance();
	t.show();
	
}
}
