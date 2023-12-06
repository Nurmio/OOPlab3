public class Turbo {
    private boolean turboOn = false;
    protected void TurboOn(){
        turboOn = true;
    }

    protected void TurboOff(){
        turboOn = false;
    }
    protected boolean TurboStatus() {
        return turboOn;
    }
}
