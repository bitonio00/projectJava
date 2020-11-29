/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author benoi
 */
public class VisitDaoImpl implements VisitDao {

    private ArrayList<Buyer> m_listBuyer;
    private ArrayList<Estate> m_listEstate;

    public ArrayList<Visit> readVisit(ArrayList<Buyer> listBuyer, ArrayList<Estate> listEstate) {
        m_listBuyer = new ArrayList<Buyer>();
        m_listBuyer = listBuyer;
        m_listEstate = new ArrayList<Estate>();
        m_listEstate = listEstate;

        ArrayList<Visit> m_listVisit = new ArrayList<Visit>();

        Connection conn = null;
        try {

            DataSource m = new DataSource();
            conn = m.createConnection();
            Statement stmt = conn.createStatement();
            //String nom, String prenom, int year,int month,int day, String country,String city,String street,int login,String Password)
            ResultSet rs = stmt.executeQuery("select * from visit ");// c pa une faute tu la appelr comme sa sur php
//public Visit(Date date,int id, Buyer buyer, RealEstateAgent agent,House houseconcerned )
            while (rs.next()) {
                int indiceb = findBuyer(rs.getInt(2));
                int indicee = findEstate(rs.getInt(3));

                if (m_listEstate.get(indicee).getType().equals("appartement")) {//public Offer( int id,double montant,Buyer buyer,House  houseconcerned,   String type)
                    Appartement a = new Appartement(m_listEstate.get(indicee).getId(), m_listEstate.get(indicee).getSize(),
                            m_listEstate.get(indicee).getAdress().getCountry(), m_listEstate.get(indicee).getAdress().getCity(),
                            m_listEstate.get(indicee).getAdress().getStreet(), m_listEstate.get(indicee).getPrice(), m_listEstate.get(indicee).getSeller(),
                            m_listEstate.get(indicee).getAgent(), m_listEstate.get(indicee).getNOF(), m_listEstate.get(indicee).getEquiped(),
                            m_listEstate.get(indicee).getMeubled(), m_listEstate.get(indicee).getvisavis(), m_listEstate.get(indicee).getType(),
                            m_listEstate.get(indicee).getNor(), m_listEstate.get(indicee).getNob());

                    if (rs.getBoolean(10) == true) {
                        m_listVisit.add(new Visit(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(1), m_listBuyer.get(indiceb), a, rs.getBoolean(10)));
                    } else {
                        m_listVisit.add(new Visit(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(1), null, a, rs.getBoolean(10)));
                    }

                }
                if (m_listEstate.get(indicee).getType().equals("house")) {//public Offer( int id,double montant,Buyer buyer,House  houseconcerned,   String type)
                    House a = new House(m_listEstate.get(indicee).getId(), m_listEstate.get(indicee).getSize(),
                            m_listEstate.get(indicee).getAdress().getCountry(), m_listEstate.get(indicee).getAdress().getCity(),
                            m_listEstate.get(indicee).getAdress().getStreet(), m_listEstate.get(indicee).getPrice(), m_listEstate.get(indicee).getSeller(),
                            m_listEstate.get(indicee).getAgent(), m_listEstate.get(indicee).getHouseType(), m_listEstate.get(indicee).getNOF(),
                            m_listEstate.get(indicee).getMeubled(), m_listEstate.get(indicee).getEquiped(), m_listEstate.get(indicee).getGarden(), m_listEstate.get(indicee).getType(),
                            m_listEstate.get(indicee).getNor(), m_listEstate.get(indicee).getNob());

                    if (rs.getBoolean(10) == true) {
                        m_listVisit.add(new Visit(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(1), m_listBuyer.get(indiceb), a, rs.getBoolean(10)));
                    } else {
                        m_listVisit.add(new Visit(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(1), null, a, rs.getBoolean(10)));
                    }

                }
                if (m_listEstate.get(indicee).getType().equals("local")) {
                    Local a = new Local(m_listEstate.get(indicee).getId(), m_listEstate.get(indicee).getSize(),
                            m_listEstate.get(indicee).getAdress().getCountry(), m_listEstate.get(indicee).getAdress().getCity(),
                            m_listEstate.get(indicee).getAdress().getStreet(), m_listEstate.get(indicee).getPrice(), m_listEstate.get(indicee).getSeller(),
                            m_listEstate.get(indicee).getAgent(), m_listEstate.get(indicee).getLocalType(),
                            m_listEstate.get(indicee).getEquiped(), m_listEstate.get(indicee).getMeubled(), m_listEstate.get(indicee).getNOF(), m_listEstate.get(indicee).getType());

                    if (rs.getBoolean(10) == true) {
                        m_listVisit.add(new Visit(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(1), m_listBuyer.get(indiceb), a, rs.getBoolean(10)));
                    } else {
                        m_listVisit.add(new Visit(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(1), null, a, rs.getBoolean(10)));
                    }

                }
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
        return m_listVisit;

    }

    public void updateVisit(Visit visit) {
        Connection conn = null;
        try {
            DataSource a = new DataSource();
            conn = a.createConnection();
            PreparedStatement stmt = conn.prepareStatement("update visit set buyer_id=?, reserved=1 where visit_id=?");
            stmt.setInt(1, visit.getBuyer().getLogin());
            stmt.setInt(2, visit.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void cancelVisit(Visit visit) {
        Connection conn = null;
        try {
            DataSource a = new DataSource();
            conn = a.createConnection();
            PreparedStatement stmt = conn.prepareStatement("update visit set buyer_id=0, reserved=0 where visit_id=?");
            stmt.setInt(1, visit.getId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public void deleteVisit(Visit visit) {
        Connection conn = null;
        try {

            DataSource a = new DataSource();
            conn = a.createConnection();

            PreparedStatement stmt = conn.prepareStatement("delete from visit where visit_id = ?");
            // stmt.execute("DELETE FROM EMPLOYEE WHERE ID >= 1");
            // stmt.execute("DELETE FROM BUYER WHERE buyer_id = 1001");
            stmt.setInt(1, visit.getId());
            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
        }
    }

    public int findEstate(int id) {
        int v = 0;
        for (int i = 0; i < m_listEstate.size(); ++i) {
            if (m_listEstate.get(i).getId() == id) {
                v = i;
            }
        }
        return v;
    }

    public int findBuyer(int id) {
        int v = 0;
        for (int i = 0; i < m_listBuyer.size(); ++i) {
            if (m_listBuyer.get(i).getLogin() == id) {
                v = i;
            }
        }
        return v;
    }

}
