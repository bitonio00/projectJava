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


        App a=new App();
        MasterList m=new MasterList();
        m.setList(a.getB(),a.getS(),a.getR(),a.getE(),a.getO(),a.getV());
        m.loadGui();
      


    }

}
