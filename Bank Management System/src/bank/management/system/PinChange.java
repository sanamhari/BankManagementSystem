package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener{
    
    JPasswordField newPin, reNewPin;
    JButton change,back;
    String pinNumber;
    
    PinChange(String pinNumber) {
        this.pinNumber = pinNumber;
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/ATM.jpg"));
        Image i2 = i1.getImage().getScaledInstance(690, 645, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 690, 645);
        add(image);
        
        JLabel text = new JLabel("Change Your PIN");
        text.setBounds(150, 230, 620, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 14));
        image.add(text);
        
        JLabel pinText = new JLabel("New PIN:");
        pinText.setBounds(120, 270, 300, 25);
        pinText.setForeground(Color.WHITE);
        pinText.setFont(new Font("System", Font.BOLD, 14));
        image.add(pinText);
        
        newPin = new JPasswordField();
        newPin.setFont(new Font("Verdana", Font.BOLD, 16));
        newPin.setBounds(260, 270, 130, 25);
        image.add(newPin);
        
        JLabel rePinText = new JLabel("Re-Enter New PIN:");
        rePinText.setBounds(120, 310, 300, 25);
        rePinText.setForeground(Color.WHITE);
        rePinText.setFont(new Font("System", Font.BOLD, 14));
        image.add(rePinText);
        
        reNewPin = new JPasswordField();
        reNewPin.setFont(new Font("Verdana", Font.BOLD, 16));
        reNewPin.setBounds(260, 310, 130, 25);
        image.add(reNewPin);
        
        change = new JButton("CHANGE");
        change.setBounds(290, 375, 100, 20);
        change.setFont(new Font("System", Font.BOLD, 12));
        change.addActionListener(this);
        image.add(change);
        
        back = new JButton("BACK");
        back.setBounds(290, 405, 100, 20);
        back.setFont(new Font("System", Font.BOLD, 12));
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(700, 700);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource() == change) {
            try {
                String nPin = newPin.getText();
                String rPin = reNewPin.getText();

                if(!nPin.equals(rPin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match!!");
                    return;
                }
                
                if(nPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN!!");
                    return;
                }
                
                if(rPin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please  re-enter New PIN!!");
                    return;
                }
                
                Conn conn = new Conn();
                String query1 = "update bank set PIN = '"+rPin+"' where PIN = '"+pinNumber+"'";
                String query2 = "update login set PIN_NUMBER = '"+rPin+"' where PIN_NUMBER = '"+pinNumber+"'";
                String query3 = "update signupthree set PIN_NUMBER = '"+rPin+"' where PIN_NUMBER = '"+pinNumber+"'";
                
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");
                
                setVisible(false);
                new Transactions(rPin).setVisible(true);
                
            } catch(Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
    }
}
