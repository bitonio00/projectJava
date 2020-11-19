/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realestateproject;

/**
 *
 * @author benoi
 */
public class Adress {
   private String m_country;
      private String m_city;
       private String m_street;
    
    public Adress( String country ,String city, String street) 
    {
        m_country=country;
        m_city=city;
         m_street=street;
        
        
    }
    public String toString()
    {
        return m_country+" "+m_city+" "+m_street;
    }
    public String getCountry()
    {
    return m_country;

    }
    public String getCity()
    {
    return m_city;
    }
    public String getStreet()
    {
    return m_street;

    }
}
