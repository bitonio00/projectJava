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
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class BuyerPage2Offer extends MasterList implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;
    private static Buyer buyerConcerned;
    private static JLabel montantLabel;
    private static JTextField montantText;
    private static JComboBox formList;
    private static JButton button1;
    private static String transactionType;
    private static double montant;
    private static int indexEstateConcerned;
    private static JButton returnButton;
    
    public BuyerPage2Offer()
    {
        transactionType="check";
       
    }
    public void loadBuyerPage2Offer() {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(2000, 2000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
       
        JLabel background1 = new JLabel(new ImageIcon("fondp1.png"));
        background1.setBounds(0, 0, 80, 80);


        frame.add(background1);
        frame.pack();
        frame.setResizable(true);
        frame.add(panel);

        JLabel fondL= new JLabel("Make your offer");
        fondL.setBounds(900, 350, 1000, 200);
        fondL.setForeground(Color.blue);

        fondL.setFont(new Font("Verdera", Font.PLAIN,30));

        panel.add(fondL);
        
        montantLabel = new JLabel("Montant:");
        montantLabel.setBounds(900, 500, 100, 50);
        montantText=new JTextField(15);
        montantText.setBounds(900, 600, 100, 50);
        panel.add(montantLabel);
        panel.add(montantText);
        
        String[] formStrings = {"check", "cash", "bankCard"};
        formList = new JComboBox(formStrings);
        formList.setSelectedIndex(0);
        formList.setBounds(900, 700, 100, 50);
        formList.addActionListener(new ActionComboTransactionType());
        panel.add(formList);
        
        button1=new JButton("Submit");
        button1.setBounds(900,900,100,50);
        panel.add(button1);
        button1.addActionListener(new BuyerPage2Offer());
        
        returnButton=new JButton("return");
        returnButton.setBounds(700, 900, 100, 50);
        panel.add(returnButton);
        returnButton.addActionListener(new ActionReturn());


        
        
        
        frame.setVisible(true);
    }
  
    
    public void setIndexEstateConcerned(int i)
    {
        indexEstateConcerned=i;
        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String montantS=montantText.getText();
        montant=parseDouble(montantS);
        Offer offer;
        OfferDaoImpl offerDaoImpl=new OfferDaoImpl();
        
        if(getEList().get(indexEstateConcerned).getType().equals("house"))
        {
            
             House houseConcerned = new House(getEList().get(indexEstateConcerned).getId(), getEList().get(indexEstateConcerned).getSize(),getEList().get(indexEstateConcerned).getAdress().getCountry(),getEList().get(indexEstateConcerned).getAdress().getCity(),
                                             getEList().get(indexEstateConcerned).getAdress().getStreet(), getEList().get(indexEstateConcerned).getPrice(),getEList().get(indexEstateConcerned).getSeller(),getEList().get(indexEstateConcerned).getAgent(),getEList().get(indexEstateConcerned).getHouseType(),getEList().get(indexEstateConcerned).getNOF(),getEList().get(indexEstateConcerned).getMeubled(),
                                             getEList().get(indexEstateConcerned).getEquiped(),getEList().get(indexEstateConcerned).getGarden(),getEList().get(indexEstateConcerned).getType(),getEList().get(indexEstateConcerned).getNor(),getEList().get(indexEstateConcerned).getNob());
            offer=new Offer(getIdLastOffer(),montant,getBList().get(getIndexUser()),houseConcerned,transactionType);
            offerDaoImpl.addOffer(offer);
            addOffer(offer);
            
        }
        else if(getEList().get(indexEstateConcerned).getType().equals("local"))
        {
            Local localConcerned = new Local(getEList().get(indexEstateConcerned).getId(),getEList().get(indexEstateConcerned).getSize(),getEList().get(indexEstateConcerned).getAdress().getCountry(),getEList().get(indexEstateConcerned).getAdress().getCity(),
                                        getEList().get(indexEstateConcerned).getAdress().getStreet(),getEList().get(indexEstateConcerned).getPrice(),getEList().get(indexEstateConcerned).getSeller(),getEList().get(indexEstateConcerned).getAgent(),getEList().get(indexEstateConcerned).getLocalType(),
                                         getEList().get(indexEstateConcerned).getEquiped(),getEList().get(indexEstateConcerned).getMeubled(),getEList().get(indexEstateConcerned).getNOF(),getEList().get(indexEstateConcerned).getType());
             offer=new Offer(getIdLastOffer(),montant,getBList().get(getIndexUser()),localConcerned,transactionType);
             offerDaoImpl.addOffer(offer);
             addOffer(offer);
        }
        else if(getEList().get(indexEstateConcerned).getType().equals("appartement"))
        {
             Appartement appartConcerned = new Appartement(getEList().get(indexEstateConcerned).getId(),getEList().get(indexEstateConcerned).getSize(),getEList().get(indexEstateConcerned).getAdress().getCountry(),getEList().get(indexEstateConcerned).getAdress().getCity(),
                                                getEList().get(indexEstateConcerned).getAdress().getStreet(),getEList().get(indexEstateConcerned).getPrice(),getEList().get(indexEstateConcerned).getSeller(),getEList().get(indexEstateConcerned).getAgent(),getEList().get(indexEstateConcerned).getNOF(),getEList().get(indexEstateConcerned).getEquiped(),
                                                 getEList().get(indexEstateConcerned).getMeubled(),getEList().get(indexEstateConcerned).getvisavis(),getEList().get(indexEstateConcerned).getType(),getEList().get(indexEstateConcerned).getNor(),getEList().get(indexEstateConcerned).getNob());
             offer=new Offer(getIdLastOffer(),montant,getBList().get(getIndexUser()),appartConcerned,transactionType);
             offerDaoImpl.addOffer(offer);
             addOffer(offer);
        }
        
        
        
        
        
    }
    class ActionComboTransactionType implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            transactionType = (String) cb.getSelectedItem();
            
        }
    }
    
     public class ActionReturn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            BuyerPage2 buyerPage2=new BuyerPage2();
            buyerPage2.loadBuyerPage2();
            
            
        }
        
    }

}
