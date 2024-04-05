
package Lab3.client;

import Lab3.prob2.Apartment;
import Lab3.prob2.Building;
import Lab3.prob2.Landlord;

import java.util.List;

public class Prob2Client {
    public static void main(String[] args) {
        // Landlord created
        Landlord landlord = new Landlord(1000, 1000);
        //we have guaranteed that, at least one building and one apartment is added initially
        Building initialLandlordBuilding = landlord.getBuildings().get(0);
        initialLandlordBuilding.addApartment(3200);
        initialLandlordBuilding.addApartment(2200);
        Building b = landlord.addBuilding(3000);
        b.addApartment(2000);
        b.addApartment(3000);
        b.addApartment(1500);
        b.addApartment(3500);
        Building b2 = landlord.addBuilding(2000);
        b2.addApartment(1300);
        b2.addApartment(900);
        b2.addApartment(5000);

        double profit = landlord.getTotalProfit();
        System.out.println("Landlord total profit is " + profit);

        System.out.println("Landlords builds are as below");
        System.out.println(landlord);
    }
}
