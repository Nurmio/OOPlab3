import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    BufferedImage AppIcon;
    ArrayList<Point> points = new ArrayList<Point>();
    ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();

    void moveit(ArrayList<Vehicle> Vehicles){
        points = new ArrayList<Point>();
        images = new ArrayList<BufferedImage>();
        for (Vehicle v: Vehicles) {
            points.add(new Point((int) Math.round(v.styrIT.getPos()[0]), (int) Math.round(v.styrIT.getPos()[1])));
            if(v.styrIT.getDirection()== Direction.EAST){images.add(v.sprite.Img);}
            else if (v.styrIT.getDirection() == Direction.WEST) {images.add(v.sprite.FlippedImg);}
        }
        this.repaint();

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
            g.drawImage(images.get(i), p.x, p.y, null);
            i++;
        }
    }
}
