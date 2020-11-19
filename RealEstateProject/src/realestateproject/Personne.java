/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realestateproject;

import java.util.Date;

/**
 *
 * @author benoi
 */
public abstract class Personne {
    private String m_nom;
    private String m_prenom;
    private Date m_ddn;
    public Personne(String nom, String prenom, int year,int month,int day)
    {
        m_nom=nom;
        m_prenom=prenom;
       m_ddn=new Date(year,month,day);
    }
    
   
    public String getNom()

    {

        return m_nom;

    }
    public String getPrenom()
    {

    return m_prenom;
    }
   
    public Date getDate( )
    {
        return m_ddn;
    
    } 
  
    

}


