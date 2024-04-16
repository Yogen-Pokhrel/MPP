package Lab7.prob2.intfaces2;

public class EquilateralTriangle implements Polygon {
    private final double side;
    EquilateralTriangle(double side){
        this.side = side;
    }
    @Override
    public double[] getLengths() {
        return new double[]{side, side, side};
    }
}
