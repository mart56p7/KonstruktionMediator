import javax.imageio.ImageIO;
import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImgPanel extends JPanel {
    private BufferedImage bi = null;
    private MediatorInterface mediator = null;
    private BufferedImage on = null;
    private BufferedImage off = null;

    private final String  pathtofiles = "c:\\images\\";
    public ImgPanel(){
        this(null);
    }

    public ImgPanel(MediatorInterface m){
        this.mediator = m;

        try {
            on = ImageIO.read(new File(pathtofiles + "on.png"));
            off = ImageIO.read(new File(pathtofiles + "off.png"));
        } catch (IOException ex) {
            System.out.println("Failed to load images " + ex.getMessage());
        }

    }


    public void turnLightOn(){
        if(on != null && mediator != null){
            mediator.setButtonText("Im out of ideas");
        }
        this.setImage(on);
    }

    public void turnLightOff(){
        if(off != null && mediator != null){
            mediator.setButtonText("I got an idea");
        }
        this.setImage(off);
    }

    public void setImage(BufferedImage bi){
        this.bi = bi;
        repaint();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("P");
        if(bi != null){
            //System.out.println("Paint");
            g.drawImage(bi, 0, 0, this); // see javadoc for more info on the parameters
        }
    }
}
