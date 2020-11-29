/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import javax.swing.*;


/**
 *
 * @author benoi
 */
public class SellerPage2 extends MasterList implements ActionListener{
    
    private static JPanel panel;
    private static JFrame frame;
    private static JComboBox nbrBedRoomList;
    private static JComboBox nbrBathRoomList;
    private static JComboBox nbrFloorList;
    private static JComboBox formList;
    private static JComboBox reaList;
    private static JButton button1;
    private static JCheckBox jardinCheck;
    private static JCheckBox visavisCheck;
    private static JCheckBox equipedCheck;
    private static JCheckBox meubledCheck;
     private static JLabel nbrFloorLabel;
    private static JLabel nbrBedRoomLabel;
    private static JLabel nbrBathRoomLabel;
    private static JLabel priceLabel;
    private static JLabel countryLabel;
    private static JLabel cityLabel;
    private static JLabel streetLabel;
    private static JLabel sizeLabel;
    private static JTextField countryText;
    private static JTextField cityText;
    private static JTextField streetText;
    private static JTextField priceText;
    private static JTextField sizeText;
    private static int nbrFloor;
    private static int nbrBedRoom;
    private static int nbrBathRoom;
    private static boolean meubled;
    private static boolean equiped;
    private static boolean garden;
    private static boolean visavis;
    private static String typeEstate;
    private static int currentREA;
    
    
    public void loadSellerPage2()
    {
        
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
        
        
        String[] formStrings = {"appartement", "house", "manoir", "villa", "local", "local_pro", "local_perso"};
        formList = new JComboBox(formStrings);
        formList.setSelectedIndex(1);
        formList.setBounds(10, 20, 80, 25);
        formList.addActionListener(new actionComboType());
        panel.add(formList);
        String [] reaStrings;
         if(getREAList().isEmpty()==false)
        {
            
            reaStrings = new String[getREAList().size()]; 
        }
        else
        {
           reaStrings = new String[1];  
        }   
        reaStrings = createRea();
        reaList = new JComboBox(reaStrings);
        reaList.setSelectedIndex(0);
        reaList.setBounds(135, 20, 80, 25);
        reaList.setSize(550, 30);
        reaList.addActionListener(new ActionComboREA());
        panel.add(reaList);

        priceLabel = new JLabel("PRICE:");
        priceLabel.setBounds(10, 80, 80, 25);
        priceText = new JTextField(15);
        priceText.setBounds(100, 80, 80, 25);
        panel.add(priceLabel);
        panel.add(priceText);
        
        sizeLabel = new JLabel("SIZE:");
        sizeLabel.setBounds(190, 80, 80, 25);
        sizeText = new JTextField(15);
        sizeText.setBounds(280, 80, 80, 25);
        panel.add(sizeLabel);
        panel.add(sizeText);
        
        
        countryLabel = new JLabel("Country:");
        countryLabel.setBounds(10, 140, 80, 25);
        countryText = new JTextField(15);
        countryText.setBounds(100, 140, 80, 25);
        panel.add(countryLabel);
        panel.add(countryText);

        cityLabel = new JLabel("City:");
        cityLabel.setBounds(200, 140, 80, 25);
        cityText = new JTextField(15);
        cityText.setBounds(280, 140, 80, 25);
        panel.add(cityLabel);
        panel.add(cityText);

        streetLabel = new JLabel("Street:");
        streetLabel.setBounds(380, 140, 80, 25);
        streetText = new JTextField(15);
        streetText.setBounds(440, 140, 80, 25);
        panel.add(streetLabel);
        panel.add(streetText);

        jardinCheck = new JCheckBox("Garden");
        jardinCheck.setSelected(false);
        jardinCheck.setBounds(10, 200, 80, 25);
        jardinCheck.addItemListener(new CheckBox());
        panel.add(jardinCheck);

        visavisCheck = new JCheckBox("VisaVis");
        visavisCheck.setSelected(false);
        visavisCheck.setBounds(110, 200, 80, 25);
        visavisCheck.addItemListener(new CheckBox());
        panel.add(visavisCheck);

        equipedCheck = new JCheckBox("equiped");
        equipedCheck.setSelected(false);
        equipedCheck.setBounds(210, 200, 80, 25);
        equipedCheck.addItemListener(new CheckBox());
        panel.add(equipedCheck);

        meubledCheck = new JCheckBox("meubled");
        meubledCheck.setSelected(false);
        meubledCheck.setBounds(310, 200, 80, 25);
        meubledCheck.addItemListener(new CheckBox());
        panel.add(meubledCheck);

        nbrFloorLabel = new JLabel("nbrFloor:");
        nbrFloorLabel.setBounds(10, 260, 80, 25);
        String[] numberFloorStrings = {"0", "1", "2", "3", "4", "5"};
        nbrFloorList = new JComboBox(numberFloorStrings);
        nbrFloorList.setSelectedIndex(0);
        nbrFloorList.setBounds(60, 260, 80, 25);
        nbrFloorList.addActionListener(new ActionComboFloor());
        panel.add(nbrFloorLabel);
        panel.add(nbrFloorList);

        nbrBedRoomLabel = new JLabel("nbrBedRoom:");
        nbrBedRoomLabel.setBounds(140, 260, 80, 25);
        String[] nbrBedRoomStrings = {"1", "2", "3", "4", "5", "6", "7", "8"};
        nbrBedRoomList = new JComboBox(nbrBedRoomStrings);
        nbrBedRoomList.setSelectedIndex(0);
        nbrBedRoomList.setBounds(220, 260, 80, 25);
        nbrBedRoomList.addActionListener(new ActionComboBedRoom());
        panel.add(nbrBedRoomLabel);
        panel.add(nbrBedRoomList);

        nbrBathRoomLabel = new JLabel("nbrBathRoom:");
        nbrBathRoomLabel.setBounds(300, 260, 80, 25);
        String[] nbrBathRoomStrings = {"1", "2", "3", "4", "5", "6", "7", "8"};
        nbrBathRoomList = new JComboBox(nbrBathRoomStrings);
        nbrBathRoomList.setSelectedIndex(0);
        nbrBathRoomList.setBounds(390, 260, 80, 25);
        nbrBathRoomList.addActionListener(new ActionComboBathRoom());
        panel.add(nbrBathRoomLabel);
        panel.add(nbrBathRoomList);
        
        button1 = new JButton("SUBMIT");
        button1.setBounds(300, 320, 200, 25);
        panel.add(button1);
        button1.addActionListener(new SellerPage2());
        
        frame.setVisible(true);
    }
    
