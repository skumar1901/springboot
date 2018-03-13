package com.suraj.practice.multithreading;

public class ThreadExampleUsingLambda {
	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 18; i++) {
				System.out.println("hi");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 18; i++) {
				System.out.println("hello");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		t2.start();
	}
}
