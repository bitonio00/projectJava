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
public class Appartement extends Estate   {
    
    
    private boolean m_visavis;
    private int m_nor;
    private int m_nob;     
    public Appartement(int id,int size,String country,String city, String street , double price,Seller seller,
            RealEstateAgent realEstateAgent, int numberOfFloor, boolean equiped,boolean meubled,boolean visavis, String type, int nor, int nob)
    {
        super(id,size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled,type);
   
    m_visavis=visavis;
    m_nob=nob;
    m_nor=nor;
    }
    public Appartement(int id,int size,String country,String city, String street , double price,Seller seller,
            RealEstateAgent realEstateAgent, int numberOfFloor, boolean equiped,boolean meubled,boolean visavis, String type, int nor, int nob,boolean b)  //on surchage le constructeurs
    {
        super(id,size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled,type,b); //appelle constructeur class mere
   
    m_visavis=visavis;
    m_nob=nob;
    m_nor=nor;
    }
    @Override
    public boolean getvisavis()
    {
    return m_visavis;
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
