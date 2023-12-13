import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Vehicle{

protected StyrIT styrIT;

public Vehicle() { this.styrIT = new StyrIT(); }


private int nrDoors; // Number of doors on vehicle

private Color color; // Color of the vehicle
private String modelName; // The vehicle model name

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

        double speedFactor(){return styrIT.speedFactor() * 0.01;}
        }
