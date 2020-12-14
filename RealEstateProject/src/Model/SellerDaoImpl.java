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
public class SellerDaoImpl implements SellerDao {
    
    public ArrayList<Seller>readSeller()
    {
        ArrayList<Seller>m_listSeller=new ArrayList<Seller>();
        Connection conn=null;
        try
        {

            DataSource a=new DataSource();
            conn=a.createConnection(); 
           Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("select * from seller ");

            while(rs.next())
            {
               m_listSeller.add(new Seller(rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                       rs.getString(8),rs.getInt(1),rs.getString(2),rs.getString(9)));

            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
        return m_listSeller;
    }
    
    public void addSeller(Seller seller)
    {
        Connection conn=null;
        try
        {
           DataSource a=new DataSource();
           conn=a.createConnection(); 
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO  seller(seller_id,password,last_name,first_name,date_birth,country,city,street,mail) VALUES('"+seller.getLogin()+"','"+seller.getPassword()+"','"+seller.getNom()+"','"+seller.getPrenom()+"','"+seller.getDate()+"','"+seller.getAdress().getCountry()+"','"+seller.getAdress().getCity()+"','"+seller.getAdress().getStreet()+"','"+seller.getMail()+"')");
            stmt.executeUpdate();
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
    public void deleteSeller(Seller seller)
    {
        Connection conn=null;
        try
        {

           DataSource a=new DataSource();
           conn=a.createConnection(); 

            PreparedStatement stmt=conn.prepareStatement("delete from seller where seller_id = ?");
            stmt.setInt(1,seller.getLogin());
            stmt.executeUpdate();
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
}
