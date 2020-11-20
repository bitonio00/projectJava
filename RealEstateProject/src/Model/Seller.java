
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 package Model;

 import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class Seller extends Personne {
    private int m_login;
    private String m_password;
    private Adress m_adress;
    private ArrayList<Estate>m_listEstate;
    public Seller(String nom, String prenom,int year,int month,int day,   String country,String city,String street ,int login, String password)
    {
        super(nom,prenom,year,month,day);
        m_login=login;
        m_adress= new Adress(country,city,street);
        m_password=password;
    }
   public void display()
    {
    System.out.println("nom:"+getNom()+" prenom:"+getPrenom()+" born:"+getDate().getDate()+" adress:"+m_adress.toString()+" login:"+m_login+" password:"+m_password);
    }
}
