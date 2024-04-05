package Lab3.prob2;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    List<Building> buildings;

    public Landlord(){
        this.buildings = new ArrayList<Building>();
    }

    public Landlord(Building building){
        this.buildings = new ArrayList<Building>();
        addBuilding(building);
    }

    public void addBuilding(double maintenanceCost, double apartmentRent){
        buildings.add(new Building(maintenanceCost, apartmentRent));
    }

    public void addBuilding(Building building){
        buildings.add(building);
    }

    public double getTotalProfit(){
        double totalProfit = 0.0;
        for(Building building: buildings){
            totalProfit += building.calculateProfit();
        }
        return totalProfit;
    }
}
