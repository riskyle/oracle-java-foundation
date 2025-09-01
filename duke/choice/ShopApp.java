package duke.choice;

import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;


public class ShopApp {

	public static void main(String[] args) {
		Customer c1 = new Customer("Pinky", 13);
		
		System.out.println("Welcome to Duke Choice Shop.");
		
		System.out.println("Customer is " + c1.getName() +" "+ c1.getSize());
		
		System.out.println("This shop has a minimum price of " + Clothing.MINIMUM_PRICE);
		
		Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
		Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");		
				
		Clothing[] items = {item1, item2, new Clothing("Blue T-Shirt", 10.5, "S"), new Clothing("Green Scarf", 5, "S")};
		
		try {
			ItemList list = new ItemList(items);
			
			Routing routing = Routing
					.builder()
					.get("/items", list)
					.build();
			
			ServerConfiguration config = ServerConfiguration
					.builder()
					.bindAddress(InetAddress.getLocalHost())
					.port(8888)
					.build();
			
			WebServer ws = WebServer.create(config, routing);
			
			ws.start();
		} catch(UnknownHostException ex) {
			ex.printStackTrace();
		}
		
		c1.addItems(items);
		
		Arrays.sort(items);
		
		for(Clothing item : c1.getItems()) {
			System.out.println("Item " + item);
		}
		
		System.out.println("Total Clothing Cost:"
				+ " " + c1.getTotalClothingCost());
		
		System.out.println("Average Price: " + Customer.getAveragePrice(c1));
	}
}
