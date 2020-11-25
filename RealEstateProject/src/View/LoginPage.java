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
