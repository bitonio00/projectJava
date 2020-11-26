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
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from seller ");

            while(rs.next())
            {
               m_listSeller.add(new Seller(rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),
                       rs.getString(8),rs.getInt(1),rs.getString(2)));

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
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO  seller(seller_id,password,name,first_name,date_birth,country,city,adress) VALUES('"+seller.getLogin()+"','"+seller.getPassword()+"','"+seller.getNom()+"','"+seller.getPrenom()+"','"+seller.getDate()+"','"+seller.getAdress().getCountry()+"','"+seller.getAdress().getCity()+"','"+seller.getAdress().getStreet()+"')");
            stmt.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
}