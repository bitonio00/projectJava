/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class RealEstateAgentDaoImpl implements RealEstateAgentDao {
    
    public ArrayList<RealEstateAgent>readRealEstateAgent()
    {
        ArrayList<RealEstateAgent> m_listRealEstateAgent=new ArrayList<RealEstateAgent>();
       Connection conn=null;
        try
        {
            DataSource a=new DataSource();
            conn=a.createConnection(); 
           Statement stmt=conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs=stmt.executeQuery("select * from estate_angent ");// c pa une faute tu la appelr comme sa sur php

            while(rs.next())
            {
               m_listRealEstateAgent.add(new RealEstateAgent(rs.getString(5),rs.getString(3),rs.getString(4),rs.getInt(1),rs.getString(2),
                       rs.getDouble(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10)));

            }
            conn.close();
        }
        catch(SQLException e)
        {
            System.out.println(""+e.getMessage());
        }
        return m_listRealEstateAgent;
    }
}
