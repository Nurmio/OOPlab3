import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GameManager {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    private final int screenWidth = 900;
    protected Timer timer = new Timer(delay, new TimerListener());
    private ArrayList<Vehicle> Vehicles;
    public ArrayList<Vehicle> getVehicles(){return Vehicles;}

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : Vehicles) {
                int x = (int) Math.round(vehicle.styrIT.getPos()[0]);
                if (x>-1 && x+vehicle.sprite.getImageWidth()+10 < screenWidth){
                    vehicle.styrIT.move();
                }
                else{
                    vehicle.styrIT.setDirection(vehicle.styrIT.getOppositeDirection());
                    vehicle.styrIT.move();
                }
            }
        }
    }
    public GameManager( ArrayList<Vehicle> vehicles){
        Vehicles = vehicles;
    }
}

