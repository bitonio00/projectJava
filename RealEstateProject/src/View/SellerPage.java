/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;

/**
 *
 * @author benoi
 */
public class SellerPage extends MasterList implements ActionListener{

    private static JPanel panel;
    private static JFrame frame;
    private static JButton button1;
    private static ArrayList<Estate>myEstates;
    
    private static JComboBox myEstateList;
    
    public void loadSellerPage()
    {
        findSellerEstate();
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
        
        String[]myEstateStrings;
        
        if(myEstates.isEmpty()==false)
        {
            
            myEstateStrings = new String[myEstates.size()]; 
        }
        else
        {
           
           myEstateStrings = new String[1];  
        }   
        myEstateStrings = createMyEstateString();
        myEstateList = new JComboBox(myEstateStrings);
        myEstateList.setSelectedIndex(0);
        myEstateList.setBounds(135, 20, 80, 25);
        myEstateList.setSize(550, 30);
        panel.add(myEstateList);
        
        button1=new JButton("Introduce_new_Estate");
        button1.setBounds(300,520,80,25);
        button1.setSize(200, 50);
        panel.add(button1);
        button1.addActionListener(new IntroduceEstate());
        
        frame.setVisible(true);
        
    }
    
    
    public void findSellerEstate()
    {
        myEstates=new ArrayList<Estate>();
        System.out.println("index:"+getIndexUser());
        for(int i=0;i<getEList().size();++i)
        {
            if(getEList().get(i).getSeller().getLogin()==getSList().get(getIndexUser()).getLogin())
            {
                myEstates.add(getEList().get(i));
            }
        }
    }
    
    public class IntroduceEstate implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            SellerPage2 sellerpage2=new SellerPage2();
            sellerpage2.loadSellerPage2();
            
        }
        
    }
    
  /*  public class ActionComboVisit implements ActionListener {

        private int indexVisitConcerned;
         private  String adr;

        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox cb = (JComboBox) ae.getSource();
            visitTime = (String) cb.getSelectedItem();
            findVisit();
            findIdVisitConcerned();

        }

        public void findVisit() {

            for (int v = 0; v < myVisit.size(); ++v) {
                if (visitTime.equals( myVisit.get(v).getFullVisit())) {

                    indexVisitConcerned = v;
                }
            }

        }

        public void findIdVisitConcerned() {
           
            for (int i = 0; i < getVList().size(); ++i) {
                if (getVList().get(i).getId() == myVisit.get(indexVisitConcerned).getId()) {
                    currentIndexVisit = i;
                    //System.out.println(currentIndexVisit);

                }

            }*/
    
        public String[] createMyEstateString() {
       
        String[] stringVisit;
        if(myEstates.isEmpty()==false)
        {
           stringVisit = new String[myEstates.size()];
        for (int i = 0; i < myEstates.size(); ++i) {
            stringVisit[i] = myEstates.get(i).getFullSpec();
        }
        
        }
        else
        {
            stringVisit = new String[1];
           stringVisit[0]=" ";
           
        }
         return stringVisit; 
    }

    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
