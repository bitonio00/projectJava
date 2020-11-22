/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class TypePage  implements ActionListener  {
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel textLabel;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private String type;
    
    public void LoadLoginPage ()
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
        panel.add(button1);
        button1.addActionListener(new TypePage());
        
        button2=new JButton("Seller");
        button2.setBounds(120, 80, 80, 25);
        panel.add(button2);
        button2.addActionListener(new TypePage());
        
        button3=new JButton("REA");
        button3.setBounds(260, 80, 80, 25);
        panel.add(button3);
        button3.addActionListener(new TypePage());
          
        
        frame.setVisible(true);
        
        
    }
    public String getT()
    {
        return type;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      type=ae.getActionCommand();
      System.out.println(type);
      frame.setVisible(false);
      LoginPage a=new LoginPage();
      a.setLoginPage(type);
      a.LoadLoginPage();
    }
    
}
