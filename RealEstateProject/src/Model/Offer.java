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
   private House m_houseConcerned;
   private Appartement m_appartementConcerned;
   private Local m_localConcerned;
   private Buyer m_buyer;
   private String m_type;

   public Offer( double montant,Buyer buyer,House  houseconcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate().getYear(),buyer.getDate().getMonth(),buyer.getDate().getDay(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword());

   m_houseConcerned = new House( houseconcerned.getSize(),houseconcerned.getAdress().getCountry(),houseconcerned.getAdress().getCity(),
            houseconcerned.getAdress().getStreet(), houseconcerned.getPrice(),houseconcerned.getSeller(),houseconcerned.getAgent(),houseconcerned.getHouseType(),houseconcerned.getNOF(),houseconcerned.getMeubled(),
           houseconcerned.getEquiped(),houseconcerned.getGarden());
   }// a voir avec benoit
   public Offer( double montant,String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password,House  houseconcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer(  nom,  prenom,  year,month,day, country,city,street,login,password);

 m_houseConcerned = new House( houseconcerned.getSize(),houseconcerned.getAdress().getCountry(),houseconcerned.getAdress().getCity(),
            houseconcerned.getAdress().getStreet(), houseconcerned.getPrice(),houseconcerned.getSeller(),houseconcerned.getAgent(),houseconcerned.getHouseType(),houseconcerned.getNOF(),houseconcerned.getMeubled(),
           houseconcerned.getEquiped(),houseconcerned.getGarden());
   }

   public Offer( double montant,Buyer buyer,Local localConcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate().getYear(),buyer.getDate().getMonth(),buyer.getDate().getDay(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword());
m_localConcerned = new Local(localConcerned.getSize(),localConcerned.getAdress().getCountry(),localConcerned.getAdress().getCity(),
localConcerned.getAdress().getStreet(),localConcerned.getPrice(),localConcerned.getSeller(),localConcerned.getAgent(),localConcerned.getLocalType(),localConcerned.getEquiped(),localConcerned.getMeubled(),localConcerned.getNOF());
   }
   
   public Offer( double montant,String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password,Local  localConcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer(  nom,  prenom,  year,month,day, country,city,street,login,password);

 m_localConcerned = new Local(localConcerned.getSize(),localConcerned.getAdress().getCountry(),localConcerned.getAdress().getCity(),
localConcerned.getAdress().getStreet(),localConcerned.getPrice(),localConcerned.getSeller(),localConcerned.getAgent(),localConcerned.getLocalType(),localConcerned.getEquiped(),localConcerned.getMeubled(),localConcerned.getNOF());
   }
   
   public Offer( double montant,Buyer buyer,Appartement aptconcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate().getYear(),buyer.getDate().getMonth(),buyer.getDate().getDay(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword());
m_appartementConcerned = new Appartement(aptconcerned.getSize(),aptconcerned.getAdress().getCountry(),aptconcerned.getAdress().getCity(),
aptconcerned.getAdress().getStreet(),aptconcerned.getPrice(),aptconcerned.getSeller(),aptconcerned.getAgent(),aptconcerned.getNOF(),aptconcerned.getEquiped(),
        aptconcerned.getMeubled(),aptconcerned.getvisavis());
   }
   public Offer( double montant,String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String password,Appartement  aptconcerned,   String type)
   {
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer(  nom,  prenom,  year,month,day, country,city,street,login,password);

m_appartementConcerned = new Appartement(aptconcerned.getSize(),aptconcerned.getAdress().getCountry(),aptconcerned.getAdress().getCity(),
aptconcerned.getAdress().getStreet(),aptconcerned.getPrice(),aptconcerned.getSeller(),aptconcerned.getAgent(),aptconcerned.getNOF(),aptconcerned.getEquiped(),
        aptconcerned.getMeubled(),aptconcerned.getvisavis());
   }
   
   public void displayHouseOffer()
   {
       System.out.println("montant:"+m_montant+" estate:"+m_houseConcerned.getAdress().getStreet()+" buyer:"+m_buyer.getNom()+" type"+m_type);
   }
   public void displayLocalOffer()
   {
       System.out.println("montant:"+m_montant+" estate:"+m_localConcerned.getAdress().getStreet()+" buyer:"+m_buyer.getNom()+" type"+m_type);
   }
   
   public void displayAppartementOffer()
   {
       System.out.println("montant:"+m_montant+" estate:"+m_appartementConcerned.getAdress().getStreet()+" buyer:"+m_buyer.getNom()+" type"+m_type);
   }

           }
