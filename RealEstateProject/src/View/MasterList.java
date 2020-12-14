/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;


import Model.*;
import java.io.IOException;
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
private static int indexUser;

public void loadGui() throws IOException
{
    TypePage a=new TypePage();
    a.LoadTypePage();
}
public void setidUser(int i)
{
    indexUser=i;
}
public void setList(ArrayList<Buyer>listBuyer,ArrayList<Seller>listSeller,ArrayList<RealEstateAgent>listRealEstateAgent,ArrayList<Estate>listEstate,ArrayList<Offer>listOffer,ArrayList<Visit>listVisit)
{
        m_listBuyer=new ArrayList<Buyer>();
        m_listBuyer=listBuyer;
        m_listSeller=new ArrayList<Seller>();
        m_listSeller=listSeller;
        m_listRealEstateAgent=new ArrayList<RealEstateAgent>();
        m_listRealEstateAgent=listRealEstateAgent;
        m_listEstate=new ArrayList<Estate>();
        m_listEstate=listEstate;
        m_listOffer=new ArrayList<Offer>();
        m_listOffer=listOffer;
        m_listVisit=new ArrayList<Visit>();
        m_listVisit=listVisit;
       
                

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
public void addEstate(Appartement a)
{
    m_listEstate.add(a);
}
public void addEstate(House a)
{
    m_listEstate.add(a);
}
public void addEstate(Local a)
{
    m_listEstate.add(a);
}
public void addOffer(Offer a)
{
    m_listOffer.add(a);
}
public void addVisit(Visit a)
{
    m_listVisit.add(a);
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
public int getIndexUser()
{
    return indexUser;
}
public int getIdLastOffer()
{
    int v=0;
    if(m_listOffer==null)
    {
        v=1;
        
    }
    else
    {
      for(int i=0;i<m_listOffer.size();++i)
    {
        v=m_listOffer.get(i).getId();
        
    } 
      v=v+1;
    }
    
    return v;
}

public int getIdLastEstate()
{
    int v=0;
    if(m_listEstate==null)
    {
        v=4000;
        
    }
    else
    {
      for(int i=0;i<m_listEstate.size();++i)
    {
        v=m_listEstate.get(i).getId();
        
    } 
      v=v+1;
    }
    
    return v;
}
public int getIdLastVisit()
{
    int v=0;
    if(m_listVisit==null)
    {
        v=1;
        
    }
    else
    {
      for(int i=0;i<m_listVisit.size();++i)
    {
        v=m_listVisit.get(i).getId();
       
    } 
      v=v+1;
    }
    
    return v;
}

public int getIdLastBuyer()
{
    int v=0;
    if(m_listBuyer==null)
    {
        v=1;
        
    }
    else
    {
      for(int i=0;i<m_listBuyer.size();++i)
    {
        v=m_listBuyer.get(i).getLogin();
       
    } 
      v=v+1;
    }
    
    return v;
}
public int getIdLastSeller()
{
    int v=0;
    if(m_listSeller==null)
    {
        v=1;
        
    }
    else
    {
      for(int i=0;i<m_listSeller.size();++i)
    {
        v=m_listSeller.get(i).getLogin();
       
    } 
      v=v+1;
    }
    
    return v;
}

public void removeVisit(Visit visit)
{
    m_listVisit.remove(visit);
}
public void removeOffer(Offer offer)
{
    m_listOffer.remove(offer);
}
public void removeBuyer(Buyer buyer)
{
    m_listBuyer.remove(buyer);
}
public void removeSeller(Seller seller)
{
    m_listSeller.remove(seller);
}
public void removeEstate(Estate estate)
{
    m_listEstate.remove(estate);
}
public void setSoldEstate(int id)
{
for (int i=0;i<m_listEstate.size(); i++)
{
if(id== m_listEstate.get(i).getId())
{
m_listEstate.get(i).setSold();
}
}
    }
    
}
