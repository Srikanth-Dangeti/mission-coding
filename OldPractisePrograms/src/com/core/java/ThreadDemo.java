package com.core.java;

class MyThread extends Thread
{
	public void run()
	{
	   for(int i=0;i<5;i++)	
	   {
	      System.out.println("Child Thread");
	      Thread.yield();
	   }
	}
}
public class ThreadDemo {
	
	public static void main(String []args)
	{
		//System.out.println(Thread.currentThread().getName());
		MyThread t=new MyThread();
		
		//System.out.println(t.getName());
		t.start();
		//Thread.currentThread().setName("kanchan");
		
		//System.out.println(Thread.currentThread().getName());
		for(int i=0;i<5;i++)
		System.out.println("Main Thread");
	}
	

}
