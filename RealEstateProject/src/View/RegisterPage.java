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
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static JTextField mailText;
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
        formList.setBounds(900,500,100,50);
        formList.addActionListener(new ActionCombo());
        panel.add(formList);
        //typeLabel=new JLabel("Seller/Buyer:");
       // typeLabel.setBounds(10,20,80,25);
        //typeText= new JTextField(6);
        //typeText.setBounds(200,20,80,25);
        //panel.add(typeLabel);
       // panel.add(typeText);



panel.setLayout(null);
        JLabel background1 = new JLabel(new ImageIcon("fondp1.png"));
        background1.setBounds(0, 0, 80, 80);


        frame.add(background1);
        frame.pack();
        frame.setResizable(true);
        frame.add(panel);

        JLabel fondL= new JLabel("Register");
        fondL.setBounds(900, 350, 1000, 200);
        fondL.setForeground(Color.blue);

        fondL.setFont(new Font("Verdera", Font.PLAIN,30));

        panel.add(fondL);



        loginLabel=new JLabel("mail:");
        loginLabel.setBounds(10,600,100,50);
        mailText= new JTextField(15);
        mailText.setBounds(100,600,200,50);
        panel.add(loginLabel);
        panel.add(mailText);

        passwordLabel=new JLabel("Password:");
        passwordLabel.setBounds(400,600,100,50);
        passwordText= new JTextField(15);
        passwordText.setBounds(500,600,200,50);
        panel.add(passwordLabel);
        panel.add(passwordText);

        nameLabel=new JLabel("last_Name:");
        nameLabel.setBounds(800,600,100,50);
        nameText= new JTextField(15);
        nameText.setBounds(900,600,200,50);
        panel.add(nameLabel);
        panel.add(nameText);

        fnameLabel=new JLabel("first_Name:");
        fnameLabel.setBounds(1200,600,100,50);
        fnameText= new JTextField(15);
        fnameText.setBounds(1300,600,200,50);
        panel.add(fnameLabel);
        panel.add(fnameText);

        ybirthLabel=new JLabel("birth_year:");
        ybirthLabel.setBounds(1600,600,100,50);
        ybirthText= new JTextField(15);
        ybirthText.setBounds(1700,600,200,50);
        panel.add(ybirthLabel);
        panel.add(ybirthText);

        mbirthLabel=new JLabel("birth_month:");
        mbirthLabel.setBounds(10,800,80,25);
        mbirthText= new JTextField(15);
        mbirthText.setBounds(100,800,200,50);
        panel.add(mbirthLabel);
        panel.add(mbirthText);

        dbirthLabel=new JLabel("birth_day:");
        dbirthLabel.setBounds(400,800,100,50);
        dbirthText= new JTextField(15);
        dbirthText.setBounds(500,800,200,50);
        panel.add(dbirthLabel);
        panel.add(dbirthText);

        countryLabel=new JLabel("country:");
        countryLabel.setBounds(800,800,100,50);
        countryText= new JTextField(15);
        countryText.setBounds(900,800,200,50);
        panel.add(countryLabel);
        panel.add(countryText);

        cityLabel=new JLabel("city:");
        cityLabel.setBounds(1200,800,100,50);
        cityText= new JTextField(15);
        cityText.setBounds(1300,800,200,50);
        panel.add(cityLabel);
        panel.add(cityText);

        streetLabel=new JLabel("street:");
        streetLabel.setBounds(1600,800,100,50);
        streetText= new JTextField(15);
        streetText.setBounds(1700,800,200,50);
        panel.add(streetLabel);
        panel.add(streetText);

        button1=new JButton("ok");
        button1.setBounds(900,900,100,50);
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
        Boolean error=false;
        
         String mail= mailText.getText();
         if(mail.contains("@")==false && mail.contains(".")==false || mail.equals(" ") )
         {
             mailText.setForeground(Color.red);
             error=true;
         }
         else
              mailText.setForeground(Color.black);
         
         pass=passwordText.getText();
         if(pass.length()>15)
         {
             error=true;
             passwordText.setForeground(Color.red);
         }
         else
             passwordText.setForeground(Color.black);
         
         lname=nameText.getText();
        
         fname=fnameText.getText();
         yb=parseInt(ybirthText.getText());
         mb=parseInt(mbirthText.getText());
         db=parseInt(dbirthText.getText());
        String birthDate=ybirthText.getText()+" "+mbirthText.getText()+" "+dbirthText.getText();
         country=countryText.getText();
         city=cityText.getText();
         street=streetText.getText();
         if(error==false)
         {
            if(person.equals("Seller"))
        {
           Seller s=new Seller(lname,fname,birthDate,country,city,street,getIdLastSeller(),pass,mail);
            addSeller(s);
            SellerDaoImpl sellerDao=new SellerDaoImpl();
            sellerDao.addSeller(s);



        }
        else if(person.equals("Buyer"))
        {  Buyer a=new Buyer(lname,fname,birthDate,country,city,street,getIdLastBuyer(),pass,mail);
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
