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
public class Seller extends Personne {
    private ArrayList<Estate>m_listEstate;
    public Seller(String nom, String prenom, int age, String adress)
    {
        super(nom,prenom,age);
        
    }
    
}
