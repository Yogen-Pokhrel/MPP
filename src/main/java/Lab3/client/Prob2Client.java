
package client;

import Lab3.prob2.Apartment;
import Lab3.prob2.Building;
import Lab3.prob2.Landlord;

public class Prob2Client {
    public static void main(String[] args) {
        // Landlord created
        Landlord landlord = new Landlord();
        // Building 1
        landlord.addBuilding(100, 500);
        // Building 2
        Building building = new Building(200, 600);
        Apartment apartment = new Apartment(700);
        building.addApartment(apartment);
        landlord.addBuilding(building);
        // Get Profit
        double totalProfit = landlord.getTotalProfit();
        System.out.println("Total Profit for landlord is : " + landlord.getTotalProfit());
    }
}
