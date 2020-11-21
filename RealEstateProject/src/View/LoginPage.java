/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Buyer;
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
    private   int log;
  
    
    public void setList(ArrayList<Buyer>listBuyer)
            {
                 listB=new ArrayList<Buyer>();
        for(int i=0;i<listBuyer.size(); ++i)
        {
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password
            listB.add(new Buyer(listBuyer.get(i).getPrenom(),listBuyer.get(i).getNom(), listBuyer.get(i).getDate().getYear(), 
             listBuyer.get(i).getDate().getMonth(), listBuyer.get(i).getDate().getDay(),  listBuyer.get(i).getAdress().getCountry(),
             listBuyer.get(i).getAdress().getCity(), listBuyer.get(i).getAdress().getStreet(), listBuyer.get(i).getLogin(), listBuyer.get(i).getPassword()));
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


