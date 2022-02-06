package com.trywith.resource;

import java.io.Closeable;
import java.io.IOException;

/**
 * To construct a custom resource that will be correctly handled by a
 * try-with-resources block, the class should implement the "Closeable" or
 * "AutoCloseable" interfaces, and override the close method:
 * 
 * https://www.baeldung.com/java-try-with-resources
 * 
 * @author rakes
 *
 */
class AutoCloseableResourcesFirst implements AutoCloseable {

	public AutoCloseableResourcesFirst() {
		System.out.println("Constructor -> AutoCloseableResources_First");
	}

	public void doSomething() {
		System.out.println("Something -> AutoCloseableResources_First");
	}

	@Override
	public void close() throws Exception {
		System.out.println("Closed AutoCloseableResources_First");
	}

}

class AutoCloseableResourcesSecond implements Closeable {

	public AutoCloseableResourcesSecond() {
		System.out.println("Constructor -> AutoCloseableResources_Second");
	}

	public void doSomething() {
		System.out.println("Something -> AutoCloseableResources_Second");
	}

	@Override
	public void close() throws IOException {
		System.out.println("Closed AutoCloseableResources_Second");
	}

}

public class TryWithCustomeResource {

	public static void main(String[] args) {

		try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
				AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {

			af.doSomething();
			as.doSomething();
			
		} catch (IOException e) {
			System.out.println("exception in case of Closeable interface");
		} catch (Exception e) {
			System.out.println("exception in case of AutoCloseable interface");
		}

	}

}
