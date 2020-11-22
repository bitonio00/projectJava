
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
public class RealEstateAgent extends Personne {
    
   // private ArrayList<Estate> listEstate;
    private double m_commission;



public RealEstateAgent(int year,int month, int day, String nom, String prenom , int login, String password,double commission,String country,
        String city,String street)
{
    super(nom,prenom,year,month,day,login,password,country,city,street);
    
    

    m_commission=commission;
    //listEstate= new ArrayList<Estate>();
}
public void display()
{
    System.out.println("nom:"+getNom()+" prenom:"+getPrenom()+" born:"+getDate().getDate()+" login:"+getLogin()+" password:"+getPassword());
}



public double getCommission()
{
  return m_commission ; 
}
}
