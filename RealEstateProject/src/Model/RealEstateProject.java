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

//        a.interact();
     //   a.displayOffer();
     //   a.delateBuyer(1001);
        RealEstateAgency b=new RealEstateAgency("pp","nn");
        TypePage a=new TypePage();
        a.LoadLoginPage();       /*
        LoginPage c=new LoginPage();
        c.setList(b.getBuyer(),b.getSeller(),b.getRealEstateAgent());
        c.LoadLoginPage();*/
       // c.compare();

       b.displayVisit();
    }

}
