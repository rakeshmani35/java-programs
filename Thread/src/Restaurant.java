import java.util.ArrayList;
import java.util.List;

// https://www.linuxtopia.org/online_books/programming_books/thinking_in_java/TIJ315_016.htm

class Order {
	private static int i = 0;
	private int count = i++;

	public Order() {
		if (count == 10) {
			System.out.println("Out of food, closing");
			System.exit(0);
		}
	}

	public String toString() {
		return "Order " + count;
	}
}

class WaitPerson extends Thread {
	 private Restaurant restaurant;
	  public WaitPerson(Restaurant r) {
	    restaurant = r;
	    start();
	  }
	  public void run() {
		    while(true) {
		      while(restaurant.order == null)
		        synchronized(this) {
		          try {
		            wait();
		          } catch(InterruptedException e) {
		            throw new RuntimeException(e);
		          }
		        }
		      System.out.println(
		        "Waitperson got " + restaurant.order);
		      restaurant.order = null;
		    }
		  }
}

public class Restaurant {

	public Object order;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = new ArrayList<>();

	}

}
