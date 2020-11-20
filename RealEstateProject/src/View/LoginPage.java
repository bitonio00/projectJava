/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.event.*; 
import javax.swing.*;
import java.awt.*;

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
                String password=passwordText.getText();
    }
    
}
