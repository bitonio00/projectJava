/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Estate;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Double.parseDouble;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;
import javax.swing.*;


/**
 *
 * @author benoi
 */
public class BuyerPage extends MasterList implements ActionListener {
    
    private static JPanel panel;
    private static JFrame frame;
    private static JLabel maxPriceLabel;
    private static JLabel minPriceLabel;
    private static JLabel countryLabel;
    private static JLabel cityLabel;
    private static JLabel streetLabel;
    private static JLabel nbrFloorLabel;
    private static JLabel nbrBedRoomLabel;
    private static JLabel nbrBathRoomLabel;
    private static JLabel minsizeLabel;
    private static JLabel maxsizeLabel;
    private static JTextField maxPriceText;
    private static JTextField minPriceText;
    private static JTextField countryText;
    private static JTextField cityText;
    private static JTextField streetText;
    private static JTextField minsizeText;
    private static JTextField maxsizeText;
    private static JComboBox formList;
    private static JComboBox nbrFloorList;
    private static JComboBox nbrBedRoomList;
    private static JComboBox nbrBathRoomList;
    private static JButton button1;
    private static JCheckBox jardinCheck;
    private static JCheckBox visavisCheck;
    private static JCheckBox equipedCheck;
    private static JCheckBox meubledCheck;
   // private static JSlider sizeSlider;
    private static String typeEstate;
    private static String nbrFloor;
    private static String nbrBedRoom;
    private static String nbrBathRoom;
    private static boolean meubled;
    private static boolean equiped;
    private static boolean garden;
    private static boolean visavis;
    private static double maxPrice;
    private static double minPrice;
    private static int maxSize;
    private static int minSize;
    private static ArrayList<Estate>m_estateConcerned;
    
