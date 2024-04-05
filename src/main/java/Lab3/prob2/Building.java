package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    private double maintenanceCost;
    private List<Apartment> apartments;

    public Building(double maintenanceCost, double rent){
        this.maintenanceCost = maintenanceCost;
        apartments = new ArrayList<>();
        apartments.add(new Apartment(rent));
    }

    public void addApartment(Apartment apartment){
        apartments.add(apartment);
    }

    double calculateProfit(){
        double totalRent = 0.0;
        for(Apartment apartment: apartments){
            totalRent += apartment.getRent();
        }
        return totalRent - maintenanceCost;
    }

    public double getMaintenanceCost() {
        return maintenanceCost;
    }

    public void setMaintenanceCost(double maintenanceCost) {
        this.maintenanceCost = maintenanceCost;
    }
}
