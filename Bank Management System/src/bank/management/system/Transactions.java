package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Transactions extends JFrame implements ActionListener {

    JButton deposit, withdrawl, fastCash, statement, pinChange, balanceEnquiry, exit;
    String pinNumber;
    
    Transactions(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(690, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 690, 645);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(150, 230, 620, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(130, 325, 100, 20);
        deposit.setFont(new Font("System", Font.BOLD, 10));
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl = new JButton("Withdrawal");
        withdrawl.setBounds(290, 325, 100, 20);
        withdrawl.setFont(new Font("System", Font.BOLD, 10));
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(130, 350, 100, 20);
        fastCash.setFont(new Font("System", Font.BOLD, 10));
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        statement = new JButton("Statement");
        statement.setBounds(290, 350, 100, 20);
        statement.setFont(new Font("System", Font.BOLD, 10));
        statement.addActionListener(this);
        image.add(statement);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(130, 375, 100, 20);
        pinChange.setFont(new Font("System", Font.BOLD, 10));
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("Balance Enquiry");
        balanceEnquiry.setBounds(290, 375, 100, 20);
        balanceEnquiry.setFont(new Font("System", Font.BOLD, 10));
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);
        
        exit = new JButton("Exit");
        exit.setBounds(290, 400, 100, 20);
        exit.setFont(new Font("System", Font.BOLD, 10));
        exit.addActionListener(this);
        image.add(exit);
        
        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == exit) {
            System.exit(0);
        } else if(ae.getSource() == deposit) {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        } else if(ae.getSource() == withdrawal) {
            setVisible(false); 
            new Withdrawal(pinNumber).setVisible(true); 
        } else if(ae.getSource() == fastCash) {
            setVisible(false); 
            new FastCash(pinNumber).setVisible(true); 
        }  else if(ae.getSource() == pinChange) {
            setVisible(false); 
            new PinChange(pinNumber).setVisible(true); 
        }  else if(ae.getSource() == balanceEnquiry) {
            setVisible(false); 
            new BalanceEnquiry(pinNumber).setVisible(true); 
        }  else if(ae.getSource() == statement) {
            setVisible(false); 
            new MiniStatement(pinNumber).setVisible(true); 
        }  
    }
    
    public static void main(String args[]) {
        new Transactions("");
    }
    
}
