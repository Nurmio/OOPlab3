import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> Vehicles = new ArrayList<>();

    Saab95 saab;
    Volvo240 volvo;
    Scania scania;


    //METHODS:

    public static void main(String[] args) {
        // Instance of this

        CarController cc = new CarController();
        cc.volvo = new Volvo240();
        cc.saab = new Saab95();
        cc.scania = new Scania();

        cc.Vehicles.add(cc.volvo);
        cc.Vehicles.add(cc.saab);
        cc.Vehicles.add(cc.scania);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim", cc);

        // Start the timer
        cc.timer.start();
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

    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : Vehicles) {
                int x = (int) Math.round(vehicle.styrIT.getPos()[0]);
                int y = (int) Math.round(vehicle.styrIT.getPos()[1]);
                if (x>-1 && x+frame.drawPanel.getImageWidth(vehicle.getModelName())+10 < frame.getWidth()){
                    vehicle.styrIT.move();
                    frame.drawPanel.moveit(x, y,vehicle.styrIT.getDirection(),vehicle.getModelName());
                }
                else{
                    vehicle.styrIT.setDirection(vehicle.styrIT.getOppositeDirection());
                    vehicle.styrIT.move();
                    frame.drawPanel.moveit(x,y,vehicle.styrIT.getDirection(),vehicle.getModelName());
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles) {if(vehicle.styrIT.getCurrentSpeed() < vehicle.getEnginePower()){vehicle.styrIT.gas(gas);}}
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.styrIT.brake(brake);}
    }
    void start(){
        for (Vehicle vehicle: Vehicles){vehicle.styrIT.startEngine();}
    }
    void stop(){
        for (Vehicle vehicle: Vehicles){vehicle.styrIT.stopEngine();}
    }
    void turboOn(){
        saab.setTurboOn();
    }
    void turboOff(){
        saab.setTurboOff();
    }
    void liftBed(){
        scania.setBedAngle(70);
    }
    void lowerBed(){
        scania.setBedAngle(0);
    }



}
