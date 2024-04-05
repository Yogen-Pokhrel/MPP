package Lab3.prob3;

abstract public class Property {
    private Address address;
	public Address getAddress() {
		return address;
	}
	public Property(Address address) {
		this.address = address;
	}

    public abstract double computeRent();
}
