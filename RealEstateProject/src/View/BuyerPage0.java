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
    private static ArrayList<Offer> myOfferAccepted;
    private static JComboBox myOfferList;
    private static JComboBox myOfferAcceptedList;
    private static JComboBox myVisitList;
    private static JButton button1;
    private static JButton button2;
    private static JButton button3;
    private static JLabel offerLabel;
    private static JLabel visitLabel;
    private static JLabel acceptedOfferLabel;
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

        JLabel fondL= new JLabel("MY AREA");
        fondL.setBounds(900, 350, 1000, 200);
        fondL.setForeground(Color.black);

        fondL.setFont(new Font("Verdera", Font.PLAIN,30));

        panel.add(fondL);
        
        offerLabel = new JLabel("Your offer :");
        offerLabel.setBounds(10, 500, 200, 50);
        panel.add(offerLabel);
        String [] myOfferStrings;
        if(myOffer.isEmpty()==false)
        {
            
            myOfferStrings = new String[myOffer.size()]; 
        }
        else
        {
           myOfferStrings = new String[1];  
        }   
        myOfferStrings = createStringmyOffer();
        myOfferList = new JComboBox(myOfferStrings);
        myOfferList.setSelectedIndex(0);
        myOfferList.setBounds(150, 500, 600, 50);
        //myOfferList.setSize(550, 30);
        myOfferList.addActionListener(new ActionComboOffer());
        panel.add(myOfferList);
        
        button1 = new JButton("Cancel an Offer");
        button1.setBounds(800, 500, 200, 50);
        panel.add(button1);
        button1.addActionListener(new ActionOfferCancel());
        
        String [] myOfferAcceptedStrings;
        if(myOfferAccepted.isEmpty()==false)
        {
            
            myOfferAcceptedStrings = new String[myOfferAccepted.size()]; 
        }
        else
        {
           myOfferAcceptedStrings = new String[1];  
        }   
        myOfferAcceptedStrings = createStringmyOfferAccepted();
        myOfferAcceptedList = new JComboBox(myOfferAcceptedStrings);
        myOfferAcceptedList.setSelectedIndex(0);
        myOfferAcceptedList.setBounds(150, 800, 600, 50);
        //myOfferList.setSize(550, 30);
        panel.add(myOfferAcceptedList);
        
        acceptedOfferLabel = new JLabel("Accepted offer(s):");
        acceptedOfferLabel.setBounds(10, 800, 600, 50);
        panel.add(acceptedOfferLabel);
        
        visitLabel = new JLabel("visit(s) planned :");
        visitLabel.setBounds(10, 700, 200, 50);
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
        myVisitList.setBounds(150, 700, 600, 50);
        //myVisitList.setSize(550, 30);
        myVisitList.addActionListener(new ActionComboVisit());
        panel.add(myVisitList);

        button2 = new JButton("Cancel a Visit");
        button2.setBounds(800, 700, 200, 50);
        panel.add(button2);
        button2.addActionListener(new ActionVisitCancel());

        button3 = new JButton("Find an Estate");
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
        myOfferAccepted=new ArrayList<Offer>();
        for (int i = 0; i < getOList().size(); ++i) {
            if (getBList().get(getIndexUser()).getLogin() == getOList().get(i).getBuyer().getLogin() && getOList().get(i).getAccepted()==false) {
                myOffer.add(getOList().get(i));
            }
            else if (getBList().get(getIndexUser()).getLogin() == getOList().get(i).getBuyer().getLogin() && getOList().get(i).getAccepted()==true) {
                myOfferAccepted.add(getOList().get(i));
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
    
    public String[] createStringmyOfferAccepted() {
       String[] stringOffer;
        if(myOffer.isEmpty()==false)
        {
            stringOffer = new String[myOfferAccepted.size()];
        for (int i = 0; i < myOfferAccepted.size(); ++i) {
            stringOffer[i] = myOfferAccepted.get(i).getFullOffer(); 
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
            if(getOList().isEmpty()==false)    
            {
              for (int i = 0; i < getOList().size(); ++i) {
                if (getOList().get(i).getId() == myOffer.get(indexOfferConcerned).getId()) {
                    currentIndexOffer = i;

                }

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
