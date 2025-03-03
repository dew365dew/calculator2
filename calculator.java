import javax.swing.*;
import java.awt.*;
import java.io.File;

public class calculator extends JFrame{
    Image icon = Toolkit.getDefaultToolkit().createImage(System.getProperty("user.dir")+ File.separator + "calculator.png");
    calculator(){
            setIconImage(icon);
            setMinimumSize(new Dimension(330, 500));
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            //setResizable(false);
            setContentPane(new panel());
    }
}

