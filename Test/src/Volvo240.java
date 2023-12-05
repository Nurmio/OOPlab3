import java.awt.*;

public class Volvo240 extends Car {
    static Trim trim;


    public Volvo240() {
        trim = new Trim(1.25);
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
    }

    @Override double speedFactor()  {
        return getEnginePower() * 0.01 * trim.getFactor();
    }

}
