public class Trim {
    private final double trimFactor;
    public Trim(double Factor) {
        this.trimFactor = Factor;
    }

    protected double getFactor(){return this.trimFactor;}
}
