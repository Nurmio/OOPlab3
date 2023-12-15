/*
 * This class represents the Controller part in the MVC pattern.
 * Its responsibilities are to listen to the View and responds in an appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController{

    // The frame that represents this instance View of the MVC pattern
    private CarView frame;
    private GameManager gm;
    private final int MAXVEHICLESALLOWED = 10;
    public void OnStart(){
        initButtons();
        for (Vehicle v : gm.getVehicles()) {
            frame.moveIT(gm.getVehicles());
        }
    }

   public void initButtons() {
       frame.addGasButtonListener(e -> gas(frame.gasAmount));
       frame.addBrakeButtonListener(e -> brake(frame.gasAmount));

       frame.addAddVehicleButtonListener(e -> addVehicle(frame.vehicleName()));
       frame.addRemoveButtonListener(e -> removeVehicle());

       frame.addTurboOnButtonListener(e -> turboOn());
       frame.addTurboOffButtonListener(e -> turboOff());

       frame.addStartButtonListener(e->start());
       frame.addStopButtonListener(e->stop());

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

    void addVehicle(String modelName) {
        if (gm.getVehicles().size() < MAXVEHICLESALLOWED) {
            Vehicle v = VehicleFactory.createVehicle(modelName);
            int nrOfVehicles = gm.getVehicles().size();
            final int DISTBETWEENVEHICLES = 50;
            double x = v.styrIT.getPos()[0];
            double y = v.styrIT.getPos()[1];
            v.styrIT.setPos(x, y + DISTBETWEENVEHICLES * nrOfVehicles);
            gm.getVehicles().add(v);
        }
    }

    void removeVehicle(){
        if (!gm.getVehicles().isEmpty()) {
            gm.getVehicles().removeLast();
        }
    }
//endregion
public CarController(GameManager gm, CarView cv){
    this.gm = gm;
    this.frame = cv;
}
}
