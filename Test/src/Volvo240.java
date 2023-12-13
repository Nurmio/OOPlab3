import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Objects;

public class Volvo240 extends Car {
    private Trim trim;


    public Volvo240() {
        trim = new Trim(1.25);
        setNrDoors(4);
        setColor(Color.black);
        setEnginePower(100);
        setModelName("Volvo240");
        try {
            this.sprite.Img = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.png")));
            this.sprite.FlippedImg = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/volvo240Flipped.png")));
        } catch (IOException ex) {ex.printStackTrace();}
    }

    @Override double speedFactor()  {
        return getEnginePower() * 0.01 * trim.getFactor();
    }

    public double getTrimFactor() {
        return trim.getFactor();
    }
}
