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
public class BuyerPage extends MasterList implements ActionListener {
    
    private static JPanel panel;
    private static JFrame frame;
    private static JComboBox formList;
    private static JButton button1;
    public void loadBuyerPage()
    {
        panel=new JPanel();
        frame= new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);
        
        String[] formStrings = { "Appartement", "House", "Local" };
        JComboBox formList = new JComboBox(formStrings);
        formList.setSelectedIndex(2);
        formList.setBounds(10,20,80,25);
        formList.addActionListener(new BuyerPage());
        panel.add(formList);
        
        button1=new JButton("enter");
        button1.setBounds(100, 80, 80, 25);
        panel.add(button1);
        button1.addActionListener(new EavesDropper());
        
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
         JComboBox cb = (JComboBox)ae.getSource();
        String formName = (String)cb.getSelectedItem();
        System.out.println(formName);
    }
    class EavesDropper implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("ee");
        }
    }
    
    
    
}
