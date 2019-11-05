import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImgPanel extends JPanel {
    BufferedImage bi = null;

    public void setImage(BufferedImage bi){
        this.bi = bi;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println("P");
        if(bi != null){
            System.out.println("Paint");
            g.drawImage(bi, 0, 0, this); // see javadoc for more info on the parameters
        }
    }
}
