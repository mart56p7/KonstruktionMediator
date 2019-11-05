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

public class Spagetti {
    private JFrame frame = null;
    private ImgPanel panel = null;
    private JButton button = null;
    BufferedImage on, off;
    private final String  pathtofiles = "c:\\images\\";

    public Spagetti() {
        frame = new JFrame("My Application");
        frame.setResizable(false);
        frame.setSize(571, 900);
        frame.setLayout(new FlowLayout());
        frame.setVisible(true);
        frame.setBackground(Color.white);
        frame.setLayout(null);
        frame.addWindowListener(
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
        panel = new ImgPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.white);
        panel.setBounds(0,10 , 571, 743);
        panel.setBackground(Color.white);

        try {
            this.on = ImageIO.read(new File(pathtofiles + "on.png"));
            this.off = ImageIO.read(new File(pathtofiles + "off.png"));
        } catch (IOException ex) {
            System.out.println("Failed to load images " + ex.getMessage());
        }
        panel.setImage(off);
        //Adding panel to jframe
        frame.add(panel);

        button = new JButton();
        button.setBounds(35, 760, 500, 60);
        button.setText("I got an idea");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(button.getText().equals("I got an idea")){
                            panel.setImage(on);
                            button.setText("Im out of ideas");
                        }
                        else{
                            panel.setImage(off);
                            button.setText("I got an idea");
                        }
                    }
                }
        );
        frame.add(button);
        frame.setVisible(true);
        button.setVisible(true);
        panel.setVisible(true);
    }

    public static void main(String[] args) {
        new Spagetti();
    }
}
