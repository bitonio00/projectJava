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
public interface OfferDao {
    ArrayList<Offer>readOffer(ArrayList<Buyer>listBuyer,ArrayList<Estate>listEstate);
    void addOffer(Offer offer);
    void deleteOffer(Offer offer);
    void acceptOffer(Offer offer);
}
