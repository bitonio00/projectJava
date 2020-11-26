
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

 import java.sql.*;
 import java.util.*;


/**
 *
 * @author benoi
 */
public class RealEstateAgency {
    // arraylist de buyers, de seller ,dagent; doffre et de visite
private String m_name;
private ArrayList<Buyer>m_listBuyer;
private ArrayList<Seller>m_listSeller  ;
private ArrayList<Estate>m_listEstate  ;
private ArrayList<Offer>m_listOffer;
private ArrayList<RealEstateAgent>m_listRealEstateAgent;
private ArrayList<Visit>m_listVisit;
private String m_pathToBdd;

public RealEstateAgency(String name,String pathToBdd)
{
    m_name=name;
    m_pathToBdd=pathToBdd;
    //"jdbc:mysql://localhost:3306/estate_agency"
    m_listBuyer=new ArrayList<Buyer>();
    readBuyer();
    m_listSeller= new ArrayList<Seller>();
    readSeller();
    m_listRealEstateAgent= new ArrayList<RealEstateAgent>();
    readRealEstateAgent();
    m_listEstate=new ArrayList<Estate>();
 readEstate();
    m_listOffer=new ArrayList<Offer>();
    readOffer();
    m_listVisit= new ArrayList< Visit>();
    readVisit();
}
public void readBuyer()
{

   
}
public void delateBuyer(int val)
{

    
}

public void displayBuyer()
{
   
}
public int findBuyer(int id)
{
    int v=0;
    for(int i=0; i<m_listBuyer.size(); ++i)
    {
        if(m_listBuyer.get(i).getLogin()==id)
        {
            v=i;
        }
    }
    return v;
}

public void readSeller()
{

    
}


public void displaySeller()
{
    
}

public int findSeller(int id)
{
    int v=0;
    for(int i=0; i<m_listSeller.size(); ++i)
    {
        if(m_listSeller.get(i).getLogin()==id)
        {
            v=i;
        }
    }
    return v;
}
public void readRealEstateAgent()
{

    
}

public void displayRealEstateAgent()
{
    
}
public int findEstateAgent(int id)
{
    int v=0;
    for(int i=0; i<m_listRealEstateAgent.size(); ++i)
    {
        if(m_listRealEstateAgent.get(i).getLogin()==id)
        {
            v=i;
        }
    }
    return v;
}




public void displayOffer()
{
  
}
public void interact()
{
//   m_listOffer.add(m_listBuyer.get(0).makeAnOffer(m_listEstate.get(0), "cash", 20000)) ;
}

public void readEstate()
{

    
}

public void displayEstate()
{
  
}

public int findEstate(int id)
{
    int v=0;
    for(int i=0; i<m_listEstate.size(); ++i)
    {
        if(m_listEstate.get(i).getId()==id)
        {
            v=i;
        }
    }
    return v;
}


public void readOffer()
{

              
}
public void readVisit()
{

   
}
public void displayVisit()
{


  

  

}
public ArrayList<Buyer>getBuyer()
{
return m_listBuyer;
}
public ArrayList<Seller>getSeller()
{
return m_listSeller;
}
public ArrayList<Estate>getEstate()
{
return m_listEstate;
}
public ArrayList<RealEstateAgent>getREA()
{
return m_listRealEstateAgent;
}
}