    public String[] createRea() {
       String[] stringRea;
        if(getREAList().isEmpty()==false)
        {
            stringRea = new String[getREAList().size()];
        for (int i = 0; i < getREAList().size(); ++i) {
            stringRea[i] =getREAList().get(i).getLogin()+" "+ getREAList().get(i).getNom(); 
        }
        
        }
        else
        {
            stringRea = new String[1];
           stringRea[0]=" ";
           
        }
        return stringRea;   
    }
    
    public class ActionComboREA implements ActionListener {

        
         private  String reaConcerned;

        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox cb = (JComboBox) ae.getSource();
            reaConcerned = (String) cb.getSelectedItem();
            findIdVisitConcerned();

        }

        

        public void findIdVisitConcerned() {
           String s;
            for (int i = 0; i < getREAList().size(); ++i) {
                s=String.valueOf(getREAList().get(i).getLogin());
                String s1=s+" "+getREAList().get(i).getNom();
                if (s1.equals(reaConcerned)) {
                    currentREA = i;
                    //System.out.println(currentIndexVisit);

                }

            }

        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
      
        String priceS=priceText.getText();
        String sizeS=sizeText.getText();
        String country=countryText.getText();
        String city=cityText.getText();
        String street=streetText.getText();
        int size=parseInt(sizeS);
        double price=parseDouble(priceS);
        EstateDaoImpl estateDao=new EstateDaoImpl();
        if(typeEstate.equals("appartement"))
        {
            Appartement estate=new Appartement(getIdLastEstate(),size,country,city,street,price,getSList().get(getIndexUser()),getREAList().get(currentREA),nbrFloor,equiped,meubled,visavis,typeEstate,nbrBedRoom,nbrBathRoom);
            estateDao.addAppart(estate);
                    
                    //int id,int size,String country,String city, String street , double price,Seller seller,
            //RealEstateAgent realEstateAgent, int numberOfFloor, boolean equiped,boolean meubled,boolean visavis, String type, int nor, int nob
        }
        
        
        
        
    }

    
    
    public class CheckBox implements ItemListener {

       

        @Override
        public void itemStateChanged(ItemEvent ie) {
           Object source = ie.getItemSelectable();
            if (source == jardinCheck) {
                garden = true;
            } else if (source == meubledCheck) {
                meubled = true;
            } else if (source == equipedCheck) {
                equiped = true;
            } else if (source == visavisCheck) {
                visavis = true;
            }
        }

    }
    
    class ActionComboFloor implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String nbrFloorS = (String) cb.getSelectedItem();
            nbrFloor = parseInt(nbrFloorS);
        }
    }

    class ActionComboBedRoom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String nbrBedRoomS = (String) cb.getSelectedItem();
            nbrBedRoom = parseInt(nbrBedRoomS);
        }

    }

    class ActionComboBathRoom implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            String nbrBathRoomS = (String) cb.getSelectedItem();
            nbrBathRoom = parseInt(nbrBathRoomS);
        }
    }
    
    class actionComboType implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            typeEstate = (String) cb.getSelectedItem();

        }
    }
    
}