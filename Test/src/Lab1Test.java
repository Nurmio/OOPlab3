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
        setSaab.styrIT.turnLeft();
        assertTrue("dir: "+ setSaab.styrIT.getDirection(),setSaab.styrIT.getDirection() == Direction.NORTH);
    }
    @Test
    public void TestTurningRight(){
        setSaab.styrIT.turnRight();
        assertTrue("dir: " + setSaab.styrIT.getDirection(),setSaab.styrIT.getDirection() == Direction.SOUTH);

    }
    @Test
    public void TestMoveForwardWithoutStartingEngine(){
        setSaab.styrIT.move();
        assertTrue(setSaab.styrIT.getPos()[0] == 0 && setSaab.styrIT.getPos()[1] == 0);
    }
    @Test
    public void TestMoveForwardWithStartedEngine(){
        setSaab.styrIT.startEngine();
        setSaab.styrIT.move();
        assertTrue("x: " + setSaab.styrIT.getPos()[0] + " y: " + setSaab.styrIT.getPos()[1],setSaab.styrIT.getPos()[0] == 0.1 && setSaab.styrIT.getPos()[1] == 0);
    }

    @Test
    public void TestVolvoSpeedFactorWhileStandingStill(){
        assertTrue(String.valueOf(0.01*setVolvo.getEnginePower()* setVolvo.getTrimFactor()),setVolvo.speedFactor() == 0.01*setVolvo.getEnginePower()* setVolvo.getTrimFactor());
    }
    @Test
    public void TestSaabSpeedFactorWhileStandingStill(){
        assertTrue(0.01*setSaab.getEnginePower() + " " + setSaab.speedFactor(),setSaab.speedFactor()== 0.01*setSaab.getEnginePower());
    }

    @Test
    public void TestGas(){
        setSaab.styrIT.startEngine();
        setSaab.styrIT.gas(1);
        assertTrue(setSaab.styrIT.getCurrentSpeed() > 0.1);
    }
    @Test
    public void TestBreak(){
        setSaab.styrIT.startEngine();
        setSaab.styrIT.gas(1);
        setSaab.styrIT.gas(1);
        setSaab.styrIT.brake(1);
        setSaab.styrIT.brake(1);
        assertTrue(""+setSaab.styrIT.getCurrentSpeed(), 0.09<= setSaab.styrIT.getCurrentSpeed() && setSaab.styrIT.getCurrentSpeed() <= 0.11);
    }

    @Test
    public void TestMovesToStartingPos(){
        setSaab.styrIT.startEngine();
        setSaab.styrIT.gas(1);
        for (int i = 0; i < 4; i++) {
            setSaab.styrIT.move();
            setSaab.styrIT.turnRight();
        }
        setSaab.styrIT.brake(1);
        for (int i = 0; i < 4; i++) {
            setSaab.move();
            setSaab.styrIT.turnLeft();
        }
        assertTrue(setSaab.styrIT.getPos()[0] == 0 && setSaab.styrIT.getPos()[1] == 0);
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
        setSaab.styrIT.setPos(0,0);
        setVolvo.styrIT.setPos(3,4);
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
        System.out.println("trans: " + setTransport.styrIT.getDirection());
        System.out.println("saab: " + setSaab.styrIT.getDirection());
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.turnRight();
        System.out.println("trans: " + setTransport.styrIT.getDirection());
        System.out.println("saab: " + setSaab.styrIT.getDirection());
        assertEquals(setSaab.styrIT.getDirection(), setTransport.styrIT.getDirection());
    }
    @Test
    public void TestTransportTurnLeft(){
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.turnLeft();
        assertEquals(setSaab.styrIT.getDirection(), setTransport.styrIT.getDirection());
    }
    @Test
    public void TestLoadVehicleTransport(){
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        assertTrue(setTransport.styrIT.getPos()[0] == setSaab.styrIT.getPos()[0] &&
                setTransport.styrIT.getPos()[1] == setSaab.styrIT.getPos()[1] &&
                setTransport.styrIT.getDirection() == setSaab.styrIT.getDirection());
    }
    @Test
    public void TestTransportMove() {
        double[] oldPos = {setTransport.styrIT.getPos()[0],setTransport.styrIT.getPos()[1]};
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.LoadVehicle(setVolvo);
        setTransport.RaiseRamp();
        setTransport.styrIT.startEngine();
        setTransport.move();
        setTransport.move();
        System.out.println(oldPos[1]);
        System.out.println(setVolvo.styrIT.getPos()[0] + " " +  setVolvo.styrIT.getPos()[1]);
        System.out.println(setTransport.styrIT.getPos()[0] + " "+ setTransport.styrIT.getPos()[1]);
        assertTrue(oldPos[0] != setTransport.styrIT.getPos()[0]
                && setTransport.styrIT.getPos()[0] == setSaab.styrIT.getPos()[0]
                && setTransport.styrIT.getPos()[0] == setVolvo.styrIT.getPos()[0]
                && setTransport.styrIT.getPos()[1] == setSaab.styrIT.getPos()[1]
                && setTransport.styrIT.getPos()[1] == setVolvo.styrIT.getPos()[1]);
    }
    @Test
    public void TestUnloadVehicleTransport() {
        setTransport.LowerRamp();
        setTransport.LoadVehicle(setSaab);
        setTransport.UnloadVehicle();
        assertEquals(setSaab.styrIT.getDirection(), setTransport.styrIT.getOppositeDirection());
        assertNotEquals(setSaab.styrIT.getPos(), setTransport.styrIT.getPos());
    }
    @Test
    public void TestWorkshopLoading(){
        setWorkshop.AddVehicle(setSaab);
        assertTrue(setWorkshop.getLoadList().size() == 1);
    }
}
