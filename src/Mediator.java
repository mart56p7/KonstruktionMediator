import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

public class Mediator implements MediatorInterface {
    private ImgPanel panel = null;

    private JButton button = null;


    public Mediator() {

    }

    public void setPanel(ImgPanel panel) {
        this.panel = panel;
    }

    public void setButton(JButton button) {
        this.button = button;
    }

    /**
     * Mediator: Used to talk to the ImgPanel
     * */
    public void turnLightOn(){
        if(panel != null){
            panel.turnLightOn();
            (new Thread(new Muse(this))).start();
        }
    }
    /**
     * Mediator: Used to talk to the ImgPanel
     * */
    public void turnLightOff(){
        if(panel != null){
            panel.turnLightOff();
        }
    }
    /**
     * Mediator: Used to talk to the Button
     * */
    public void setButtonText(String str){
        if (button != null) {
            button.setText(str);
        }
    }

    public static void main(String[] args) {

        BufferedImage on = null;
        BufferedImage off = null;
        JFrame frame = new JFrame("Mediator Application");
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
        MediatorInterface mediator = new Mediator();

        ImgPanel panel = new ImgPanel(mediator);
        panel.setLayout(new FlowLayout());
        panel.setBackground(Color.white);
        panel.setBounds(0,10 , 571, 743);
        panel.setBackground(Color.white);
       //Adding panel to jframe
        frame.add(panel);
        mediator.setPanel(panel);

        JButton button = new JButton();
        button.setBounds(35, 760, 500, 60);
        button.setText("I got an idea");
        button.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        if(button.getText().equals("I got an idea")){
                            mediator.turnLightOn();
                        }
                        else{
                            mediator.turnLightOff();
                        }
                    }
                }
        );
        frame.add(button);
        mediator.setButton(button);

        frame.setVisible(true);
        button.setVisible(true);
        panel.setVisible(true);
        frame.repaint();
        mediator.turnLightOff();
    }
}

