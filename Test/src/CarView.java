import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;


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

    private DrawPanel drawPanel = new DrawPanel(X, Y-240);
    public void setIMGWIDTH(int width){drawPanel.setIMGWIDTH(width);}
    public void initImages(){drawPanel.initImages();}
    public void moveIT(ArrayList<Vehicle> v){drawPanel.moveit(v);}

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
//region Buttons, Spinners, Textfields, etc...
    JSpinner gasSpinner = new JSpinner();
    JTextField VehicleTextField = new JTextField(1);
    String vehicleName(){return VehicleTextField.getText();}
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");
    JLabel VehicleLabel = new JLabel("Which car: ");

    private final JButton gasButton = new JButton("Gas");
    public JButton getGasButton(){return gasButton;}
    public void addGasButtonListener(ActionListener al){gasButton.addActionListener(al);}
    private final JButton brakeButton = new JButton("Brake");
    public JButton getBrakeButton(){return brakeButton;}
    public void addBrakeButtonListener(ActionListener al){brakeButton.addActionListener(al);}
    private final JButton turboOnButton = new JButton("Saab Turbo on");
    public JButton getTurboOnButton(){return turboOnButton; }
    public void addTurboOnButtonListener(ActionListener al){turboOnButton.addActionListener(al);}



    private final JButton turboOffButton = new JButton("Saab Turbo off");
    public void addTurboOffButtonListener(ActionListener al){turboOffButton.addActionListener(al);}
    private final JButton liftBedButton = new JButton("Scania Lift Bed");

    public void addLiftBedButtonListener(ActionListener al){liftBedButton.addActionListener(al);}
    private final JButton lowerBedButton = new JButton("Lower Lift Bed");
    public JButton getlowerBedButton(){return lowerBedButton;}
    private final JButton startButton = new JButton("Start all cars");
    public void addStartButtonListener(ActionListener al){startButton.addActionListener(al);}

    private final JButton stopButton = new JButton("Stop all cars");
    public void addStopButtonListener(ActionListener al){stopButton.addActionListener(al);}
    private final JButton addVehicleButton = new JButton("Add car");
    public void addAddVehicleButtonListener(ActionListener al){addVehicleButton.addActionListener(al);}
    private final JButton removeVehicleButton = new JButton("Remove car");
    public void addRemoveButtonListener(ActionListener al){removeVehicleButton.addActionListener(al);}

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
        this.setIconImage(drawPanel.getAppIcon());
    }
}
