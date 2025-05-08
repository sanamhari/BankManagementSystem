package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdraw, back;
    String pinNumber;
    
    Withdrawl (String pinNumber) {
        
        this.pinNumber = pinNumber; 
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(690, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 690, 645);
        add(image);
        
        JLabel text = new JLabel("Enter the amount you want to Withdraw");
        text.setBounds(130, 230, 330, 20);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(130, 280, 260, 25);
        image.add(amount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(290, 375, 100, 25);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(290, 400, 100, 25);
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 700);
        setLocation(300, 0);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == withdraw) {
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to withdraw");
            }else {
                try {
                Conn conn = new Conn();
                String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+number+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs " +number+" Withdraw Successfully");
                setVisible(false);
                new Transactions(pinNumber).setVisible(true);
               } catch (Exception e) {
                System.out.println(e);
               }
            }
        } else if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new Withdrawl("");
    }
}
