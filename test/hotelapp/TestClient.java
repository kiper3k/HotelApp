package hotelapp;

import java.time.LocalDate;
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiper
 */
public class TestClient {
    
    public void testSetPrivileges(){
        Client client = new Client(2, "Monika", "Cabaj", 
                LocalDate.parse("1987-03-14"), "mc", "000", 0);
        Assert.assertEquals(Privileges.CLIENT, client.getPrivileges());
    }
    
    public void testSetNbOfReservations(){
        Client client = new Client(2, "Monika", "Cabaj", 
                LocalDate.parse("1987-03-14"), "mc", "000", 0);
        Assert.assertEquals(0, client.getNbOfReservations());
    }
    
}
