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
         
    public Appartement(int size,String country,String city, String street , double price,Seller seller,
            RealEstateAgent realEstateAgent, int numberOfFloor, boolean equiped,boolean meubled,boolean visavis)
    {
        super(size,country,city,street,price,seller,realEstateAgent,numberOfFloor,equiped,meubled);
   
    m_visavis=visavis;
    }
    
    public boolean getvisavis()
    {
    return m_visavis;
    }
}
