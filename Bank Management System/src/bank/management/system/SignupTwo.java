package bank.management.system;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class SignupTwo extends JFrame implements ActionListener{
    
    JLabel additionalDetails, rel, cate, inc, educ, qual, occu, pan, aadhar, seniorCit, exist ;
    JTextField panNumberTextField, aadharNumberTextField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox religions, categories, annualIncome, education, occupations;
    String formno;
    SignupTwo(String formno) {
        
        this.formno = formno;
        setLayout(null);
        
        setTitle("NEW ACCOUNT APLLICATION FORM - PAGE 2");
        
        additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Times New Roman", Font.BOLD, 22));
        additionalDetails.setBounds(290, 80, 400, 30);
        add(additionalDetails);
        
        rel = new JLabel("Religion:");
        rel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        rel.setBounds(100, 140, 100, 30);
        add(rel);
        
        String valReligion[] = {"Hindu", "Muslim", "Christian", "Sikh", "Other"};
        religions = new JComboBox(valReligion);
        religions.setBounds(300, 140, 400, 30);
        religions.setBackground(Color.WHITE);
        religions.setFont(new Font("Raleway", Font.BOLD, 14));
        add(religions);
        
        cate = new JLabel("Category:");
        cate.setFont(new Font("Times New Roman", Font.BOLD, 20));
        cate.setBounds(100, 180, 200, 30);
        add(cate);
        
        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categories = new JComboBox(valCategory);
        categories.setBounds(300, 180, 400, 30);
        categories.setBackground(Color.WHITE);
        categories.setFont(new Font("Raleway", Font.BOLD, 14));
        add(categories);
        
        inc = new JLabel("Income:");
        inc.setFont(new Font("Times New Roman", Font.BOLD, 20));
        inc.setBounds(100, 220, 200, 30);
        add(inc);
        
        String valIncome[] = {"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000","Above 10,00,000"};
        annualIncome = new JComboBox(valIncome);
        annualIncome.setBounds(300, 220, 400, 30);
        annualIncome.setBackground(Color.WHITE);
        annualIncome.setFont(new Font("Raleway", Font.BOLD, 14));
        add(annualIncome);
        
        educ = new JLabel("Educational");
        educ.setFont(new Font("Times New Roman", Font.BOLD, 20));
        educ.setBounds(100, 260, 200, 30);
        add(educ);
        
        qual = new JLabel("Qualification:");
        qual.setFont(new Font("Times New Roman", Font.BOLD, 20));
        qual.setBounds(100, 280, 200, 30);
        add(qual);
        
        String educationalValues[] = {"Non-Graduate", "Graduate", "Post Graduate", "Doctrate", "Class XII/Diploma", "Class X", "Other"};
        education = new JComboBox(educationalValues);
        education.setBounds(300, 280, 400, 30);
        education.setBackground(Color.WHITE);
        education.setFont(new Font("Raleway", Font.BOLD, 14));
        add(education);
        
        
        occu = new JLabel("Occupation:");
        occu.setFont(new Font("Times New Roman", Font.BOLD, 20));
        occu.setBounds(100, 320, 200, 30);
        add(occu);
        
        String occupationValues[] = {"Self-Employed", "Salaried", "Business", "Student", "Unemployed", "Other"};
        occupations = new JComboBox(occupationValues);
        occupations.setBounds(300, 320, 400, 30);
        occupations.setBackground(Color.WHITE);
        occupations.setFont(new Font("Raleway", Font.BOLD, 14));
        add(occupations);
  
       
        pan = new JLabel("PAN Number:");
        pan.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.setBounds(100, 360, 200, 30);
        add(pan);
        
        panNumberTextField = new JTextField();
        panNumberTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        panNumberTextField.setBounds(300, 360, 400, 30);
        add(panNumberTextField);
        
        ((AbstractDocument) panNumberTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            private final int MAX_LENGTH = 10;

            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) return;
                string = string.toUpperCase();
                if (isValidInput(fb.getDocument().getLength(), string)) {
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) return;
                text = text.toUpperCase();
                if (isValidInput(fb.getDocument().getLength() - length, text)) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            private boolean isValidInput(int currentLength, String text) {
                return (currentLength + text.length() <= MAX_LENGTH) && text.matches("[A-Z0-9]+");
            }
        });
        
        aadhar = new JLabel("Aadhar Number:");
        aadhar.setFont(new Font("Times New Roman", Font.BOLD, 20));
        aadhar.setBounds(100, 400, 200, 30);
        add(aadhar);
        
        aadharNumberTextField = new JTextField();
        aadharNumberTextField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharNumberTextField.setBounds(300, 400, 400, 30);
        add(aadharNumberTextField);
        
        ((AbstractDocument) aadharNumberTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if ((fb.getDocument().getLength() + text.length() - length) <= 12 && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if ((fb.getDocument().getLength() + text.length()) <= 12 && text.matches("\\d+")) {
                    super.insertString(fb, offset, text, attr);
                }
            }
        });

        // Validate Aadhar format when focus is lost
        aadharNumberTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if (aadharNumberTextField.getText().length() != 12) {
                    JOptionPane.showMessageDialog(null, "Aadhar Number must be exactly 12 digits!", "Error", JOptionPane.ERROR_MESSAGE);
                    aadharNumberTextField.setText(""); // Clear invalid input
                }
            }
        });
        
        seniorCit = new JLabel("Senior Citizen:");
        seniorCit.setFont(new Font("Times New Roman", Font.BOLD, 20));
        seniorCit.setBounds(100, 440, 200, 30);
        add(seniorCit);
        
        syes = new JRadioButton("Yes");
        syes.setBounds(300, 440, 100, 30);
        syes.setBackground(Color.WHITE);
        syes.setFont(new Font("Raleway", Font.BOLD, 14));
        add(syes);
        
        sno = new JRadioButton("No");
        sno.setBounds(450, 440, 100, 30);
        sno.setBackground(Color.WHITE);
        sno.setFont(new Font("Ralway", Font.BOLD, 14));
        add(sno);
        
        
        ButtonGroup seniorCitizens = new ButtonGroup();
        seniorCitizens.add(syes);
        seniorCitizens.add(sno);
        
        exist = new JLabel("Existing Account:");
        exist.setFont(new Font("Times New Roman", Font.BOLD, 20));
        exist.setBounds(100, 480, 200, 30);
        add(exist);
        
        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 480, 100, 30);
        eyes.setBackground(Color.WHITE);
        eyes.setFont(new Font("Raleway", Font.BOLD, 14));
        add(eyes);
        
        eno = new JRadioButton("No");
        eno.setBounds(450, 480, 100, 30);
        eno.setBackground(Color.WHITE);
        eno.setFont(new Font("Raleway", Font.BOLD, 14));
        add(eno);
        
        ButtonGroup exisitingAccs = new ButtonGroup();
        exisitingAccs.add(eyes);
        exisitingAccs.add(eno);
       
        next = new JButton("Next");
        next.setBackground(Color.CYAN);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Times New Roman", Font.BOLD, 14));
        next.setBounds(620, 550, 80, 30);
        next.addActionListener(this);
        add(next);
       
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String religion = (String)religions.getSelectedItem();
        String category = (String)categories.getSelectedItem();
        String income = (String)annualIncome.getSelectedItem();
        String educational = (String)education.getSelectedItem();
        String occupation = (String) occupations.getSelectedItem();
        
        String seniorCitizen = null;
        if(syes.isSelected()) {
            seniorCitizen = "Yes";
        } else if(sno.isSelected()) {
            seniorCitizen = "No";
        }
       
        String existingAcc = null;
        if(eyes.isSelected()) {
            existingAcc = "Yes";
        }else if (eno.isSelected()) {
            existingAcc = "No";
        }
        
        String panNumber = panNumberTextField.getText();
        String aadharNumber = aadharNumberTextField.getText();
        
        try {
            if(aadharNumberTextField.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Fill the all reuired fields!");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signupTwo values('"+formno+"', '"+religion+"', '"+category+"', '"+income+"', '"+educational+"', '"+occupation+"', '"+panNumber+"', '"+aadharNumber+"', '"+seniorCitizen+"', '"+existingAcc+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupTwo("");
  } 
}
