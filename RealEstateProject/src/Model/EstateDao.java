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
public interface EstateDao {
    ArrayList<Estate>readEstate(ArrayList<RealEstateAgent>m_listRealEstateAgent,ArrayList<Seller>m_listSeller);//necessite une liste d'state agent et de seller
    void addEstate(Estate estate);   
    void deleteEstate(Estate estate);
    public void addAppart(Appartement estate);
    public void addHouse(House estate);
    public void sellEstate(Estate estate);
}
