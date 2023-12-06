import java.awt.*;

public class Vehicle{

protected StyrIT styrIT;

//private double[] pos = new double[2];
//private Direction direction = Direction.EAST;
private int nrDoors; // Number of doors on vehicle
private double currentSpeed; // The current speed of the vehicle
private double enginePower; // Engine power of the vehicle
private Color color; // Color of the vehicle
private String modelName; // The vehicle model name
private boolean drivable = true;
private boolean engineOn = false;

public Vehicle(){this.styrIT = new StyrIT();}


public int getNrDoors(){
        return nrDoors;
        }
public double getEnginePower(){
        return enginePower;
        }

public boolean getIfDrivable(){return drivable;}
public Color getColor(){
        return color;
        }
public String getModelName(){return modelName;}
protected void setColor(Color clr){
        color = clr;
        }
protected void setNrDoors(int NrDoors){nrDoors = NrDoors;}
protected void setEnginePower(double engPow){enginePower = engPow;}
protected void setModelName(String Mdlname){modelName = Mdlname;}
protected void setDrivable(Boolean s){drivable = s;}


public void move() {styrIT.move();}

public Direction getDirection() { return styrIT.getDirection();}
public double getCurrentSpeed(){return styrIT.getCurrentSpeed();}
public void setPos(double x,double y){styrIT.setPos(x,y);}
public double[] getPos(){return styrIT.getPos();}
public void stopEngine() {styrIT.stopEngine();}
public void startEngine() {styrIT.stopEngine();}
public void setDirection(Direction dir){styrIT.setDirection(dir);}
public Direction getOppositeDirection(){return styrIT.getOppositeDirection();}

public double getDeltaPos(Vehicle vehicle){
        return Math.pow(Math.pow(styrIT.getPos()[0] - vehicle.styrIT.getPos()[0],2)
                + Math.pow(styrIT.getPos()[1] - vehicle.styrIT.getPos()[1],2), 0.5);
        }
        //public void gas(double amount){if(engineOn){incrementSpeed(Math.min(Math.abs(amount),1));}}
        //public void brake(double amount){decrementSpeed(Math.max(amount,0));}
        double speedFactor(){return enginePower * 0.01;}
        }
