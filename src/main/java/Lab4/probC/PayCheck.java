package Lab4.probC;

final public class PayCheck {
    private final double grossPay;
    private final double fica;
    private final double stateTax;
    private final double localTax;
    private final double medicare;
    private final double socialSecurity;

    public PayCheck(double grossPay, double fica, double stateTax, double localTax, double medicare,
            double socialSecurity) {
        this.grossPay = grossPay;
        this.fica = fica;
        this.stateTax = stateTax;
        this.localTax = localTax;
        this.medicare = medicare;
        this.socialSecurity = socialSecurity;
    }

    public double getNetPay() {
        double taxPercentage = fica + stateTax + localTax + medicare + socialSecurity;
        double tax = grossPay * taxPercentage / 100;
        return grossPay - tax;
    }

    public void print() {
        String res = "Paystub: \n" + "\t" + "Gross Pay: " + grossPay + "\n" + "\t" + "FICA: " + fica + "\n" + "\t"
                + "State: "
                + stateTax + "\n" + "\t" + "Local: " + localTax + "\n" + "\t" + "Medicare: "
                + medicare + "\n" + "\t" + "Social Security: " + socialSecurity + "\n" + "\t" + "NET PAY: "
                + getNetPay();
        System.out.println(res);
    }
}
