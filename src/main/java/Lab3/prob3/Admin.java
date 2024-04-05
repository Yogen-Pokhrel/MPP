package Lab3.prob3;

import java.util.ArrayList;
import java.util.List;

public class Admin {
	public static double computeTotalRent(Property[] properties) {
		double totalRent = 0;
		for (Property o : properties) {
			totalRent += o.computeRent();
		}
		return totalRent;
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
}
