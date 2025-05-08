package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JButton signin, signup, clear;
    JTextField cardTextField;
    JPasswordField pinTextField;
    
    Login() {
        
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/Logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);
        
        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Times New Roman", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 40);
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(300, 150, 230, 30);
        cardTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 28));
        pin.setBounds(120, 220, 250, 30);
        add(pin);
        
        pinTextField = new JPasswordField();
        pinTextField.setBounds(300, 220, 230, 30);
        pinTextField.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinTextField);
        add(pinTextField);
        
        signin = new JButton("SIGN IN");
        signin.setBounds(300, 300, 100, 30);
        signin.setBackground(Color.GREEN);
        signin.setForeground(Color.BLACK);
        signin.addActionListener(this);
        add(signin);
        
        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(Color.CYAN);
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800, 480);
        setVisible(true);
        setLocation(250, 170);
    }
    public void actionPerformed(ActionEvent ae){
      if(ae.getSource() == clear) {
          cardTextField.setText("");
          pinTextField.setText("");
      } else if(ae.getSource() == signin) {
          Conn conn = new Conn();
          String cardNumber = cardTextField.getText();
          String pinNumber = pinTextField.getText();
          String query = "select * from login where CARD_NUMBER = '"+cardNumber+"' and PIN_NUMBER = '"+pinNumber+"'";
          try {
              ResultSet rs = conn.s.executeQuery(query);
              if(rs.next()) {
                  setVisible(false);
                  new Transactions(pinNumber).setVisible(true);
              } else {
                  JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
              }
          } catch (Exception e) {
              System.out.println(e);
          }
          
      } else if(ae.getSource() == signup) {
          setVisible(false);
          new SignupOne().setVisible(true);
      }
    }
    public static void main(String args[]) {
         new Login();
    }
}
