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
public class TestReservationInfoImpl {

    public TestReservationInfoImpl() {
    }
    
    @Test
    public void testSetReservationId(){
        ReservationInfoImpl reservationInfoImpl = new ReservationInfoImpl(1,
                LocalDate.parse("2017-12-27"), LocalDate.parse("2018-01-03"), 3,
                "Room3");
        reservationInfoImpl.setReservationId(8);
        Assert.assertEquals(8, reservationInfoImpl.getReservationId());
    }
    
    @Test
    public void testSetStartDate(){
        ReservationInfoImpl reservationInfoImpl = new ReservationInfoImpl(1,
                LocalDate.parse("2017-12-27"), LocalDate.parse("2018-01-03"), 3,
                "Room3");
        reservationInfoImpl.setStartDate(LocalDate.parse("2017-12-25"));
        Assert.assertEquals(LocalDate.parse("2017-12-25"), reservationInfoImpl.getStartDate());
    }
    
    @Test
    public void testSetEndDate(){
        ReservationInfoImpl reservationInfoImpl = new ReservationInfoImpl(1,
                LocalDate.parse("2017-12-27"), LocalDate.parse("2018-01-03"), 3,
                "Room3");
        reservationInfoImpl.setEndDate(LocalDate.parse("2018-01-09"));
        Assert.assertEquals(LocalDate.parse("2018-01-09"), reservationInfoImpl.getEndDate());
    }
    
}
