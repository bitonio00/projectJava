
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
    
    
   
    private ArrayList<Estate>m_listEstate;
    public Seller(String nom, String prenom,int year,int month,int day,   String country,String city,String street ,int login, String password)
    {
        super(nom,prenom,year,month,day,login,password,country,city,street);
        
        
       
    }
   public void display()
    {
    System.out.println("nom:"+getNom()+" prenom:"+getPrenom()+" born:"+getDate().getDate()+" adress:"+getAdress().toString()+" login:"+getLogin()+" password:"+getPassword());
    }
}
