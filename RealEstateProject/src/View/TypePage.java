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
    
    public void LoadTypePage ()
    {
       
        
        
       
        panel=new JPanel();
        frame= new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(panel);
        
        panel.setLayout(null);
        textLabel=new JLabel("Connect As");
        textLabel.setBounds(850,200,400,100);
        
        panel.add(textLabel);
       
        
        button1=new JButton("Buyer");
        button1.setBounds(200, 500, 400, 100);
        button1.setSize(new Dimension(200, 40));
        panel.add(button1);
        button1.addActionListener(new TypePage());
        
        button2=new JButton("Seller");
        button2.setBounds(600, 500, 400, 100);
        button2.setSize(new Dimension(200, 40));
        panel.add(button2);
        button2.addActionListener(new TypePage());
        
        button3=new JButton("Real Estate Agent");
        button3.setBounds(1000, 500, 400, 100);
        button3.setSize(new Dimension(200, 40));
        panel.add(button3);
        button3.addActionListener(new TypePage());
        
        button4=new JButton("New Customer");
        button4.setBounds(1400, 500, 400, 100);
        button4.setSize(new Dimension(400, 100));
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
