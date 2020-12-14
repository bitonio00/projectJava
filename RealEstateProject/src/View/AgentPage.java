/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.BuyerDaoImpl;
import Model.Estate;
import Model.EstateDaoImpl;
import Model.Offer;
import Model.OfferDaoImpl;
import Model.SellerDaoImpl;
import Model.Visit;
import Model.VisitDaoImpl;
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
public class AgentPage extends MasterList implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;

    private static JLabel deleteBuyerLabel;
    private static JLabel deleteSellerLabel;
    private static JLabel offerLabel;
    private static JLabel myVisitLabel;
    private static JLabel estateLabel;
    private static JLabel titlepage;

    private static JButton deleteBuyerButon;
    private static JButton deleteSellerButon;
    private static JButton addVisitButton;
    private static JButton updateEstateButton;

        
    private static JTextField deleteBuyerText;
    private static JTextField deleteSellerText;
    
    private static JComboBox myEstateList;
    private static JComboBox myOfferList;
    private static JComboBox myVisitList;
    
    private static JButton deleteVisitButton;
    private static JButton updateOfferButton;
    private static JButton addEstateButton;
    private static JButton returnButton;
    
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
        
        titlepage= new JLabel("MY AREA");
        titlepage.setBounds(600,450 ,200 ,45 );
         titlepage.setForeground(Color.black);

        titlepage.setFont(new Font("Verdera", Font.PLAIN,30));

        panel.add(titlepage);
        
        deleteBuyerLabel = new JLabel("mail of the Buyer:");
        deleteBuyerLabel.setBounds(10, 500, 100, 50);
        panel.add(deleteBuyerLabel);

        deleteBuyerText = new JTextField(30);
        deleteBuyerText.setBounds(110, 500, 200, 50);
        panel.add(deleteBuyerText);

        deleteBuyerButon = new JButton("Delete a Buyer");
        deleteBuyerButon.setBounds(350, 500, 150, 50);
        deleteBuyerButon.addActionListener(new ActionDeleteBuyer());
        panel.add(deleteBuyerButon);

        deleteSellerLabel = new JLabel("mail of Seller:");
        deleteSellerLabel.setBounds(520, 500, 100, 50);
        panel.add(deleteSellerLabel);

        deleteSellerText = new JTextField(30);
        deleteSellerText.setBounds(655, 500, 200, 50);
        panel.add(deleteSellerText);

        deleteSellerButon = new JButton("Delete a Seller");
        deleteSellerButon.setBounds(890, 500, 150, 50);
        deleteSellerButon.addActionListener(new ActionDeleteSeller());
        panel.add(deleteSellerButon);
        
        estateLabel = new JLabel("Estate:");
        estateLabel.setBounds(10, 750, 100, 50);
        panel.add(estateLabel);
        
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
        
        updateEstateButton=new JButton("Update an estate");
        updateEstateButton.setBounds(10, 900, 175, 50);
        panel.add(updateEstateButton);
        updateEstateButton.addActionListener(new ActionUpdateEstate());
        
        addVisitButton=new JButton("Add a visit");
        addVisitButton.setBounds(260, 900, 100, 50);
        addVisitButton.addActionListener(new ActionAddVisit());
        panel.add(addVisitButton);
        
        offerLabel = new JLabel("Offer:");
        offerLabel.setBounds(610, 750, 100, 50);
        panel.add(offerLabel);
        
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
        
        updateOfferButton=new JButton("Update an offer");
        updateOfferButton.setBounds(850, 900, 175, 50);
        panel.add(updateOfferButton);
        updateOfferButton.addActionListener(new ActionUpdateOffer());
        
        myVisitLabel = new JLabel("Visit:");
        myVisitLabel.setBounds(1200, 750, 100, 50);
        panel.add(myVisitLabel);
        
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
        
        deleteVisitButton=new JButton("Delete a visit");
        deleteVisitButton.setBounds(1450, 900, 178, 50);
        panel.add(deleteVisitButton);
        deleteVisitButton.addActionListener(new ActionDeleteVisit());
        
        addEstateButton=new JButton("Add an estate");
        addEstateButton.setBounds(1100, 500, 175, 50);
        panel.add(addEstateButton);
        addEstateButton.addActionListener(new ActionAddEstate());

        returnButton=new JButton("return");
        returnButton.setBounds(650, 950, 175, 50);
        panel.add(returnButton);
        returnButton.addActionListener(new AgentPage.ActionReturn());
        
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
            if(myOffer.get(i).getAccepted()==true)
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
            boolean error=false;
            String mailBuyer = deleteBuyerText.getText();
            if(mailBuyer.contains("@")==false || mailBuyer.contains(".")==false || mailBuyer.equals(" ") )
         {
             deleteBuyerText.setForeground(Color.red);
             error=true;
         }
         else
              deleteBuyerText.setForeground(Color.black);
            
         int s=0;
        for(int i=0; i<getBList().size(); ++i)
        {
        if (getBList().get(i).getMail().equals(mailBuyer))
        {
         s=1;
         }
         }
    if(s==0)
    {  deleteBuyerText.setForeground(Color.red);
    error=true;
    }
            else 
              deleteBuyerText.setForeground(Color.black);
            
if(error==false){
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

frame.setVisible(false);
frame.dispose();
AgentPage y = new AgentPage();
      y.loadAgentPage();
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
            boolean error=false;
            String mailSeller = deleteSellerText.getText();
 if(mailSeller.contains("@")==false || mailSeller.contains(".")==false || mailSeller.equals(" ")  )
         { 
             deleteSellerText.setForeground(Color.red);
             error=true;
         }
 else 
              deleteSellerText.setForeground(Color.black);
  int s=0;
 for(int i=0; i<getSList().size(); ++i)
 {
  if (getSList().get(i).getMail().equals(mailSeller))
  {
      s=1;
    
  }
 }
 if(s==0)
 {deleteSellerText.setForeground(Color.red);
 error=true;
 }
 else 
              deleteSellerText.setForeground(Color.black);
       if (error==false) {   
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
       frame.setVisible(false);
       frame.dispose();
       AgentPage y = new AgentPage();
      y.loadAgentPage();
       
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
            AgentPageAddVisit pageaddvisit=new AgentPageAddVisit();
            pageaddvisit.setIndex(currentEstate);
            pageaddvisit.loadAgentPageAddVisit();
            
        }
        
    }
    
    public class ActionUpdateOffer implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            OfferDaoImpl offerdao=new OfferDaoImpl();
            offerdao.deleteOffer(getOList().get(currentOffer));
            removeOffer(getOList().get(currentOffer));
            AgentPage agentPage=new AgentPage();
            agentPage.loadAgentPage();
            
        }
        
    }
    
    public class ActionUpdateEstate implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            
            if(getEList().get(currentEstate).getSold()==true)
            {
                frame.setVisible(false);
                frame.dispose();
               
                EstateDaoImpl estatedao=new EstateDaoImpl();
                estatedao.deleteEstate(getEList().get(currentEstate));
                removeEstate(getEList().get(currentEstate));
                AgentPage agentPage=new AgentPage();
                agentPage.loadAgentPage();
                
            }
        }
        
    }
    
    public class ActionAddEstate implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            
            frame.setVisible(false);
            frame.dispose();
            AgentPage2 agentPage=new AgentPage2();
            agentPage.loadAgentPage2();
            
            
            
                
            
        }
        
    }
    
     public class ActionReturn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            LoginPage sellerpage=new LoginPage ();
         sellerpage.LoadLoginPage();

        }

    }




}
