/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author benoi
 */
public class Local extends Estate {

    String m_type;
public Local(int size, String type , String country,String city,String street, long price)
{
    super(size,country,city,street,price);

m_type= type;
}
}
