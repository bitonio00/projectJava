/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class BuyerPage0 extends MasterList implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;
    private static ArrayList<Visit> myVisit;
    private static ArrayList<Offer> myOffer;
    private static JComboBox myOfferList;
    private static JComboBox myVisitList;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JLabel offerLabel;
    private static JLabel visitLabel;
    private static JButton returnButton;
    private static int currentIndexVisit;
    private static int currentIndexOffer;
   

    public void loadBuyerPage0() {
        findMyOffer();
        findMyVisit();
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
        
        JLabel background1 = new JLabel(new ImageIcon("fondp1.png"));
        background1.setBounds(0, 0, 80, 80);


        frame.add(background1);
        frame.pack();
        frame.setResizable(true);
        frame.add(panel);

        JLabel fondL= new JLabel("what do you want to do ?");
        fondL.setBounds(900, 350, 1000, 200);
        fondL.setForeground(Color.blue);

        fondL.setFont(new Font("Verdera", Font.PLAIN,30));

        panel.add(fondL);
        
        offerLabel = new JLabel("Vos_Offres:");
        offerLabel.setBounds(300, 500, 125, 25);
        panel.add(offerLabel);
        String [] myOfferStrings;
        if(myOffer.isEmpty()==false)
        {
            
            myOfferStrings = new String[myVisit.size()]; 
        }
        else
        {
           myOfferStrings = new String[1];  
        }   
        myOfferStrings = createStringmyOffer();
        myOfferList = new JComboBox(myOfferStrings);
        myOfferList.setSelectedIndex(0);
        myOfferList.setBounds(500, 500, 100, 50);
        //myOfferList.setSize(550, 30);
        myOfferList.addActionListener(new ActionComboOffer());
        panel.add(myOfferList);
        
        button1 = new JButton("Cancel_Offer");
        button1.setBounds(790, 500, 200, 50);
        panel.add(button1);
        button1.addActionListener(new ActionOfferCancel());
        
        visitLabel = new JLabel("Vos_Visit:");
        visitLabel.setBounds(500, 600, 125, 25);
        panel.add(visitLabel);
        String[] myVisitStrings;
        if(myVisit.isEmpty()==false)
        {
            myVisitStrings = new String[myVisit.size()]; 
        }
        else
        {
           myVisitStrings = new String[1];  
        }   
        myVisitStrings = createMyVisitString();
        myVisitList = new JComboBox(myVisitStrings);
        myVisitList.setSelectedIndex(0);
        myVisitList.setBounds(650, 600, 100, 50);
        //myVisitList.setSize(550, 30);
        myVisitList.addActionListener(new ActionComboVisit());
        panel.add(myVisitList);

        button2 = new JButton("Cancel_Visit");
        button2.setBounds(790, 600, 200, 50);
        panel.add(button2);
        button2.addActionListener(new ActionVisitCancel());

        button3 = new JButton("Find_Estate");
        button3.setBounds(700,900, 100, 50);
        panel.add(button3);
        button3.addActionListener(new BuyerPage0());
        
        returnButton=new JButton("return");
        returnButton.setBounds(500, 900, 100, 50);
        panel.add(returnButton);
        returnButton.addActionListener(new ActionReturn());

        frame.setVisible(true);

    }

    public void findMyOffer() {
        
        myOffer = new ArrayList<Offer>();
        for (int i = 0; i < getOList().size(); ++i) {
            if (getBList().get(getIndexUser()).getLogin() == getOList().get(i).getBuyer().getLogin()) {
                myOffer.add(getOList().get(i));
            }
        }
    }

    public void findMyVisit() {
       
        myVisit = new ArrayList<Visit>();

        //
        for (int i = 0; i < getVList().size(); ++i) {

            if (getVList().get(i).getReserved() == true) {
                

                if (getBList().get(getIndexUser()).getLogin() == getVList().get(i).getBuyer().getLogin()) {

                    myVisit.add(getVList().get(i));

                }
            }

        }
    }

    public String[] createStringmyOffer() {
       String[] stringOffer;
        if(myOffer.isEmpty()==false)
        {
            stringOffer = new String[myOffer.size()];
        for (int i = 0; i < myOffer.size(); ++i) {
            stringOffer[i] = myOffer.get(i).getFullOffer(); 
        }
        
        }
        else
        {
            stringOffer = new String[1];
           stringOffer[0]=" ";
           
        }
        return stringOffer; 
            
        
    }

    public String[] createMyVisitString() {
       
        String[] stringVisit;
        if(myVisit.isEmpty()==false)
        {
           stringVisit = new String[myVisit.size()];
        for (int i = 0; i < myVisit.size(); ++i) {
            stringVisit[i] = myVisit.get(i).getFullVisit();
        }
        
        }
        else
        {
            stringVisit = new String[1];
           stringVisit[0]=" ";
           
        }
         return stringVisit; 
    }

    public class ActionComboOffer implements ActionListener {

        private int indexOfferConcerned;
         private  String offerTime;

        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox cb = (JComboBox) ae.getSource();
            offerTime = (String) cb.getSelectedItem();
            findOffer();
            findIdOfferConcerned();

        }

        public void findOffer() {

            for (int v = 0; v < myOffer.size(); ++v) {
                if (offerTime.equals( myOffer.get(v).getFullOffer())) {

                    indexOfferConcerned = v;
                }
            }

        }

        public void findIdOfferConcerned() {
                
            for (int i = 0; i < getOList().size(); ++i) {
                if (getOList().get(i).getId() == myOffer.get(indexOfferConcerned).getId()) {
                    currentIndexOffer = i;

                }

            }

        }

    }

    public class ActionComboVisit implements ActionListener {

        private int indexVisitConcerned;
         private  String visitTime;

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

            }

        }
    }

    public class ActionVisitCancel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            VisitDaoImpl visitDaoImpl=new VisitDaoImpl();
            visitDaoImpl.cancelVisit(getVList().get(currentIndexVisit));
            getVList().get(currentIndexVisit).cancelVisit();
            frame.setVisible(false);
            frame.dispose();
            loadBuyerPage0();

        }

    }
    public class ActionOfferCancel implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            OfferDaoImpl offerDaoImpl=new OfferDaoImpl();
            offerDaoImpl.deleteOffer(getOList().get(currentIndexOffer));
            removeOffer(getOList().get(currentIndexOffer));
            frame.setVisible(false);
            frame.dispose();
            loadBuyerPage0();

        }

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        frame.setVisible(false);
        frame.dispose();
        BuyerPage buyerPage = new BuyerPage();
        buyerPage.loadBuyerPage();
    }
    
     public class ActionReturn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            LoginPage loginpage=new LoginPage();
            loginpage.LoadLoginPage();
            
        }
        
    }

}
