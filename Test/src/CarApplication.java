import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarApplication {
    public static void main(String[] args) {
        ArrayList<Vehicle> Vehicles = new ArrayList<>();
        GameManager gm = new GameManager(Vehicles);
        CarController cc = new CarController(gm);
        cc.addVehicle("Volvo240");
        cc.addVehicle("Saab95");
        cc.addVehicle("Scania");
        // Start a new view and send a reference of self
        cc.setFrame("BRum");
        cc.getFrame().drawPanel.setIMGWIDTH(gm.getConstImageWidth());
        cc.getFrame().drawPanel.initImages();
        cc.OnStart();
        // Start the timer

         class updateAll implements ActionListener {
            public void actionPerformed(ActionEvent e){
                cc.getFrame().drawPanel.moveit(gm.getVehicles());
                gm.updateModel();
            }
        }
        Timer timer = new Timer(50, new updateAll());
        timer.start();
    }

}
