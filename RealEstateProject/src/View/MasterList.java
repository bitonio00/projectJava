/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Model.*;
import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class MasterList {
private static ArrayList<Buyer>m_listBuyer;
private static ArrayList<Seller>m_listSeller;
private static ArrayList<Estate>m_listEstate;
private static ArrayList<Offer>m_listOffer;
private static ArrayList<RealEstateAgent>m_listRealEstateAgent;
private static ArrayList<Visit>m_listVisit;

public void loadGui()
{
    TypePage a=new TypePage();
    a.LoadTypePage();
}
public void setList(ArrayList<Buyer>listBuyer,ArrayList<Seller>listSeller,ArrayList<RealEstateAgent>listRealEstateAgent,ArrayList<Estate>listEstate)
{
    m_listBuyer=new ArrayList<Buyer>();
        for(int i=0;i<listBuyer.size(); ++i)
        {
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password
            m_listBuyer.add(new Buyer(listBuyer.get(i).getNom(),listBuyer.get(i).getPrenom(), listBuyer.get(i).getDate().getYear(), 
             listBuyer.get(i).getDate().getMonth(), listBuyer.get(i).getDate().getDay(),  listBuyer.get(i).getAdress().getCountry(),
             listBuyer.get(i).getAdress().getCity(), listBuyer.get(i).getAdress().getStreet(), listBuyer.get(i).getLogin(), listBuyer.get(i).getPassword()));
        }
        m_listSeller=new ArrayList<Seller>();
        for(int i=0;i<listSeller.size(); ++i)
        {
           // String nom, String prenom,int year,int month,int day,   String country,String city,String street ,int login, String password
            m_listSeller.add(new Seller(listSeller.get(i).getNom(),listSeller.get(i).getPrenom(), listSeller.get(i).getDate().getYear(), 
             listSeller.get(i).getDate().getMonth(), listSeller.get(i).getDate().getDay(),  listSeller.get(i).getAdress().getCountry(),
             listSeller.get(i).getAdress().getCity(), listSeller.get(i).getAdress().getStreet(), listSeller.get(i).getLogin(), listSeller.get(i).getPassword()));
        }
        m_listRealEstateAgent=new ArrayList<RealEstateAgent>();
        for(int i=0;i<listRealEstateAgent.size(); ++i)
        {
            //(int year,int month, int day, String nom, String prenom , int login, String password,double commission,String country,String city,String street
        
            m_listRealEstateAgent.add(new RealEstateAgent(listRealEstateAgent.get(i).getDate().getYear(),listRealEstateAgent.get(i).getDate().getMonth(),listRealEstateAgent.get(i).getDate().getDay(), 
                    listRealEstateAgent.get(i).getNom(),listRealEstateAgent.get(i).getPrenom(),listRealEstateAgent.get(i).getLogin(),listRealEstateAgent.get(i).getPassword(), listRealEstateAgent.get(i).getCommission(),
                    listRealEstateAgent.get(i).getAdress().getCountry(), listRealEstateAgent.get(i).getAdress().getCity(), listRealEstateAgent.get(i).getAdress().getStreet()));
        }
        m_listEstate=new ArrayList<Estate>();
        for(int i=0;i <listEstate.size();i++)
        {
            if(listEstate.get(i).getType().equals("house"))
            {

                m_listEstate.add(new House(listEstate.get(i).getId(),listEstate.get(i).getSize(),listEstate.get(i).getAdress().getCountry()
                ,listEstate.get(i).getAdress().getCity(),listEstate.get(i).getAdress().getStreet()
                ,listEstate.get(i).getPrice(),listEstate.get(i).getSeller(),listEstate.get(i).getAgent(),listEstate.get(i).getHouseType()
                ,listEstate.get(i).getNOF(), listEstate.get(i).getMeubled(),listEstate.get(i).getEquiped(),listEstate.get(i).getGarden()
                ,listEstate.get(i).getType()));

            }

                if(listEstate.get(i).getType().equals("appartement"))
                {

                    m_listEstate.add(new Appartement(listEstate.get(i).getId(),listEstate.get(i).getSize(),listEstate.get(i).getAdress().getCountry()
                            ,listEstate.get(i).getAdress().getCity(),listEstate.get(i).getAdress().getStreet()
                            ,listEstate.get(i).getPrice(),listEstate.get(i).getSeller(),listEstate.get(i).getAgent()
                            ,listEstate.get(i).getNOF(), listEstate.get(i).getEquiped(),listEstate.get(i).getMeubled(),listEstate.get(i).getvisavis()
                            ,listEstate.get(i).getType()));
                }

                if(listEstate.get(i).getType().equals("local"))
                {

                    m_listEstate.add(new Local(listEstate.get(i).getId(),listEstate.get(i).getSize(),listEstate.get(i).getAdress().getCountry()
                    ,listEstate.get(i).getAdress().getCity(),listEstate.get(i).getAdress().getStreet()
                    ,listEstate.get(i).getPrice(),listEstate.get(i).getSeller(),listEstate.get(i).getAgent(),listEstate.get(i).getLocalType()
                    , listEstate.get(i).getEquiped(),listEstate.get(i).getMeubled(),listEstate.get(i).getNOF()
                    ,listEstate.get(i).getType()));

                }

            }
}


public void addBuyer(Buyer a)
{
    m_listBuyer.add(a);
}

public void addSeller(Seller a)
{
    m_listSeller.add(a);
}
public void addREA(RealEstateAgent a)
{
    m_listRealEstateAgent.add(a);
}
public ArrayList<Seller> getSList()
{
    return m_listSeller;
}

public ArrayList<Buyer> getBList()
{
    return m_listBuyer;
}
public ArrayList<Estate> getEList()
{
    return m_listEstate;
}
public ArrayList<RealEstateAgent> getREAList()
{
    return m_listRealEstateAgent;
}
public ArrayList<Offer> getOList()
{
    return m_listOffer;
}
public ArrayList<Visit> getVList()
{
    return m_listVisit;
}


    
}
