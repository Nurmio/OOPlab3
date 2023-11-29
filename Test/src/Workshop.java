import java.util.ArrayList;

public class Workshop<T extends Vehicle> {
    private final Loader loader;
    private final int vehicleLimit;

    public Workshop(int vehicleLimit) {
        this.vehicleLimit = vehicleLimit;
        this.loader = new Loader();
    }
    public ArrayList<Vehicle> getLoadList(){return loader.GetLoadList();
    }



    public void AddVehicle(T vehicle) {
        if (loader.GetLoadList().size() < vehicleLimit) {
            loader.LoadVehicle(vehicle);
        }
    }

    public void RemoveVehicle() {loader.UnloadVehicle();}



}
