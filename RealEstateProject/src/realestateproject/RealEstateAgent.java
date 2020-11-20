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
public class RealEstateAgent extends Personne {
    private int m_login;
    private ArrayList<Estate> listEstate;
    private double m_commission;
    private String m_password;
  

public RealEstateAgent(int year,int month, int day, String nom, String prenom , int login, String password,double commission)
{
    super(nom,prenom,year,month,day);
    m_login=login;
    m_password=password;
 
    m_commission=commission;
    listEstate= new ArrayList<Estate>();
}
public void display()
{
    System.out.println("nom:"+getNom()+" prenom:"+getPrenom()+" born:"+getDate().getDate()+" login:"+m_login+" password:"+m_password);
}
}
