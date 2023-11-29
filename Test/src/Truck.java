public class Truck extends Vehicle{
    private double bedAngle;
    private double maxAngle;

    public double getCurrentBedAngle(){return bedAngle;}
    public double getMaxAngle(){return maxAngle;}
    protected void setMaxAngle(double ang){maxAngle = ang;}
    public void setBedAngle(double ang){
    if(getCurrentSpeed() == 0){
        if(ang > bedAngle){
            bedAngle = (Math.min(ang,maxAngle));
            setDrivable(false);
        }
        else if(ang < bedAngle){
            bedAngle = (Math.max(ang,0));
            setDrivable(false);
        }
    }
        if(bedAngle == 0){setDrivable(true);
        }
    }

}
