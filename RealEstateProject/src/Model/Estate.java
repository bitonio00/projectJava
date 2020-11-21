/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public abstract class Estate {
    private int m_size;
    private Adress m_adress;
    private double m_price;
    private Seller m_seller;
    private RealEstateAgent m_RealEstateAgent;
    private String m_features;
     private int m_numberOfFloor;
    private boolean m_meubled;
    private boolean m_equiped; 




    public Estate(int size,String country,String city, String street , double price,Seller seller, RealEstateAgent realEstateAgent,  int numberOfFloor,boolean equiped, boolean meubled)
{
    m_meubled=meubled;
    m_equiped=equiped;
    m_numberOfFloor=numberOfFloor;

m_size=size;

m_price=price;
m_seller= new Seller(seller.getNom(),seller.getPrenom(),seller.getDate().getYear(),seller.getDate().getMonth(),seller.getDate().getDay(),
        seller.getAdress().getCountry(),seller.getAdress().getCity(),seller.getAdress().getStreet(), seller.getLogin(),seller.getPassword());
m_RealEstateAgent=new RealEstateAgent(realEstateAgent.getDate().getYear() ,realEstateAgent.getDate().getMonth(),realEstateAgent.getDate().getDay(),
    realEstateAgent.getNom(),realEstateAgent.getPrenom(),realEstateAgent.getLogin(),realEstateAgent.getPassword(),realEstateAgent.getCommission(),realEstateAgent.getAdress().getCountry(),
realEstateAgent.getAdress().getCity(),realEstateAgent.getAdress().getStreet());

m_adress= new Adress(country,city,street);
}
public int getSize()
{
return m_size;
}

public double getPrice()
{
return m_price;
}
public Adress getAdress()
{
return m_adress;
}
public Seller getSeller()
{
return m_seller;
}
public RealEstateAgent getAgent()
{
return m_RealEstateAgent;
}
public int getNOF ()
{
    return m_numberOfFloor;
    
}
public boolean getEquiped()
{
return m_equiped;
}

public boolean getMeubled()
{
return m_meubled;
}




}
