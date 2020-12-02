/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author benoi
 */
public class Local extends Estate {

    String m_localType;
   
public Local(int id,int size,String country,String city, String street , double price,Seller seller,
        RealEstateAgent realEstateAgent, String localType,boolean equiped, boolean meubled, int numberOfFloor, String type)
{
       
           super( id,size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled,type);
        

m_localType= localType;
}
public Local(int id,int size,String country,String city, String street , double price,Seller seller,
        RealEstateAgent realEstateAgent, String localType,boolean equiped, boolean meubled, int numberOfFloor, String type,boolean b)
{
       
           super( id,size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled,type,b);
        

m_localType= localType;
}
@Override
public String getLocalType()
{
return m_localType;
}
@Override
public boolean getvisavis()
    {
   return false;
    }
@Override
public String getHouseType()
{
    return "0";
}
@Override
public boolean getGarden()
{
return false;
}
 @Override
public int getNob()
{
    return 0;
} 
@Override
public int getNor()
{
    return 0;
}  
}
