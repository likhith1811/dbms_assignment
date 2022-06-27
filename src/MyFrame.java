import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener{


    private JButton b_Developer;
    private JButton b_Student;


    MyFrame(){

        b_Developer = new JButton("Developer");
        b_Student = new JButton("Student");

        b_Student.setBounds(50,50,100,50);
        b_Developer.setBounds(200,50,100,50);
        this.setSize(420,200);
        this.setTitle("Codec Guide");
        this.setLayout(null);
        this.setVisible(true);


        b_Developer.addActionListener(this);
        b_Student.addActionListener(this);


        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        add(b_Developer);
        add(b_Student);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==b_Developer){
            System.out.println("Developer");
            dispose();
            new Dev_login();

        }

        if(e.getSource()==b_Student) {
            System.out.println("Student");
            dispose();
            new Stu_login();
        }
    }
}
