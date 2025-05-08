package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton hundred, fiveHundred, thousand, twoThousand, fiveThousand, tenThousand, back;
    String pinNumber;
    
    FastCash (String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(690, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 690, 645);
        add(image);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(150, 230, 620, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        hundred = new JButton("Rs 100");
        hundred.setBounds(130, 325, 100, 20);
        hundred.setFont(new Font("System", Font.BOLD, 12));
        hundred.addActionListener(this);
        image.add(hundred);
        
        fiveHundred = new JButton("Rs 500");
        fiveHundred.setBounds(290, 325, 100, 20);
        fiveHundred.setFont(new Font("System", Font.BOLD, 12));
        fiveHundred.addActionListener(this);
        image.add(fiveHundred);
        
        thousand = new JButton("Rs 1000");
        thousand.setBounds(130, 350, 100, 20);
        thousand.setFont(new Font("System", Font.BOLD, 12));
        thousand.addActionListener(this);
        image.add(thousand);
        
        twoThousand = new JButton("Rs 2000");
        twoThousand.setBounds(290, 350, 100, 20);
        twoThousand.setFont(new Font("System", Font.BOLD, 12));
        twoThousand.addActionListener(this);
        image.add(twoThousand);
        
        fiveThousand = new JButton("Rs 5000");
        fiveThousand.setBounds(130, 375, 100, 20);
        fiveThousand.setFont(new Font("System", Font.BOLD, 12));
        fiveThousand.addActionListener(this);
        image.add(fiveThousand);
        
        tenThousand = new JButton("Rs 10000");
        tenThousand.setBounds(290, 375, 100, 20);
        tenThousand.setFont(new Font("System", Font.BOLD, 12));
        tenThousand.addActionListener(this);
        image.add(tenThousand);
        
        back = new JButton("Back");
        back.setBounds(290, 400, 100, 20);
        back.setFont(new Font("System", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);
        
        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == back) {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }else {
            String amount = ((JButton) ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try {
               ResultSet rs = c.s.executeQuery("select * from bank where PIN = '"+pinNumber+"'");
               int balance = 0;
               while(rs.next()) {
                   if(rs.getString("type").equals("Deposit")) {
                       balance += Integer.parseInt(rs.getString("amount"));
                   }else {
                       balance -= Integer.parseInt(rs.getString("amount"));
                   }
               }
               
               if(ae.getSource() != back && balance < Integer.parseInt(amount)) {
                   JOptionPane.showMessageDialog(null, "Insufficient Balance");
                   return;
               }
               
               Date date = new Date();
               String query = "insert into bank values('"+pinNumber+"', '"+date+"', 'Withdrawl', '"+amount+"')";
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Rs "+amount+" Debited Successfully");
               
               setVisible(false);
               new Transactions(pinNumber).setVisible(true);
               
            } catch(Exception e) {
                System.out.println(e);
            }
        }
    }
    
    public static void main(String args[]) {
        new FastCash("");
    }
    
}
