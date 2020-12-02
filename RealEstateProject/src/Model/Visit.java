/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author benoi
 */
public class Visit {

    private Estate m_estateviewed;
    private Buyer m_estatebuyer;
    private int m_id;
    private int m_year;
    private int m_month;
    private int m_day;
    private int m_hour;
    private int m_minute;
    private boolean m_reserved;
    // acompleter avec benoit

    public Visit(int year, int month, int day, int hour, int minute, int id, Buyer buyer, House houseconcerned,boolean reserved) {
        m_id = id;
        m_year = year;
        m_month = month;
        m_day = day;
        m_hour = hour;
        m_minute = minute;
        m_estateviewed = new House(houseconcerned.getId(), houseconcerned.getSize(), houseconcerned.getAdress().getCountry(), houseconcerned.getAdress().getCity(),
                houseconcerned.getAdress().getStreet(), houseconcerned.getPrice(), houseconcerned.getSeller(), houseconcerned.getAgent(), houseconcerned.getHouseType(), houseconcerned.getNOF(), houseconcerned.getMeubled(),
                houseconcerned.getEquiped(), houseconcerned.getGarden(), houseconcerned.getType(), houseconcerned.getNor(), houseconcerned.getNob());
        if(reserved==true)
        {
             m_estatebuyer = new Buyer(buyer.getNom(), buyer.getPrenom(), buyer.getDate(),
                buyer.getAdress().getCountry(), buyer.getAdress().getCity(), buyer.getAdress().getStreet(), buyer.getLogin(), buyer.getPassword(),buyer.getMail());
        }
        else
            m_estatebuyer=null;
       
        m_reserved=reserved;
    }
    public Visit(int year, int month, int day, int hour, int minute, int id,  Estate estateconcerned) {
        m_id = id;
        m_year = year;
        m_month = month;
        m_day = day;
        m_hour = hour;
        m_minute = minute;
        if(estateconcerned.getType().equals("house"))
        {
             m_estateviewed = new House(estateconcerned.getId(), estateconcerned.getSize(), estateconcerned.getAdress().getCountry(), estateconcerned.getAdress().getCity(),
                estateconcerned.getAdress().getStreet(), estateconcerned.getPrice(), estateconcerned.getSeller(), estateconcerned.getAgent(), estateconcerned.getHouseType(), estateconcerned.getNOF(), estateconcerned.getMeubled(),
                estateconcerned.getEquiped(), estateconcerned.getGarden(), estateconcerned.getType(), estateconcerned.getNor(), estateconcerned.getNob()); 
        }
        else if(estateconcerned.getType().equals("local"))
        {
             m_estateviewed = new Local(estateconcerned.getId(), estateconcerned.getSize(), estateconcerned.getAdress().getCountry(), estateconcerned.getAdress().getCity(),
                estateconcerned.getAdress().getStreet(), estateconcerned.getPrice(), estateconcerned.getSeller(), estateconcerned.getAgent(), estateconcerned.getLocalType(),
                estateconcerned.getEquiped(), estateconcerned.getMeubled(), estateconcerned.getNOF(), estateconcerned.getType());
        }
        else if(estateconcerned.getType().equals("appartement"))
        {
            m_estateviewed = new Appartement(estateconcerned.getId(), estateconcerned.getSize(), estateconcerned.getAdress().getCountry(), estateconcerned.getAdress().getCity(),
                estateconcerned.getAdress().getStreet(), estateconcerned.getPrice(), estateconcerned.getSeller(), estateconcerned.getAgent(), estateconcerned.getNOF(), estateconcerned.getEquiped(),
                estateconcerned.getMeubled(), estateconcerned.getvisavis(), estateconcerned.getType(), estateconcerned.getNor(), estateconcerned.getNob());
        }
      
       m_estatebuyer=null;
       
        m_reserved=false;
    }

