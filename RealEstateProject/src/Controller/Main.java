/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BuyerPage;
import View.MasterList;
import View.TypePage;

/**
 *
 * @author benoi
 */
public class Main {
    
    public static void main(String[] args) {

//        a.interact();
     //   a.displayOffer();
     //   a.delateBuyer(1001);
        //RealEstateAgency b=new RealEstateAgency("pp","nn");
        App a=new App();
        //a.display();
        MasterList m=new MasterList();
        m.setList(a.getB(),a.getS(),a.getR(),a.getE(),a.getO(),a.getV());
        m.loadGui();
     //TypePage h= new TypePage();
    // h.LoadTypePage();
        //BuyerPage b=new BuyerPage();
        //b.loadBuyerPage();
        //MasterList a=new MasterList();
       // a.setList(b.getBuyer(),b.getSeller(),b.getREA(),b.getEstate());
        //a.loadGui();
        //BuyerPage c=new BuyerPage();
        //c.loadBuyerPage();
       //BuyerPage c=new BuyerPage();
       //c.loadBuyerPage();

       
    }
    
}
