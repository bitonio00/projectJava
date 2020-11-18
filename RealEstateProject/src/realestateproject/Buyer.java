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
    private ArrayList<Offer>m_listOffer;
    private ArrayList<Visit>m_visit;
    private String m_adress;
    boolean m_returning;
    private int m_login;
    private String m_password;
    // jjojojo
    
    public Buyer(String nom, String prenom, int age, String adress)
    {
        super(nom,prenom,age);
        m_adress=adress;
    }
    
    
}
