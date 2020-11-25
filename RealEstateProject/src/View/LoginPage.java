/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.event.*; 
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class LoginPage implements ActionListener {
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel loginLabel;
    private static JLabel passWordLabel;
    private static JLabel success;
    private static JTextField loginText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static String password;
    private static ArrayList<Buyer>listB;
    private static ArrayList<Seller>listS;
    private static ArrayList<RealEstateAgent>listREA;
    private static ArrayList<Estate>listE;
    private   int log;
    private String m_type;
  
    public void setLoginPage(String type)
    {
        m_type=type;
    }
    public void setList(ArrayList<Buyer>listBuyer,ArrayList<Seller>listSeller,ArrayList<RealEstateAgent>listRealEstateAgent,ArrayList<Estate>listEstate)
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
        for(int i=0;i <listEstate.size();i++)
        {
        if(listEstate.get(i).getType().equals("house"))
        {
        /*int id,int size,String country,String city, String street ,
            double price,Seller seller, RealEstateAgent realEstateAgent, String houseType,
            int numberOfFloor, boolean meubled,boolean equiped,boolean garden,String type*/
            listE.add(new House(listEstate.get(i).getId(),listEstate.get(i).getSize(),listEstate.get(i).getAdress().getCountry()
                    ,listEstate.get(i).getAdress().getCity(),listEstate.get(i).getAdress().getStreet()
                    ,listEstate.get(i).getPrice(),listEstate.get(i).getSeller(),listEstate.get(i).getAgent(),listEstate.get(i).getHouseType()
                    ,listEstate.get(i).getNOF(), listEstate.get(i).getMeubled(),listEstate.get(i).getEquiped(),listEstate.get(i).getGarden()
                    ,listEstate.get(i).getType()));
        
        }
        
        if(listEstate.get(i).getType().equals("appartement"))
        {
        /*int id,int size,String country,String city, String street , double price,Seller seller,
            RealEstateAgent realEstateAgent, int numberOfFloor, boolean equiped,boolean meubled,boolean visavis, String type*/
        listE.add(new Appartement(listEstate.get(i).getId(),listEstate.get(i).getSize(),listEstate.get(i).getAdress().getCountry()
                    ,listEstate.get(i).getAdress().getCity(),listEstate.get(i).getAdress().getStreet()
                    ,listEstate.get(i).getPrice(),listEstate.get(i).getSeller(),listEstate.get(i).getAgent()
                    ,listEstate.get(i).getNOF(), listEstate.get(i).getEquiped(),listEstate.get(i).getMeubled(),listEstate.get(i).getvisavis()
                    ,listEstate.get(i).getType()));
        }
        
        if(listEstate.get(i).getType().equals("local"))
        {
        /*int id,int size,String country,String city, String street , double price,Seller seller,
        RealEstateAgent realEstateAgent, String localType,boolean equiped, boolean meubled, int numberOfFloor, String type*/
            listE.add(new Local(listEstate.get(i).getId(),listEstate.get(i).getSize(),listEstate.get(i).getAdress().getCountry()
                    ,listEstate.get(i).getAdress().getCity(),listEstate.get(i).getAdress().getStreet()
                    ,listEstate.get(i).getPrice(),listEstate.get(i).getSeller(),listEstate.get(i).getAgent(),listEstate.get(i).getLocalType()
                    , listEstate.get(i).getEquiped(),listEstate.get(i).getMeubled(),listEstate.get(i).getNOF()
                    ,listEstate.get(i).getType()));
        
        }
            
        }
            }
    public void LoadLoginPage ()
    {
       
        
        
       
        panel=new JPanel();
        frame= new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        
        panel.setLayout(null);
        loginLabel=new JLabel("login");
        loginLabel.setBounds(10,20,80,25);
        passWordLabel=new JLabel("password");
        passWordLabel.setBounds(10,50,80,25);
        loginText=new JTextField(20);
        loginText.setBounds(100, 20, 165, 25);
        passwordText=new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(loginLabel);
        panel.add(passWordLabel);
        panel.add(loginText);
        panel.add(passwordText);
        
         success=new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);
       
        
        button=new JButton("enter");
        button.setBounds(10, 80, 80, 25);
        panel.add(button);
        button.addActionListener(new LoginPage());
        
          
        
        frame.setVisible(true);
        
        
    }

    
    public void actionPerformed(ActionEvent e) {
                String login=loginText.getText();
                 password=passwordText.getText();
                 
                log=Integer.parseInt(login);
                if(m_type.equals("Buyer"))
                {
                  for(int i=0; i<listB.size(); ++i)
               {
                   System.out.print("ttt");
                      if(listB.get(i).getLogin()==log && listB.get(i).getPassword().equals(password))
                         {
                          System.out.println("yeeeeeeeeeeeeees");
                          JOptionPane.showMessageDialog(null,"lolo");
                         }
                       }  
                }
                if(m_type.equals("REA"))
                {
                  for(int i=0; i<listREA.size(); ++i)
               {
                   System.out.print("ttt");
                      if(listREA.get(i).getLogin()==log && listREA.get(i).getPassword().equals(password))
                         {
                          System.out.println("yeeeeeeeeeeeeees");
                          JOptionPane.showMessageDialog(null,"lolo");
                         }
                       }  
                }
                 if(m_type.equals("Seller"))
                {
                  for(int i=0; i<listS.size(); ++i)
               {
                   System.out.print("ttt");
                      if(listS.get(i).getLogin()==log && listS.get(i).getPassword().equals(password))
                         {
                          System.out.println("yeeeeeeeeeeeeees");
                          JOptionPane.showMessageDialog(null,"lolo");
                         }
                       }  
                }
                 
                              
                
    }
  
public void compare()
{
    
 for(int i=0; i<listB.size(); ++i)
               {
                   System.out.print("ttt");
                      if(listB.get(i).getLogin()==log && listB.get(i).getPassword().equals(password))
                         {
                          System.out.println("yeeeeeeeeeeeeees");
                          JOptionPane.showMessageDialog(null,"lolo");
                         }
                       }
}   
}


