import java.awt.*;

public abstract class Vehicle{

protected StyrIT styrIT = new StyrIT();
protected Sprite sprite = new Sprite();
//private double[] pos = new double[2];
//private Direction direction = Direction.EAST;
private int nrDoors; // Number of doors on vehicle
//private double currentSpeed; // The current speed of the vehicle
//private double enginePower; // Engine power of the vehicle
private Color color; // Color of the vehicle
private String modelName; // The vehicle model name
//private boolean drivable = true;
//private boolean engineOn = false;

//public Vehicle(){this.styrIT = new StyrIT();}


public int getNrDoors(){
        return nrDoors;
        }
public double getEnginePower(){
        return styrIT.getEnginePower();
        }
public boolean getIfDrivable(){return styrIT.getIfDriveable();}
public Color getColor(){
        return color;
        }
public String getModelName(){return modelName;}
protected void setColor(Color clr){
        color = clr;
        }
protected void setNrDoors(int NrDoors){nrDoors = NrDoors;}
protected void setEnginePower(double engPow){styrIT.setEnginePower(engPow);}
protected void setModelName(String Mdlname){modelName = Mdlname;}
protected void setDrivable(Boolean s){styrIT.setDrivable(s);}

public double getDeltaPos(Vehicle vehicle){
        return Math.pow(Math.pow(styrIT.getPos()[0] - vehicle.styrIT.getPos()[0],2)
                + Math.pow(styrIT.getPos()[1] - vehicle.styrIT.getPos()[1],2), 0.5);
        }
        //public void gas(double amount){if(engineOn){incrementSpeed(Math.min(Math.abs(amount),1));}}
        //public void brake(double amount){decrementSpeed(Math.max(amount,0));}
        double speedFactor(){return styrIT.speedFactor() * 0.01;}
        }
