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
    
   

    public House(int id,int size,String country,String city, String street ,
            double price,Seller seller, RealEstateAgent realEstateAgent, String houseType,
            int numberOfFloor, boolean meubled,boolean equiped,boolean garden,String type)
    {
    super(id,size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled,type);
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


}