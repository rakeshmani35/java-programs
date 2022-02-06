package com.forkjoin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

// https://howtodoinjava.com/java7/forkjoin-framework-tutorial-forkjoinpool-example/
// program that will search for files with a determined extension inside a folder and its subfolders. 
class FolderProcessor extends RecursiveTask<List<String>> {

	// This attribute will store the full path of the folder this task is going to
	// process.
	private final String path;

	// This attribute will store the name of the extension of the files this task is
	// going to look for.
	private final String extension;

	public FolderProcessor(String path, String extension) {
		this.path = path;
		this.extension = extension;
	}

	/**
	 * Implement the compute() method. As you parameterized the RecursiveTask class
	 * with the List<String> type, this method has to return an object of that type.
	 */
	@Override
	protected List<String> compute() {

		// List to store the names of the files stored in the folder.
		List<String> list = new ArrayList<String>();

		// FolderProcessor tasks to store the subtasks that are going to process the
		// subfolders stored in the folder
		List<FolderProcessor> tasks = new ArrayList<FolderProcessor>();

		File file = new File(path);
		File[] listFiles = file.listFiles();

		// For each element in the folder, if there is a subfolder, create a new
		// FolderProcessor object and execute it asynchronously using the fork() method.

		if (listFiles != null) {
			for (int i = 0; i < listFiles.length; i++) {

				if (listFiles[i].isDirectory()) { // check if folder
					FolderProcessor task = new FolderProcessor(listFiles[i].getAbsolutePath(), extension);
					task.fork();
					tasks.add(task);
				} else {
                     if (checkFile(listFiles[i].getName())) {
						list.add(listFiles[i].getAbsolutePath());
					}
				}
			}
		}

		addResultFromTask(list, tasks);
		
		return list;
	}

	private void addResultFromTask(List<String> list,List<FolderProcessor> tasks) {
		for (FolderProcessor folderProcessor : tasks) {
			list.addAll(folderProcessor.join());
		}
	}
	
	private boolean checkFile(String name) {
		return name.endsWith(extension);
	}
}

public class SearchFileInFolder {

	public static void main(String[] args) {

		// create ForkJoinPool using default constructor
		//ForkJoinPool pool = new ForkJoinPool(10); // 10 threads 
		ForkJoinPool pool = new ForkJoinPool(); // default thread max to core size

		FolderProcessor apps = new FolderProcessor("C:\\Program Files", "exe");
		pool.execute(apps);
		
		System.out.printf("******************************************\n");
        System.out.printf("Main: Parallelism: %d\n", pool.getParallelism());
        System.out.printf("Main: Active Threads: %d\n", pool.getActiveThreadCount());
        System.out.printf("Main: Task Count: %d\n", pool.getQueuedTaskCount());
        System.out.printf("Main: Steal Count: %d\n", pool.getStealCount());
        System.out.printf("******************************************\n");
		
		
		while (!apps.isDone()) {
			pool.shutdown();
			 List<String> results= apps.join();
			 System.out.printf("Apps: %d files found.\n", results.size());
		}
	}

}

// output: Apps: 845 files found.