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
public class Local extends Estate {

    String m_type;
public Local(int size, String type , Adress adress, long price)
{
    super(size,adress,price);

m_type= type;
}
}
