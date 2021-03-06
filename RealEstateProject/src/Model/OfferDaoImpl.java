/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class OfferDaoImpl implements OfferDao {
    private ArrayList<Buyer>m_listBuyer;
    private ArrayList<Estate>m_listEstate;
    
    public ArrayList<Offer>readOffer(ArrayList<Buyer>listBuyer,ArrayList<Estate>listEstate)
    {
        m_listBuyer=new ArrayList<Buyer>();
        m_listBuyer=listBuyer;
        m_listEstate=new ArrayList<Estate>();
        m_listEstate=listEstate;
        ArrayList<Offer>m_listOffer=new ArrayList<Offer>();
        
        Connection conn=null;
        try
        {

            DataSource m=new DataSource();
            conn=m.createConnection(); 
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from offer ");

            while(rs.next())
            {
                int indiceb=findBuyer(rs.getInt(2));
                int indicee= findEstate(rs.getInt(3));
               if (m_listEstate.get(indicee).getType().equals("appartement"))
               {
               Appartement a= new Appartement(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getNOF(),m_listEstate.get(indicee).getEquiped(),
                       m_listEstate.get(indicee).getMeubled(),m_listEstate.get(indicee).getvisavis(),m_listEstate.get(indicee).getType(),
               m_listEstate.get(indicee).getNor(),m_listEstate.get(indicee).getNob());

                  m_listOffer.add(new Offer(rs.getInt(1),rs.getDouble(4), m_listBuyer.get(indiceb),a,rs.getString(5),rs.getBoolean(6)));
               }
               if (m_listEstate.get(indicee).getType().equals("house"))
               {
               House a= new House(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getHouseType(),m_listEstate.get(indicee).getNOF(),
                       m_listEstate.get(indicee).getMeubled(),m_listEstate.get(indicee).getEquiped(), m_listEstate.get(indicee).getGarden(),
                       m_listEstate.get(indicee).getType(),m_listEstate.get(indicee).getNor(),m_listEstate.get(indicee).getNob());


                  m_listOffer.add(new Offer(rs.getInt(1),rs.getDouble(4), m_listBuyer.get(indiceb),a,rs.getString(5),rs.getBoolean(6)));
               }
                if (m_listEstate.get(indicee).getType().equals("local"))
               {
               Local a= new Local(m_listEstate.get(indicee).getId(),m_listEstate.get(indicee).getSize(),
                       m_listEstate.get(indicee).getAdress().getCountry(),m_listEstate.get(indicee).getAdress().getCity(),
                       m_listEstate.get(indicee).getAdress().getStreet(),m_listEstate.get(indicee).getPrice(),m_listEstate.get(indicee).getSeller()
               ,m_listEstate.get(indicee).getAgent(),m_listEstate.get(indicee).getLocalType(),
                       m_listEstate.get(indicee).getEquiped(),m_listEstate.get(indicee).getMeubled(), m_listEstate.get(indicee).getNOF(),m_listEstate.get(indicee).getType());


    
                  m_listOffer.add(new Offer(rs.getInt(1),rs.getDouble(4), m_listBuyer.get(indiceb),a,rs.getString(5),rs.getBoolean(6)));
               }
            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
        return m_listOffer;    
    }
    public void addOffer(Offer offer)
    {
        Connection conn=null;
        try
        {
           DataSource a=new DataSource();
           conn=a.createConnection(); 
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO  offer(offer_id,buyer_id,estate_id,offer_amount,type,accepted) VALUES('"+offer.getId()+"','"+offer.getBuyer().getLogin()+"','"+offer.getEstate().getId()+"','"+offer.getMontant()+"','"+offer.getType()+"','"+0+"')");
            stmt.executeUpdate();
            conn.close();
 
      }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    public void deleteOffer(Offer offer)
    {
        Connection conn=null;
        try
        {

           DataSource a=new DataSource();
           conn=a.createConnection(); 

            PreparedStatement stmt=conn.prepareStatement("delete from offer where offer_id = ?");
            stmt.setInt(1,offer.getId());
            stmt.executeUpdate();
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
    public void acceptOffer(Offer aThis)
    {
        Connection conn = null;
        try {
            DataSource a = new DataSource();
            conn = a.createConnection();
            PreparedStatement stmt = conn.prepareStatement("update offer set accepted=1 where offer_id=?");
            stmt.setInt(1, aThis.getId());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
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

    
}


