/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realestateproject;

import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class Buyer extends Personne{
   
    
    boolean m_returning;
    private int m_login;
    private String m_password;
    Adress m_adress;

    
    public Buyer(String nom, String prenom, int age, String country,String city,String street)
    {
        super(nom,prenom,age);
      m_adress= new Adress(country,city,street);
    }


}
