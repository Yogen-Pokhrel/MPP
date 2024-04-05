package Lab3.prob3;



public class Condo extends Property {
	private int numberOfFloors;
	 
	public Condo(Address address, int numberOfFloors) {
		super(address);
		this.numberOfFloors = numberOfFloors;
	}

	public double computeRent(){
		return 400 * numberOfFloors;
	}

	public String toString(){
		return "Condo at: " + getAddress() + " Number of Floors: " + numberOfFloors + " Rent: " + computeRent();
	}
}
