package com.amit.syncronization;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DeadlockQueue queue = new DeadlockQueue();
		
		// enqueue the first object. It will cause deadlock
		
		queue.enqueue("Just a String");
		
		System.out.println("No DeadLock!!");
	}

}
