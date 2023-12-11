import java.util.ArrayList;

public class CarApplication {
    public static void main(String[] args) {
        ArrayList<Vehicle> Vehicles = new ArrayList<>();

        Vehicles.add(VehicleFactory.createVolvo());
        Vehicles.add(VehicleFactory.createSaab());
        Vehicles.add(VehicleFactory.createScania());
        GameManager gm = new GameManager(Vehicles);
        CarController cc = new CarController(gm);
        // Start a new view and send a reference of self
        cc.frame = new CarView("BRum");
        cc.initButtons();
        // Start the timer
        gm.timer.start();


        while(true) {
        cc.update();
        }
    }
}
