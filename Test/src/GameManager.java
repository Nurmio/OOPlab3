import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class GameManager {
    private final int screenWidth = 900;
    private final int CONSTWIDTH = 100;
    public int getConstImageWidth(){
        return CONSTWIDTH;
    }
    private ArrayList<Vehicle> Vehicles;
    public ArrayList<Vehicle> getVehicles(){return Vehicles;}
    public void updateModel(){
        for (Vehicle vehicle : Vehicles) {
        int x = (int) Math.round(vehicle.styrIT.getPos()[0]);
        if (x>-1 && x+CONSTWIDTH+10 < screenWidth){
            vehicle.styrIT.move();
        }
        else{
            vehicle.styrIT.setDirection(vehicle.styrIT.getOppositeDirection());
            vehicle.styrIT.move();
        }
    }}
    public GameManager( ArrayList<Vehicle> vehicles){
        Vehicles = vehicles;
    }
}

