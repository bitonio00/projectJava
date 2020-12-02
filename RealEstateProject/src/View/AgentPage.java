/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.BuyerDaoImpl;
import Model.Estate;
import Model.Offer;
import Model.OfferDaoImpl;
import Model.SellerDaoImpl;
import Model.Visit;
import Model.VisitDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class AgentPage extends MasterList implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;

    private static JLabel deleteBuyerLabel;
    private static JLabel deleteSellerLabel;

    private static JButton deleteBuyerButon;
    private static JButton deleteSellerButon;
    private static JButton addVisitButton;

    private static JTextField deleteBuyerText;
    private static JTextField deleteSellerText;
    
    private static JComboBox myEstateList;
    private static JComboBox myOfferList;
    private static JComboBox myVisitList;
    
    private static JButton deleteVisitButton;
    
    private static ArrayList<Estate>myEstate;
    private static ArrayList<Offer>myOffer;
    private static ArrayList<Visit>myVisit;
    
    private static int currentEstate;
    private static int currentOffer;
    private static int currentVisit;

    public void loadAgentPage() {
        findMyOffer();
        findMyVisit();
        findMyEstate();
        
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

        deleteBuyerLabel = new JLabel("mail_Buyer:");
        deleteBuyerLabel.setBounds(10, 500, 50, 50);
        panel.add(deleteBuyerLabel);

        deleteBuyerText = new JTextField(30);
        deleteBuyerText.setBounds(100, 500, 100, 50);
        panel.add(deleteBuyerText);

        deleteBuyerButon = new JButton("Delete Buyer");
        deleteBuyerButon.setBounds(200, 500, 100, 50);
        deleteBuyerButon.addActionListener(new ActionDeleteBuyer());
        panel.add(deleteBuyerButon);

        deleteSellerLabel = new JLabel("mail_Seller:");
        deleteSellerLabel.setBounds(300, 500, 50, 50);
        panel.add(deleteSellerLabel);

        deleteSellerText = new JTextField(30);
        deleteSellerText.setBounds(450, 500, 100, 50);
        panel.add(deleteSellerText);

        deleteSellerButon = new JButton("Delete Seller");
        deleteSellerButon.setBounds(550, 500, 100, 50);
        deleteSellerButon.addActionListener(new ActionDeleteSeller());
        panel.add(deleteSellerButon);
        
        String[]myEstateStrings;
        
        if(myEstate.isEmpty()==false)
        {
            
            myEstateStrings = new String[myEstate.size()]; 
        }
        else
        {
           
           myEstateStrings = new String[1];  
        }   
        myEstateStrings = createMyEstateString();
        myEstateList = new JComboBox(myEstateStrings);
        myEstateList.setSelectedIndex(0);
        myEstateList.setBounds(10, 800, 500, 50);
        myEstateList.addActionListener(new ActionComboEstate());
        panel.add(myEstateList);
        
        addVisitButton=new JButton("Add_visit");
        addVisitButton.setBounds(260, 900, 100, 50);
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
        myOfferList.setBounds(610, 800, 500, 50);
        myOfferList.addActionListener(new ActionComboOffer());
        panel.add(myOfferList);
        
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
        myVisitList.setBounds(1200, 800, 600, 50);
        myVisitList.addActionListener(new ActionComboVisit());
        panel.add(myVisitList);
        
        deleteVisitButton=new JButton("delete_visit");
        deleteVisitButton.setBounds(1450, 900, 100, 50);
        panel.add(deleteVisitButton);
        deleteVisitButton.addActionListener(new ActionDeleteVisit());

        frame.setVisible(true);
    }
    public void findMyEstate()
    {
       myEstate=new ArrayList<Estate>();
       
        for(int i=0;i<getEList().size();++i)
        {
            if(getEList().get(i).getAgent().getLogin()==getREAList().get(getIndexUser()).getLogin())
            {
                myEstate.add(getEList().get(i));
            }
        } 
    }
    
    public void findMyOffer()
    {
        myOffer=new ArrayList<Offer>();
        
        for(int i=0;i<getOList().size();++i)
        {
            if(getOList().get(i).getEstate().getAgent().getLogin()==getREAList().get(getIndexUser()).getLogin())
            {
                myOffer.add(getOList().get(i));
            }
        }
    }
    public void findMyVisit()
    {
        myVisit=new ArrayList<Visit>();
        
        for(int i=0;i<getVList().size();++i)
        {
            if(getVList().get(i).getEstate().getAgent().getLogin()==getREAList().get(getIndexUser()).getLogin())
            {
                myVisit.add(getVList().get(i));
            }
        }
    }
    
    public String[] createMyEstateString() {
       
        String[] stringVisit;
        if(myEstate.isEmpty()==false)
        {
           stringVisit = new String[myEstate.size()];
        for (int i = 0; i < myEstate.size(); ++i) {
            stringVisit[i] = myEstate.get(i).getFullSpec();
        }
        
        }
        else
        {
            stringVisit = new String[1];
           stringVisit[0]=" ";
           
        }
         return stringVisit; 
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class ActionDeleteBuyer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String mailBuyer = deleteBuyerText.getText();

            for (int i = 0; i < getBList().size(); ++i) {

                if (getBList().get(i).getMail().equals(mailBuyer)) {

                    BuyerDaoImpl buyerDaoImpl = new BuyerDaoImpl();
                    buyerDaoImpl.deleteBuyer(getBList().get(i));
                    removeBuyer(getBList().get(i));

                }
            }
            for (int i = 0; i < getOList().size(); ++i) {
                System.out.println(getOList().get(i).getBuyer().getMail());
                if (getOList().get(i).getBuyer().getMail().equals(mailBuyer)) {

                    OfferDaoImpl offerDaoImpl = new OfferDaoImpl();
                    offerDaoImpl.deleteOffer(getOList().get(i));
                    removeOffer(getOList().get(i));

                }
            }
            for (int i = 0; i < getVList().size(); ++i) {
                if (getVList().get(i).getBuyer() != null) {
                    if (getVList().get(i).getBuyer().getMail().equals(mailBuyer)) {
                        VisitDaoImpl visitDaoImpl = new VisitDaoImpl();
                        visitDaoImpl.cancelVisit(getVList().get(i));
                        getVList().get(i).cancelVisit();

                    }
                }

            }

        }
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
            
            for(int v=0;v<myEstate.size();++v)
            {
                if(adressEstate.equals(myEstate.get(v).getFullSpec()))
                {
                    indexEstateConcern=v;
                }
            }
            
        }
        
        public void findIdEstateConcerned()
        {
            
            for(int i=0;i<getEList().size();++i)
            {
                if(getEList().get(i).getId()==myEstate.get(indexEstateConcern).getId())
                {
                    currentEstate=i;
                    
                }
                    
            }
            
        }
    }

    public class ActionDeleteSeller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String mailSeller = deleteSellerText.getText();

            for (int i = 0; i < getSList().size(); ++i) {

                if (getSList().get(i).getMail().equals(mailSeller)) {

                    SellerDaoImpl sellerDaoImpl = new SellerDaoImpl();
                    sellerDaoImpl.deleteSeller(getSList().get(i));
                    removeSeller(getSList().get(i));

                }
            }
            for (int i = 0; i < getEList().size(); ++i) {

                if (getEList().get(i).getSeller().getMail().equals(mailSeller)) {

                    OfferDaoImpl offerDaoImpl = new OfferDaoImpl();
                    offerDaoImpl.deleteOffer(getOList().get(i));
                    removeOffer(getOList().get(i));

                }
            }
            for (int i = 0; i < getVList().size(); ++i) {

                if (getVList().get(i).getEstate().getSeller().getMail().equals(mailSeller)) {
                    VisitDaoImpl visitDaoImpl = new VisitDaoImpl();
                    visitDaoImpl.deleteVisit(getVList().get(i));
                    removeVisit(getVList().get(i));

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
    
    public class ActionDeleteVisit implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            VisitDaoImpl visitDaoImpl=new VisitDaoImpl();
            visitDaoImpl.deleteVisit(getVList().get(currentVisit));
            removeVisit(getVList().get(currentVisit));
            AgentPage agentPage=new AgentPage();
            agentPage.loadAgentPage();
            
            
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



}
