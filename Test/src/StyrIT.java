import java.awt.*;

public class StyrIT implements Movable {

    private double[] pos = new double[2];
    private Direction direction = Direction.EAST;
    private double currentSpeed; // The current speed of the vehicle
    private double enginePower; // Engine power of the vehicle
    private boolean drivable = true;
    private boolean engineOn = false;

    protected double getCurrentSpeed(){
        return currentSpeed;
    }

    protected double[] getPos(){
        return pos;
    }
    protected int getDirectionInt(){return direction.ordinal();}
    protected Direction getDirection() {return direction;}
    protected Direction getOppositeDirection(){
        return Direction.values()[(direction.ordinal()+2)%4];
    }
    public double getEnginePower(){
        return enginePower;
    }
    protected void setPos(double x, double y) {pos[0] = x; pos[1] = y;}
    protected void setEnginePower(double engPow){enginePower = engPow;}
    protected void setDrivable(Boolean s){drivable = s;}
    protected void setDirection(Direction dir){
        direction = dir;
    }

    public void move() {
        switch(direction){
            case NORTH:
                pos[1]+= currentSpeed;
                break;
            case EAST:
                pos[0]+= currentSpeed;
                break;
            case SOUTH:
                pos[1]-= currentSpeed;
                break;
            case WEST:
                pos[0]-= currentSpeed;
                break;
        }
    }


    public void turnLeft(){
        direction = Direction.values()[((((getDirectionInt()-1) % 4) + 4) % 4)];
    }
    public void turnRight(){
        direction = Direction.values()[(getDirectionInt() +1)%4];
    }
    protected void gas(double amount){if(engineOn){incrementSpeed(Math.min(Math.abs(amount),1));}}
    protected void brake(double amount){decrementSpeed(Math.max(amount,0));}

    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
    }
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
    }
    double speedFactor(){return enginePower * 0.01;}

    protected void startEngine(){if(drivable){currentSpeed = 0.1;engineOn=true;}}
    protected void stopEngine(){currentSpeed = 0;engineOn = false;}
}
