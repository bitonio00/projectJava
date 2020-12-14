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
    private int m_id;
    private Adress m_adress;
    private double m_price;
    private Seller m_seller;
    private RealEstateAgent m_RealEstateAgent;
    private int m_numberOfFloor;
    private boolean m_meubled;
    private boolean m_equiped; 
    private String m_type;
    private boolean m_sold;




    public Estate(int id,int size,String country,String city, String street , double price,Seller seller, RealEstateAgent realEstateAgent,
            int numberOfFloor,boolean equiped, boolean meubled,String type)
{
    m_meubled=meubled;
    m_equiped=equiped;
    m_numberOfFloor=numberOfFloor;
    m_id=id;
    m_type=type;
m_size=size;

m_price=price;
m_seller= new Seller(seller.getNom(),seller.getPrenom(),seller.getDate(),
        seller.getAdress().getCountry(),seller.getAdress().getCity(),seller.getAdress().getStreet(), seller.getLogin(),seller.getPassword(),seller.getMail());
m_RealEstateAgent=new RealEstateAgent(realEstateAgent.getDate(),
    realEstateAgent.getNom(),realEstateAgent.getPrenom(),realEstateAgent.getLogin(),realEstateAgent.getPassword(),realEstateAgent.getCommission(),realEstateAgent.getAdress().getCountry(),
realEstateAgent.getAdress().getCity(),realEstateAgent.getAdress().getStreet(),realEstateAgent.getMail());

m_adress= new Adress(country,city,street);

m_sold=false;
}

public Estate(int id,int size,String country,String city, String street , double price,Seller seller, RealEstateAgent realEstateAgent,
            int numberOfFloor,boolean equiped, boolean meubled,String type,boolean b)
{
    m_meubled=meubled;
    m_equiped=equiped;
    m_numberOfFloor=numberOfFloor;
    m_id=id;
    m_type=type;
m_size=size;

m_price=price;
m_seller= new Seller(seller.getNom(),seller.getPrenom(),seller.getDate(),
        seller.getAdress().getCountry(),seller.getAdress().getCity(),seller.getAdress().getStreet(), seller.getLogin(),seller.getPassword(),seller.getMail());
m_RealEstateAgent=new RealEstateAgent(realEstateAgent.getDate(),
    realEstateAgent.getNom(),realEstateAgent.getPrenom(),realEstateAgent.getLogin(),realEstateAgent.getPassword(),realEstateAgent.getCommission(),realEstateAgent.getAdress().getCountry(),
realEstateAgent.getAdress().getCity(),realEstateAgent.getAdress().getStreet(),realEstateAgent.getMail());

m_adress= new Adress(country,city,street);

m_sold=b;
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
public int getId()
{
    return m_id;
}  

public String getType()
{
return m_type;
}

public String getFullSpec()
{   String string0="vendu";
    String string1=String.valueOf(m_price);
    if(m_sold==false)
    {
     return m_adress.getFullAdress()+" price:"+string1;   
    }
    else
        return  m_adress.getFullAdress()+" price:"+string1+" "+string0;
    
}

public boolean getSold()
{
    return m_sold;
}
public void soldEstate()
{
    m_sold=true;
    EstateDaoImpl estate=new EstateDaoImpl();
    estate.sellEstate(this);
}

public void setSold()
{
m_sold=true;
}

public void display()
{
    System.out.println( "size: "+m_size+"adress: "+m_adress+"price: "+m_price+"seller: "+m_seller.getPrenom()+
            m_seller.getNom()+"agent: "+m_RealEstateAgent.getPrenom()+m_RealEstateAgent.getNom()+"number of floor: "+m_numberOfFloor
    +"equiped: " + m_equiped+"meubled: "+m_meubled);
}
public abstract boolean getvisavis();
public abstract String getHouseType();
public abstract boolean getGarden();
public abstract String getLocalType();
public abstract int getNor();
public abstract int getNob();

}
