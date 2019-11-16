/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package payroll;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.JFrame;

/**
 *
 * @author hency sethi
 */

public class login extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    login(){
        super("Login Page");
        setLayout(new BorderLayout());
        t2 = new JPasswordField(20);
        t1 = new JTextField(20);
        JLabel l = new JLabel(new ImageIcon(ClassLoader.getSystemResource("payroll/icon\\defaultpic.png")));
        
        b1 = new JButton("Submit", new ImageIcon(ClassLoader.getSystemResource("payroll/icon\\login.png")));
        b2 = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("payroll/icon\\Cancel.png")));
        
        b1.addActionListener(this);
        b2.addActionListener(this);

        JPanel p1,p2,p3,p4;
        p1=new JPanel();
        p2=new JPanel();
        p3=new JPanel();
        p4=new JPanel();
        
        

       String type[]={"Select","Admin","User"};
       JComboBox cb=new JComboBox(type);
      cb.setBounds(160,120,90,30);
      add(cb);

        add(l,BorderLayout.WEST);


        p2.add(new JLabel("User Name  "));
        p2.add(t1);
        p2.add(new JLabel("Password "));
        p2.add(t2);
        p2.add(new JLabel("Type "));
      
        add(p2,BorderLayout.CENTER);

        p4.add(b1);
        p4.add(b2);

        add(p4,BorderLayout.SOUTH);

      
        setSize(350,350);
        setLocation(200,200); 
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url= "jdbc:mysql://localhost:3306/project2";
            String uname="root";
            String pass="";
             Connection con=DriverManager.getConnection(url,uname,pass);
             Statement st=con.createStatement();
           
             String u=t1.getText();
             String v=t2.getText();
             
             
               if (t1.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Username Field is empty");
    } else  if(t2.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Password Field is empty");
    }
            
            String query="select * from login where username='"+u+"' and password='"+v+"'";
           
            
            ResultSet rs=st.executeQuery(query); // query execute
            if(rs.next()){
                JOptionPane.showMessageDialog(null,"Welcome");
               // new project().setVisible(true);
                setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Invalid login");
                setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    public static void main(String[] args){
        new login();
    }

}