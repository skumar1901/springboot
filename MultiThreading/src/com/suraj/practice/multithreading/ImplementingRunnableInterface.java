package com.suraj.practice.multithreading;

class D implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 18; i++) {
			System.out.println("hi");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

class C implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 18; i++) {
			System.out.println("hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}

public class ImplementingRunnableInterface {
	public static void main(String[] args) {
		Runnable c = new C();
		Runnable d = new D();
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(d);
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t2.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
