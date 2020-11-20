/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realestateproject;

import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public abstract class Estate {
    private int m_size;
    private Adress m_adress;
    private double m_price;
 
   
    
public  Estate(int size,String country,String city, String street , double price)
{
   
m_size=size;

m_price=price;

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

}
