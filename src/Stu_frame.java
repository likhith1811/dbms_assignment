import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Stu_frame extends JFrame {
    Stu_frame(){
        this.setSize(240,240);
        this.setTitle("Student");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);

        JOptionPane.showMessageDialog(null,"Are you good","Question 1",JOptionPane.PLAIN_MESSAGE);

    }
}
