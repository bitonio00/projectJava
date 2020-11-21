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
   
public Local(int size,String country,String city, String street , double price,Seller seller, RealEstateAgent realEstateAgent, String localType,boolean equiped, boolean meubled, int numberOfFloor)
{
       
           super( size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled);
        

m_localType= localType;
}
public String getLocalType()
{
return m_localType;
}
}
