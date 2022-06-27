import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Stu_login extends JFrame
{

    private QuizTest qt;

    private static final long serialVersionUID = 1L;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    public Stu_login()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Login");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(423, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        textField.setBounds(481, 170, 281, 68);
        contentPane.add(textField);
        textField.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(481, 286, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblUsername.setBounds(250, 166, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 31));
        lblPassword.setBounds(250, 286, 193, 52);
        contentPane.add(lblPassword);
        this.setVisible(true);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(545, 392, 162, 73);
        btnNewButton.addActionListener(new ActionListener()
        {

            public void actionPerformed(ActionEvent e)
            {
//                String userName = textField.getText();
//                String password = passwordField.getText();
//




                if (e.getActionCommand().equals("Login")) {


                    try
                    {
                    int s1 = Integer.parseInt(textField.getText());
                    String s2 = passwordField.getText();
                    System.out.println(s1+s2);

                    qt.setId(s1);



                    try {

                        Class.forName("oracle.jdbc.driver.OracleDriver");
                        Connection con;
                        con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "likhith", "likhith");

                        Statement stmt = con.createStatement();

                        ResultSet rs = stmt.executeQuery("select * from log_stu where sid='" + s1 + "'");

                        if (rs.next()) {


                            if (s2.equals(rs.getString(2))) {

                                System.out.println("yess");
                                qt = new QuizTest("Student Quiz");
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

                }catch(Exception e1)
                    {
                        System.out.println("integer only");
                    }

                }








        }
        });

        contentPane.add(btnNewButton);

        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);


    }
}