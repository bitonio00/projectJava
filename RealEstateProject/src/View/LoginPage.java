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
    private static JLabel fondL;
    private static JLabel errorLabel;
    private static JTextField loginText;
    private static JPasswordField passwordText;
    private static JButton button;
    private static JButton returnButton;
    private static String password;
    private static int log;
    private static String m_type;

    public void setLoginPage(String type)
    {
        m_type=type;
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
        loginLabel.setBounds(800,500,80,25);
        passWordLabel=new JLabel("password");
        passWordLabel.setBounds(800,600,80,25);
        loginText=new JTextField(20);
        loginText.setBounds(900, 500, 165, 25);
        passwordText=new JPasswordField(20);
        passwordText.setBounds(900, 600, 165, 25);
        panel.add(loginLabel);
        panel.add(passWordLabel);
        panel.add(loginText);
        panel.add(passwordText);

         success=new JLabel("");
        success.setBounds(10,110,300,25);
        panel.add(success);

JLabel background1 = new JLabel(new ImageIcon("fondp1.png"));
        background1.setBounds(0, 0, 80, 80);


        frame.add(background1);
        frame.pack();
        frame.setResizable(true);
        frame.add(panel);

        fondL= new JLabel("Login");
        fondL.setBounds(900, 350, 1000, 200);
        fondL.setForeground(Color.blue);
        
        errorLabel= new JLabel("");
        errorLabel.setBounds(900, 700, 200, 50);
        panel.add(errorLabel);
       

        fondL.setFont(new Font("Verdera", Font.PLAIN,30));

        panel.add(fondL);
        
        button=new JButton("enter");
        button.setBounds(1000, 700, 100, 50);
        panel.add(button);
        button.addActionListener(new LoginPage());

        returnButton=new JButton("return");
        returnButton.setBounds(800, 700, 100, 50);
        panel.add(returnButton);
        returnButton.addActionListener(new ActionReturn());



        frame.setVisible(true);


    }


    public void actionPerformed(ActionEvent e) {



                String login=loginText.getText();
                 password=passwordText.getText();

                 
             //   System.out.print(m_type);
                if(m_type.equals("Buyer"))
                {
                    
                  for(int i=0; i<getBList().size(); ++i)
               {

                      if(getBList().get(i).getMail().equals(login) && getBList().get(i).getPassword().equals(password))
                         {
                          setidUser(i);
                          BuyerPage0 buyerpage0=new BuyerPage0();
                          buyerpage0.loadBuyerPage0();

                          frame.setVisible(false);
                          frame.dispose();
                         }
                       }
                  
                  
                }
                else if(m_type.equals("Real Estate Agent"))
                {
                  for(int i=0; i<getREAList().size(); ++i)
               {
                  // System.out.print("ttt");
                      if(getREAList().get(i).getMail().equals(login)&& getREAList().get(i).getPassword().equals(password))
                         {
                          setidUser(i);
                          AgentPage agentPage=new AgentPage();
                          agentPage.loadAgentPage();
                          frame.setVisible(false);
                          frame.dispose();
                         }
                       }
                  
                  
                }
                else if(m_type.equals("Seller"))
                {
                  for(int i=0; i<getSList().size(); ++i)
                     {
                //   System.out.print("ttt");
                      if(getSList().get(i).getMail().equals(login) && getSList().get(i).getPassword().equals(password))
                         {
                          setidUser(i);
                          SellerPage sellerpage=new SellerPage();
                          sellerpage.loadSellerPage();
                          frame.setVisible(false);
                          frame.dispose();
                         }
                     
                       }
                
                }
                
                    
                    errorLabel.setText("WRONG PASSWORD OR LOGIN");
                    errorLabel.setForeground(Color.red);
                
                


                
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