    public BuyerPage()
            {
                maxPrice=100000000;
                minPrice=0;
                minSize=0;
                maxSize=1500;
            }
    public void loadBuyerPage()
    {
        panel=new JPanel();
        frame= new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
        
        String[] formStrings = { "Appartement", "House", "Local" };
        formList = new JComboBox(formStrings);
        formList.setSelectedIndex(2);
        formList.setBounds(10,20,80,25);
        formList.addActionListener(new actionComboType());
        panel.add(formList);
        
        maxPriceLabel=new JLabel("MAX_PRICE:");
        maxPriceLabel.setBounds(10,80,80,25);
        maxPriceText= new JTextField(15);
        maxPriceText.setBounds(100,80,80,25);
        panel.add(maxPriceLabel);
        panel.add(maxPriceText);
        
        minPriceLabel=new JLabel("MIN_PRICE:");
        minPriceLabel.setBounds(200,80,80,25);
        minPriceText= new JTextField(15);
        minPriceText.setBounds(280,80,80,25);
        panel.add(minPriceLabel);
        panel.add(minPriceText);
        
        countryLabel=new JLabel("Country:");
        countryLabel.setBounds(10,140,80,25);
        countryText= new JTextField(15);
        countryText.setBounds(100,140,80,25);
        panel.add(countryLabel);
        panel.add(countryText);
        
        cityLabel=new JLabel("City:");
        cityLabel.setBounds(200,140,80,25);
        cityText= new JTextField(15);
        cityText.setBounds(280,140,80,25);
        panel.add(cityLabel);
        panel.add(cityText);
        
        streetLabel=new JLabel("Street:");
        streetLabel.setBounds(380,140,80,25);
        streetText= new JTextField(15);
        streetText.setBounds(440,140,80,25);
        panel.add(streetLabel);
        panel.add(streetText);
        
        jardinCheck = new JCheckBox("Garden");
        jardinCheck.setSelected(false);
        jardinCheck.setBounds(10,200,80,25);
        jardinCheck.addItemListener(new CheckBox());
        panel.add(jardinCheck);
        
        visavisCheck = new JCheckBox("VisaVis");
        visavisCheck.setSelected(false);
        visavisCheck.setBounds(110,200,80,25);
        visavisCheck.addItemListener(new CheckBox());
        panel.add(visavisCheck);
        
        equipedCheck = new JCheckBox("equiped");
        equipedCheck.setSelected(false);
        equipedCheck.setBounds(210,200,80,25);
        equipedCheck.addItemListener(new CheckBox());
        panel.add(equipedCheck);
        
        meubledCheck = new JCheckBox("meubled");
        meubledCheck.setSelected(false);
        meubledCheck.setBounds(310,200,80,25);
        meubledCheck.addItemListener(new CheckBox());
        panel.add(meubledCheck);
        
        nbrFloorLabel=new JLabel("nbrFloor:");
        nbrFloorLabel.setBounds(10,260,80,25);
        String[] numberFloorStrings = { "1", "2", "3","4","5" };
        nbrFloorList = new JComboBox(numberFloorStrings);
        nbrFloorList.setSelectedIndex(0);
        nbrFloorList.setBounds(60,260,80,25);
        nbrFloorList.addActionListener(new ActionComboFloor());
        panel.add(nbrFloorLabel);
        panel.add(nbrFloorList);
        
        nbrBedRoomLabel=new JLabel("nbrBedRoom:");
        nbrBedRoomLabel.setBounds(140,260,80,25);
        String[] nbrBedRoomStrings = { "1", "2", "3","4","5","6","7","8" };
        nbrBedRoomList = new JComboBox(nbrBedRoomStrings);
        nbrBedRoomList.setSelectedIndex(0);
        nbrBedRoomList.setBounds(220,260,80,25);
        nbrBedRoomList.addActionListener(new ActionComboBedRoom());
        panel.add(nbrBedRoomLabel);
        panel.add(nbrBedRoomList);
        
        nbrBathRoomLabel=new JLabel("nbrBathRoom:");
        nbrBathRoomLabel.setBounds(300,260,80,25);
        String[] nbrBathRoomStrings = { "1", "2", "3","4","5","6","7","8" };
        nbrBathRoomList = new JComboBox(nbrBathRoomStrings);
        nbrBathRoomList.setSelectedIndex(0);
        nbrBathRoomList.setBounds(390,260,80,25);
        nbrBathRoomList.addActionListener(new ActionComboBathRoom());
        panel.add(nbrBathRoomLabel);
        panel.add(nbrBathRoomList);
        
        minsizeLabel=new JLabel("min_size:");
        minsizeLabel.setBounds(10,320,80,25);
        minsizeText=new JTextField(10);
        minsizeText.setBounds(70,320,80,25);
        maxsizeLabel=new JLabel("max_size:");
        maxsizeLabel.setBounds(160,320,80,25);
        maxsizeText=new JTextField(10);
        maxsizeText.setBounds(240,320,80,25);
        /*sizeSlider = new JSlider(JSlider.HORIZONTAL,0, 500, 0);
        sizeSlider.setBounds(50,320,80,25);
        sizeSlider.setSize(100, 100);
        sizeSlider.setMajorTickSpacing(100);
        sizeSlider.setMinorTickSpacing(100);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        Font font = new Font("Serif", Font.ITALIC, 10);
        sizeSlider.setFont(font);*/
        panel.add(minsizeLabel);
        panel.add(minsizeText);
        panel.add(maxsizeLabel);
        panel.add(maxsizeText);
        
        
        
        button1=new JButton("Search");
        button1.setBounds(100, 360, 80, 25);
        panel.add(button1);
        button1.addActionListener(new BuyerPage());
        
        
        frame.setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String maxPriceS=maxPriceText.getText();
        maxPrice=parseDouble(maxPriceS);
        String minPriceS=minPriceText.getText();
        minPrice=parseDouble(minPriceS);
        String country=countryText.getText();
        String city=cityText.getText();
        String street=streetText.getText();
        if(typeEstate.equals("House"))
        {
            for(int i=0;i<getEList().size();++i)
            {
                if(getEList().get(i).getEquiped()==equiped && getEList().get(i).getGarden()==garden && getEList().get(i).getMeubled()==meubled && getEList().get(i).getvisavis()==visavis && getEList().get(i).getPrice()>minPrice)
                           
                {
                    
                }
            }
        }
        
    }
    
    public class CheckBox implements ItemListener
            {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            Object source = ie.getItemSelectable();
            if(source==jardinCheck)
                garden=true;
            else if(source==meubledCheck)
                meubled=true;
            else if(source==equipedCheck)
                equiped=true;
            else if(source==visavisCheck)
                visavis=true;
       
            
            
        }
                
            }
    class actionComboType implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        JComboBox cb = (JComboBox)e.getSource();
        typeEstate = (String)cb.getSelectedItem();
        
        }
    }
    class ActionComboFloor implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        JComboBox cb = (JComboBox)e.getSource();
        nbrFloor = (String)cb.getSelectedItem();
        }
    }
    class ActionComboBedRoom implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        JComboBox cb = (JComboBox)e.getSource();
        nbrBedRoom = (String)cb.getSelectedItem();
        }
        
    }
        class ActionComboBathRoom implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
        JComboBox cb = (JComboBox)e.getSource();
        nbrBathRoom = (String)cb.getSelectedItem();
        }
    }
    
    
}

