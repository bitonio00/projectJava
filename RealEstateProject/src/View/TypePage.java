/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Buyer;
import Model.RealEstateAgent;
import Model.Seller;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class TypePage extends MasterList implements ActionListener  {
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel textLabel;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JButton button4;
    private static String type;
    /*private static ArrayList<Buyer>listB;
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
    public void LoadTypePage ()
    {
       
        
        
       
        panel=new JPanel();
        frame= new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        
        panel.setLayout(null);
        textLabel=new JLabel("Connect As");
        textLabel.setBounds(10,20,80,25);
        
        panel.add(textLabel);
       
        
        button1=new JButton("Buyer");
        button1.setBounds(10, 80, 80, 25);
        button1.setSize(new Dimension(200, 40));
        panel.add(button1);
        button1.addActionListener(new TypePage());
        
        button2=new JButton("Seller");
        button2.setBounds(300, 80, 80, 25);
        button2.setSize(new Dimension(200, 40));
        panel.add(button2);
        button2.addActionListener(new TypePage());
        
        button3=new JButton("Real Estate Agent");
        button3.setBounds(590, 80, 80, 25);
        button3.setSize(new Dimension(200, 40));
        panel.add(button3);
        button3.addActionListener(new TypePage());
        
        button4=new JButton("New Customer");
        button4.setBounds(880, 80, 80, 25);
        button4.setSize(new Dimension(200, 40));
        panel.add(button4);
        button4.addActionListener(new TypePage());
          
        
        frame.setVisible(true);
        
        
    }
    public String getT()
    {
        return type;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      type=ae.getActionCommand();
      RegisterPage b=null;
     // frame.setVisible(false);
      if(type.equals("New Customer"))
      {
          b=new RegisterPage();
          b.loadRegisterPage();
      }
      else
      {
      
      LoginPage a=new LoginPage();
      a.setLoginPage(type);
      a.LoadLoginPage();   
      }
      frame.setVisible(false);
      frame.dispose();
      
    }
    
}
