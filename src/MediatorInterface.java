import javax.swing.*;

interface MediatorInterface{
    void turnLightOn();
    void turnLightOff();
    void setButtonText(String str);
    void setPanel(ImgPanel panel);
    void setButton(JButton button);
}