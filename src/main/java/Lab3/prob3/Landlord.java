package Lab3.prob3;

import java.util.ArrayList;
import java.util.List;

public class Landlord {
    List<Property> properties;
    Landlord(Property property){
        properties = new ArrayList<>();
        properties.add(property);
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void addProperty(Property property){
        properties.add(property);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Landlord { \n\tProperties: [ \n");
        for(Property b: properties){
            sb.append("\t\t" + b + "\n");
        }
        sb.append("\t\t]\n\t}");
        return sb.toString();
    }
}
