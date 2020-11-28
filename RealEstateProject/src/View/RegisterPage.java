/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class RegisterPage extends MasterList implements ActionListener{
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel typeLabel;
    private static JLabel passwordLabel;
    private static JLabel nameLabel;
    private static JLabel fnameLabel;
    private static JLabel ybirthLabel;
    private static JLabel mbirthLabel;
    private static JLabel dbirthLabel;
    private static JLabel countryLabel;
    private static JLabel cityLabel;
    private static JLabel streetLabel;
    private static JLabel loginLabel;
    private static JTextField typeText;
    private static JTextField loginText;
    private static JTextField passwordText;
    private static JTextField nameText;
    private static JTextField fnameText;
    private static JTextField ybirthText;
    private static JTextField mbirthText;
    private static JTextField dbirthText;
    private static JTextField countryText;
    private static JTextField cityText;
    private static JTextField streetText;
    private static JComboBox formList;
    private static JButton button1;
    private static JButton returnButton;
    private static String type;
    private static int login;
    private static  String pass;
    private static String lname;
    private static String fname;
    private static int yb;
    private static int mb;
    private static int db;
    private static String country;       
    private static String city;
    private static String street;
    private static String person;
 
    public void loadRegisterPage()
    {
        panel=new JPanel();
        frame= new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        
        panel.setLayout(null);
        String[] formStrings = { "Seller","Buyer"   };
       formList = new JComboBox(formStrings);
        formList.setSelectedIndex(1);
        formList.setBounds(10,20,80,25);
        formList.addActionListener(new ActionCombo());
        panel.add(formList);
        
         
        
        loginLabel=new JLabel("login:");
        loginLabel.setBounds(10,60,80,25);
        loginText= new JTextField(15);
        loginText.setBounds(200,60,80,25);
        panel.add(loginLabel);
        panel.add(loginText);
        
        passwordLabel=new JLabel("Password:");
        passwordLabel.setBounds(10,100,80,25);
        passwordText= new JTextField(15);
        passwordText.setBounds(200,100,80,25);
        panel.add(passwordLabel);
        panel.add(passwordText);
        
        nameLabel=new JLabel("last_Name:");
        nameLabel.setBounds(10,140,80,25);
        nameText= new JTextField(15);
        nameText.setBounds(200,140,80,25);
        panel.add(nameLabel);
        panel.add(nameText);
        
        fnameLabel=new JLabel("first_Name:");
        fnameLabel.setBounds(10,180,80,25);
        fnameText= new JTextField(15);
        fnameText.setBounds(200,180,80,25);
        panel.add(fnameLabel);
        panel.add(fnameText);
        
        ybirthLabel=new JLabel("birth_year:");
        ybirthLabel.setBounds(10,220,80,25);
        ybirthText= new JTextField(15);
        ybirthText.setBounds(200,220,80,25);
        panel.add(ybirthLabel);
        panel.add(ybirthText);
        
        mbirthLabel=new JLabel("birth_month:");
        mbirthLabel.setBounds(10,260,80,25);
        mbirthText= new JTextField(15);
        mbirthText.setBounds(200,260,80,25);
        panel.add(mbirthLabel);
        panel.add(mbirthText);
        
        dbirthLabel=new JLabel("birth_day:");
        dbirthLabel.setBounds(10,300,80,25);
        dbirthText= new JTextField(15);
        dbirthText.setBounds(200,300,80,25);
        panel.add(dbirthLabel);
        panel.add(dbirthText);
        
        countryLabel=new JLabel("country:");
        countryLabel.setBounds(10,340,80,25);
        countryText= new JTextField(15);
        countryText.setBounds(200,340,80,25);
        panel.add(countryLabel);
        panel.add(countryText);
        
        cityLabel=new JLabel("city:");
        cityLabel.setBounds(10,380,80,25);
        cityText= new JTextField(15);
        cityText.setBounds(200,380,80,25);
        panel.add(cityLabel);
        panel.add(cityText);
        
        streetLabel=new JLabel("street:");
        streetLabel.setBounds(10,420,80,25);
        streetText= new JTextField(15);
        streetText.setBounds(200,420,80,25);
        panel.add(streetLabel);
        panel.add(streetText);
        
        button1=new JButton("ok");
        button1.setBounds(10,460,80,25);
        panel.add(button1);
        button1.addActionListener(new RegisterPage());
        
        returnButton=new JButton("return");
        returnButton.setBounds(350, 10, 80, 25);
        panel.add(returnButton);
        returnButton.addActionListener(new ActionReturn());
        
        
        
        //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password
        
        frame.setVisible(true);
    }
    
  public class ActionCombo implements ActionListener
  {
  public void actionPerformed(ActionEvent ae)
  {
   JComboBox cb = (JComboBox)ae.getSource();
        person = (String)cb.getSelectedItem();
       
  
  }
  
  
  }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
         
         login= parseInt(loginText.getText());
         pass=passwordText.getText();
         lname=nameText.getText();
         fname=fnameText.getText();
         yb=parseInt(ybirthText.getText());
         mb=parseInt(mbirthText.getText());
         db=parseInt(dbirthText.getText());
        String birthDate=ybirthText.getText()+" "+mbirthText.getText()+" "+dbirthText.getText();
         country=countryText.getText();
         city=cityText.getText();
         street=streetText.getText();
         System.out.println(person);
        
         
        if(person.equals("Seller"))
        {
           Seller s=new Seller(lname,fname,birthDate,country,city,street,login,pass);
            addSeller(s);
            SellerDaoImpl sellerDao=new SellerDaoImpl();
            sellerDao.addSeller(s);
           
         
            
        }
        else if(person.equals("Buyer"))
        {  Buyer a=new Buyer(lname,fname,birthDate,country,city,street,login,pass);
           System.out.print("aa"+a.getLogin());
           addBuyer(a);
           BuyerDaoImpl buyerDao=new BuyerDaoImpl();
           buyerDao.addBuyer(a);
         
        }
        

        
        frame.setVisible(false);
        frame.dispose();
        TypePage typePage=new TypePage();
        typePage.LoadTypePage();
        //TypePage a=new TypePage();
        
    }
    
        public class ActionReturn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            TypePage typepage=new TypePage();
            typepage.LoadTypePage();
            
        }
        
    }
    
}
