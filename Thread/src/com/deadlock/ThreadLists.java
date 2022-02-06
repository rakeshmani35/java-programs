package com.deadlock;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Map;

public class ThreadLists {

	public static void main(String[] args) {

		// get top level thread group
		ThreadGroup top = Thread.currentThread().getThreadGroup();
		ThreadGroup parent;

		do {
			parent = top.getParent();
			if (parent != null) {
				top = parent;
			}
		} while (parent != null);

		// get thread count
		int activeCount = top.activeCount();

		Map<Thread, StackTraceElement[]> stackTraces = Thread.getAllStackTraces();

		ThreadMXBean threadBean = ManagementFactory.getThreadMXBean();
		int threadCount = threadBean.getThreadCount();
		long[] threadIds = threadBean.getAllThreadIds();

		System.out.println("ThreadGroup: " + activeCount + " active threads");
		System.out.println("Thread: " + stackTraces.size() + " stack trace(s) returned");
		System.out.println("ThreadMXBean: " + threadCount + " live threads(s)");
		System.out.println("ThreadMXBean: " + threadIds.length + " thread Id(s)");

		// check results are consistent
		boolean failed = false;
		if (activeCount != stackTraces.size())
			failed = true;
		if (activeCount != threadCount)
			failed = true;
		if (activeCount != threadIds.length)
			failed = true;

		if (failed) {
			throw new RuntimeException("inconsistent results");
		}
	}
}