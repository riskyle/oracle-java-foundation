package duke.choice;

public class Clothing implements Comparable<Clothing>{
	public final static double TAX = 0.2;
	public static final double MINIMUM_PRICE = 10.0;
	private String description;
	private double price;
	private String size = "M";

	public Clothing(String descripiton, double price, String size) {
		this.description = descripiton;
		this.price = price;
		this.size = size;
	}
	
	@Override
	public int compareTo(Clothing clothing) {
		return description.compareTo(clothing.description);
	}
	
	@Override
	public String toString() {
		return getDescription() + ", "+ getPrice() + ", " + getSize();
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public double getPrice() {
		double taxAdded =  price * TAX;
		double priceWithTax = taxAdded + price;
		
		return priceWithTax;
	}
	
	public void setPrice(double price) {
		this.price = (price > MINIMUM_PRICE) ? price : MINIMUM_PRICE;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size = size;
	}
}