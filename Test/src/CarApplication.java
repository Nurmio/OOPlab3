import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CarApplication implements GameManagerObserver{
    public static void main(String[] args) {
        ArrayList<Vehicle> Vehicles = new ArrayList<>();

        GameManager gm = new GameManager(Vehicles);
        CarController cc = new CarController(gm);
        cc.addVehicle("Volvo240");
        cc.addVehicle("Saab95");
        cc.addVehicle("Scania");
        // Start a new view and send a reference of self
        cc.frame = new CarView("BRum");

        cc.OnStart();
        // Start the timer
        gm.timer.start();


         class updateAll implements ActionListener {
            public void actionPerformed(ActionEvent e){
                cc.update();
                System.out.println(cc.frame.getVehicleTextField().getText());
            }
        }
        Timer timer = new Timer(50, new updateAll());
        timer.start();
    }
    @Override
    public void OnGameManagerChange() {

    }
}
