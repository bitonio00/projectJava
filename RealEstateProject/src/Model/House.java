/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author moule
 */
public class House extends Estate {
    private String m_houseType;
    private boolean m_garden;
    private int m_nor;
    private int m_nob;
    
   

    public House(int id,int size,String country,String city, String street ,
            double price,Seller seller, RealEstateAgent realEstateAgent, String houseType,
            int numberOfFloor, boolean meubled,boolean equiped,boolean garden,String type, int nor, int nob)
    {
    super(id,size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled,type);
    m_nor=nor;
    m_nob=nob;
    m_houseType=  houseType;
   m_garden=garden;
    
    }
    
    public House(int id,int size,String country,String city, String street ,
            double price,Seller seller, RealEstateAgent realEstateAgent, String houseType,
            int numberOfFloor, boolean meubled,boolean equiped,boolean garden,String type, int nor, int nob,boolean b)
    {
    super(id,size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled,type,b);
    m_nor=nor;
    m_nob=nob;
    m_houseType=  houseType;
   m_garden=garden;
    
    }
@Override
public String getHouseType()
{
    return m_houseType;
}
@Override
public boolean getGarden()
{
return m_garden;
}
@Override
public boolean getvisavis()
    {
   return false;
    }
@Override
public String getLocalType()
{
return "0";
}
 @Override
public int getNob()
{
    return m_nob;
}  
@Override
public int getNor()
{
    return m_nor;
}  

}
