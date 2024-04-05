package Lab3.prob3;



public class Condo extends Property {
	private int numberOfFloors;
	private Address address;
	 
	public Condo(Address address, int numberOfFloors) {
		this.address = address;
		this.numberOfFloors = numberOfFloors;
	}

	public double computeRent(){
		return 400 * numberOfFloors;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	public String toString(){
		return "Condo at: " + getAddress() + " Number of Floors: " + numberOfFloors + " Rent: " + computeRent();
	}
}
