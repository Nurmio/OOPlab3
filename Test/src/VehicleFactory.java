import java.util.Random;
public class VehicleFactory {
    private static Volvo240 createVolvo() { return new Volvo240(); }
    private static Saab95 createSaab() { return new Saab95(); }

    private static Scania createScania() { return new Scania(); }

    private static Vehicle createRandomVehicle() {
        Random r = new Random();
        int rand = r.nextInt(3);
        if(rand == 0){return createVolvo();}
        else if(rand == 1){return createSaab();}
        else if(rand == 2){return createScania();}
        else{return null;}
    }

    public static Vehicle createVehicle(String modelName) {
        return switch (modelName) {
            case "Saab95" -> createSaab();
            case "Volvo240" -> createVolvo();
            case "Scania" -> createScania();
            default -> createRandomVehicle();
        };
    }

}
