package hotelapp;

import java.time.LocalDate;

/**
 * @author kiper
 */
public interface ReservationInfo {
//    Period getPeriod();
//    RoomInfo getRoomInfo();

    int getReservationId();
    LocalDate getStartDate();
    LocalDate getEndDate();
    int getClientId();
    String getRoomName();
}
