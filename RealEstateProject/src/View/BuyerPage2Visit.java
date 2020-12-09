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
public class BuyerPage2Visit extends MasterList implements ActionListener {
    
    private static JPanel panel;
    private static JFrame frame;
    private static int indexEstateConcerned;
    private static ArrayList<Visit>listVisitConcerned;
    private static JComboBox visitList;
    private static JButton button1;
    private static String visitStrings;
    private static int currentIndexVisit;
    private static int indexVisitConcerned;
    private static int indexVisit;
    private static JButton returnButton;
    private static JLabel textLabel;
    private ArrayList<Estate>m_listEstateConcerned;
            
    public void setListEstate(ArrayList<Estate>listEstateConcerned)
    {
        m_listEstateConcerned=new ArrayList<Estate>();
        m_listEstateConcerned=listEstateConcerned;
    }
    
    public BuyerPage2Visit()
    {
       
    }
    
    
    public void loadBuyerPage2Visit()
    {
        findVisitsConcerned();
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
        
         JLabel fondL= new JLabel("CasaDelSol");
        fondL.setBounds(820, 450, 1000, 200);
        fondL.setForeground(Color.blue);

        fondL.setFont(new Font("Verdera", Font.PLAIN,45));

        panel.add(fondL);

        textLabel=new JLabel("Connect As");
        textLabel.setBounds(850,600,200,200);
        textLabel.setForeground(Color.blue);
        textLabel.setFont(new Font("Verdera", Font.PLAIN,35));
        
        String[] visitStrings = new String[listVisitConcerned.size()];
        visitStrings=createStringVisit();
        visitList = new JComboBox(visitStrings);
        visitList.setSelectedIndex(0);
        visitList.setBounds(500, 600, 500, 25);
        //visitList.setSize(500, 30);
        visitList.addActionListener(new ActionComboVisit());
        panel.add(visitList);
        
        button1=new JButton("Book a Visit");
        button1.setBounds(1100,600,100,50);
       // button1.setSize(200, 50);
        panel.add(button1);
        button1.addActionListener(new BuyerPage2Visit());
        
        returnButton=new JButton("return");
        returnButton.setBounds(400, 900, 100, 50);
        panel.add(returnButton);
        returnButton.addActionListener(new ActionReturn());
        
        frame.setVisible(true);
        
        
    }
    public void setIndexEstateConcerned(int i)
    {
        indexEstateConcerned=i;
        
    }

    public void findVisitsConcerned()
    {
        listVisitConcerned=new ArrayList<Visit>();
        for(int i=0;i<getVList().size();++i)
        {
            if(getVList().get(i).getEstate().getId()==getEList().get(indexEstateConcerned).getId() && getVList().get(i).getReserved()==false)
            {
                listVisitConcerned.add(getVList().get(i));
                System.out.println("gggg");
            }
        }
    }
    public String[]createStringVisit()
    {
        String[]stringEstate=new String[listVisitConcerned.size()];
        for(int i=0;i<listVisitConcerned.size();++i)
        {
            stringEstate[i]=listVisitConcerned.get(i).getEstate().getAdress().getFullAdress()+" date:"+listVisitConcerned.get(i).getYear()+"/"+listVisitConcerned.get(i).getMonth()+"/"+listVisitConcerned.get(i).getDay()+" "+listVisitConcerned.get(i).getHour()+"H"+listVisitConcerned.get(i).getMinute();
        }
        return stringEstate;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
       
        getVList().get(indexVisit).setBuyer(getBList().get( getIndexUser()));
        VisitDaoImpl a=new VisitDaoImpl();
        a.updateVisit( getVList().get(indexVisit));
        frame.setVisible(false);
        frame.dispose();
        BuyerPage0 buyerpage= new BuyerPage0();
        buyerpage.loadBuyerPage0();
         
    }
    
    public class ActionComboVisit implements  ActionListener
    {
        private  String visitTime;
        

        @Override
        public void actionPerformed(ActionEvent ae) {
            JComboBox cb = (JComboBox) ae.getSource();
             visitTime = (String) cb.getSelectedItem();
             findVisit();
             findIdVisitConcerned();
            
            
            
            
            
            }
        public void findVisit()
        {
            System.out.println(listVisitConcerned.size());
            for(int v=0;v<listVisitConcerned.size();++v)
            {   
                if(visitTime.equals(listVisitConcerned.get(v).getEstate().getAdress().getFullAdress()+listVisitConcerned.get(v).getFullDate()))
                {
                    
                    indexVisitConcerned=v;
                }
            }
            
        }
        public void findIdVisitConcerned()
        {
            System.out.print(indexVisitConcerned);
            for(int i=0;i<getVList().size();++i)
            {
                if(getVList().get(i).getId()==listVisitConcerned.get(indexVisitConcerned).getId())
                {
                    indexVisit=i;
                    
                }
                    
            }
            
        }

            
            
        
        }
     public class ActionReturn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            BuyerPage buyerpage= new BuyerPage();
           buyerpage.loadBuyerPage();
                        
        }
        
    }
    
}
