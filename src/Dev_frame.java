import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.sql.SQLOutput;

public class Dev_frame extends JFrame implements ItemListener, TextListener{

    JComboBox rating;
    JTextField Hobbie;

    JLabel greetings;

    JButton submit;

    Color c;

    Dev_frame(){
        this.setSize(1350,450);
        this.setTitle("Developer");
        this.setLayout(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setVisible(true);




        String scores[]={" Rating 1 "," Rating 2 "," Rating 3 "," Rating 4 "," Rating 5 "," Rating 6 "," Rating 7 "};
        rating = new JComboBox(scores);
        rating.setBounds(75,150,220,75);
        rating.addItemListener(this);
        rating.setFont(new Font("Serief",Font.BOLD,40));
        rating.setBackground(new Color(253, 207, 169, 194));
        rating.setForeground(new Color(49, 49, 49));

        c=new Color(253, 207, 169);


        getContentPane().setBackground(c);

        Hobbie=new JTextField("    Enter a new Hobbie");
        Hobbie.setFont(new Font("Serief",Font.BOLD,35));
        Hobbie.setBackground(new Color(254, 211, 1));
        Hobbie.setForeground(new Color(49, 49, 49, 255));
        Hobbie.setEditable(false);

        greetings=new JLabel("Hello \"Developer\" & \"DevId\" Select Rating And then Enter the Hobby");

        greetings.setFont(new Font("Serief",Font.BOLD,40));

        greetings.setBounds(25,35,10000,100);

        greetings.setForeground(new Color(49, 49, 49));
        this.add(greetings);
        this.add(rating);

        this.add(Hobbie);
        Hobbie.setBounds(800,150,400,75);

        submit=new JButton("Submit");


        submit.setBounds(450,250,220,75);
        submit.setFont(new Font("Serief",Font.BOLD,40));
        submit.setBackground(new Color(59, 59, 79, 255));
        submit.setForeground(new Color(255, 255, 255));
        this.add(submit);

        Hobbie.setCaretColor(Color.black);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if(e.getSource()==rating) {
            System.out.println(rating.getSelectedIndex());
            rating.setEnabled(false);
            Hobbie.setEditable(true);
        }
    }

    @Override
    public void textValueChanged(TextEvent e) {
        //if(e.getSource()==Hobbie)
        String s =Hobbie.getText();
        System.out.println(s);
    }
}

