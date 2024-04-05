package Lab3.prob3;

import java.util.List;

public class Driver {

	public static void main(String[] args) {
		Property p1 = new House(new Address("1000 N 4th street", "Fairfield", "IA",  "52557"), 1200);
		Admin a1 = new Admin(p1);
		Address[] addresses = {
				new Address("111 Main", "Fairfield", "IA", "52556"),
				new Address("200 Forest Ave", "Fairfield", "IA", "52556"),
			    new Address("10 N. 4th St.", "Fairfield", "IA", "52556")
		};
		Property[] properties = { 
				new House(addresses[0], 1200.0), 
				new Condo(addresses[1], 2), 
				new Trailer(addresses[2]) 
		};

		for(Property p: properties){
			a1.addProperty(p);
		}

		double totalRent = a1.computeTotalRent();
		System.out.println("Total rent is " + totalRent);
		System.out.println("All admin properties are");
		System.out.println(a1);
	}
}
