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
public class Buyer extends Personne{
   
  
    boolean m_returning;
    private int m_login;
    private String m_password;
    Adress m_adress;

    
    public Buyer(String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password)
    {
        super(nom,prenom,year,month,day);
      m_adress= new Adress(country,city,street);
      m_login=login;
      m_password=password;
    }
// return madress.getcountry
public Adress getAdress()
{
return m_adress;
}
public int getLogin()
{
return m_login;
}
public String getPassword()
{
return m_password;
}
public void display()
{
    System.out.println("nom:"+getNom()+" prenom:"+getPrenom()+" born:"+getDate().getDate()+" adress:"+m_adress.toString()+" login:"+m_login+" password:"+m_password);
}
public Offer makeAnOffer(Estate estate,String type, double amount)
{
    Offer offer;
    return offer=new Offer(amount,getNom(), getPrenom(),getDate().getYear(),getDate().getMonth(),getDate().getDay(),
            m_adress.getCountry(),m_adress.getCity(),m_adress.getStreet(),m_login,m_password, estate, type);
}

}
