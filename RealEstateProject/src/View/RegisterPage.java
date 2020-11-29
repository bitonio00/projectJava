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
   /* private static ArrayList<Buyer>listB;
    private static ArrayList<Seller>listS;
    private static ArrayList<RealEstateAgent>listREA;*/
       
        
     /*public void setList(ArrayList<Buyer>listBuyer,ArrayList<Seller>listSeller,ArrayList<RealEstateAgent>listRealEstateAgent)
               {
        listB=new ArrayList<Buyer>();
        for(int i=0;i<listBuyer.size(); ++i)
        {
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password
            listB.add(new Buyer(listBuyer.get(i).getNom(),listBuyer.get(i).getPrenom(), listBuyer.get(i).getDate().getYear(), 
             listBuyer.get(i).getDate().getMonth(), listBuyer.get(i).getDate().getDay(),  listBuyer.get(i).getAdress().getCountry(),
             listBuyer.get(i).getAdress().getCity(), listBuyer.get(i).getAdress().getStreet(), listBuyer.get(i).getLogin(), listBuyer.get(i).getPassword()));
        }
        listS=new ArrayList<Seller>();
        for(int i=0;i<listSeller.size(); ++i)
        {
           // String nom, String prenom,int year,int month,int day,   String country,String city,String street ,int login, String password
            listS.add(new Seller(listSeller.get(i).getNom(),listSeller.get(i).getPrenom(), listSeller.get(i).getDate().getYear(), 
             listSeller.get(i).getDate().getMonth(), listSeller.get(i).getDate().getDay(),  listSeller.get(i).getAdress().getCountry(),
             listSeller.get(i).getAdress().getCity(), listSeller.get(i).getAdress().getStreet(), listSeller.get(i).getLogin(), listSeller.get(i).getPassword()));
        }
        listREA=new ArrayList<RealEstateAgent>();
        for(int i=0;i<listRealEstateAgent.size(); ++i)
        {
            //(int year,int month, int day, String nom, String prenom , int login, String password,double commission,String country,String city,String street
        
            listREA.add(new RealEstateAgent(listRealEstateAgent.get(i).getDate().getYear(),listRealEstateAgent.get(i).getDate().getMonth(),listRealEstateAgent.get(i).getDate().getDay(), 
                    listRealEstateAgent.get(i).getNom(),listRealEstateAgent.get(i).getPrenom(),listRealEstateAgent.get(i).getLogin(),listRealEstateAgent.get(i).getPassword(), listRealEstateAgent.get(i).getCommission(),
                    listRealEstateAgent.get(i).getAdress().getCountry(), listRealEstateAgent.get(i).getAdress().getCity(), listRealEstateAgent.get(i).getAdress().getStreet()));
        }
            }*/
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
        
        
        loginLabel=new JLabel("login:");
        loginLabel.setBounds(10,600,100,50);
        loginText= new JTextField(15);
        loginText.setBounds(100,600,200,50);
        panel.add(loginLabel);
        panel.add(loginText);
        
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
         // if tatirioeoe blinder
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
        try {
            typePage.LoadTypePage();
            //TypePage a=new TypePage();
        } catch (IOException ex) {
            Logger.getLogger(RegisterPage.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
