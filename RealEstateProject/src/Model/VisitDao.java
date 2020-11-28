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
public interface VisitDao {
    ArrayList<Visit>readVisit(ArrayList<Buyer>listBuyer,ArrayList<Estate>listEstate);
    void updateVisit(Visit visit);
    void cancelVisit(Visit visit);
    void deleteVisit(Visit visit);
}
