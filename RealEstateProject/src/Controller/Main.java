/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.BuyerPage;
import View.SellerPage;
import View.SellerPage2;
import View.SellerPageAddVisit;
import View.BuyerPage0;
import View.RegisterPage;
import View.MasterList;
import View.TypePage;
import View.LoginPage;
import View.BuyerPage2;
import View.AgentPage;
import View.AgentPage2;
import View.AgentPageAddVisit;
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
       // SellerPage2 h= new  SellerPage2();
       // h.loadSellerPage2();
       //BuyerPage w = new BuyerPage();
        //w.loadBuyerPage();
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
      // AgentPage b= new AgentPage();
       //b.loadAgentPage();
//AgentPage2 c= new AgentPage2();
//c.loadAgentPage2();
//AgentPageAddVisit d= new AgentPageAddVisit();
//d.loadAgentPageAddVisit();
//SellerPage e = new SellerPage();
//e.loadSellerPage();
//SellerPage2 f= new SellerPage2();
// nf.loadSellerPage2();
//SellerPageAddVisit g= new SellerPageAddVisit();
//g.loadSellerPageAddVisit();
BuyerPage q =new BuyerPage();
//q.loadBuyerPage();
BuyerPage0 s= new BuyerPage0();
//s.loadBuyerPage0();
BuyerPage2 w= new BuyerPage2();
//w.loadBuyerPage2();
BuyerPage2Offer n= new BuyerPage2Offer();
//n.loadBuyerPage2Offer();
BuyerPage2Visit k = new BuyerPage2Visit();
//k.loadBuyerPage2Visit();


    }

}
