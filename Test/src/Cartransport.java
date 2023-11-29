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
        if (RampIsUp && getCurrentSpeed() == 0) {
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
                vehicle.setPos(getPos()[0], getPos()[1]);
                vehicle.setDirection((getDirection()));
            }
        }

    }

    public void UnloadVehicle() {
        if (!RampIsUp) {
            loader.GetLastElement().setDirection(getOppositeDirection());
            loader.GetLastElement().move();
            loader.GetLoadList().remove(loader.GetLastElement());
        }
    }

    private void updateLoadCarPos() {
        for (Vehicle v : loader.GetLoadList()) {
            switch(getDirection()){
                case NORTH:
                    v.setPos(v.getPos()[0],v.getPos()[1]+=getCurrentSpeed());
                    break;
                case EAST:
                    v.setPos(v.getPos()[0]+=getCurrentSpeed(),v.getPos()[1]);
                    break;
                case SOUTH:
                    v.setPos(v.getPos()[0],v.getPos()[1]-=getCurrentSpeed());
                    break;
                case WEST:
                    v.setPos(v.getPos()[0]+=getCurrentSpeed(),v.getPos()[1]);
                    break;
            }
        }
    }
    public int getLoadlistSize(){
        return loader.GetLoadList().size();
    }

    @Override
    public void turnRight() {
        super.turnRight();
        for (Vehicle v : loader.GetLoadList()) {
            v.turnRight();
        }

    }

    @Override
    public void turnLeft() {
        super.turnLeft();
        for (Vehicle v : loader.GetLoadList()) {
            v.turnLeft();
        }

    }

    @Override
    public void move() {
        updateLoadCarPos();
        super.move();
    }
}
