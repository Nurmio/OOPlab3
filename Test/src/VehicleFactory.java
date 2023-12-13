public class VehicleFactory {
    public static Volvo240 createVolvo() { return new Volvo240(); }
    public static Saab95 createSaab() { return new Saab95(); }

    private static Scania createScania() { return new Scania(); }

    public static Vehicle createVehicle(String modelName) {
        return switch (modelName) {
            case "Saab95" -> createSaab();
            case "Volvo240" -> createVolvo();
            case "Scania" -> createScania();
            default -> createVolvo();
        };
    }

}
