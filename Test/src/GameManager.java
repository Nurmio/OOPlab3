import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameManager {
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    private final int screenWidth = 800;
    private final int screenHeight = 800;
    private final int prefferedScreenWidth = 800;
    private final int prefferedScreenHeight = 560;
    private final int ImageWidth = 40;
    //True when going east, false when going west

    protected Timer timer = new Timer(delay, new TimerListener());
    private ArrayList<Vehicle> Vehicles;
    public ArrayList<Vehicle> getVehicles(){return Vehicles;}
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : Vehicles) {
                int x = (int) Math.round(vehicle.styrIT.getPos()[0]);
                int y = (int) Math.round(vehicle.styrIT.getPos()[1]);
                if (x>-1 && x+ImageWidth+10 < screenWidth){
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
