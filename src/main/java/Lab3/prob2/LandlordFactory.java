package Lab3.prob2;

public class LandlordFactory {
    static public Landlord createLandlord(double apartmentRent, double buildingMaintenanceCost){
        return new Landlord(apartmentRent, buildingMaintenanceCost);
    }
}
