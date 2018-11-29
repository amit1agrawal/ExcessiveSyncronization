package com.amit.syncronization;

public class DisplayQueue extends WorkQueue {

	@Override
	protected void processItem(Object workItem) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println(workItem);
		// Sleep for 1 second
		Thread.sleep(1000);
	}
}
