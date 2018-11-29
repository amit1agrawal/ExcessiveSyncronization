package com.amit.syncronization;

import java.util.*;

public abstract class WorkQueue {

	private final List queue = new LinkedList();
	private boolean stopped = false;
	
	protected WorkQueue() {
		new WorkerThread().start();
	}
	
	public final void enqueue (Object workItem) {
		synchronized (queue) {
			queue.add(workItem);
			queue.notify();
		}
	}
	
	public final void stop() {
		synchronized (queue) {
			stopped = true;
			queue.notify();
		}
		
	}
	// The method should be implemented by subclass
	protected abstract void processItem(Object workItem) throws InterruptedException;
	
	private class WorkerThread extends Thread {
		public void run() {
			while (true) {
				synchronized (queue) {
					try {
							while (queue.isEmpty() && !stopped) {
								queue.wait();
							}
					}
					catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
					
					if (stopped)
						return;
					
					Object workItem = queue.remove(0);
					try {
						processItem(workItem);
					}
					catch (InterruptedException e) {
						e.printStackTrace();
						return;
					}
				}
			}
		}
	}
}
