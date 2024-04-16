package Lab7.prob2.intfaces2;

public class Ellipse implements ClosedCurve {
    private final double semiaxis;
    private final double elateral;

    Ellipse(double semiaxis, double elateral){
        this.semiaxis = semiaxis;
        this.elateral = elateral;
    }
    @Override
    public double computePerimeter() {
        return 4 * semiaxis * elateral;
    }
}
