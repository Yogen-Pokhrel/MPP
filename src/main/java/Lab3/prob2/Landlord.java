package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    private List<Building> buildings;

    /**
     * Since we are maintaining 1 to * relationship we are collecting at least one building and one apartment data of the
     * building initially
     * */

    public Landlord(double apartmentRent, double buildingMaintenanceCost){
        this.buildings = new ArrayList<>();
        Building b1 = new Building(buildingMaintenanceCost, this);
        b1.addApartment(apartmentRent);
        this.buildings.add(b1);
    }

    public Building addBuilding(double maintenanceCost){
        Building b = new Building(maintenanceCost, this);
        buildings.add(b);
        return b;
    }

    public double getTotalProfit(){
        double totalProfit = 0.0;
        for(Building building: buildings){
            totalProfit += building.calculateProfit();
        }
        return totalProfit;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Landlord { \n\tBuildings: [ \n");
        for(Building b: this.buildings){
            sb.append("\t\t" + b + "\n");
        }
        sb.append("\t\t]\n\t}");
        return sb.toString();
    }
}
