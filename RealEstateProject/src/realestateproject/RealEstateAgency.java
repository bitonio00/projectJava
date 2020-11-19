/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realestateproject;

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

public void displayBuyer()
{
    for(int i=0; i<m_listBuyer.size();++i)
    {
        m_listBuyer.get(i).display();
    }
}
}
