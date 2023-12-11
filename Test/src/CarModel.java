import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        cc.frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.gas(cc.frame.gasAmount);
            }
        });
        cc.frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.brake(cc.frame.gasAmount);
            }
        });
        cc.frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.turboOn();
            }
        });
        cc.frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.turboOff();
            }
        });
        cc.frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.start();
            }
        });
        cc.frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.stop();
            }
        });
        cc.frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.liftBed();
            }
        });
        cc.frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cc.lowerBed();
            }
        });
//endregion
    }
}
