import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class s_signup extends JFrame
{


    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;

    private JTextField username;

    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JButton btnLogin;



    public s_signup()
    {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 190, 1014, 597);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("New Student Register");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(362, 52, 325, 50);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(65, 152, 99, 43);
        contentPane.add(lblName);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(214, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        username = new JTextField();
        username.setFont(new Font("Tahoma", Font.PLAIN, 32));
        username.setBounds(707, 151, 228, 50);
        contentPane.add(username);
        username.setColumns(10);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblUsername.setBounds(565, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(310, 245, 99, 24);
        contentPane.add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(425, 235, 228, 50);
        contentPane.add(passwordField);

        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String firstName = firstname.getText();
                String userName = username.getText();
                String password = String.valueOf(passwordField.getPassword());

                System.out.println(firstName+" "+userName+" "+password+" ");
                String msg = "" + firstName;
                msg += " \n";

                JOptionPane.showMessageDialog(btnNewButton,
                        "Welcome, " + msg + "Your account is sucessfully created"+"\n Please close this session and login again");

                dispose();

            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(399, 350, 259, 74);
        contentPane.add(btnNewButton);

        btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                new Stu_login();
                dispose();

            }
        });
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnLogin.setBounds(399, 475, 259, 74);
        contentPane.add(btnLogin);


        JLabel lblOR = new JLabel("OR");
        lblOR.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblOR.setBounds(510, 427, 99, 43);
        contentPane.add(lblOR);

        this.setVisible(true);
    }
}