package com.forkjoin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


// https://www.javatpoint.com/java-forkjoinpool
class Task9 extends RecursiveAction {
	private long Load = 0;

	public Task9(long Load) {
		this.Load = Load;
	}

	@Override
	protected void compute() {
		// if work is above threshold, break tasks up into smaller tasks
		List<Task9> subtasks = new ArrayList<Task9>();
		subtasks.addAll(createSubtasks());
		for (RecursiveAction subtask : subtasks) {
			subtask.fork();
		}
	}

	private List<Task9> createSubtasks() {
		List<Task9> subtasks = new ArrayList<Task9>();
		Task9 subtask1 = new Task9(this.Load / 2);
		Task9 subtask2 = new Task9(this.Load / 2);
		Task9 subtask3 = new Task9(this.Load / 2);
		subtasks.add(subtask1);
		subtasks.add(subtask2);
		subtasks.add(subtask3);
		return subtasks;
	}
}

public class JavaForkJoingetActivethreadcountExample1 {

	public static void main(String[] args) {
		
		int proc = Runtime.getRuntime().availableProcessors();
		
		System.out.println("numbers of core available in your processor:" + proc);
		
		ForkJoinPool Pool = ForkJoinPool.commonPool();
		System.out.println(" Before invoking number of active thread   :" + Pool.getActiveThreadCount());
		
		Task9 t = new Task9(400);
		Pool.invoke(t);
		
		System.out.println(" After invoking Numbers of active thread   :" + Pool.getActiveThreadCount());
		
		System.out.println("Common Pool Size   :" + Pool.getPoolSize());

		
	}

}
