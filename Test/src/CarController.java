import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.Vehicles.add(new Volvo240());
        cc.Vehicles.add(new Saab95());
        cc.Vehicles.add(new Scania());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : Vehicles) {
                int x = (int) Math.round(vehicle.getPos()[0]);
                int y = (int) Math.round(vehicle.getPos()[1]);
                if (x>-1 && x+frame.drawPanel.getImageWidth(vehicle.getModelName())+10 < frame.getWidth()){
                    vehicle.move();
                    System.out.println(x);
                    frame.drawPanel.moveit(x, y,vehicle.getDirection(),vehicle.getModelName());
                }
                else{
                    vehicle.setDirection(vehicle.getOppsiteDirection());
                    vehicle.move();
                    frame.drawPanel.moveit(x,y,vehicle.getDirection(),vehicle.getModelName());
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles) {vehicle.gas(gas);}
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.brake(brake);}
    }
    //TODO
    void start(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.brake(brake);}
    }
    //TODO
    void stop(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.brake(brake);}
    }
    //TODO
    void turboOn(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.brake(brake);}
    }
    //TODO
    void turboOff(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.brake(brake);}
    }
    //TODO
    void liftBed(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.brake(brake);}
    }
    //TODO
    void lowerBed(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: Vehicles){vehicle.brake(brake);}
    }



}
