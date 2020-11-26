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
    private RealEstateAgent m_estateagent;
    private int m_id;
    private int m_year;
    private int m_month;
    private int m_day;
    private int m_hour;
    private int m_minute;
    // acompleter avec benoit

public Visit(int year,int month,int day, int hour, int minute,int id, Buyer buyer, RealEstateAgent agent,House houseconcerned )
{
m_id=id;
m_year=year;
m_month=month;
m_day=day;
m_hour=hour;
m_minute=minute;
m_estateviewed = new House(houseconcerned.getId(), houseconcerned.getSize(),houseconcerned.getAdress().getCountry(),houseconcerned.getAdress().getCity(),
            houseconcerned.getAdress().getStreet(), houseconcerned.getPrice(),houseconcerned.getSeller(),houseconcerned.getAgent(),houseconcerned.getHouseType(),houseconcerned.getNOF(),houseconcerned.getMeubled(),
           houseconcerned.getEquiped(),houseconcerned.getGarden(),houseconcerned.getType(),houseconcerned.getNor(),houseconcerned.getNob());
m_estatebuyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword());

m_estateagent= new  RealEstateAgent(agent.getDate(),
agent.getNom(),agent.getPrenom(),agent.getLogin(),agent.getPassword(),agent.getCommission(),
agent.getAdress().getCountry(),agent.getAdress().getCity(),agent.getAdress().getStreet());

}

public Visit(int year,int month,int day, int hour, int minute,int id, Buyer buyer, RealEstateAgent agent,Local localConcerned )
{
m_id=id;
m_year=year;
m_month=month;
m_day=day;
m_hour=hour;
m_minute=minute;
m_estateviewed = new Local(localConcerned.getId(),localConcerned.getSize(),localConcerned.getAdress().getCountry(),localConcerned.getAdress().getCity(),
localConcerned.getAdress().getStreet(),localConcerned.getPrice(),localConcerned.getSeller(),localConcerned.getAgent(),localConcerned.getLocalType(),
        localConcerned.getEquiped(),localConcerned.getMeubled(),localConcerned.getNOF(),localConcerned.getType());
m_estatebuyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword());

m_estateagent= new  RealEstateAgent(agent.getDate(),
agent.getNom(),agent.getPrenom(),agent.getLogin(),agent.getPassword(),agent.getCommission(),
agent.getAdress().getCountry(),agent.getAdress().getCity(),agent.getAdress().getStreet());

}

public Visit(int year,int month,int day, int hour, int minute,int id, Buyer buyer, RealEstateAgent agent,Appartement aptconcerned )
{
m_id=id;
m_year=year;
m_month=month;
m_day=day;
m_hour=hour;
m_minute=minute;
m_estateviewed = new Appartement(aptconcerned.getId(),aptconcerned.getSize(),aptconcerned.getAdress().getCountry(),aptconcerned.getAdress().getCity(),
aptconcerned.getAdress().getStreet(),aptconcerned.getPrice(),aptconcerned.getSeller(),aptconcerned.getAgent(),aptconcerned.getNOF(),aptconcerned.getEquiped(),
        aptconcerned.getMeubled(),aptconcerned.getvisavis(),aptconcerned.getType(),aptconcerned.getNor(),aptconcerned.getNob());
m_estatebuyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword());

m_estateagent= new  RealEstateAgent(agent.getDate(),
agent.getNom(),agent.getPrenom(),agent.getLogin(),agent.getPassword(),agent.getCommission(),
agent.getAdress().getCountry(),agent.getAdress().getCity(),agent.getAdress().getStreet());

}


public void display()
{
System.out.println("date: " + m_day + " "+ m_month+ " "+ m_year +" "+ m_hour+" " +m_minute
+ "adresse: "+ m_estateviewed.getAdress()+"buyer: "+ m_estatebuyer.getNom()+ "agent: "+m_estateagent.getNom());
}

}
