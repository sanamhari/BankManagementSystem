package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.util.regex.Pattern;
import javax.swing.text.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long random;
    JTextField nameTextField, fnameTextField, emailTextField, mobileNoTextField, addressTextField, cityTextField, stateTextField, pincodeTextField;
    JButton next;
    JRadioButton male, female, other, married, unmarried, others;
    JDateChooser dateChooser;
    
    SignupOne() {
        
        setLayout(null);
        
        Random r = new Random();
        random = Math.abs((r.nextLong() % 9000L) + 1000L);
        
        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Times New Roman", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);
        
        JLabel personalDetails = new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Times New Roman", Font.BOLD, 22));
        personalDetails.setBounds(290, 80, 400, 30);
        add(personalDetails);
        
        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Times New Roman", Font.BOLD, 20));
        name.setBounds(100, 140, 100, 30);
        add(name);
        
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        nameTextField.setBounds(300, 140, 400, 30);
        add(nameTextField);
        
        JLabel fathersname = new JLabel("Father's Name:");
        fathersname.setFont(new Font("Times New Roman", Font.BOLD, 20));
        fathersname.setBounds(100, 180, 200, 30);
        add(fathersname);
        
        fnameTextField = new JTextField();
        fnameTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        fnameTextField.setBounds(300, 180, 400, 30);
        add(fnameTextField);
        
        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Times New Roman", Font.BOLD, 20));
        dob.setBounds(100, 220, 200, 30);
        add(dob);
        
        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 220, 200, 30);
        dateChooser.setForeground(new Color(105, 105, 105));
        add(dateChooser);
        
        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Times New Roman", Font.BOLD, 20));
        gender.setBounds(100, 260, 200, 30);
        add(gender);
        
        male = new JRadioButton("Male");
        male.setBounds(300, 260, 60, 30);
        male.setBackground(Color.WHITE);
        male.setFont(new Font("Verdana", Font.BOLD, 12));
        add(male);
        
        female = new JRadioButton("Female");
        female.setBounds(450, 260, 120, 30);
        female.setBackground(Color.WHITE);
        female.setFont(new Font("Verdana", Font.BOLD, 12));
        add(female);
        
        other = new JRadioButton("Other");
        other.setBounds(600, 260, 180, 30);
        other.setBackground(Color.WHITE);
        other.setFont(new Font("Verdana", Font.BOLD, 12));
        add(other);
        
        ButtonGroup gendergroup = new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        gendergroup.add(other);
        
        JLabel email = new JLabel("Email ID:");
        email.setFont(new Font("Times New Roman", Font.BOLD, 20));
        email.setBounds(100, 300, 200, 30);
        add(email);
        
        emailTextField = new JTextField();
        emailTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        emailTextField.setBounds(300, 300, 400, 30);
        add(emailTextField);
         ((AbstractDocument) emailTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[a-zA-Z0-9@._-]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }

            @Override
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if (text.matches("[a-zA-Z0-9@._-]+")) {
                    super.insertString(fb, offset, text, attr);
                }
            }
        });
         
        emailTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {}

            @Override
            public void focusLost(FocusEvent e) {
                if (!isValidEmail(emailTextField.getText())) {
                    JOptionPane.showMessageDialog(null, "Invalid Email ID!", "Error", JOptionPane.ERROR_MESSAGE);
                    emailTextField.setText(""); // Clear invalid input
                }
            }
            private boolean isValidEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
            Pattern pattern = Pattern.compile(emailRegex);
            return pattern.matcher(email).matches();
            }
        });
         
        
        JLabel mobileNo = new JLabel("Mobile Number:");
        mobileNo.setFont(new Font("Times New Roman", Font.BOLD, 20));
        mobileNo.setBounds(100, 340, 200, 30);
        add(mobileNo);
        
        mobileNoTextField = new JTextField();
        mobileNoTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        mobileNoTextField.setBounds(300, 340, 200, 30);
        add(mobileNoTextField);
        ((AbstractDocument) mobileNoTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if ((fb.getDocument().getLength() + text.length() - length) <= 10 && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if ((fb.getDocument().getLength() + text.length()) <= 10 && text.matches("\\d+")) {
                    super.insertString(fb, offset, text, attr);
                }
            }
        });
        
        JLabel mstatus = new JLabel("Marital Status:");
        mstatus.setFont(new Font("Times New Roman", Font.BOLD, 20));
        mstatus.setBounds(100, 380, 200, 30);
        add(mstatus);
        
        married = new JRadioButton("Married");
        married.setBounds(300, 380, 100, 30);
        married.setBackground(Color.WHITE);
        married.setFont(new Font("Verdana", Font.BOLD, 12));
        add(married);
        
        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 380, 100, 30);
        unmarried.setBackground(Color.WHITE);
        unmarried.setFont(new Font("Verdana", Font.BOLD, 12));
        add(unmarried);
        
        others = new JRadioButton("Others");
        others.setBounds(600, 380, 100, 30);
        others.setBackground(Color.WHITE);
        others.setFont(new Font("Verdana", Font.BOLD, 12));
        add(others);
        
        ButtonGroup mstatusgroup = new ButtonGroup();
        mstatusgroup.add(married);
        mstatusgroup.add(unmarried);
        mstatusgroup.add(others);
        
        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Times New Roman", Font.BOLD, 20));
        address.setBounds(100, 420, 200, 30);
        add(address);
        
        addressTextField = new JTextField();
        addressTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        addressTextField.setBounds(300, 420, 400, 30);
        add(addressTextField);
        
        JLabel city = new JLabel("City:");
        city.setFont(new Font("Times New Roman", Font.BOLD, 20));
        city.setBounds(100, 460, 200, 30);
        add(city);
        
        cityTextField = new JTextField();
        cityTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        cityTextField.setBounds(300, 460, 400, 30);
        add(cityTextField);
        
        JLabel state = new JLabel("State:");
        state.setFont(new Font("Times New Roman", Font.BOLD, 20));
        state.setBounds(100, 500, 200, 30);
        add(state);
        
        stateTextField = new JTextField();
        stateTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        stateTextField.setBounds(300, 500, 400, 30);
        add(stateTextField);
        
        JLabel pincode = new JLabel("Pincode:");
        pincode.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pincode.setBounds(100, 540, 200, 30);
        add(pincode);
        
        pincodeTextField = new JTextField();
        pincodeTextField.setFont(new Font("Verdana", Font.BOLD, 14));
        pincodeTextField.setBounds(300, 540, 200, 30);
        add(pincodeTextField);
        ((AbstractDocument) pincodeTextField.getDocument()).setDocumentFilter(new DocumentFilter() {
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if ((fb.getDocument().getLength() + text.length() - length) <= 6 && text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
            public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
                if ((fb.getDocument().getLength() + text.length()) <= 6 && text.matches("\\d+")) {
                    super.insertString(fb, offset, text, attr);
                }
            }
        });
        
        next = new JButton("Next");
        next.setBackground(Color.CYAN);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Times New Roman", Font.BOLD, 14));
        next.setBounds(620, 600, 80, 30);
        next.addActionListener(this);
        add(next);
       
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850, 800);
        setLocation(300, 10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        String formno = "" + random;
        String name = nameTextField.getText();
        String fname = fnameTextField.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        
        String gender = null;
        if(male.isSelected()) {
            gender = "Male";
        } else if(female.isSelected()) {
            gender = "Female";
        } else if(other.isSelected()) {
            gender = "Other";
        }
        
        String email = emailTextField.getText();
        String mobile = mobileNoTextField.getText();
        
        String mstatus = null;
        if(married.isSelected()) {
            mstatus = "Married";
        }else if (unmarried.isSelected()) {
            mstatus = "Unmarried";
        } else if (others.isSelected()){
            mstatus = "Others";
        }
        
        String address = addressTextField.getText();
        String city = cityTextField.getText();
        String state = stateTextField.getText();
        String pincode = pincodeTextField.getText();
        
        try {
            if(name.equals("")) {
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(fname.equals("")) {
                JOptionPane.showMessageDialog(null, "Father's Name is Required");
            }
            else if(dob.equals("")) {
                JOptionPane.showMessageDialog(null, "DOB is Required");
            }
            else if(email.equals("")) {
                JOptionPane.showMessageDialog(null, "Email ID is Required");
            }
            else if(mobile.equals("")) {
                JOptionPane.showMessageDialog(null, "Mobile Number is Required");
            }
            else if(address.equals("")) {
                JOptionPane.showMessageDialog(null, "Address is Required");
            }
            else if(city.equals("")) {
                JOptionPane.showMessageDialog(null, "City is Required");
            }
            else if(state.equals("")) {
                JOptionPane.showMessageDialog(null, "State is Required");
            }
            else if(pincode.equals("")) {
                JOptionPane.showMessageDialog(null, "Pincode is Required");
            }
            else
            {
                Conn c = new Conn();
                String query = "insert into signupone values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+mobile+"', '"+mstatus+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"')";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public static void main(String args[]) {
        new SignupOne();
  } 
}
