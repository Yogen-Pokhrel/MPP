package Lab3.prob3;


public class Trailer extends Property {
	private static final double RENT = 500;
	private TrailerPark trailerPark;
	
	public Trailer(TrailerPark trailerPark) {
		this.trailerPark = trailerPark;
	}

	@Override
	public Address getAddress() {
		return trailerPark.address;
	}

	public double computeRent(){
		return RENT;
	}

	public String toString(){
		return "Trailer at: " + getAddress() + " Rent: " + computeRent();
	}
}
