package com.suraj.practice.multithreading;

class Base{
	int num;
	boolean isProduced=false;

	public synchronized void getNum() throws Exception {
		if(!isProduced) {
			wait();
		}
		
		System.out.println("Get : "+num);
		isProduced=false;
		notify();
	}

	public synchronized void setNum(int num) throws Exception {
		if(isProduced) {
			wait();
		}
		this.num = num;
		System.out.println("Set : "+num);
		isProduced=true;
		notify();
	}
	
}
class Producer implements Runnable{
Base o;
	public Producer(Base o) {
		this.o=o;
		Thread t=new Thread(this,"producer");
		t.start();
		
	}
	@Override
	public void run() {
		int i=0;
		while(true) {
			try {
				o.setNum(i++);
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
class Consumer implements Runnable{
Base o;
 public Consumer(Base o) {
	this.o=o;
	Thread t=new Thread(this,"consumer");
	t.start();
}
	@Override
	public void run() {
		while(true) {
			try {
				o.getNum();
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}
public class ProducerConsumer {
	public static void main(String[] args) {
Base b=new Base();
new Producer(b);
new Consumer(b);

}
}
