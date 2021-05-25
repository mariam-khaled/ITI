public class Quartile {
    
    private double Q1;
    private double Q3;
    private double IQR;

    public Quartile(double Q1, double Q3, double IQR) {
        this.Q1 = Q1;
        this.Q3 = Q3;
        this.IQR = IQR;
    }

    public double getQ1() {
        return Q1;
    }

    public double getQ3() {
        return Q3;
    }

    public double getIQR() {
        return IQR;
    }

    public void setQ1(double Q1) {
        this.Q1 = Q1;
    }

    public void setQ3(double Q3) {
        this.Q3 = Q3;
    }

    public void setIQR(double IQR) {
        this.IQR = IQR;
    }
    
    
    
}
