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
   private Estate m_houseConcerned;
   private int m_id;
   private Buyer m_buyer;
   private String m_type;
   private boolean m_accepted;

   public Offer( int id,double montant,Buyer buyer,House  houseconcerned,   String type,boolean b)
   {
   m_id=id;    
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate(),buyer.getAdress().getCountry(), 
           buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword(),buyer.getMail());

   m_houseConcerned = new House(houseconcerned.getId(), houseconcerned.getSize(),houseconcerned.getAdress().getCountry(),houseconcerned.getAdress().getCity(),
            houseconcerned.getAdress().getStreet(), houseconcerned.getPrice(),houseconcerned.getSeller(),houseconcerned.getAgent(),houseconcerned.getHouseType(),houseconcerned.getNOF(),houseconcerned.getMeubled(),
           houseconcerned.getEquiped(),houseconcerned.getGarden(),houseconcerned.getType(),houseconcerned.getNor(),houseconcerned.getNob());
   
   m_accepted=b;
   }// a voir avec benoit
   
   public Offer( int id,double montant,Buyer buyer,Estate  estateconcerned,   String type)
   {
   m_id=id;    
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate(),buyer.getAdress().getCountry(), 
           buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword(),buyer.getMail());

   if(estateconcerned.getType().equals("house"))
        {
             m_houseConcerned = new House(estateconcerned.getId(), estateconcerned.getSize(), estateconcerned.getAdress().getCountry(), estateconcerned.getAdress().getCity(),
                estateconcerned.getAdress().getStreet(), estateconcerned.getPrice(), estateconcerned.getSeller(), estateconcerned.getAgent(), estateconcerned.getHouseType(), estateconcerned.getNOF(), estateconcerned.getMeubled(),
                estateconcerned.getEquiped(), estateconcerned.getGarden(), estateconcerned.getType(), estateconcerned.getNor(), estateconcerned.getNob()); 
        }
        else if(estateconcerned.getType().equals("local"))
        {
             m_houseConcerned = new Local(estateconcerned.getId(), estateconcerned.getSize(), estateconcerned.getAdress().getCountry(), estateconcerned.getAdress().getCity(),
                estateconcerned.getAdress().getStreet(), estateconcerned.getPrice(), estateconcerned.getSeller(), estateconcerned.getAgent(), estateconcerned.getLocalType(),
                estateconcerned.getEquiped(), estateconcerned.getMeubled(), estateconcerned.getNOF(), estateconcerned.getType());
        }
        else if(estateconcerned.getType().equals("appartement"))
        {
            m_houseConcerned = new Appartement(estateconcerned.getId(), estateconcerned.getSize(), estateconcerned.getAdress().getCountry(), estateconcerned.getAdress().getCity(),
                estateconcerned.getAdress().getStreet(), estateconcerned.getPrice(), estateconcerned.getSeller(), estateconcerned.getAgent(), estateconcerned.getNOF(), estateconcerned.getEquiped(),
                estateconcerned.getMeubled(), estateconcerned.getvisavis(), estateconcerned.getType(), estateconcerned.getNor(), estateconcerned.getNob());
        }
   m_accepted=false;
   }
   public Offer( int id,double montant,String nom, String prenom, String date, String country,String city,String street,int login,String password,House  houseconcerned,   String type,boolean b,String mail)
   {
       m_id=id;
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer(  nom,  prenom,  date, country,city,street,login,password,mail);

 m_houseConcerned = new House(houseconcerned.getId(), houseconcerned.getSize(),houseconcerned.getAdress().getCountry(),houseconcerned.getAdress().getCity(),
            houseconcerned.getAdress().getStreet(), houseconcerned.getPrice(),houseconcerned.getSeller(),houseconcerned.getAgent(),houseconcerned.getHouseType(),houseconcerned.getNOF(),houseconcerned.getMeubled(),
           houseconcerned.getEquiped(),houseconcerned.getGarden(),houseconcerned.getType(),houseconcerned.getNor(),houseconcerned.getNob());
   m_accepted=b;
   }

   public Offer(int id, double montant,Buyer buyer,Local localConcerned,   String type,boolean b)
   {
    m_id=id;   
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword(),buyer.getMail());
m_houseConcerned = new Local(localConcerned.getId(),localConcerned.getSize(),localConcerned.getAdress().getCountry(),localConcerned.getAdress().getCity(),
localConcerned.getAdress().getStreet(),localConcerned.getPrice(),localConcerned.getSeller(),localConcerned.getAgent(),localConcerned.getLocalType(),
        localConcerned.getEquiped(),localConcerned.getMeubled(),localConcerned.getNOF(),localConcerned.getType());
        m_accepted=b;
   }
   
   public Offer(int id, double montant,String nom, String prenom, String date, String country,String city,String street,int login,String password,Local localConcerned,   String type,String mail)
   {
       m_id=id; 
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer(  nom,  prenom,  date, country,city,street,login,password,mail);

 m_houseConcerned = new Local(localConcerned.getId(),localConcerned.getSize(),localConcerned.getAdress().getCountry(),localConcerned.getAdress().getCity(),
localConcerned.getAdress().getStreet(),localConcerned.getPrice(),localConcerned.getSeller(),localConcerned.getAgent(),localConcerned.getLocalType(),
         localConcerned.getEquiped(),localConcerned.getMeubled(),localConcerned.getNOF(),localConcerned.getType());
 m_accepted=false;
   }
   
   public Offer(int id, double montant,Buyer buyer,Appartement aptconcerned,   String type,boolean b)
   {
       m_id=id; 
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer( buyer.getNom(),buyer.getPrenom(),buyer.getDate(),
           buyer.getAdress().getCountry(), buyer.getAdress().getCity(),buyer.getAdress().getStreet(),buyer.getLogin(),buyer.getPassword(),buyer.getMail());
m_houseConcerned = new Appartement(aptconcerned.getId(),aptconcerned.getSize(),aptconcerned.getAdress().getCountry(),aptconcerned.getAdress().getCity(),
aptconcerned.getAdress().getStreet(),aptconcerned.getPrice(),aptconcerned.getSeller(),aptconcerned.getAgent(),aptconcerned.getNOF(),aptconcerned.getEquiped(),
        aptconcerned.getMeubled(),aptconcerned.getvisavis(),aptconcerned.getType(),aptconcerned.getNor(),aptconcerned.getNob());

        m_accepted=b;
   }
   public Offer(int id, double montant,String nom, String prenom, String date, String country,String city,
           String street,int login,String password,Appartement  aptconcerned,   String type,String mail)
   {
       m_id=id; 
   m_montant= montant;
   m_type=type;
   m_buyer= new Buyer(  nom,  prenom,  date, country,city,street,login,password,mail);

m_houseConcerned = new Appartement(aptconcerned.getId(),aptconcerned.getSize(),aptconcerned.getAdress().getCountry(),aptconcerned.getAdress().getCity(),
aptconcerned.getAdress().getStreet(),aptconcerned.getPrice(),aptconcerned.getSeller(),aptconcerned.getAgent(),aptconcerned.getNOF(),aptconcerned.getEquiped(),
        aptconcerned.getMeubled(),aptconcerned.getvisavis(),aptconcerned.getType(),aptconcerned.getNor(),aptconcerned.getNob());

        m_accepted=false;
   }
   public void acceptOffer()
   {
       m_accepted=true;
       OfferDaoImpl offerDao=new OfferDaoImpl();
       offerDao.acceptOffer(this);
       m_houseConcerned.soldEstate();
   }
   public void display()
   {
       
       System.out.println("montant:"+m_montant+" estate:"+m_houseConcerned.getAdress().getStreet()+" buyer:"+m_buyer.getNom()+" type"+m_type);
   }
   public int getId()
   {
       return m_id;
   }
   public Buyer getBuyer()
   {
       return m_buyer;
   }
   public Estate getEstate()
   {
       return m_houseConcerned;
   }
  public String getType()
  {
      return m_type;
  }
  public double getMontant()
  {
      return m_montant;
  }
  public boolean getAccepted()
  {
      return m_accepted;
  }
  public String getFullOffer()
  {
      String string1=String.valueOf(getMontant());
      return string1+"$ "+" in "+getType()+" on "+getEstate().getAdress().getFullAdress();
  }
   

           }
