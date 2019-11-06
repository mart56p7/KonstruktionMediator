import javax.swing.*;
import java.awt.image.BufferedImage;
import java.sql.SQLOutput;

/**
 * Ideas only last so long...
 * */
class Muse implements Runnable{
    //Facade
    private Facade mf = null;
    //Mediator
    private MediatorInterface mediator = null;
    //Spagetti
    private ImgPanel ip = null;
    private BufferedImage bi = null;
    //Spagetti & Facade
    private JButton button = null;
    private String str = null;

    public Muse(Facade f, JButton b, String str){
        this.mf = f;
        this.button = b;
        this.str = str;
    }

    public Muse(MediatorInterface m){
        this.mediator = m;
    }

    public Muse(ImgPanel ip, JButton button, BufferedImage bi, String str){
        this.ip = ip;
        this.button = button;
        this.bi = bi;
        this.str = str;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println(System.currentTimeMillis() + ": Time is up!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(mf != null && button != null && str != null){
            mf.turnLightOff();
            button.setText(str);
        }
        if(mediator != null){
            mediator.turnLightOff();
        }
        if(ip != null && button != null){
            ip.setImage(bi);
            button.setText(str);
        }

    }
}