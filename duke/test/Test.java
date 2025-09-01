package duke.test;

public class Test {
	public static void main(String[] args) {
		Dog dog = new Dog();
		SquekyToy st = new SquekyToy();		
		dog.fetch(st);
		System.out.println(dog.myFavorite);
		
		BallToy bt = new BallToy();
		dog.fetch(bt);
		System.out.println(dog.myFavorite);
	}
}

class Dog {
	Toy myFavorite;
	
	public void fetch(Toy aToy) {
		aToy.play();
		makeFavorite(aToy);
	}
	
	public void makeFavorite(Toy aToy) {
		myFavorite = aToy;
	}
}

class SquekyToy extends Toy {
	String color = "Violet";
	String behaviour = "Make Sounds";
	
	public void play(){
		System.out.println("Squeky toy is being biten.");
	}
}

class BallToy extends Toy {
	String color = "Green";
	String behaviour = "Bounces";
	
	public void play(){
		System.out.println("Ball was rolling");
	}
}

abstract class Toy {
	abstract void play();
}


class Bottle{
	
	public void process() {
		for(int numOfBottles = 99; numOfBottles > 0; numOfBottles--) {
			System.out.print(lyrics(numOfBottles, "Bottles I keep on the storage. \n"));
			System.out.print(lyrics(-1, "I throw 1 of the bottle on the storage. \n"));
			System.out.print(lyrics(numOfBottles - 1, "Bottles left :< \n\n\n"));
		}
	}
	
	public String lyrics(int numOfBottles, String line) {
		if(numOfBottles == -1) {
			return line;
		}
		
		return numOfBottles + " " + line;
	}
}

class LeapYear {
	final int DIVISIBLE = 4;

	private String status = "";
	
	public boolean isLeapYear(int year) {
		if(checkYearFormat(year)) {
			return false;
		}
		
		int isYear = year % DIVISIBLE;
		
		if(isYear != 0) {
			status = "Year " + year + " is not a leap year.";
			
			return false;
		}
		
		status = "Year " + year + " is a leap year.";
		
		return true;
	}
	
	private boolean checkYearFormat(int year) {
		if(year < 1000 || year > 9999) {
			return true;
		}
		
		return false;
	}
	
	public String getStatus() {
		return status;
	}
}