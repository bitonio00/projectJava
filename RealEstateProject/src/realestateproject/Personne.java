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
public abstract class Personne {
    private String m_nom;
    private String m_prenom;
    private int m_age;
    public Personne(String nom, String prenom, int age)
    {
        m_nom=nom;
        m_prenom=prenom;
        m_age=age;
    }
}
