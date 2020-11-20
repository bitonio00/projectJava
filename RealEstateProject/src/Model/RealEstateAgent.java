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
    private int m_login;
    private ArrayList<Estate> listEstate;
    private double m_commission;

public RealEstateAgent(int year,int month, int day, String nom, String prenom , int login, double commission)
{
    super(nom,prenom,year,month,day);
    m_login=login;
    m_commission=commission;
    listEstate= new ArrayList<Estate>();
}

}
