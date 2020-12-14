/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Visit;
import Model.VisitDaoImpl;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class SellerPageAddVisit extends MasterList implements ActionListener{
    
    
    private static JPanel panel;
    private static JFrame frame;
    private static int indexEstateConcerned;
    private static JLabel yearLabel;
    private static JLabel monthLabel;
    private static JLabel dayLabel;
    private static JLabel hoursLabel;
    private static JLabel minuteLabel;
    private static JLabel textLabel;
    private static JTextField yearText;
    private static JTextField monthText;
    private static JTextField dayText;
    private static JTextField hoursText;
    private static JTextField minuteText;
    private static JButton button1;
    private static JButton returnButton;
    
    public void loadSellerPageAddVisit()
    {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
         panel.setLayout(null);
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

        panel.add(textLabel);
 
        yearLabel = new JLabel("YEAR:");
        yearLabel.setBounds(10, 700, 100, 50);
        yearText = new JTextField(15);
        yearText.setBounds(150, 700, 100, 50);
        panel.add(yearLabel);
        panel.add(yearText);
        
        monthLabel = new JLabel("MONTH:");
        monthLabel.setBounds(250, 700, 100, 50);
        monthText = new JTextField(15);
        monthText.setBounds(340, 700, 100, 50);
        panel.add(monthLabel);
        panel.add(monthText);
        
        dayLabel = new JLabel("DAY:");
        dayLabel.setBounds(450, 700, 100, 50);
        dayText = new JTextField(15);
        dayText.setBounds(550, 700, 100, 50);
        panel.add(dayLabel);
        panel.add(dayText);
        
        hoursLabel = new JLabel("HOURS:");
        hoursLabel.setBounds(650, 700, 100, 50);
        hoursText = new JTextField(15);
        hoursText.setBounds(750, 700, 100, 50);
        panel.add(hoursLabel);
        panel.add(hoursText);
        
        minuteLabel = new JLabel("MINUTES:");
        minuteLabel.setBounds(850, 700, 100, 50);
        minuteText = new JTextField(15);
        minuteText.setBounds(950, 700, 100, 50);
        panel.add(minuteLabel);
        panel.add(minuteText);
        
        button1 = new JButton("SUBMIT");
        button1.setBounds(100, 900, 200, 50);
        panel.add(button1);
        button1.addActionListener(new SellerPageAddVisit());
        
        returnButton=new JButton("return");
        returnButton.setBounds(650, 950, 200, 50);
        panel.add(returnButton);
        returnButton.addActionListener(new SellerPageAddVisit.ActionReturn());
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        boolean error=false;
        String yearS=yearText.getText();
        int year=parseInt(yearS);
        if(year<1900 || year>2020  )
          {
           error=true;
            yearText.setForeground(Color.red);
            }
          else
            yearText.setForeground(Color.black);
        String monthS=monthText.getText();
        
        int month=parseInt(monthS);
        if(month<1 || month>12)
        {
        error=true;
            monthText.setForeground(Color.red);
            }
          else
          monthText.setForeground(Color.black);

        String dayS=dayText.getText();
        int day=parseInt(dayS);
        if(day<1 || day>31)
        {
        error=true;
       dayText.setForeground(Color.red);
            }
          else
          dayText.setForeground(Color.black);
 
        String hoursS=hoursText.getText();
        int hours=parseInt(hoursS);
          if(hours<8 || hours>19)
        {error=true;
            hoursText.setForeground(Color.red);
            }
          else
         hoursText.setForeground(Color.black);
        String minuteS=minuteText.getText();
        int minute=parseInt(minuteS);
        if(minute<0 || minute>59)
        {
            error=true;
            minuteText.setForeground(Color.red);
            }
          else
          minuteText.setForeground(Color.black);
         
        //int year, int month, int day, int hour, int minute, int id, Buyer buyer, House houseconcerned,boolean reserved
        if(error == false){
        Visit visit=new Visit(year,month,day,hours,minute,getIdLastVisit(),getEList().get(indexEstateConcerned));
        addVisit(visit);
        VisitDaoImpl visitDao=new VisitDaoImpl();
        visitDao.addVisit(visit);
        frame.setVisible(false);
        frame.dispose();
        SellerPage page=new SellerPage();
        page.loadSellerPage();}
    
    }
    
    public void setIndex(int i)
    {
        indexEstateConcerned=i;
    }
       public class ActionReturn implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent ae) {
            frame.setVisible(false);
            frame.dispose();
            SellerPage sellerpage=new SellerPage ();
         sellerpage.loadSellerPage();

        }

    }
    
}
