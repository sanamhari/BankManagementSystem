package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{
    
    JButton back;
    String pinNumber;
    
    BalanceEnquiry(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(690, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 690, 645);
        add(image);
        
        back = new JButton("BACK");
        back.setBounds(290, 405, 100, 20);
        back.setFont(new Font("System", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);
        
        Conn c = new Conn();
        int balance = 0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where PIN = '"+pinNumber+"'");
            while(rs.next()) {
                if(rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                }else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
             }
        }catch(Exception e) {
            System.out.println(e);
        }
        
        JLabel text = new JLabel("Your Current Account Balance is Rs. " +balance);
        text.setBounds(120, 230, 620, 15);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 12));
        image.add(text);
        
        
        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    
    public static void main(String args[]) {
        new BalanceEnquiry("");
    }
}
