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

/**
 *
 * @author hency sethi
 */

public class TakeAttendence extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JButton b1,b2;
    Choice c2,fh,sh;
    
    TakeAttendence(){
       
        setLayout(new GridLayout(4,2,50,50));
        c2 = new Choice();
        try{
             String url= "jdbc:mysql://localhost:3306/project2";
              String uname="root";
              String pass="";
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(url,uname,pass);
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("select * from employee");
            
            
            while(rs.next()){
                c2.add(rs.getString("id"));    
            }
      
      
       }catch(Exception e){ }
       
        add(new JLabel(" Select Empno"));
        add(c2);
      
        l1 = new JLabel("  First Half");
        fh = new Choice();
        fh.add("Present");
        fh.add("Absent");
        fh.add("Leave");
       
        add(l1);
        add(fh);
        
        l2 = new JLabel("  Second Half");
        sh = new Choice();
        sh.add("Present");
        sh.add("Absent");
        sh.add("Leave");
       
        add(l2);
        add(sh);
       
        b1 =new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        add(b1);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setVisible(true);
        setSize(400,450);
        setLocation(600,200);
       
    }
    
    public void actionPerformed(ActionEvent ae){
       
        String f = fh.getSelectedItem();
        String s = sh.getSelectedItem();
        String dt = new java.util.Date().toString();
        String id=c2.getSelectedItem();
        String qry = "insert into attendence values("+ id +",'"+dt+"','"+f+"','"+s+"')";
       
        try{
            String url= "jdbc:mysql://localhost:3306/project2";
              String uname="root";
              String pass="";
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection con=DriverManager.getConnection(url,uname,pass);
    Statement st=con.createStatement();
   
            
            st.executeUpdate(qry);
            JOptionPane.showMessageDialog(null,"Attendence confirmed");
            this.setVisible(false);
        }catch(Exception ee){
            ee.printStackTrace();
        }
    }
    
    public static void main(String s[]){
        new TakeAttendence();
    }

}
