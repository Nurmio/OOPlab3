import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Saab95 extends Car{
    private final Turbo turbo;

    public Saab95(){
        this.turbo = new Turbo();
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(125);
        setModelName("Saab95");
    }
    public void setTurboOn(){
        turbo.TurboOn();
    }

    public void setTurboOff(){ turbo.TurboOff(); }

    public boolean getTurboStatus() {
        return turbo.TurboStatus();
    }

    @Override double speedFactor(){
        double turboSpeed = 1;
        if(turbo.TurboStatus())
            turboSpeed = 1.3;
        return (getEnginePower() * 0.01 * turboSpeed);
    }
}