    public Visit(int year, int month, int day, int hour, int minute, int id, Buyer buyer, Local localConcerned,boolean reserved) {
        m_id = id;
        m_year = year;
        m_month = month;
        m_day = day;
        m_hour = hour;
        m_minute = minute;
        m_estateviewed = new Local(localConcerned.getId(), localConcerned.getSize(), localConcerned.getAdress().getCountry(), localConcerned.getAdress().getCity(),
                localConcerned.getAdress().getStreet(), localConcerned.getPrice(), localConcerned.getSeller(), localConcerned.getAgent(), localConcerned.getLocalType(),
                localConcerned.getEquiped(), localConcerned.getMeubled(), localConcerned.getNOF(), localConcerned.getType());
        if(reserved==true)
        {
             m_estatebuyer = new Buyer(buyer.getNom(), buyer.getPrenom(), buyer.getDate(),
                buyer.getAdress().getCountry(), buyer.getAdress().getCity(), buyer.getAdress().getStreet(), buyer.getLogin(), buyer.getPassword(),buyer.getMail());
        }
        else
            m_estatebuyer=null;
        
        m_reserved=reserved;
    }

    public Visit(int year, int month, int day, int hour, int minute, int id, Buyer buyer, Appartement aptconcerned,boolean reserved) {
        m_id = id;
        m_year = year;
        m_month = month;
        m_day = day;
        m_hour = hour;
        m_minute = minute;
        m_estateviewed = new Appartement(aptconcerned.getId(), aptconcerned.getSize(), aptconcerned.getAdress().getCountry(), aptconcerned.getAdress().getCity(),
                aptconcerned.getAdress().getStreet(), aptconcerned.getPrice(), aptconcerned.getSeller(), aptconcerned.getAgent(), aptconcerned.getNOF(), aptconcerned.getEquiped(),
                aptconcerned.getMeubled(), aptconcerned.getvisavis(), aptconcerned.getType(), aptconcerned.getNor(), aptconcerned.getNob());
        if(reserved==true)
        {
             m_estatebuyer = new Buyer(buyer.getNom(), buyer.getPrenom(), buyer.getDate(),
                buyer.getAdress().getCountry(), buyer.getAdress().getCity(), buyer.getAdress().getStreet(), buyer.getLogin(), buyer.getPassword(),buyer.getMail());
        }
        else
            m_estatebuyer=null;
        
        m_reserved=reserved;
    }

    public void display() {
        System.out.println("date: " + m_day + " " + m_month + " " + m_year + " " + m_hour + " " + m_minute
                + "adresse: " + m_estateviewed.getAdress() + "buyer: " + m_estatebuyer.getNom() + "agent: " + m_estateviewed.getAgent().getNom()+" reserved:"+m_reserved);
    }
    public Estate getEstate()
    {
        return  m_estateviewed;
    }
    public Buyer getBuyer()
    {
        return m_estatebuyer;
    }
    public RealEstateAgent getREA()
    {
        return m_estateviewed.getAgent();
    }
    public int getId()
    {
        return m_id;
    }
    public int getYear()
    {
        return  m_year;
    }
    public int getMonth()
    {
        return  m_month;
    }
    public int getDay()
    {
        return  m_day;
    }
    public int getHour()
    {
        return  m_hour;
    }
    public int getMinute()
    {
        return  m_minute;
    }
    public boolean getReserved()
    {
        return  m_reserved;
    }
    public String getFullDate()
    {
        return "Year:"+m_year+" month:"+m_month+" day:"+m_day+" hour:"+m_hour+" minute:"+m_minute;
    }
    public String getFullVisit()
    {
        String s;
        if(m_reserved==true)
            s="reserved";
        else
            s="not_reserved";
            
        return s+" "+ m_estateviewed.getAdress().getFullAdress()+" visitBooked: "+getFullDate();
    }
    public void setBuyer(Buyer buyer)
    {
        m_reserved=true;
         m_estatebuyer = new Buyer(buyer.getNom(), buyer.getPrenom(), buyer.getDate(),
                buyer.getAdress().getCountry(), buyer.getAdress().getCity(), buyer.getAdress().getStreet(), buyer.getLogin(), buyer.getPassword(),buyer.getMail());
        
    }
    public void cancelVisit()
    {
        m_reserved=false;
        m_estatebuyer=null;
    }
    
    
  
}
