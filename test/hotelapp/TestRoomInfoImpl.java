/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapp;

import java.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author kiper
 */
public class TestRoomInfoImpl {

    public TestRoomInfoImpl() {
    }
    
    @Test
    public void testSetRoomName(){
        RoomInfoImpl roomInfo = new RoomInfoImpl("Room3", 3, 450);
        roomInfo.setRoomName("Room2");
        Assert.assertEquals("Room2", roomInfo.getRoomName());
    }
    
    @Test
    public void testSetNumberOfBeds(){
        RoomInfoImpl roomInfo = new RoomInfoImpl("Room3", 3, 450);
        roomInfo.setNumberOfBeds(2);
        Assert.assertEquals(2, roomInfo.getNumberOfBeds());
    }
    
//    @Test
//    public void testSetPrice(){
//        RoomInfoImpl roomInfo = new RoomInfoImpl("Room3", 3, 450);
//        roomInfo.setPrice((float) 300.0);
//        Assert.assertEquals((float) 300.0, roomInfo.getPrice());
//    }
    
}
