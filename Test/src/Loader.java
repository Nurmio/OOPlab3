import java.util.ArrayList;

public class Loader {
    private ArrayList<Vehicle> LoadList = new ArrayList<>();
    public Loader(){

    }
    public void LoadVehicle(Vehicle vehicle) {
        if (!(vehicle instanceof Cartransport)) {
            LoadList.add(vehicle);

        }

    }
    public void UnloadVehicle(){
        LoadList.remove(GetLastElement());



    }

    public ArrayList<Vehicle> GetLoadList(){
        return LoadList;

    }

    public Vehicle GetLastElement(){ return LoadList.get(LoadList.size()-1);}
}
