package Lab3.prob3;

import Lab3.prob2.Building;

import java.util.ArrayList;
import java.util.List;

public class Admin {
    List<Property> properties;
    Admin(Property property){
        properties = new ArrayList<>();
        properties.add(property);
    }
	public double computeTotalRent() {
		double totalRent = 0;
		for (Property o : properties) {
			totalRent += o.computeRent();
		}
		return totalRent;
	}

    public void addProperty(Property property){
        properties.add(property);
    }

	public static List<Property> listPropertiesInCity(Property[] properties, String city) {
        List<Property> propertiesInCity = new ArrayList<>();
        for (Property property : properties) {
            if (property.getAddress().getCity().equals(city)) {
                propertiesInCity.add(property);
            }
        }
        return propertiesInCity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Admin { \n\tProperties: [ \n");
        for(Property b: properties){
            sb.append("\t\t" + b + "\n");
        }
        sb.append("\t\t]\n\t}");
        return sb.toString();
    }
}
