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
public class BuyerDaoImpl implements BuyerDao{ 
    public  ArrayList<Buyer>readBuyer()
    {
        ArrayList<Buyer>m_listBuyer=new ArrayList<Buyer>();
         Connection conn=null;
        try ///try catch exception si le chemin de la bdd n'est pas la bonne
        {
           DataSource a=new DataSource();
           conn=a.createConnection();   //on cree la connection
           Statement stmt=conn.createStatement();  

           
            
            ResultSet rs=stmt.executeQuery("select * from buyer ");

            while(rs.next()) //on lit les attribut de la table 1 par 1
            {
               m_listBuyer.add(new Buyer(rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(1),rs.getString(2),rs.getString(9)));

            }
            conn.close(); //fermeture de la connection
            
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage()); //on print l'erreur
        }
        return m_listBuyer;
    }
    public void addBuyer(Buyer buyer)
    {
        Connection conn=null;
        try
        {
           DataSource a=new DataSource();
           conn=a.createConnection(); 
            PreparedStatement stmt=conn.prepareStatement("INSERT INTO  buyer(buyer_id,password,name,first_name,date_birth,country,city,adress,mail) VALUES('"+buyer.getLogin()+"','"+buyer.getPassword()+"','"+buyer.getNom()+"','"+buyer.getPrenom()+"','"+buyer.getDate()+"','"+buyer.getAdress().getCountry()+"','"+buyer.getAdress().getCity()+"','"+buyer.getAdress().getStreet()+"','"+buyer.getMail()+"')");
            stmt.executeUpdate();
            conn.close();
 
      }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    public void deleteBuyer(Buyer buyer)
    {
        Connection conn=null;
        try
        {

           DataSource a=new DataSource();
           conn=a.createConnection(); 

            PreparedStatement stmt=conn.prepareStatement("delete from buyer where buyer_id = ?"); //on supprime l'instance de la table ou l'id est envoyer en parametre
            stmt.setInt(1,buyer.getLogin());
            stmt.executeUpdate(); 
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
    }
    
}
