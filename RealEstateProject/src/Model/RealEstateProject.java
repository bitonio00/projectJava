/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;
import View.*;

/**
 *
 * @author benoi
 */
public class RealEstateProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //RealEstateAgency a=new RealEstateAgency("pp","nn");
        //a.displayBuyer();
        //a.interact();
       // a.displayOffer();
        //a.delateBuyer(1001);
        //RealEstateAgency b=new RealEstateAgency("pp","nn");
        //b.displayBuyer();
        //LoginPage c=new LoginPage();
        //c.LoadLoginPage();
        Seller a =new Seller("a","b",2,2,2,"c","d","e",2,"f");
        a.display();
    }

}
