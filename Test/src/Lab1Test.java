import org.junit.Test;
import org.junit.Before;
import java.awt.*;
import static org.junit.Assert.*;

public class Lab1Test {

    private Saab95 setSaab;
    private Volvo240 setVolvo;
    private Scania setScania;

    private Cartransport setTransport;
    private Workshop<Vehicle> setWorkshop = new Workshop<>(5);

    private Loader setLoader;
    @Before
    public void init()
    {
        setSaab = new Saab95();
        setVolvo = new Volvo240();
        setScania = new Scania();
        setLoader = new Loader();
        setTransport = new Cartransport();
        setWorkshop = new Workshop<>(5);
    }

    @Test
    public void TestUnloadWorkshop()
    {
        setWorkshop.AddVehicle(setSaab);
        setWorkshop.AddVehicle(setScania);
        setWorkshop.RemoveVehicle();
        setWorkshop.RemoveVehicle();
        assertTrue(setWorkshop.getLoadList().size() == 0);
    }
    @Test
    public void TestTurnTurboON() {
        setSaab.setTurboOn();
        assertTrue(setSaab.getTurboStatus());
    }
    @Test
    public void TestTurnTurboOF(){
        setSaab.setTurboOn();
        setSaab.setTurboOff();
        assertTrue(!setSaab.getTurboStatus());
    }
    @Test
    public void TestTurningLeft(){
        setSaab.turnLeft();
        assertTrue("dir: "+ setSaab.getDirection(),setSaab.getDirection() == Direction.WEST);
    }
    @Test
    public void TestTurningRight(){
        setSaab.turnRight();
        assertTrue("dir: " + setSaab.getDirection(),setSaab.getDirection() == Direction.EAST);

    }
    @Test
    public void TestMoveForwardWithoutStartingEngine(){
        setSaab.move();
        assertTrue(setSaab.getPos()[0] == 0 && setSaab.getPos()[1] == 0);
    }
    @Test
    public void TestMoveForwardWithStartedEngine(){
        setSaab.startEngine();
        setSaab.move();
        assertTrue("x: " + setSaab.getPos()[0] + " y: " + setSaab.getPos()[1],setSaab.getPos()[0] == 0 && setSaab.getPos()[1] == 0.1);
    }

    @Test
    public void TestVolvoSpeedFactorWhileStandingStill(){
        assertTrue(String.valueOf(0.01*setVolvo.getEnginePower()* Volvo240.trim.getFactor()),setVolvo.speedFactor() == 0.01*setVolvo.getEnginePower()* Volvo240.trim.getFactor());
    }
    @Test
    public void TestSaabSpeedFactorWhileStandingStill(){
        assertTrue(0.01*setSaab.getEnginePower() + " " + setSaab.speedFactor(),setSaab.speedFactor()== 0.01*setSaab.getEnginePower());
    }

    @Test
    public void TestGas(){
        setSaab.startEngine();
        setSaab.gas(1);
        assertTrue(setSaab.getCurrentSpeed() > 0.1);
    }
    @Test
    public void TestBreak(){
        setSaab.startEngine();
        setSaab.gas(1);
        setSaab.gas(1);
        setSaab.brake(1);
        setSaab.brake(1);
        assertTrue(""+setSaab.getCurrentSpeed(), 0.09<= setSaab.getCurrentSpeed() && setSaab.getCurrentSpeed() <= 0.11);
    }

    @Test
    public void TestMovesToStartingPos(){
        setSaab.startEngine();
        setSaab.gas(1);
        for (int i = 0; i < 4; i++) {
            setSaab.move();
            setSaab.turnRight();
        }
        setSaab.brake(1);
        for (int i = 0; i < 4; i++) {
            setSaab.move();
            setSaab.turnLeft();
        }
        assertTrue(setSaab.getPos()[0] == 0 && setSaab.getPos()[1] == 0);

    }
    @Test
    public void TestGetColorAndNrOfDoors(){
        assertTrue(setSaab.getNrDoors()== 2&& setSaab.getColor()== Color.red);
    }
    @Test
    public void TestScaniaTruck(){
        setScania.setBedAngle(-1);
        assertTrue(setScania.getCurrentBedAngle() == 0);
    }
    @Test
    public void TestIfDrivable(){
        setScania.setBedAngle(1);
        setScania.setBedAngle(0);
        assertTrue(setScania.getCurrentBedAngle() + " " + setScania.getIfDrivable(),setScania.getIfDrivable());
    }

    @Test
    public void TestDirectionsEnum(){
        assertTrue(Direction.values()[0] == Direction.NORTH && Direction.values()[1] == Direction.EAST && Direction.values()[2] == Direction.SOUTH && Direction.values()[3] == Direction.WEST);
    }
    @Test
    public void TestLoadVehicle(){
        setLoader.LoadVehicle(setSaab);
        assertEquals(1, setLoader.GetLoadList().size());
    }
    @Test
    public void TestUnloadVehicle(){
        setLoader.LoadVehicle(setSaab);
        setLoader.UnloadVehicle();
        assertEquals(0, setLoader.GetLoadList().size());

    }
    @Test
    public void TestDeltaPos(){
        setSaab.setPos(0,0);
        setVolvo.setPos(3,4);
        assertTrue(setVolvo.getDeltaPos(setSaab)==5);
    }
    @Test
    public void LowerRamp(){
        setTransport.LowerRamp();
        assertFalse(setTransport.GetRampState());
    }
    @Test
    public void RaiseRamp(){
        setTransport.RaiseRamp();
        assertTrue(setTransport.GetRampState());
    }
    @Test
    public void TestTransportTurnRight(){
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.turnRight();
        assertEquals(setSaab.getDirection(), setTransport.getDirection());
    }
    @Test
    public void TestTransportTurnLeft(){
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.turnLeft();
        assertEquals(setSaab.getDirection(), setTransport.getDirection());
    }
    @Test
    public void TestLoadVehicleTransport(){
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        assertTrue(setTransport.getPos()[0] == setSaab.getPos()[0] &&
                setTransport.getPos()[1] == setSaab.getPos()[1] &&
                setTransport.getDirection() == setSaab.getDirection());
    }
    @Test
    public void TestTransportMove() {
        double[] oldPos = {setTransport.getPos()[0],setTransport.getPos()[1]};
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.LoadVehicle(setVolvo);
        setTransport.RaiseRamp();
        setTransport.startEngine();
        setTransport.move();
        setTransport.move();
        assertTrue(oldPos[1] != setTransport.getPos()[1]
                && setTransport.getPos()[0] == setSaab.getPos()[0]
                && setTransport.getPos()[0] == setVolvo.getPos()[0]
                && setTransport.getPos()[1] == setSaab.getPos()[1]
                && setTransport.getPos()[1] == setVolvo.getPos()[1]);
    }
    @Test
    public void TestUnloadVehicleTransport() {
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.UnloadVehicle();
        assertEquals(setSaab.getDirection(), setTransport.getOppositeDirection());
        assertNotEquals(setSaab.getPos(), setTransport.getPos());
    }
    @Test
    public void TestWorkshopLoading(){
        setWorkshop.AddVehicle(setSaab);
        assertTrue(setWorkshop.getLoadList().size() == 1);
    }
}
