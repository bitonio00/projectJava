/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author benoi
 */
public class DataSource {
        Connection conn = null;
  

  public Connection createConnection()
  {
  
    try
    {
          // db parameters
        String url="jdbc:mysql://localhost:3306/estate_agency"; //chemin de notre bdd
        String user="root"; //nom
        String password="";

        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password); //on cree la connection avec la bdd

    }
    catch( Exception e )
    {
      System.out.println("Error Occured " + e.toString());
    }
    return conn; //on return la connection
  }
}

    

