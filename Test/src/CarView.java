import javax.swing.*;
import java.awt.*;


/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components
 **/

public class CarView extends JFrame {
    private static final int X = 900;
    private static final int Y = 800;

    // The controller member
    //CarController carC;

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
//region Buttons, Spinners, Textfields, etc...
    JSpinner gasSpinner = new JSpinner();
    JTextField VehicleTextField = new JTextField(1);
    JTextField getVehicleTextField(){return VehicleTextField;}
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JLabel VehicleLabel = new JLabel("Which car: ");

    private final JButton gasButton = new JButton("Gas");
    public JButton getGasButton(){return gasButton;}
    private final JButton brakeButton = new JButton("Brake");
    public JButton getBrakeButton(){return brakeButton;}

    private final JButton turboOnButton = new JButton("Saab Turbo on");
    public JButton getTurboOnButton(){return turboOnButton; }
    private final JButton turboOffButton = new JButton("Saab Turbo off");
    public JButton getTurboOffButton(){return turboOffButton;}
    private final JButton liftBedButton = new JButton("Scania Lift Bed");
    public JButton getliftBedButton(){return liftBedButton;}
    private final JButton lowerBedButton = new JButton("Lower Lift Bed");
    public JButton getlowerBedButton(){return lowerBedButton;}
    private final JButton startButton = new JButton("Start all cars");
    public JButton getstartButton(){return startButton;}

    private final JButton stopButton = new JButton("Stop all cars");
    public JButton getstopButton(){return stopButton;}
    private final JButton addVehicleButton = new JButton("Add car");
    public JButton getaddVehicleButton(){return addVehicleButton;}
    private final JButton removeVehicleButton = new JButton("Remove car");
    public JButton getremoveVehicleButton(){return removeVehicleButton;}
//endregion

    // Constructor
    public CarView(String framename){
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(
                        0, //initial value
                        0, //min
                        100, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(e -> gasAmount = (int) ((JSpinner)e.getSource()).getValue());

        gasPanel.setLayout(new GridLayout(2,1));
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        gasPanel.add(VehicleLabel, BorderLayout.PAGE_START);
        gasPanel.add(VehicleTextField, BorderLayout.PAGE_END);

        this.add(gasPanel); 

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(addVehicleButton, 6);
        controlPanel.add(removeVehicleButton, 7);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/6-18,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/6-18,200));
        this.add(stopButton);


        this.pack();
        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(drawPanel.AppIcon);
    }
}
