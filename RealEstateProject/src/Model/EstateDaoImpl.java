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
public class EstateDaoImpl implements EstateDao{
    private ArrayList<RealEstateAgent>m_listRealEstateAgent;
    private ArrayList<Seller>m_listSeller;
    
    public ArrayList<Estate>readEstate(ArrayList<RealEstateAgent>listRealEstateAgent,ArrayList<Seller>listSeller)
    {
        m_listRealEstateAgent=new ArrayList<RealEstateAgent>();
        m_listRealEstateAgent=listRealEstateAgent;
        
        m_listSeller=new ArrayList<Seller>();
        m_listSeller=listSeller;
        
        ArrayList<Estate>m_listEstate=new ArrayList<Estate>();
        
        Connection conn=null;
        try
        {

            DataSource a=new DataSource();
            conn=a.createConnection(); 
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
                    rs.getString(13),rs.getInt(10), rs.getBoolean(14), rs.getBoolean(15),rs.getBoolean(16),rs.getString(4),rs.getInt(17),rs.getInt(18)));
                }

                if (rs.getString(4).equals("appartement") )
                {
                 int indices= findSeller(rs.getInt(8));
                 int indicee= findEstateAgent(rs.getInt(9));
                    m_listEstate.add(new Appartement(rs.getInt(1),rs.getInt(2),rs.getString(5),rs.getString(6),rs.getString(7)
                 , rs.getDouble(3), m_listSeller.get(indices),m_listRealEstateAgent.get(indicee),rs.getInt(10)
                    , rs.getBoolean(14), rs.getBoolean(15),rs.getBoolean(11),rs.getString(4),rs.getInt(17),rs.getInt(18)));
                }


            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
        return m_listEstate;
        
    }
    public void addEstate(Estate estate)
    {
      //tarek  
          Connection conn=null;
        try
        {
           DataSource a=new DataSource();
           conn=a.createConnection(); 
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO  estate(seller_id,password,name,first_name,date_birth,country,city,adress) VALUES('"+seller.getLogin()+"','"+seller.getPassword()+"','"+seller.getNom()+"','"+seller.getPrenom()+"','"+seller.getDate()+"','"+seller.getAdress().getCountry()+"','"+seller.getAdress().getCity()+"','"+seller.getAdress().getStreet()+"')");
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
//PreparedStatement stmt=conn.prepareStatement("INSERT INTO  seller(seller_id,password,name,first_name,date_birth,country,city,adress) VALUES('"+seller.getLogin()+"','"+seller.getPassword()+"','"+seller.getNom()+"','"+seller.getPrenom()+"','"+seller.getDate()+"','"+seller.getAdress().getCountry()+"','"+seller.getAdress().getCity()+"','"+seller.getAdress().getStreet()+"')");

    }
    public void deleteEstate(Estate estate)
    {
        Connection conn=null;
        try
        {

           DataSource a=new DataSource();
           conn=a.createConnection(); 

            PreparedStatement stmt=conn.prepareStatement("delete from estate where estate_id = ?");
          // stmt.execute("DELETE FROM EMPLOYEE WHERE ID >= 1");
           // stmt.execute("DELETE FROM BUYER WHERE buyer_id = 1001");
            stmt.setInt(1,estate.getId());
            stmt.executeUpdate();
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
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
    
    
}
