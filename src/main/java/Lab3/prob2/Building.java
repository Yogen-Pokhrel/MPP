package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Building {
    // we are assuming maintenanceCost as monthly maintenance cost
    private double maintenanceCost;
    private List<Apartment> apartments;
    private Landlord landlord;

    public Building(double maintenanceCost, Landlord landlord){
        this.maintenanceCost = maintenanceCost;
        apartments = new ArrayList<>();
        this.landlord = landlord;
    }

    public void addApartment(double rent){
        apartments.add(new Apartment(rent, this));
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

    public List<Apartment> getApartments() {
        return apartments;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder("Building { maintenanceCost: ");
        sb.append(this.maintenanceCost);
        sb.append(",  Apartments: [ ");
        for(Apartment a: this.apartments){
            sb.append(a.toString() + ", ");
        }
        sb.append(" ]}");
        return sb.toString();
    }
}
