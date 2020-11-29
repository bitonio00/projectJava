/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BuyerPage;
import View.SellerPage;
import View.SellerPage2;
import View.BuyerPage0;
import View.RegisterPage;
import View.MasterList;
import View.TypePage;
import View.LoginPage;
import View.BuyerPage2;
import View.BuyerPage2Offer;
import View.BuyerPage2Visit;
import java.io.IOException;

/**
 *
 * @author benoi
 */
public class Main {

    public static void main(String[] args) throws IOException {

//        a.interact();
     //   a.displayOffer();
     //   a.delateBuyer(1001);
        //RealEstateAgency b=new RealEstateAgency("pp","nn");
        App a=new App();
        //a.display();
        MasterList m=new MasterList();
        m.setList(a.getB(),a.getS(),a.getR(),a.getE(),a.getO(),a.getV());
        m.loadGui();
       BuyerPage w = new BuyerPage();
        w.loadBuyerPage();
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
