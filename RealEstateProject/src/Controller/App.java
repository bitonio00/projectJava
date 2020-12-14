/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import View.BuyerPage;
import View.MasterList;
import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class App {

private  ArrayList<Buyer>m_listBuyer;
private  ArrayList<Seller>m_listSeller  ; 
private  ArrayList<Estate>m_listEstate  ;
private  ArrayList<Offer>m_listOffer;
private  ArrayList<RealEstateAgent>m_listRealEstateAgent;
private  ArrayList<Visit>m_listVisit;

    
public App()
{
    m_listBuyer=new ArrayList<Buyer>();
    BuyerDaoImpl b=new BuyerDaoImpl(); //on passe par le dao pour lire notre bdd
    m_listBuyer=b.readBuyer();//on remplit nos listes
    
    m_listSeller=new ArrayList<Seller>();
    SellerDaoImpl s=new SellerDaoImpl();
    m_listSeller=s.readSeller();
    
    m_listRealEstateAgent =new ArrayList<RealEstateAgent>();
    RealEstateAgentDaoImpl rea=new RealEstateAgentDaoImpl();
    m_listRealEstateAgent=rea.readRealEstateAgent();
    
    m_listEstate=new ArrayList<Estate>();
    EstateDaoImpl e=new EstateDaoImpl();
    m_listEstate=e.readEstate(m_listRealEstateAgent, m_listSeller);
    
    m_listVisit=new ArrayList<Visit>();
    VisitDaoImpl v=new VisitDaoImpl();
    m_listVisit=v.readVisit(m_listBuyer, m_listEstate);
    
    m_listOffer=new ArrayList<Offer>();
    OfferDaoImpl o=new OfferDaoImpl();
    m_listOffer=o.readOffer(m_listBuyer, m_listEstate);
       
    
}
public ArrayList<Estate> getE()
{
    return m_listEstate;
}
public ArrayList<Buyer> getB()
{
    return m_listBuyer;
}
public ArrayList<Seller> getS()
{
    return m_listSeller;
}
public ArrayList<RealEstateAgent> getR()
{
    return m_listRealEstateAgent;
}
public ArrayList<Offer>getO()
{
    return m_listOffer;
}
public ArrayList<Visit>getV()
{
    return m_listVisit;
}
public void display()
{
     for(int i=0; i<m_listBuyer.size();++i)
    {
        m_listBuyer.get(i).display();
    }
    for(int i=0; i<m_listSeller.size();++i)
    {
        m_listSeller.get(i).display();
    }
    for(int i=0; i<m_listRealEstateAgent.size();++i)
    {

        m_listRealEstateAgent.get(i).display();
    }
    for(int i=0; i<m_listEstate.size();++i)
    {
        m_listEstate.get(i).display();
    }
    for(int i=0; i<m_listOffer.size();++i)
    {
        m_listOffer.get(i).display();
    }
    for(int i=0; i<m_listVisit.size();++i)
    {
        m_listVisit.get(i).display();
    }
}
 

}
