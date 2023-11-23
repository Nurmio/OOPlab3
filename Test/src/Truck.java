public class Truck extends Vehicle{
    private double BedAngle;
    private double maxAngle;

    public double getCurrentBedAngle(){return BedAngle;}
    public double getMaxAngle(){return maxAngle;}
    protected void setMaxAngle(double ang){maxAngle = ang;}
    public void setBedAngle(double ang){
    if(getCurrentSpeed() == 0){
        if(ang > getCurrentBedAngle()){
            BedAngle = (Math.min(ang,getMaxAngle()));
            setDrivable(false);
        }
        else if(ang < getCurrentBedAngle()){
            BedAngle = (Math.max(ang,0));
            setDrivable(false);
        }
    }
        if(getCurrentBedAngle() == 0){setDrivable(true);
        }
    }

}
