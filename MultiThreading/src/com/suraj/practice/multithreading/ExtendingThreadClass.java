package com.suraj.practice.multithreading;

class A extends Thread {
	public void run() {
		for (int i = 0; i < 18; i++) {
			
			try {
				System.out.println("hi");
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class B extends Thread {
	public void run() {
		for (int i = 0; i < 18; i++) {
			
			try {
				System.out.println("hello");
				Thread.sleep(100);
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}
}

public class ExtendingThreadClass {
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		a.start();
		try {
			Thread.sleep(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		b.start();
	}
}
