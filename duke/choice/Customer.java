package duke.choice;

public class Customer {
	private String name;
	private String size;
	private Clothing[] items;
	
	public Customer(String name, int measurement) {
		this.name = name;
		
		setSize(measurement);
	}
	
	public void addItems(Clothing[] items) {
		this.items = items;
	}
	
	public Clothing[] getItems() {
		return items;
	}
	
	public double getTotalClothingCost() {
		double total  = 0.0;
		
		for(Clothing item : items) {
			if(this.getSize().equals(item.getSize())) {
				System.out.println(item.getDescription() + ", " + item.getPrice() + ", " + item.getSize());
				
				total += item.getPrice();
			}
		}
		
		return total;
		
	}
	
	public static double getAveragePrice(Customer customer) {
		int total = 0;
		int getLength = 0;
		
		for(Clothing item : customer.items) {
			if(customer.getSize().equals(item.getSize())) {
				total += item.getPrice();
					
				getLength += 1;
			}
		}
			
		try {
			double sumOfAveragePrice = getLength == 0 ? 0 :  total / getLength;
			
			return sumOfAveragePrice;	
		}catch(ArithmeticException e) {
			System.out.println("Error cannot divisible by zero");
		}
		
		return 0;	
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
	
	public void setSize(int measurement) {
		switch(measurement) {
			case 1, 2, 3:
				this.setSize("S");
				break;
			case 4, 5, 6:
				this.setSize("M");
				break;
			case 7, 8, 9:
				this.setSize("L");
				break;
			default: 
				this.setSize("XL");
		}
	}
}
