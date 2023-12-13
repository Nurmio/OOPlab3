import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Scania extends Truck{
    public Scania(){
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(500);
        setModelName("Scania");
        setMaxAngle(70);
        try {
            sprite.Img = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.png"));
            sprite.FlippedImg = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/ScaniaFlipped.png"));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
