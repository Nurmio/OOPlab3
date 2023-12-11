import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    protected Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> Vehicles = new ArrayList<>();

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

    //region buttons

   public void initButtons() {
       frame.getGasButton().addActionListener(e -> gas(frame.gasAmount));
       frame.getBrakeButton().addActionListener(e -> brake(frame.gasAmount));
       frame.getTurboOnButton().addActionListener(e -> turboOn());
       frame.getTurboOffButton().addActionListener(e -> turboOff());
       frame.getstartButton().addActionListener(e -> start());
       frame.getstopButton().addActionListener(e -> stop());
       frame.getliftBedButton().addActionListener(e -> liftBed());
       frame.getlowerBedButton().addActionListener(e -> lowerBed());
   }
//endregion

    // Functionality for the buttons
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
        for (Vehicle v : Vehicles){
            if(v instanceof Saab95){
                ((Saab95) v).setTurboOn();
            }}
    }
    void turboOff(){
        for (Vehicle v : Vehicles){
            if(v instanceof Saab95){
                ((Saab95) v).setTurboOff();
            }}
    }
    void liftBed(){
        for (Vehicle v : Vehicles){
            if(v instanceof Scania){
                ((Scania) v).setBedAngle(70);
            }}
    }
    void lowerBed(){
        for (Vehicle v : Vehicles){
            if(v instanceof Scania){
                ((Scania) v).setBedAngle(0);
            }}
    }

}
