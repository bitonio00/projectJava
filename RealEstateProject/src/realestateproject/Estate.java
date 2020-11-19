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
public class Estate {
    private int m_size;
    private Adress m_adress;
    private long m_price;
    private ArrayList<Visit>m_listVisit;
    private ArrayList<Offer>m_listOffer;
    
public Estate(int size, Adress adress, long price)
{
   
m_size=size;
m_adress=adress;
m_price=price;
m_listVisit= new ArrayList<Visit>();
m_listOffer= new ArrayList<Offer>();

}


}
