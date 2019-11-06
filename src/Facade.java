import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Facade {
    private MyFrame frame = null;


    public Facade(MyFrame frame) {
        this.frame = frame;
    }

    public void turnLightOn(){
        frame.turnLightOn();
        //More methods could be called here
    }

    public void turnLightOff(){
        frame.turnLightOff();
        //More methods could be called here
    }

    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        Facade facade = new Facade(frame);
        JButton button = new JButton();
        button.setBounds(35, 760, 500, 60);
        button.setText("I got an idea");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(button.getText().equals("I got an idea")){
                            //The facade has no way to call back the button
                            button.setText("Im out of ideas");
                            //Calls facade
                            facade.turnLightOn();
                            //The muse goes away quickly!
                            (new Thread(new Muse(facade, button, "I got an idea"))).start();
                        }
                        else{
                            button.setText("I got an idea");
                            //Calls facade
                            facade.turnLightOff();
                        }
                    }
                }
        );
        frame.add(button);
        frame.repaint();
        frame.turnLightOff();

    }
}


class MyFrame extends JFrame{
    private ImgPanel panel = null;
    private BufferedImage on = null;
    private BufferedImage off = null;

    public MyFrame(){
        super("Facade");
        final String  pathtofiles = "c:\\images\\";
        BufferedImage on = null;
        BufferedImage off = null;
        this.setResizable(false);
        this.setSize(571, 900);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
        this.setBackground(Color.white);
        this.setLayout(null);
        this.addWindowListener(
                new WindowAdapter() {
                    public void windowClosed(WindowEvent e) {
                        System.out.println("windowClosed");
                        Runtime.getRuntime().exit(0);
                    }

                    public void windowClosing(WindowEvent e) {
                        System.out.println("windowClosing");
                        Runtime.getRuntime().exit(0);
                    }
                });
        this.panel = new ImgPanel();
        this.panel.setLayout(new FlowLayout());
        this.panel.setBackground(Color.white);
        this.panel.setBounds(0,10 , 571, 743);
        this.panel.setBackground(Color.white);

        try {
            this.on = ImageIO.read(new File(pathtofiles + "on.png"));
            this.off = ImageIO.read(new File(pathtofiles + "off.png"));
        } catch (IOException ex) {
            System.out.println("Failed to load images " + ex.getMessage());
        }
        this.panel.setImage(off);
        //Adding panel to jframe
        this.add(this.panel);


        this.setVisible(true);
        panel.setVisible(true);

    }

    public void turnLightOn(){
        if(on != null){
            panel.setImage(on);
        }
        else{
            System.out.println("Image failed to load");
        }
    }

    public void turnLightOff(){
        if(off != null){
            panel.setImage(off);
        }
        else{
            System.out.println("Image failed to load");
        }
    }
}