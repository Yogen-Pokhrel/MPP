package Lab3.prob3;



public class House extends Property{
	private double lotSize;
	private Address address;
	
	public House(Address address, double lotSize) {
		this.address = address;
		this.lotSize = lotSize;
	}

	@Override
	public Address getAddress() {
		return address;
	}

	public double computeRent(){
		return 0.1 * lotSize;
	}

	public String toString(){
		return "House at: " + getAddress() + " Lot Size: " + lotSize + " Rent: " + computeRent();
	}
}
