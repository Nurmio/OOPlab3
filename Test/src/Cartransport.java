import java.awt.*;
import java.util.ArrayList;
public class Cartransport extends Vehicle {
    private Loader loader;

    public Cartransport() {
        this.loader = new Loader();
        setNrDoors(2);
        setColor(Color.red);
        setEnginePower(500);
        setModelName("CarTransport");
    }


    private boolean RampIsUp = true;

    public void LowerRamp() {
        if (RampIsUp && styrIT.getCurrentSpeed() == 0) {
            RampIsUp = false;
        }
    }

    public void RaiseRamp() {
        if (!RampIsUp) {
            RampIsUp = true;
        }
    }


    public boolean GetRampState() {
        return (RampIsUp);
    }

    public void LoadVehicle(Vehicle vehicle) {
        if (!(vehicle instanceof Cartransport)) {

            if (!RampIsUp && getDeltaPos(vehicle) <= 3) {
                loader.LoadVehicle(vehicle);
                vehicle.styrIT.setPos(styrIT.getPos()[0], styrIT.getPos()[1]);
                vehicle.styrIT.setDirection((styrIT.getDirection()));
            }
        }

    }

    public void UnloadVehicle() {
        if (!RampIsUp) {
            loader.GetLastElement().styrIT.setDirection(styrIT.getOppositeDirection());
            loader.GetLastElement().styrIT.move();
            loader.GetLoadList().remove(loader.GetLastElement());
        }
    }

    private void updateLoadCarPos() {
        for (Vehicle v : loader.GetLoadList()) {
            switch(styrIT.getDirection()){
                case NORTH:
                    v.styrIT.setPos(v.styrIT.getPos()[0],v.styrIT.getPos()[1]+=styrIT.getCurrentSpeed());
                    break;
                case EAST:
                    v.styrIT.setPos(v.styrIT.getPos()[0]+=styrIT.getCurrentSpeed(),v.styrIT.getPos()[1]);
                    break;
                case SOUTH:
                    v.styrIT.setPos(v.styrIT.getPos()[0],v.styrIT.getPos()[1]-=styrIT.getCurrentSpeed());
                    break;
                case WEST:
                    v.styrIT.setPos(v.styrIT.getPos()[0]+=styrIT.getCurrentSpeed(),v.styrIT.getPos()[1]);
                    break;
            }
        }
    }
    public int getLoadlistSize(){
        return loader.GetLoadList().size();
    }

    public void turnRight() {
        super.styrIT.turnRight();
        for (Vehicle v : loader.GetLoadList()) {
            v.styrIT.turnRight();
        }

    }

    public void turnLeft() {
        super.styrIT.turnLeft();
        for (Vehicle v : loader.GetLoadList()) {
            v.styrIT.turnLeft();
        }

    }


    public void move() {
        updateLoadCarPos();
        super.styrIT.move();
    }
}
