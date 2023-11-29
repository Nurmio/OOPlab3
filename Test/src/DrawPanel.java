import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    BufferedImage SaabImage;
    BufferedImage ScaniaImage;
    BufferedImage flippedVolvoImage;
    BufferedImage flippedSaabImage;
    BufferedImage flippedScaniaImage;

    // To keep track of a single cars position
    Point volvoPoint = new Point();
    Point SaabPoint = new Point();
    Point ScaniaPoint = new Point();
    Direction volvoDir;
    Direction saabDir;
    Direction scaniaDir;

    void moveit(int x, int y,Direction dir, String modelName){
        switch (modelName){
            case "Saab95":
                SaabPoint.x = x;
                SaabPoint.y = y+100;
                saabDir = dir;
                break;
            case "Volvo240":
                volvoPoint.x = x;
                volvoPoint.y = y;
                volvoDir = dir;
                break;
            case "Scania":
                ScaniaPoint.x = x;
                ScaniaPoint.y = y+200;
                scaniaDir = dir;
                break;
        }


    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.darkGray);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.png"));
            SaabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95.png"));
            ScaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.png"));
            flippedVolvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/volvo240Flipped.png"));
            flippedSaabImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Saab95Flipped.png"));
            flippedScaniaImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/ScaniaFlipped.png"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if(volvoDir == Direction.EAST){g.drawImage(volvoImage, volvoPoint.x, volvoPoint.y, null);}
        else if(volvoDir == Direction.WEST){g.drawImage(flippedVolvoImage, volvoPoint.x, volvoPoint.y, null);}
        if(saabDir == Direction.EAST){g.drawImage(SaabImage, SaabPoint.x, SaabPoint.y, null);}
        else if(saabDir == Direction.WEST){g.drawImage(flippedSaabImage, SaabPoint.x, SaabPoint.y, null);}
        if(scaniaDir == Direction.EAST){g.drawImage(ScaniaImage, ScaniaPoint.x, ScaniaPoint.y, null);}
        else if(scaniaDir == Direction.WEST){g.drawImage(flippedScaniaImage, ScaniaPoint.x, ScaniaPoint.y, null);}
    }
    public int getImageWidth(String modelName){
        return switch (modelName) {
            case "Saab95" -> SaabImage.getWidth();
            case "Volvo240" -> volvoImage.getWidth();
            case "Scania" -> ScaniaImage.getWidth();
            default -> 100;
        };
    }
}
