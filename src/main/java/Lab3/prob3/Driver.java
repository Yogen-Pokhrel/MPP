package Lab3.prob3;

import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Property p1 = new House(new Address("1000 N 4th street", "Fairfield", "IA",  "52557"), 1200);
		Landlord l1 = new Landlord(p1);
		Address[] addresses = {
				new Address("111 Main", "Fairfield", "IA", "52556"),
				new Address("200 Forest Ave", "Chicago", "IA", "52556"),
			    new Address("10 N. 4th St.", "Fairfield", "IA", "52556")
		};
		TrailerPark tp = new TrailerPark(addresses[1]);
		TrailerPark tp2 = new TrailerPark(addresses[2]);
		Property[] properties = {
				new House(addresses[0], 1200.0),
				new Condo(addresses[1], 2),
				new House(addresses[1], 1400),
				new Trailer(tp),
				new Trailer(tp2),
				new Trailer(tp2)
		};

		for(Property p: properties){
			l1.addProperty(p);
		}

		double totalRent = Admin.computeTotalRent(l1.getProperties());
		List<Property> allPropertiesInCity = Admin.listPropertiesInCity(l1.getProperties(), "Chicago");
		System.out.println("Total rent is " + totalRent);
		System.out.println("All admin properties are");
		System.out.println(l1);

		System.out.println("All properties in Chicago city are");
		System.out.println(allPropertiesInCity);
	}
}
