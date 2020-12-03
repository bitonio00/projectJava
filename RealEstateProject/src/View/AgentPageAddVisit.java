/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Visit;
import Model.VisitDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author benoi
 */
public class AgentPageAddVisit extends MasterList implements ActionListener {
    
    private static JPanel panel;
    private static JFrame frame;
    private static int indexEstateConcerned;
    private static JLabel yearLabel;
    private static JLabel monthLabel;
    private static JLabel dayLabel;
    private static JLabel hoursLabel;
    private static JLabel minuteLabel;
    private static JTextField yearText;
    private static JTextField monthText;
    private static JTextField dayText;
    private static JTextField hoursText;
    private static JTextField minuteText;
    private static JButton button1;
    
    public void loadAgentPageAddVisit()
    {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);
        
        
        yearLabel = new JLabel("YEAR:");
        yearLabel.setBounds(10, 10, 100, 50);
        yearText = new JTextField(15);
        yearText.setBounds(150, 10, 100, 50);
        panel.add(yearLabel);
        panel.add(yearText);
        
        monthLabel = new JLabel("MONTH:");
        monthLabel.setBounds(250, 10, 100, 50);
        monthText = new JTextField(15);
        monthText.setBounds(340, 10, 100, 50);
        panel.add(monthLabel);
        panel.add(monthText);
        
        dayLabel = new JLabel("DAY:");
        dayLabel.setBounds(450, 10, 100, 50);
        dayText = new JTextField(15);
        dayText.setBounds(550, 10, 100, 50);
        panel.add(dayLabel);
        panel.add(dayText);
        
        hoursLabel = new JLabel("HOURS:");
        hoursLabel.setBounds(650, 10, 100, 50);
        hoursText = new JTextField(15);
        hoursText.setBounds(750, 10, 100, 50);
        panel.add(hoursLabel);
        panel.add(hoursText);
        
        minuteLabel = new JLabel("MINUTES:");
        minuteLabel.setBounds(850, 10, 100, 50);
        minuteText = new JTextField(15);
        minuteText.setBounds(950, 10, 100, 50);
        panel.add(minuteLabel);
        panel.add(minuteText);
        
        button1 = new JButton("SUBMIT");
        button1.setBounds(100, 100, 200, 50);
        panel.add(button1);
        button1.addActionListener(new AgentPageAddVisit());
        
        
        
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        String yearS=yearText.getText();
        String monthS=monthText.getText();
        String dayS=dayText.getText();
        String hoursS=hoursText.getText();
        String minuteS=minuteText.getText();
        int year=parseInt(yearS);
        int month=parseInt(monthS);
        int day=parseInt(dayS);
        int hours=parseInt(hoursS);
        int minute=parseInt(minuteS);
        //int year, int month, int day, int hour, int minute, int id, Buyer buyer, House houseconcerned,boolean reserved
        
        Visit visit=new Visit(year,month,day,hours,minute,getIdLastVisit(),getEList().get(indexEstateConcerned));
        addVisit(visit);
        VisitDaoImpl visitDao=new VisitDaoImpl();
        visitDao.addVisit(visit);
        frame.setVisible(false);
        frame.dispose();
        AgentPage page=new AgentPage();
        page.loadAgentPage();
    
    }
    
    public void setIndex(int i)
    {
        indexEstateConcerned=i;
    }
    
}
