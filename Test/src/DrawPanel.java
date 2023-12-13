import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{
    private BufferedImage volvoImg;
    private BufferedImage flippedVolvoImg ;
    private BufferedImage saabImg;
    private BufferedImage flippedSaabImg;
    private BufferedImage scaniaImg;
    private BufferedImage flippedScaniaImg;
    private BufferedImage AppIcon;
    public BufferedImage getAppIcon(){return AppIcon;};
    private ArrayList<Point> points = new ArrayList<>();
    private  ArrayList<BufferedImage> images = new ArrayList<>();

    private int IMGWIDTH;
    public void setIMGWIDTH(int x){IMGWIDTH = x;}

    void moveit(ArrayList<Vehicle> Vehicles) {
        points = new ArrayList<>();
        images = new ArrayList<>();
        for (Vehicle v : Vehicles) {
            points.add(new Point((int) Math.round(v.styrIT.getPos()[0]), (int) Math.round(v.styrIT.getPos()[1])));
            if (v.styrIT.getDirection() == Direction.EAST) {
                images.add(getImage(v.getModelName()).get(0));
            } else if (v.styrIT.getDirection() == Direction.WEST) {
                images.add(getImage((v.getModelName())).get(1));
            }
        }
        this.repaint();
    }
    public void initImages(){
        try {
             volvoImg = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240.png")));
             flippedVolvoImg = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Volvo240Flipped.png")));;
             saabImg = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95.png")));;
             flippedSaabImg= ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Saab95Flipped.png")));;
             scaniaImg= ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Scania.png")));;
             flippedScaniaImg= ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/ScaniaFlipped.png")));;
        }
        catch (IOException e){ throw new RuntimeException(e);}
    }
    private ArrayList<BufferedImage> getImage(String modelName) {
        ArrayList<BufferedImage> tempArray = new ArrayList<>();
        switch (modelName) {
            case "Volvo240" ->{ tempArray.add(volvoImg); tempArray.add(flippedVolvoImg);}
            case "Saab95" -> {tempArray.add(saabImg); tempArray.add(flippedSaabImg);}
            case "Scania" -> {tempArray.add(scaniaImg); tempArray.add(flippedScaniaImg);}
            default -> throw new RuntimeException();
        }
            return tempArray;
    }
    public int getImageWidth(String modelName){
        switch (modelName) {
            case "Volvo240" ->{ return volvoImg.getWidth();}
            case "Saab95" -> {return saabImg.getWidth();}
            case "Scania" -> {return scaniaImg.getWidth();}
            default -> throw new RuntimeException();
        }
    }
    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        try {
            AppIcon = ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream("pics/Icon.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
    // This method is called each time the panel updates/refreshes/repaints itself
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int i=0;
        for (Point p: points) {
            g.drawImage((images.get(i).getScaledInstance(IMGWIDTH,images.get(i).getHeight(),Image.SCALE_DEFAULT)), p.x, p.y, null);
            i++;
        }
    }
}
