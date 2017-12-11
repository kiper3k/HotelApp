package hotelapp;

/**
 * @author kiper
 */
public interface ReservationInfo {
    Period getPeriod();

    RoomInfo getRoomInfo();

    long getClientId();
}
