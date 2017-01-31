
public class Dog {
	public String name;
	public String breed;
	public String gender;
	
	public Dog (String name, String breed, String gender) {
		this.name = name;
		this.breed = breed;
		this.gender = gender;
	}
	
	public void call() {
		String callOut = this.name + " the " + this.breed + "!";
		String come = "Come here, " + this.gender + "!!";
		System.out.println(callOut);
		System.out.println(come);
		System.out.println();
	}
	
	public static void main(String[] args) {
		Dog spot = new Dog("Spot", "Spaniel", "boy");
		Dog lucy = new Dog("Lucy", "Shihtzu", "girl");
		spot.call();
		lucy.call();
	}
}
