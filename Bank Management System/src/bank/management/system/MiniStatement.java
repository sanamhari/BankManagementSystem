package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    
    MiniStatement(String pinNumber) {
        setTitle("Mini Statement");
        
        setLayout(null);
        
        JLabel bank = new JLabel("UNION BANK");
        bank.setBounds(150, 20, 100, 20);
        add(bank);
        
        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel mini = new JLabel();
        mini.setBounds(20, 140, 400, 200);
        add(mini);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);
        
        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from login where PIN_NUMBER = '"+pinNumber+"'");
            while(rs.next()) {
                card.setText("Card Number: "+ rs.getString("CARD_NUMBER").substring(0, 4) + "XXXXXXXX" + rs.getString("CARD_NUMBER").substring(12));
            }
        } catch(Exception e) {
            System.out.println(e);
        }
       
        
        try {
            Conn conn = new Conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where PIN = '"+pinNumber+"'");
            while(rs.next()) {
                mini.setText(mini.getText()+ "<html>" + rs.getString("DATE") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("TYPE") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("AMOUNT") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")) {
                    bal += Integer.parseInt(rs.getString("amount"));
                }else {
                    bal -= Integer.parseInt(rs.getString("amount"));
                }
            }
            balance.setText("Your current Account Balance is Rs. " + bal);
        } catch(Exception e) {
            System.out.println(e);
        }
        
        setSize(400, 600);
        setLocation(50, 50);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    } 
    public static void main(String args[]) {
        new MiniStatement("");
    }
}
