/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class BuyerPage2   extends MasterList implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;
    private static JLabel typeLabel;
    private static JLabel typeSpecLabel;
    private static JLabel typeRepLabel;
    private static JLabel typeSpecRepLabel;
    private static JLabel priceLabel;
    private static JLabel priceRepLabel;
    private static JLabel sizeLabel;
    private static JLabel sizeRepLabel;
    private static JLabel nbrFloorLabel;
    private static JLabel nbrFloorRepLabel;
    private static JLabel nbrBedRoomLabel;
    private static JLabel nbrBedRoomRepLabel;
    private static JLabel nbrBathRoomLabel;
    private static JLabel nbrBathRoomRepLabel;
    private static JLabel gardenLabel;
    private static JLabel gardenRepLabel;
    private static JLabel visavisLabel;
    private static JLabel visavisRepLabel;
    private static JLabel equipedLabel;
    private static JLabel equipedRepLabel;
    private static JLabel meubledLabel;
    private static JLabel meubledRepLabel;
    private static JButton button1;
    private static JButton button2;
    private static JComboBox estateList;
    private static int indexEstateConcern;
    private static int indexEstate;
    
    private static String estateType;
    
    private ArrayList<Estate>m_listEstateConcerned;
    
    public BuyerPage2()
    {
        estateType="";
    }
    public void setListEstate(ArrayList<Estate>listEstateConcerned)
    {
        m_listEstateConcerned=new ArrayList<Estate>();
        m_listEstateConcerned=listEstateConcerned;
    }
    public void loadBuyerPage2()
    {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
        
        String[] estateStrings;
        if(m_listEstateConcerned.isEmpty()==false)
        {
          estateStrings = new String[m_listEstateConcerned.size()];  
        }
        else
            estateStrings = new String[1]; 
        estateStrings=createStringEstate();
        estateList = new JComboBox(estateStrings);
        estateList.setSelectedIndex(0);
        estateList.setBounds(10, 20, 80, 25);
        estateList.setSize(500, 30);
        estateList.addActionListener(new ActionComboEstate());
        panel.add(estateList);
        
        typeLabel = new JLabel("EstateType:");
        typeLabel.setBounds(10, 130, 80, 25);
        typeRepLabel=new JLabel("");
        typeRepLabel.setBounds(90, 130, 80, 25);
        panel.add(typeLabel);
        panel.add(typeRepLabel);
        
        typeSpecLabel = new JLabel("EstateSpec:");
        typeSpecLabel.setBounds(160, 130, 80, 25);
        typeSpecRepLabel=new JLabel("");
        typeSpecRepLabel.setBounds(230, 130, 80, 25);
        panel.add(typeSpecLabel);
        panel.add(typeSpecRepLabel);
        
        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(300, 130, 80, 25);
        priceRepLabel=new JLabel("");
        priceRepLabel.setBounds(350, 130, 80, 25);
        panel.add(priceLabel);
        panel.add(priceRepLabel);
        
        sizeLabel = new JLabel("Size:");
        sizeLabel.setBounds(440, 130, 80, 25);
        sizeRepLabel=new JLabel("");
        sizeRepLabel.setBounds(490, 130, 80, 25);
        panel.add(sizeLabel);
        panel.add(sizeRepLabel);
        
        nbrFloorLabel = new JLabel("nbrFloor:");
        nbrFloorLabel.setBounds(10, 170, 80, 25);
        nbrFloorRepLabel=new JLabel("");
        nbrFloorRepLabel.setBounds(70, 170, 80, 25);
        panel.add(nbrFloorLabel);
        panel.add(nbrFloorRepLabel);
        
        nbrBedRoomLabel = new JLabel("nbrBedRoom:");
        nbrBedRoomLabel.setBounds(110, 170, 80, 25);
        nbrBedRoomRepLabel=new JLabel("");
        nbrBedRoomRepLabel.setBounds(190, 170, 80, 25);
        panel.add(nbrBedRoomLabel);
        panel.add(nbrBedRoomRepLabel);
        
        nbrBathRoomLabel = new JLabel("nbrBathRoom:");
        nbrBathRoomLabel.setBounds(230, 170, 80, 25);
        nbrBathRoomRepLabel=new JLabel("");
        nbrBathRoomRepLabel.setBounds(300, 170, 80, 25);
        panel.add(nbrBathRoomLabel);
        panel.add(nbrBathRoomRepLabel);
        
        gardenLabel = new JLabel("Garden:");
        gardenLabel.setBounds(10, 210, 80, 25);
        gardenRepLabel=new JLabel("");
        gardenRepLabel.setBounds(70, 210, 80, 25);
        panel.add(gardenLabel);
        panel.add(gardenRepLabel);
        
        meubledLabel = new JLabel("Meubled:");
        meubledLabel.setBounds(130, 210, 80, 25);
        meubledRepLabel=new JLabel("");
        meubledRepLabel.setBounds(200, 210, 80, 25);
        panel.add(meubledLabel);
        panel.add(meubledRepLabel);
        
        equipedLabel = new JLabel("Equiped:");
        equipedLabel.setBounds(250, 210, 80, 25);
        equipedRepLabel=new JLabel("");
        equipedRepLabel.setBounds(320, 210, 80, 25);
        panel.add(equipedLabel);
        panel.add(equipedRepLabel);
        
        visavisLabel = new JLabel("VisaVis:");
        visavisLabel.setBounds(370, 210, 80, 25);
        visavisRepLabel=new JLabel("");
        visavisRepLabel.setBounds(430, 210, 80, 25);
        panel.add(visavisLabel);
        panel.add(visavisRepLabel);
        
        button1=new JButton("Make_Offer");
        button1.setBounds(50,520,80,25);
        button1.setSize(200, 50);
        panel.add(button1);
        button1.addActionListener(new BuyerPage2());
        
        button2=new JButton("Book_Visit");
        button2.setBounds(300,520,80,25);
        button2.setSize(200, 50);
        panel.add(button2);
        button2.addActionListener(new BuyerPage2());
        
        
        
        
        
        
        
        frame.setVisible(true);

    }
    public String [] createStringEstate()
    {
        String[]stringEstate;
        if(m_listEstateConcerned.isEmpty()==false)
        {
           stringEstate=new String[m_listEstateConcerned.size()];
        
        for(int i=0;i<m_listEstateConcerned.size();++i)
        {
            stringEstate[i]=m_listEstateConcerned.get(i).getAdress().getFullAdress();
        }
        
        }
        else
        {
            stringEstate=new String[1];
            stringEstate[0]=" ";
        }
        
        return stringEstate;
    }
   
    
    
    
    public void actionPerformed(ActionEvent ae) {
        String source=ae.getActionCommand();
        if(source.equals("Make_Offer"))
        {
           BuyerPage2Offer buyerpage2offer=new BuyerPage2Offer();
           buyerpage2offer.setIndexEstateConcerned(indexEstate);
           buyerpage2offer.loadBuyerPage2Offer();
        }
        else if(source.equals("Book_Visit"))
        {
            
           BuyerPage2Visit buyerpage2visit=new BuyerPage2Visit();
           buyerpage2visit.setIndexEstateConcerned(indexEstate);
           buyerpage2visit.loadBuyerPage2Visit();  
        }
    }
    
    public class ActionComboEstate implements  ActionListener
    {
        private  String adressEstate;
        

        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox cb = (JComboBox) ae.getSource();
             adressEstate = (String) cb.getSelectedItem();
            findEstate();
            findIdEstateConcerned();
            typeRepLabel.setText(m_listEstateConcerned.get(indexEstateConcern).getType());
            String string1=String.valueOf(m_listEstateConcerned.get(indexEstateConcern).getPrice());
            priceRepLabel.setText(string1);
            String string2=String.valueOf(m_listEstateConcerned.get(indexEstateConcern).getSize());
            sizeRepLabel.setText(string2);
            String string3=String.valueOf(m_listEstateConcerned.get(indexEstateConcern).getNOF());
            nbrFloorRepLabel.setText(string3);
            if(m_listEstateConcerned.get(indexEstateConcern).getMeubled()==true)
                meubledRepLabel.setText("yes");
            else
                meubledRepLabel.setText("no");
            
            if(m_listEstateConcerned.get(indexEstateConcern).getEquiped()==true)
                equipedRepLabel.setText("yes");
            else
                equipedRepLabel.setText("no");
            
            
            if(m_listEstateConcerned.get(indexEstateConcern).getType().equals("house"))
            {
               typeSpecRepLabel.setText(m_listEstateConcerned.get(indexEstateConcern).getHouseType());
               String string4=String.valueOf(m_listEstateConcerned.get(indexEstateConcern).getNor());
               nbrBedRoomRepLabel.setText(string4);
               String string5=String.valueOf(m_listEstateConcerned.get(indexEstateConcern).getNob());
               nbrBathRoomRepLabel.setText(string4);
               
               if(m_listEstateConcerned.get(indexEstateConcern).getGarden()==true)
                gardenRepLabel.setText("yes");
               else
                gardenRepLabel.setText("no");
               
               if(m_listEstateConcerned.get(indexEstateConcern).getvisavis()==true)
                visavisRepLabel.setText("yes");
               else
                visavisRepLabel.setText("no");
            
            
            }
            //int id,int size,String country,String city, String street ,
            //double price,Seller seller, RealEstateAgent realEstateAgent, String houseType,
            //int numberOfFloor, boolean meubled,boolean equiped,boolean garden,String type, int nor, int nob
            
            
            
            
            
        
        }
        public void findEstate()
        {
            
            for(int v=0;v<m_listEstateConcerned.size();++v)
            {
                if(adressEstate.equals(m_listEstateConcerned.get(v).getAdress().getFullAdress()))
                {
                    indexEstateConcern=v;
                }
            }
            
        }
        public void findIdEstateConcerned()
        {
            
            for(int i=0;i<getEList().size();++i)
            {
                if(getEList().get(i).getId()==m_listEstateConcerned.get(indexEstateConcern).getId())
                {
                    indexEstate=i;
                    
                }
                    
            }
            
        }
        
    
}
    
        
    }

