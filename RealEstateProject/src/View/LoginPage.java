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
public class LoginPage extends MasterList implements ActionListener {
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel loginLabel;
    private static JLabel passWordLabel;
    private static JLabel success;
    private static JTextField loginText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static String password;
    /*private static ArrayList<Buyer>listB;
    private static ArrayList<Seller>listS;
    private static ArrayList<RealEstateAgent>listREA;*/
    private static int log;
    private static String m_type;

    public void setLoginPage(String type)
    {
        m_type=type;
    }
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
                System.out.println(m_type);
                String login=loginText.getText();
                 password=passwordText.getText();

                 log=Integer.parseInt(login);
             //   System.out.print(m_type);
                if(m_type.equals("Buyer"))
                {
                  for(int i=0; i<getBList().size(); ++i)
               {
                   System.out.println(getBList().get(i).getLogin());
                      if(getBList().get(i).getLogin()==log && getBList().get(i).getPassword().equals(password))
                         {
                          System.out.println("yeeeeeeeeeeeeees");
                          JOptionPane.showMessageDialog(null,"lolo");

                         }
                       }
                  //GUI a=new hhhuhug()
                  //a.setEstate(listEstate)
                  //a.loadPAGE()

                }
                if(m_type.equals("Real Estate Agent"))
                {
                  for(int i=0; i<getREAList().size(); ++i)
               {
                  // System.out.print("ttt");
                      if(getREAList().get(i).getLogin()==log && getREAList().get(i).getPassword().equals(password))
                         {
                          System.out.println("yeeeeeeeeeeeeees");
                          JOptionPane.showMessageDialog(null,"lolo");
                         }
                       }
                }
                 if(m_type.equals("Seller"))
                {
                  for(int i=0; i<getSList().size(); ++i)
               {
                //   System.out.print("ttt");
                      if(getSList().get(i).getLogin()==log && getSList().get(i).getPassword().equals(password))
                         {
                          System.out.println("yeeeeeeeeeeeeees");
                          JOptionPane.showMessageDialog(null,"lolo");
                         }
                       }
                }



    }
}
