package Lab3.prob3;

import Lab3.prob2.Building;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	public static double computeTotalRent(List<Property> properties) {
		double totalRent = 0;
		for (Property o : properties) {
			totalRent += o.computeRent();
		}
		return totalRent;
	}


	public static List<Property> listPropertiesInCity(List<Property> properties, String city) {
        List<Property> propertiesInCity = new ArrayList<>();
        for (Property property : properties) {
            if (property.getAddress().getCity().equals(city)) {
                propertiesInCity.add(property);
            }
        }
        return propertiesInCity;
    }
}
