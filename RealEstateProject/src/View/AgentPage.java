/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.BuyerDaoImpl;
import Model.OfferDaoImpl;
import Model.SellerDaoImpl;
import Model.VisitDaoImpl;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author benoi
 */
public class AgentPage extends MasterList implements ActionListener {

    private static JPanel panel;
    private static JFrame frame;

    private static JLabel deleteBuyerLabel;
    private static JLabel deleteSellerLabel;

    private static JButton deleteBuyerButon;
    private static JButton deleteSellerButon;

    private static JTextField deleteBuyerText;
    private static JTextField deleteSellerText;

    public void loadAgentPage() {
        panel = new JPanel();
        frame = new JFrame();
        frame.setSize(4000, 4000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(null);
        frame.add(panel);

        JLabel background1 = new JLabel(new ImageIcon("fondp1.png"));
        background1.setBounds(0, 0, 80, 80);

        frame.add(background1);
        frame.pack();
        frame.setResizable(true);
        frame.add(panel);

        deleteBuyerLabel = new JLabel("mail_Buyer:");
        deleteBuyerLabel.setBounds(10, 500, 50, 50);
        panel.add(deleteBuyerLabel);

        deleteBuyerText = new JTextField(30);
        deleteBuyerText.setBounds(100, 500, 100, 50);
        panel.add(deleteBuyerText);

        deleteBuyerButon = new JButton("Delete Buyer");
        deleteBuyerButon.setBounds(200, 500, 100, 50);
        deleteBuyerButon.addActionListener(new ActionDeleteBuyer());
        panel.add(deleteBuyerButon);

        deleteSellerLabel = new JLabel("mail_Seller:");
        deleteSellerLabel.setBounds(300, 500, 50, 50);
        panel.add(deleteSellerLabel);

        deleteSellerText = new JTextField(30);
        deleteSellerText.setBounds(450, 500, 100, 50);
        panel.add(deleteSellerText);

        deleteSellerButon = new JButton("Delete Seller");
        deleteSellerButon.setBounds(550, 500, 100, 50);
        deleteSellerButon.addActionListener(new ActionDeleteSeller());
        panel.add(deleteSellerButon);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public class ActionDeleteBuyer implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String mailBuyer = deleteBuyerText.getText();

            for (int i = 0; i < getBList().size(); ++i) {

                if (getBList().get(i).getMail().equals(mailBuyer)) {

                    BuyerDaoImpl buyerDaoImpl = new BuyerDaoImpl();
                    buyerDaoImpl.deleteBuyer(getBList().get(i));
                    removeBuyer(getBList().get(i));

                }
            }
            for (int i = 0; i < getOList().size(); ++i) {
                System.out.println(getOList().get(i).getBuyer().getMail());
                if (getOList().get(i).getBuyer().getMail().equals(mailBuyer)) {

                    OfferDaoImpl offerDaoImpl = new OfferDaoImpl();
                    offerDaoImpl.deleteOffer(getOList().get(i));
                    removeOffer(getOList().get(i));

                }
            }
            for (int i = 0; i < getVList().size(); ++i) {
                if (getVList().get(i).getBuyer() != null) {
                    if (getVList().get(i).getBuyer().getMail().equals(mailBuyer)) {
                        VisitDaoImpl visitDaoImpl = new VisitDaoImpl();
                        visitDaoImpl.cancelVisit(getVList().get(i));
                        getVList().get(i).cancelVisit();

                    }
                }

            }

        }
    }

    public class ActionDeleteSeller implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String mailSeller = deleteSellerText.getText();

            for (int i = 0; i < getSList().size(); ++i) {

                if (getSList().get(i).getMail().equals(mailSeller)) {

                    SellerDaoImpl sellerDaoImpl = new SellerDaoImpl();
                    sellerDaoImpl.deleteSeller(getSList().get(i));
                    removeSeller(getSList().get(i));

                }
            }
            for (int i = 0; i < getEList().size(); ++i) {

                if (getEList().get(i).getSeller().getMail().equals(mailSeller)) {

                    OfferDaoImpl offerDaoImpl = new OfferDaoImpl();
                    offerDaoImpl.deleteOffer(getOList().get(i));
                    removeOffer(getOList().get(i));

                }
            }
            for (int i = 0; i < getVList().size(); ++i) {

                if (getVList().get(i).getEstate().getSeller().getMail().equals(mailSeller)) {
                    VisitDaoImpl visitDaoImpl = new VisitDaoImpl();
                    visitDaoImpl.deleteVisit(getVList().get(i));
                    removeVisit(getVList().get(i));

                }

            }

        }

    }

}
