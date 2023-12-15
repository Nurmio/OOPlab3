import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarApplication {
    public static void main(String[] args) {
        ArrayList<Vehicle> Vehicles = new ArrayList<>();
        GameManager gm = new GameManager(Vehicles);
        CarView cv = new CarView("BRum");
        CarController cc = new CarController(gm,cv);
        cc.addVehicle("Volvo240");
        cc.addVehicle("Saab95");
        cc.addVehicle("Scania");
        cv.setIMGWIDTH(gm.getConstImageWidth());
        cv.initImages();
        cc.OnStart();
        // Start the timer

         class updateAll implements ActionListener {
            public void actionPerformed(ActionEvent e){
                cv.moveIT(gm.getVehicles());
                gm.updateModel();

                for (Vehicle v : gm.getVehicles()){
                    System.out.println(v.getModelName() + " " + v.styrIT.speedFactor());
                }

            }
        }
        Timer timer = new Timer(50, new updateAll());
        timer.start();
    }

}
