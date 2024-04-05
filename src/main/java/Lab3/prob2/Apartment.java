package Lab3.prob2;

import java.util.List;

public class Apartment {
    private double rent;
    private Building building;

    public Apartment(double rent, Building building){

        this.rent = rent;
        this.building = building;
    }

    public double getRent() {
        return rent;
    }

    public void setRent(double rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return "Apartment - Rent: " + this.rent;
    }
}
