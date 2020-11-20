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
public class Offer {
    private double m_montant;
   private Estate m_estateconcerned;
   private Buyer m_buyer;
   private String m_type;

   public Offer( double montant,Buyer buyer,Estate estateconcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate().getYear(),buyer.getDate().getMonth(),buyer.getDate().getDay(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword());

   m_estateconcerned = new Estate( estateconcerned.getSize(),estateconcerned.getAdress().getCountry(),estateconcerned.getAdress().getCity(),
            estateconcerned.getAdress().getStreet(), estateconcerned.getPrice());
   }// a voir avec benoit
   public Offer( double montant,String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password,Estate estateconcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer(  nom,  prenom,  year,month,day, country,city,street,login,password);

   m_estateconcerned = new Estate( estateconcerned.getSize(),estateconcerned.getAdress().getCountry(),estateconcerned.getAdress().getCity(),
            estateconcerned.getAdress().getStreet(), estateconcerned.getPrice());
   }

   public void display()
   {
       System.out.println("montant:"+m_montant+" estate:"+m_estateconcerned.getAdress().getStreet()+" buyer:"+m_buyer.getNom()+" type"+m_type);
   }
           }
