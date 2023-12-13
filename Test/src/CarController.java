/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController{

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    GameManager gm;
    final int MAXVEHICLESALLOWED = 10;
    public void OnStart(){
        initButtons();
        for (Vehicle v : gm.getVehicles()) {
            frame.drawPanel.moveit(gm.getVehicles());
        }
    }
    public void update(){

            frame.drawPanel.moveit(gm.getVehicles());
     //   }
        //frame.drawPanel.repaint();
    }

   public void initButtons() {
       frame.getGasButton().addActionListener(e -> gas(frame.gasAmount));
       frame.getBrakeButton().addActionListener(e -> brake(frame.gasAmount));

       frame.getaddVehicleButton().addActionListener(e -> addVehicle(frame.getVehicleTextField().getText()));
       frame.getremoveVehicleButton().addActionListener(e -> removeVehicle());

       frame.getTurboOnButton().addActionListener(e -> turboOn());
       frame.getTurboOffButton().addActionListener(e -> turboOff());

       frame.getstartButton().addActionListener(e -> start());
       frame.getstopButton().addActionListener(e -> stop());

       frame.getliftBedButton().addActionListener(e -> liftBed());
       frame.getlowerBedButton().addActionListener(e -> lowerBed());
   }
//region Functionality for the buttons
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle: gm.getVehicles()) {if(vehicle.styrIT.getCurrentSpeed() < vehicle.getEnginePower()){vehicle.styrIT.gas(gas);}}
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle: gm.getVehicles()){vehicle.styrIT.brake(brake);}
    }
    void start(){
        for (Vehicle vehicle: gm.getVehicles()){vehicle.styrIT.startEngine();}
    }
    void stop(){
        for (Vehicle vehicle: gm.getVehicles()){vehicle.styrIT.stopEngine();}
    }
    void turboOn(){
        for (Vehicle v : gm.getVehicles()){
            if(v instanceof Saab95){
                ((Saab95) v).setTurboOn();
            }}
    }
    void turboOff(){
        for (Vehicle v : gm.getVehicles()){
            if(v instanceof Saab95){
                ((Saab95) v).setTurboOff();
            }}
    }
    void liftBed(){
        for (Vehicle v : gm.getVehicles()){
            if(v instanceof Scania){
                ((Scania) v).setBedAngle(70);
            }}
    }
    void lowerBed(){
        for (Vehicle v : gm.getVehicles()){
            if(v instanceof Scania){
                ((Scania) v).setBedAngle(0);
            }}
    }
    public CarController(GameManager gm){
        this.gm = gm;
    }
//endregion
public CarController(GameManager gm){
    this.gm = gm;
}
}
