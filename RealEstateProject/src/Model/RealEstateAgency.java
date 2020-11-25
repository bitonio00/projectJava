
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

 import java.sql.*;
 import java.util.*;


/**
 *
 * @author benoi
 */
public class RealEstateAgency {
    // arraylist de buyers, de seller ,dagent; doffre et de visite
private String m_name;
private ArrayList<Buyer>m_listBuyer;
private ArrayList<Seller>m_listSeller  ;
private ArrayList<Estate>m_listEstate  ;
private ArrayList<Offer>m_listOffer;
private ArrayList<RealEstateAgent>m_listRealEstateAgent;
private ArrayList<Visit>m_listVisit;
private String m_pathToBdd;

public RealEstateAgency(String name,String pathToBdd)
{
    m_name=name;
    m_pathToBdd=pathToBdd;
    //"jdbc:mysql://localhost:3306/estate_agency"
    m_listBuyer=new ArrayList<Buyer>();
    readBuyer();
    m_listSeller= new ArrayList<Seller>();
    readSeller();
    m_listRealEstateAgent= new ArrayList<RealEstateAgent>();
    readRealEstateAgent();
    m_listEstate=new ArrayList<Estate>();
 readEstate();
    m_listOffer=new ArrayList<Offer>();
    readOffer();
    m_listVisit= new ArrayList< Visit>();
    readVisit();
}
public void readBuyer()
{

    Connection conn=null;
        try
        {

            String url="jdbc:mysql://localhost:3306/estate_agency";
            String user="root";
            String password="";

            conn=DriverManager.getConnection(url,user,password);

            Statement stmt=conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from buyer ");

            while(rs.next())
            {
               m_listBuyer.add(new Buyer(rs.getString(3),rs.getString(4),1,1,1,rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(1),rs.getString(2)));

            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
}
public void delateBuyer(int val)
{

    Connection conn=null;
        try
        {

            String url="jdbc:mysql://localhost:3306/estate_agency";
            String user="root";
            String password="";

            conn=DriverManager.getConnection(url,user,password);

            PreparedStatement stmt=conn.prepareStatement("delete from buyer where buyer_id = ?");
          // stmt.execute("DELETE FROM EMPLOYEE WHERE ID >= 1");
           // stmt.execute("DELETE FROM BUYER WHERE buyer_id = 1001");
            stmt.setInt(1,val);
            stmt.executeUpdate();

            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
}

public void displayBuyer()
{
    for(int i=0; i<m_listBuyer.size();++i)
    {
        m_listBuyer.get(i).display();
    }
}
public int findBuyer(int id)
{
    int v=0;
    for(int i=0; i<m_listBuyer.size(); ++i)
    {
        if(m_listBuyer.get(i).getLogin()==id)
        {
            v=i;
        }
    }
    return v;
}

public void readSeller()
{

    Connection conn=null;
        try
        {

            String url="jdbc:mysql://localhost:3306/estate_agency";
            String user="root";
            String password="";

            conn=DriverManager.getConnection(url,user,password);

            Statement stmt=conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from seller ");

            while(rs.next())
            {
               m_listSeller.add(new Seller(rs.getString(3),rs.getString(4),1,1,1,rs.getString(6),rs.getString(7),
                       rs.getString(8),rs.getInt(1),rs.getString(2)));

            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
}


public void displaySeller()
{
    for(int i=0; i<m_listSeller.size();++i)
    {
        m_listSeller.get(i).display();
    }
}

public int findSeller(int id)
{
    int v=0;
    for(int i=0; i<m_listSeller.size(); ++i)
    {
        if(m_listSeller.get(i).getLogin()==id)
        {
            v=i;
        }
    }
    return v;
}
public void readRealEstateAgent()
{

    Connection conn=null;
        try
        {

            String url="jdbc:mysql://localhost:3306/estate_agency";
            String user="root";
            String password="";

            conn=DriverManager.getConnection(url,user,password);

            Statement stmt=conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from estate_angent ");// c pa une faute tu la appelr comme sa sur php

            while(rs.next())
            {
               m_listRealEstateAgent.add(new RealEstateAgent(1,1,1,rs.getString(3),rs.getString(4),rs.getInt(1),rs.getString(2),
                       rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9)));

            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
}

public void displayRealEstateAgent()
{
    for(int i=0; i<m_listRealEstateAgent.size();++i)
    {

        m_listRealEstateAgent.get(i).display();
    }
}
public int findEstateAgent(int id)
{
    int v=0;
    for(int i=0; i<m_listRealEstateAgent.size(); ++i)
    {
        if(m_listRealEstateAgent.get(i).getLogin()==id)
        {
            v=i;
        }
    }
    return v;
}




public void displayOffer()
{
  for(int i=0; i<m_listOffer.size();++i)
    {
        m_listOffer.get(i).display();
    }
}
public void interact()
{
//   m_listOffer.add(m_listBuyer.get(0).makeAnOffer(m_listEstate.get(0), "cash", 20000)) ;
}

public void readEstate()
{

    Connection conn=null;
        try
        {

            String url="jdbc:mysql://localhost:3306/estate_agency";
            String user="root";
            String password="";

            conn=DriverManager.getConnection(url,user,password);

            Statement stmt=conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from estate ");// c pa une faute tu la appelr comme sa sur php

            while(rs.next())
            {
                if (rs.getString(4).equals("local") )
                {
                 int indices= findSeller(rs.getInt(8));
                 int indicee= findEstateAgent(rs.getInt(9));
                    m_listEstate.add(new Local(rs.getInt(1),rs.getInt(2),rs.getString(5),rs.getString(6),rs.getString(7)
                 , rs.getDouble(3), m_listSeller.get(indices),m_listRealEstateAgent.get(indicee),
                    rs.getString(12), rs.getBoolean(15), rs.getBoolean(14),rs.getInt(10),rs.getString(4)));
                }

                if (rs.getString(4).equals("house") )
                {
                 int indices= findSeller(rs.getInt(8));
                 int indicee= findEstateAgent(rs.getInt(9));
                    m_listEstate.add(new House(rs.getInt(1),rs.getInt(2),rs.getString(5),rs.getString(6),rs.getString(7)
                 , rs.getDouble(3), m_listSeller.get(indices),m_listRealEstateAgent.get(indicee),
                    rs.getString(13),rs.getInt(10), rs.getBoolean(14), rs.getBoolean(15),rs.getBoolean(16),rs.getString(4)));
                }

                if (rs.getString(4).equals("appartement") )
                {
                 int indices= findSeller(rs.getInt(8));
                 int indicee= findEstateAgent(rs.getInt(9));
                    m_listEstate.add(new Appartement(rs.getInt(1),rs.getInt(2),rs.getString(5),rs.getString(6),rs.getString(7)
                 , rs.getDouble(3), m_listSeller.get(indices),m_listRealEstateAgent.get(indicee),rs.getInt(10)
                    , rs.getBoolean(14), rs.getBoolean(15),rs.getBoolean(11),rs.getString(4)));
                }


            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
}

public void displayEstate()
{
  for(int i=0; i<m_listEstate.size();++i)
    {
        m_listEstate.get(i).display();
    }
}

public int findEstate(int id)
{
    int v=0;
    for(int i=0; i<m_listEstate.size(); ++i)
    {
        if(m_listEstate.get(i).getId()==id)
        {
            v=i;
        }
    }
    return v;
}


public void readOffer()
{

    Connection conn=null;
        try
        {

            String url="jdbc:mysql://localhost:3306/estate_agency";
            String user="root";
            String password="";

            conn=DriverManager.getConnection(url,user,password);

            Statement stmt=conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from offer ");// c pa une faute tu la appelr comme sa sur php

            while(rs.next())
            {
                int indiceb=findBuyer(rs.getInt(2));
                int indicee= findEstate(rs.getInt(3));
               if (m_listEstate.get(indicee).getType().equals("appartement"))
               {//public Offer( int id,double montant,Buyer buyer,House  houseconcerned,   String type)
               Appartement a= new Appartement(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getNOF(),m_listEstate.get(indicee).getEquiped(),
                       m_listEstate.get(indicee).getMeubled(),m_listEstate.get(indicee).getvisavis(),m_listEstate.get(indicee).getType());

                  m_listOffer.add(new Offer(rs.getInt(1),rs.getDouble(4), m_listBuyer.get(indiceb),a,rs.getString(5)));
               }
               if (m_listEstate.get(indicee).getType().equals("house"))
               {//public Offer( int id,double montant,Buyer buyer,House  houseconcerned,   String type)
               House a= new House(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getHouseType(),m_listEstate.get(indicee).getNOF(),
                       m_listEstate.get(indicee).getMeubled(),m_listEstate.get(indicee).getEquiped(), m_listEstate.get(indicee).getGarden(),m_listEstate.get(indicee).getType());


                  m_listOffer.add(new Offer(rs.getInt(1),rs.getDouble(4), m_listBuyer.get(indiceb),a,rs.getString(5)));
               }
                if (m_listEstate.get(indicee).getType().equals("local"))
               {
               Local a= new Local(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getLocalType(),
                       m_listEstate.get(indicee).getEquiped(),m_listEstate.get(indicee).getMeubled(), m_listEstate.get(indicee).getNOF(),m_listEstate.get(indicee).getType());

/*public Local(int id,int size,String country,String city, String street , double price,Seller seller,
        RealEstateAgent realEstateAgent, String localType,boolean equiped, boolean meubled, int numberOfFloor, String type)*/
                  m_listOffer.add(new Offer(rs.getInt(1),rs.getDouble(4), m_listBuyer.get(indiceb),a,rs.getString(5)));
               }
            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
}
public void readVisit()
{

    Connection conn=null;
        try
        {

            String url="jdbc:mysql://localhost:3306/estate_agency";
            String user="root";
            String password="";

            conn=DriverManager.getConnection(url,user,password);

            Statement stmt=conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from visit ");// c pa une faute tu la appelr comme sa sur php
//public Visit(Date date,int id, Buyer buyer, RealEstateAgent agent,House houseconcerned )
            while(rs.next())
            {
                int indiceb=findBuyer(rs.getInt(2));
                int indicee= findEstate(rs.getInt(3));
                int indicea= findEstateAgent(rs.getInt(4));
               if (m_listEstate.get(indicee).getType().equals("appartement"))
               {//public Offer( int id,double montant,Buyer buyer,House  houseconcerned,   String type)
               Appartement a= new Appartement(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getNOF(),m_listEstate.get(indicee).getEquiped(),
                       m_listEstate.get(indicee).getMeubled(),m_listEstate.get(indicee).getvisavis(),m_listEstate.get(indicee).getType());

                  m_listVisit.add(new Visit(rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(1), m_listBuyer.get(indiceb),m_listRealEstateAgent.get(indicea) ,a));
               }
               if (m_listEstate.get(indicee).getType().equals("house"))
               {//public Offer( int id,double montant,Buyer buyer,House  houseconcerned,   String type)
               House a= new House(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getHouseType(),m_listEstate.get(indicee).getNOF(),
                       m_listEstate.get(indicee).getMeubled(),m_listEstate.get(indicee).getEquiped(), m_listEstate.get(indicee).getGarden(),m_listEstate.get(indicee).getType());


                  m_listVisit.add(new Visit(rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(1), m_listBuyer.get(indiceb),m_listRealEstateAgent.get(indicea) ,a));
               }
                if (m_listEstate.get(indicee).getType().equals("local"))
               {
               Local a= new Local(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getLocalType(),
                       m_listEstate.get(indicee).getEquiped(),m_listEstate.get(indicee).getMeubled(), m_listEstate.get(indicee).getNOF(),m_listEstate.get(indicee).getType());
               m_listVisit.add(new Visit(rs.getInt(5),rs.getInt(6),rs.getInt(7),rs.getInt(8),rs.getInt(9),rs.getInt(1), m_listBuyer.get(indiceb),m_listRealEstateAgent.get(indicea) ,a));
/*public Local(int id,int size,String country,String city, String street , double price,Seller seller,
        RealEstateAgent realEstateAgent, String localType,boolean equiped, boolean meubled, int numberOfFloor, String type)*/

               }
            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
}
public void displayVisit()
{


  for(int i=0; i<m_listVisit.size();++i)
    {
        m_listVisit.get(i).display();
    }

  

}
public ArrayList<Buyer>getBuyer()
{
return m_listBuyer;
}
public ArrayList<Seller>getSeller()
{
return m_listSeller;
}
public ArrayList<Estate>getEstate()
{
return m_listEstate;
}
public ArrayList<RealEstateAgent>getREA()
{
return m_listRealEstateAgent;
}
}
