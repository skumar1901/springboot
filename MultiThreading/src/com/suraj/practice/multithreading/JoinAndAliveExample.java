package com.suraj.practice.multithreading;

public class JoinAndAliveExample {
	public static void main(String[] args) throws Exception {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				System.out.println("hi");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
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
		t1.join();
		t2.join();
//		if (!(t1.isAlive() || t2.isAlive())) {
			System.out.println("Byeee");
//		}
	}
}
