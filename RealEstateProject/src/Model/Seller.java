
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
    private double m_money;
    public Seller(String nom, String prenom,String date,   String country,String city,String street ,int login, String password,String mail)
    {
        super(nom,prenom,date,login,password,country,city,street,mail);
        m_money=0;
        
       
    }
   public void display()
    {
    System.out.println("nom:"+getNom()+" prenom:"+getPrenom()+" born:"+getDate()+" adress:"+getAdress().toString()+" login:"+getLogin()+" password:"+getPassword());
    }
   public double getMoney()
   {
       return m_money;
   }
   public void addMoney(int i)
   {
       m_money+=i;
   }
}
