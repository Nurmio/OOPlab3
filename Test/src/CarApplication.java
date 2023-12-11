
public class CarApplication {
    public static void main(String[] args) {
        CarController cc = new CarController();


        cc.Vehicles.add(new Volvo240());
        cc.Vehicles.add(new Saab95());
        cc.Vehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("BRum");
        cc.initButtons();
        // Start the timer
        cc.timer.start();

    }
}
