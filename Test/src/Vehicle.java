import java.awt.*;

public class Vehicle implements Movable{
    private double[] pos = new double[2];
    private Direction direction = Direction.NORTH;
    private int nrDoors; // Number of doors on vehicle
    private double currentSpeed; // The current speed of the vehicle
    private double enginePower; // Engine power of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The vehicle model name
    private boolean drivable = true;

    public int getNrDoors(){
        return nrDoors;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public double getCurrentSpeed(){
        return currentSpeed;
    }
    public Boolean getIfDrivable(){return drivable;}
    public Color getColor(){
        return color;
    }
    protected void setColor(Color clr){
        color = clr;
    }
    protected void setNrDoors(int NrDoors){nrDoors = NrDoors;}
    protected void setEnginePower(double engPow){enginePower = engPow;}
    protected void setModelName(String Mdlname){modelName = Mdlname;}
    protected void setDrivable(Boolean s){drivable = s;}
    public void startEngine(){if(drivable){currentSpeed = 0.1;}}
    public void stopEngine(){
        currentSpeed = 0;
    }
    private void incrementSpeed(double amount){
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount,enginePower);
        //SAAB was missing math.min()
    }
    private void decrementSpeed(double amount){
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount,0);
        //SAAB was missing math.max()
    }

    public double[] getPos(){
        return pos;
    }
    public void setPos(double x, double y) {
        pos[0] = x;
        pos[1] = y;
    }
    //int[] pos = new int[2];

    public void move(){
        switch(direction){
            case NORTH:
                pos[1]+=getCurrentSpeed();
                break;
            case EAST:
                pos[0]+=getCurrentSpeed();
                break;
            case SOUTH:
                pos[1]-=getCurrentSpeed();
                break;
            case WEST:
                pos[0]-=getCurrentSpeed();
                break;
        }
    }
    public void turnLeft(){
        direction = Direction.values()[((((getDirectionInt()-1) % 4) + 4) % 4)];
    }
    public void turnRight(){
        direction = Direction.values()[(getDirectionInt() +1)%4];
    }

    public int getDirectionInt(){return direction.ordinal();}
    public Direction getDirection() {return direction;}

    public void setDirection(Direction dir){
        direction = dir;
    }

    public Direction getOppsiteDirection(){
        return Direction.values()[(direction.ordinal()+2)%4];
    }

    public double getDeltaPos(Vehicle vehicle){
        //Pythagorean Theorem
        return Math.pow(Math.pow(getPos()[0] - vehicle.getPos()[0],2) + Math.pow(getPos()[1] - vehicle.getPos()[1],2), 0.5);
    }
    public void gas(double amount){
        incrementSpeed(Math.min(Math.abs(amount),1));
    }
    public void brake(double amount){
        decrementSpeed(Math.max(amount,0));
    }
    double speedFactor(){
        return enginePower * 0.01;
    }
}
