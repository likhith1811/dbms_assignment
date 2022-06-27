import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class QuizTest extends JFrame implements ActionListener
{

    JLabel label;
    JRadioButton radioButtons[]= new JRadioButton[5];
    JButton btnNext, btnResult;
    ButtonGroup bg;
    int sid;
    int count=0, current=0, x=1, y=1, now=0,rating;
    int m[] = new int[5];

    public void setId(int sid) {
        this.sid=sid;
    }

    QuizTest(String s)
    {
        super(s);
        label=new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i=0; i<5; i++)
        {
            radioButtons[i]= new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result");
        btnResult.setVisible(false);
        btnNext.addActionListener(this);
        btnResult.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,40,450,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        
        
        
        
        
    }
    
    void setData()
    {
        radioButtons[4].setSelected(true);
        if(current==0)
        {
            label.setText("How familiar are you with Programming");
            radioButtons[0].setText("Very Familiar and know Advanced Concepts");
            radioButtons[1].setText("Familiar but I often get struck");
            radioButtons[2].setText("A Little familiar, Can print basic things");
            radioButtons[3].setText("Don't know at all!");
        }
        
        if(current==1)
        {
            label.setText("Are you Good with your logic while programming?");
            radioButtons[0].setText("Yes...");
            radioButtons[1].setText("Mostly but cant get through with tougher questions");
            radioButtons[2].setText("A little ");
            radioButtons[3].setText("No not at all");
        }
        if(current==2)
        {
            label.setText("How punctual are you?");
            radioButtons[0].setText("Very punctual");
            radioButtons[1].setText("Punctual at most times");
            radioButtons[2].setText("Sometimes this Sometimes that..");
            radioButtons[3].setText("Not at all");
        }
        if(current==3)
        {
            label.setText("How good are you with debugging your own code?");
            radioButtons[0].setText("Very good, rarely make a mistake");
            radioButtons[1].setText("Can debug a lot myself");
            radioButtons[2].setText("I need someones help");
            radioButtons[3].setText("Cannot debug at all");
        }
        if(current==4)
        {
            label.setText("Do you enjoy yourself while coding?");
            radioButtons[0].setText("Yes I enjoy a lot");
            radioButtons[1].setText("Yes at most times but harder problems frustrate me");
            radioButtons[2].setText("Cant say!");
            radioButtons[3].setText("I feel CS is not my cup of coffee");
        }
        label.setBounds(30,40,450,20);
        for(int i=0,j=0; i<=90; i+=30,j++)
        {
            radioButtons[j].setBounds(50,80+i,200,20);
        }
    }
    
    int checkAnswer()
    {
        if(current==0)
        {
            if(radioButtons[0].isSelected()) count=count+4;
            if(radioButtons[1].isSelected()) count=count+3;
            if(radioButtons[2].isSelected()) count=count+2;
            if(radioButtons[3].isSelected()) count=count+1;
        }
        if(current==1)
        {
            if(radioButtons[0].isSelected()) count=count+4;
            if(radioButtons[1].isSelected()) count=count+3;
            if(radioButtons[2].isSelected()) count=count+2;
            if(radioButtons[3].isSelected()) count=count+1;
        }
        if(current==2)
        {
            if(radioButtons[0].isSelected()) count=count+4;
            if(radioButtons[1].isSelected()) count=count+3;
            if(radioButtons[2].isSelected()) count=count+2;
            if(radioButtons[3].isSelected()) count=count+1;
        }
        if(current==3)
        {
            if(radioButtons[0].isSelected()) count=count+4;
            if(radioButtons[1].isSelected()) count=count+3;
            if(radioButtons[2].isSelected()) count=count+2;
            if(radioButtons[3].isSelected()) count=count+1;
        }
        if(current==4)
        {
            if(radioButtons[0].isSelected()) count=count+4;
            if(radioButtons[1].isSelected()) count=count+3;
            if(radioButtons[2].isSelected()) count=count+2;
            if(radioButtons[3].isSelected()) count=count+1;
        }
        
        if(0<=count&&count<3) return 1;
        if(3<=count&&count<6) return 2;
        if(6<=count&&count<9) return 3;
        if(9<=count&&count<12) return 4;
        if(12<=count&&count<15) return 5;
        if(15<=count&&count<18) return 6;
        if(18<=count&&count<20) return 7;
        
        return rating;
    }
    
    public static void main(String args[])
    {
        new QuizTest("Simple Quiz App");
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnNext)
        {
            rating=checkAnswer();
            current++;
            setData();
            if(current==4)
            {
                btnResult.setVisible(true);
                btnNext.setEnabled(false);
                btnResult.setText("Result");
            }
        }
        
        if(e.getActionCommand().equals("Result"))
        {
            rating=checkAnswer();
            current++;
        }
        
        if(current==5)
        {
            JOptionPane.showMessageDialog(this,"Your total score is "+count+" Your rating level is "+rating);
            System.exit(0);

            try {

                Class.forName("oracle.jdbc.driver.OracleDriver");
                Connection con;
                con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "likhith", "likhith");

                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("select * from log_stu where sid='" + s1 + "'");

                if (rs.next()) {

                    } else {

                        throw new Exception("Enter valid credentials");
                    }


                } else {

                    throw new Exception("Email not found");

                }
                con.close();

                dispose();

            } catch (Exception e1) {

                System.out.println(e1);
                JOptionPane.showMessageDialog(qt, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);

            }
        }
    }
}