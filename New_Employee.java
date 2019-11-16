/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.*;
import java.util.Scanner;


/**
 *
 * @author hency sethi
 */

public class New_Employee extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c1,c2;
    String Email;
    
    New_Employee(){
        
        super("New Employee");
        
        setSize(600,650);
        setLocation(400,70);
        getContentPane().setBackground(Color.WHITE);
        
        JPanel p1= new JPanel();
        p1.setBackground(Color.WHITE);
      
        p1.setLayout(new GridLayout(8,2,10,40));
        l1 = new JLabel("Name");
        t1 = new JTextField(15);
        p1.add(l1);
        p1.add(t1);
       
        c1 = new Choice();
        c1.add("Male");
        c1.add("Female");
        c1.add("Others");
        
         c2= new Choice();
        c2.add("Andhra Pradesh");
        c2.add("Arunachal Pradesh");
        c2.add("Assam");
        c2.add("Bihar");
        c2.add("Chhattisgarh");
        c2.add("Goa");
        c2.add("Gujarat");
        c2.add("Haryana");
        c2.add("Himachal Pradesh");
        c2.add("Jammu Kashmir");
        c2.add("Jharkhand");
        c2.add("Karnataka");
        c2.add("Kerala");
        c2.add("Madhya Pradesh");
        c2.add("Maharashtra");
        c2.add("Manipur");
        c2.add("Meghalay");
        c2.add("Mizoram");
        c2.add("Nagaland");
        c2.add("Odisha");
        c2.add("Punjab");
        c2.add("Rajasthan");
        c2.add("Sikkim");
        c2.add("Tamil Nadu");
        c2.add("Telangana");
        c2.add("Tripura");
        c2.add("Uttar Pradesh");
        c2.add("Uttarakhad");
        c2.add("WestBengal");
       
        l2 = new JLabel("Gender");
        p1.add(l2);
        p1.add(c1);
        l3 = new JLabel("Address");
        t3 = new JTextField(15);
        p1.add(l3);
        p1.add(t3);
        l4 = new JLabel("State");
        t4 = new JTextField(15);
        p1.add(l4);
       // p1.add(t4); 
        p1.add(c2);
        l5 = new JLabel("City");
        t5 = new JTextField(15);
        p1.add(l5);
        p1.add(t5);
        l6 = new JLabel("Email");
        t6 = new JTextField(15);
        p1.add(l6);
        p1.add(t6);
        l7 = new JLabel("Phone");
        t7= new JTextField(15);
        p1.add(l7);
        p1.add(t7);
        b1 =new JButton("Submit");
        b2 = new JButton("Cancel");
        p1.add(b1);
        p1.add(b2);
       
        setLayout(new BorderLayout());
        add(new JLabel(new ImageIcon(ClassLoader.getSystemResource("payroll/icons/new_employee.png"))),"West");
        add(p1,"Center");
       
        b1.addActionListener(this);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2.addActionListener(this);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
       
    }
    public static boolean isValid(String Email)
    {
        String emailRegex= "^[_A-Za-z0-9-\\+]+(\\.Email[_A-Za-z0-9-]+)*@"
                             + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pat=Pattern.compile(emailRegex);
        if(Email==null)
            return false;
        return pat. matcher(Email).matches();
    }
   
    public static boolean isPhonenumberValid(String s)
    {
        Pattern p=Pattern.compile("(0/91)?[7-9][0-9]{9}");
        Matcher m=p.matcher(s);
        return(m.find() && m.group().equals(s));
    }
    
    
    public void actionPerformed(ActionEvent ae){
       
        
        String n = t1.getText();
        String g = c1.getSelectedItem();
        String a = t3.getText();
        String s = t4.getText();
        String c = t5.getText();
        String e = t6.getText();
        Email=e;
        String p = t7.getText();
        String qry = "insert into employee values(null,'"+n+"','"+g+"','"+a+"','"+s+"','"+c+"','"+e+"','"+p+"')";
       
        try{
             Class.forName("com.mysql.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/project2";
            String uname="root";
            String pass="";
             Connection con=DriverManager.getConnection(url,uname,pass);
             Statement st=con.createStatement();
             if (t1.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Name Field is empty");
    } else  if(t3.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Address is empty");
    }
             else  if(t3.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Address is empty");
    }
             
           // conn c1 = new conn();
            //c1.s.executeUpdate(qry);
            //st.executeUpdate(qry);
             if(isValid(e))
           JOptionPane.showMessageDialog(null,"Valid email"); 
              // JOptionPane.showMessageDialog(null,"Employee Created");
        else
         JOptionPane.showMessageDialog(null,"Invalid Email");   
            this.setVisible(true);  
            
            if(isValid(p))
           JOptionPane.showMessageDialog(null,"Valid phoneno."); 
              // JOptionPane.showMessageDialog(null,"Employee Created");
        else
         JOptionPane.showMessageDialog(null,"Invalid phoneno.");   
            this.setVisible(true); 
            st.executeUpdate(qry);
            this.setVisible(false); 
        }catch(Exception ee){
            ee.printStackTrace();
        }
          
    }
    public static void main(String s[]){
        new New_Employee().setVisible(true);
        
    }

}
