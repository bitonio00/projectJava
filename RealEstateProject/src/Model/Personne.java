/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.Date;

/**
 *
 * @author benoi
 */
public abstract class Personne {
    private String m_nom;
    private String m_prenom;
    private String m_ddn;
    private int m_login;
     private Adress m_adress;
     private String m_password;
    public Personne(String nom, String prenom, String date, int login,String password,String country,String city, String street)
    {
        m_password=password;
        m_login=login;
        m_nom=nom;
        m_prenom=prenom;
       m_ddn=date;
       m_adress= new Adress(country,city,street);
    }
    
   
    public String getNom()

    {

        return m_nom;

    }
    public String getPrenom()
    {

    return m_prenom;
    }
   
    public String getDate( )
    {
        return m_ddn;
    
    } 
  
    public int getLogin()
    {
        return m_login;
    }
    public Adress getAdress()
    {
    return m_adress;
    }
    
    public String getPassword()
    {
    return m_password;
    }
}


