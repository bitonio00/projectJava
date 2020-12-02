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
    private static JButton addVisitButton;
    private static JButton deleteVisitButton;
    private static JButton deleteOfferButton;
    private static JButton acceptOfferButton;
            
    private static ArrayList<Estate>myEstates;
    private static ArrayList<Offer>myOffer;
    private static ArrayList<Visit>myVisit;
    
    
    private static JComboBox myEstateList;
    private static JComboBox myOfferList;
    private static JComboBox myVisitList;
    
    private static int currentEstate;
    private static int currentOffer;
    private static int currentVisit;
    
    
    
    public void loadSellerPage()
    {
        findSellerEstate();
        findSellerOffer();
        findSellerVisit();
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
        myEstateList.setBounds(10, 500, 600, 50);
        myEstateList.addActionListener(new ActionComboEstate());
        panel.add(myEstateList);
        
        addVisitButton=new JButton("Add_visit");
        addVisitButton.setBounds(300, 600, 100, 50);
        panel.add(addVisitButton);
        addVisitButton.addActionListener(new ActionAddVisit());
        
        String[]myOfferStrings;
        
        if(myOffer.isEmpty()==false)
        {
            
            myOfferStrings = new String[myOffer.size()]; 
        }
        else
        {
           
           myOfferStrings = new String[1];  
        }   
        myOfferStrings = createOfferString();
        myOfferList = new JComboBox(myOfferStrings);
        myOfferList.setSelectedIndex(0);
        myOfferList.setBounds(650, 500, 600, 50);
        myOfferList.addActionListener(new ActionComboOffer());
        panel.add(myOfferList);
        
        deleteOfferButton=new JButton("delete_offer");
        deleteOfferButton.setBounds(850, 600, 100, 50);
        panel.add(deleteOfferButton);
        deleteOfferButton.addActionListener(new ActionDeleteOffer());
        
        acceptOfferButton=new JButton("accept_offer");
        acceptOfferButton.setBounds(650, 600, 100, 50);
        panel.add(acceptOfferButton);
        acceptOfferButton.addActionListener(new ActionAcceptOffer());
        
        String[]myVisitStrings;
        
        if(myVisit.isEmpty()==false)
        {
            
            myVisitStrings = new String[myVisit.size()]; 
        }
        else
        {
           
           myVisitStrings = new String[1];  
        }   
        myVisitStrings = createVisitString();
        myVisitList = new JComboBox(myVisitStrings);
        myVisitList.setSelectedIndex(0);
        myVisitList.setBounds(1350, 500, 600, 50);
        myVisitList.addActionListener(new ActionComboVisit());
        panel.add(myVisitList);
        
        deleteVisitButton=new JButton("delete_visit");
        deleteVisitButton.setBounds(1600, 600, 100, 50);
        panel.add(deleteVisitButton);
        deleteVisitButton.addActionListener(new ActionDeleteVisit());
        
        button1=new JButton("Introduce_new_Estate");
        button1.setBounds(700,720,100,50);
        button1.setSize(200, 50);
        panel.add(button1);
        button1.addActionListener(new IntroduceEstate());
        
        JLabel background1 = new JLabel(new ImageIcon("fondp1.png"));
        background1.setBounds(0, 0, 80, 80);


        frame.add(background1);
        frame.pack();
        frame.setResizable(true);
        frame.add(panel);

        JLabel fondL= new JLabel("Sell your estate");
        fondL.setBounds(900, 350, 1000, 200);
        fondL.setForeground(Color.blue);

        fondL.setFont(new Font("Verdera", Font.PLAIN,30));

        panel.add(fondL);
        
        frame.setVisible(true);
        
    }
    
    
    public void findSellerEstate()
    {
        myEstates=new ArrayList<Estate>();
       
        for(int i=0;i<getEList().size();++i)
        {
            if(getEList().get(i).getSeller().getLogin()==getSList().get(getIndexUser()).getLogin())
            {
                myEstates.add(getEList().get(i));
            }
        }
    }
    
    public void findSellerOffer()
    {
        myOffer=new ArrayList<Offer>();
        
        for(int i=0;i<getOList().size();++i)
        {
            if(getOList().get(i).getEstate().getSeller().getLogin()==getSList().get(getIndexUser()).getLogin())
            {
                myOffer.add(getOList().get(i));
            }
        }
    }
    
    public void findSellerVisit()
    {
        myVisit=new ArrayList<Visit>();
        
        for(int i=0;i<getVList().size();++i)
        {
            if(getVList().get(i).getEstate().getSeller().getLogin()==getSList().get(getIndexUser()).getLogin())
            {
                myVisit.add(getVList().get(i));
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
                    currentVisit = i;
                    //System.out.println(currentIndexVisit);

                }

            }
        }
    }
    
    public class ActionComboOffer implements ActionListener {

        private int indexOfferConcerned;
         private  String offer;

        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox cb = (JComboBox) ae.getSource();
            offer = (String) cb.getSelectedItem();
            findOffer();
            findIdOfferConcerned();

        }

        public void findOffer() {

            for (int v = 0; v < myOffer.size(); ++v) {
                if (offer.equals( myOffer.get(v).getFullOffer())) {

                    indexOfferConcerned = v;
                }
            }

        }

        public void findIdOfferConcerned() {
           
            for (int i = 0; i < getOList().size(); ++i) {
                if (getOList().get(i).getId() == myOffer.get(indexOfferConcerned).getId()) {
                    currentOffer = i;
                    //System.out.println(currentIndexVisit);

                }

            }
        }
    }
        
    
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

        public String[] createOfferString() {
       
        String[] stringOffer;
        if(myOffer.isEmpty()==false)
        {
           stringOffer= new String[myOffer.size()];
        for (int i = 0; i < myOffer.size(); ++i) {
            if(myOffer.get(i).getAccepted()==false)
            {
               stringOffer[i] =myOffer.get(i).getBuyer().getNom()+" ask " +myOffer.get(i).getFullOffer(); 
            }
            
        }
        
        }
        else
        {
            stringOffer = new String[1];
           stringOffer[0]=" ";
           
        }
         return stringOffer; 
    }
        
        public String[] createVisitString() {
       
        String[] stringVisit;
        if(myVisit.isEmpty()==false)
        {
           stringVisit= new String[myVisit.size()];
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
        
    public class ActionComboEstate implements  ActionListener
    {
        private  String adressEstate;
        private int indexEstateConcern;
        

        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox cb = (JComboBox) ae.getSource();
             adressEstate = (String) cb.getSelectedItem();
            findEstate();
            findIdEstateConcerned() ;
            
               
            
            }
            
        
        public void findEstate()
        {
            
            for(int v=0;v<myEstates.size();++v)
            {
                if(adressEstate.equals(myEstates.get(v).getFullSpec()))
                {
                    indexEstateConcern=v;
                }
            }
            
        }
        
        public void findIdEstateConcerned()
        {
            
            for(int i=0;i<getEList().size();++i)
            {
                if(getEList().get(i).getId()==myEstates.get(indexEstateConcern).getId())
                {
                    currentEstate=i;
                    
                }
                    
            }
            
        }
         

        
    }
    
    public class ActionAddVisit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            SellerPageAddVisit pageaddvisit=new SellerPageAddVisit();
            pageaddvisit.setIndex(currentEstate);
            pageaddvisit.loadSellerPageAddVisit();
            
        }
        
    }
    
    public class ActionDeleteVisit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            VisitDaoImpl visitDaoImpl=new VisitDaoImpl();
            visitDaoImpl.deleteVisit(getVList().get(currentVisit));
            removeVisit(getVList().get(currentVisit));
            SellerPage sellerPage=new SellerPage();
            sellerPage.loadSellerPage();
            
            
        }
        
    }
    
    public class ActionDeleteOffer implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            OfferDaoImpl offerDaoImpl=new OfferDaoImpl();
            offerDaoImpl.deleteOffer(getOList().get(currentOffer));
            removeOffer(getOList().get(currentOffer));
            SellerPage sellerPage=new SellerPage();
            sellerPage.loadSellerPage();
            
            
        }
        
    }
    
    public class ActionAcceptOffer implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            myOffer.get(currentOffer).acceptOffer();
            
            SellerPage sellerPage=new SellerPage();
            sellerPage.loadSellerPage();
            
            
        }
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
