
public class CarModel {
    public static void main(String[] args) {
        CarController cc = new CarController();


        cc.Vehicles.add(new Volvo240());
        cc.Vehicles.add(new Saab95());
        cc.Vehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("BRum", cc);

        // Start the timer
        cc.timer.start();
//region buttons
        cc.frame.gasButton.addActionListener(e -> cc.gas(cc.frame.gasAmount));
        cc.frame.brakeButton.addActionListener(e -> cc.brake(cc.frame.gasAmount));
        cc.frame.turboOnButton.addActionListener(e -> cc.turboOn());
        cc.frame.turboOffButton.addActionListener(e -> cc.turboOff());
        cc.frame.startButton.addActionListener(e -> cc.start());
        cc.frame.stopButton.addActionListener(e -> cc.stop());
        cc.frame.liftBedButton.addActionListener(e -> cc.liftBed());
        cc.frame.lowerBedButton.addActionListener(e -> cc.lowerBed());
//endregion
    }
}
