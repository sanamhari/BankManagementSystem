package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton savingsAcc, fixedDipositAcc, currentAcc, reccuringDepositAcc; 
    JCheckBox atmCard, internetBanking, mobileBanking,emailSMSAlerts, chequeBook, eStatement, declaration;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        
        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 24));
        l1.setBounds(280,40, 400, 40);
        add(l1);
        
        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Times New Roman", Font.BOLD, 22));
        type.setBounds(100, 100, 200, 30);
        add(type);
        
        savingsAcc = new JRadioButton("Savings Account");
        savingsAcc.setFont(new Font("Times New Roman", Font.BOLD, 16));
        savingsAcc.setBackground(Color.WHITE);
        savingsAcc.setBounds(100, 140, 150, 20);
        add(savingsAcc);
        
        fixedDipositAcc = new JRadioButton("Fixed Deposit Account");
        fixedDipositAcc.setFont(new Font("Times New Roman", Font.BOLD, 16));
        fixedDipositAcc.setBackground(Color.WHITE);
        fixedDipositAcc.setBounds(350, 140, 250, 20);
        add(fixedDipositAcc);
        
        currentAcc = new JRadioButton("Current Account");
        currentAcc.setFont(new Font("Times New Roman", Font.BOLD, 16));
        currentAcc.setBackground(Color.WHITE);
        currentAcc.setBounds(100, 180, 150, 20);
        add(currentAcc);
        
        reccuringDepositAcc = new JRadioButton("Recurring Deposit Account");
        reccuringDepositAcc.setFont(new Font("Times New Roman", Font.BOLD, 16));
        reccuringDepositAcc.setBackground(Color.WHITE);
        reccuringDepositAcc.setBounds(350, 180, 250, 20);
        add(reccuringDepositAcc);
        
        ButtonGroup account = new ButtonGroup();
        account.add(savingsAcc);
        account.add(fixedDipositAcc);
        account.add(currentAcc);
        account.add(reccuringDepositAcc);
        
        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Times New Roman", Font.BOLD, 22));
        card.setBounds(100, 220, 200, 30);
        add(card);
        
        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Times New Roman", Font.BOLD, 20));
        number.setBounds(330, 220, 300, 30);
        add(number);
        
        JLabel carddetail = new JLabel("Your 16 Digit Card Number");
        carddetail.setFont(new Font("Times New Roman", Font.BOLD, 12));
        carddetail.setBounds(100, 250, 300, 20);
        add(carddetail);
        
        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 22));
        pin.setBounds(100, 280, 200, 30);
        add(pin);
        
        JLabel pinNumber = new JLabel("XXXX");
        pinNumber.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pinNumber.setBounds(330, 280, 200, 30);
        add(pinNumber);
        
        JLabel pindetail = new JLabel("Your 4 Digit Password");
        pindetail.setFont(new Font("Times New Roman", Font.BOLD, 12));
        pindetail.setBounds(100, 310, 300, 20);
        add(pindetail);
        
        JLabel services = new JLabel("Services Required:");
        services.setFont(new Font("Times New Roman", Font.BOLD, 22));
        services.setBounds(100, 350, 400, 22);
        add(services);
        
        atmCard = new JCheckBox("ATM Card");
        atmCard.setBackground(Color.WHITE);
        atmCard.setFont(new Font("Times New Roman", Font.BOLD, 16));
        atmCard.setBounds(100, 390, 200, 30);
        add(atmCard);
        
        internetBanking = new JCheckBox("Internet Banking");
        internetBanking.setBackground(Color.WHITE);
        internetBanking.setFont(new Font("Times New Roman", Font.BOLD, 16));
        internetBanking.setBounds(350, 390, 200, 30);
        add(internetBanking);
        
        mobileBanking = new JCheckBox("Mobile Banking");
        mobileBanking.setBackground(Color.WHITE);
        mobileBanking.setFont(new Font("Times New Roman", Font.BOLD, 16));
        mobileBanking.setBounds(350, 430, 200, 30);
        add(mobileBanking);
        
        emailSMSAlerts = new JCheckBox("Email & SMS Alerts");
        emailSMSAlerts.setBackground(Color.WHITE);
        emailSMSAlerts.setFont(new Font("Times New Roman", Font.BOLD, 16));
        emailSMSAlerts.setBounds(100, 430, 200, 30);
        add(emailSMSAlerts);
       
        chequeBook = new JCheckBox("Cheque Book");
        chequeBook.setBackground(Color.WHITE);
        chequeBook.setFont(new Font("Times New Roman", Font.BOLD, 16));
        chequeBook.setBounds(350, 470, 200, 30);
        add(chequeBook);
        
        eStatement = new JCheckBox("E-Statement");
        eStatement.setBackground(Color.WHITE);
        eStatement.setFont(new Font("Times New Roman", Font.BOLD, 16));
        eStatement.setBounds(100, 470, 200, 30);
        add(eStatement);
        
        declaration = new JCheckBox("I hereby declares that the above entered details are correct to the best of my knowledge");
        declaration.setBackground(Color.WHITE);
        declaration.setFont(new Font("Times New Roman", Font.BOLD, 14));
        declaration.setBounds(100, 520, 600, 30);
        add(declaration);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.CYAN);
        submit.setForeground(Color.BLACK);
        submit.setFont(new Font("Times New Roman", Font.BOLD, 14));
        submit.setBounds(250, 570, 100, 30);
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.RED);
        cancel.setForeground(Color.BLACK);
        cancel.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cancel.setBounds(420, 570, 100, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == submit) {
            String accountType = null;
            if(savingsAcc.isSelected()) {
                accountType = "Saving Account";
            } else if(fixedDipositAcc.isSelected()) {
                accountType = "Fixed Deposit Account";
            } else if(currentAcc.isSelected()) {
                accountType = "Current Account";
            } else if(reccuringDepositAcc.isSelected()) {
                accountType = "Reccuring Deposit Account";
            }
            
            Random random = new Random();
            String cardNumber = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            
            String pinNumber = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            
            String facility = "";
            
            if(atmCard.isSelected()) {
                facility += " ATM Card, ";
            } if(internetBanking.isSelected()) {
                facility += " Internet Banking, ";
            } if(mobileBanking.isSelected()) {
                facility += " Moblie Banking, ";
            } if(emailSMSAlerts.isSelected()) {
                facility += " Email & SMS Alerts, ";
            } if(chequeBook.isSelected()) {
                facility += " Cheque Book, ";
            } if(eStatement.isSelected()) {
                facility += " E-Statement, ";
            }
            
            if(!facility.isEmpty()) {
                facility = facility.substring(0, facility.length() - 2);
            }
            
            
            try {
                if(accountType.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    Conn conn = new Conn();
                    String query1 = "insert into signupthree values('"+formno+"', '"+accountType+"', '"+cardNumber+"', '"+pinNumber+"','"+facility+"')";  
                    String query2 = "insert into login values('"+formno+"', '"+cardNumber+"', '"+pinNumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardNumber + "\n Pin: " + pinNumber);
                    
                    setVisible(false);
                    new Deposit(pinNumber).setVisible(false);
                }
          
                
            } catch (Exception e) {
                System.out.println(e);
            }
            
        } else if(ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    public static void main(String args[]) {
        new SignupThree("");
    }
}
