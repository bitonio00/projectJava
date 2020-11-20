/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realestateproject;

/**
 *
 * @author benoi
 */
public class RealEstateProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        RealEstateAgency a=new RealEstateAgency("pp","nn");
        a.displayBuyer();
        a.interact();
        a.displayOffer();
    }
    
}
