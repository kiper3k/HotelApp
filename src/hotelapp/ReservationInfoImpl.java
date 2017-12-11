package hotelapp;

import java.time.LocalDate;

/**
 * @author Marta Motyka
 * @since 25.11.2017
 */
public class ReservationInfoImpl implements ReservationInfo {

    private Period period;

    private RoomInfo roomInfo;
    
    private int reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int clientId;
    
    private String roomName;

    public ReservationInfoImpl(Period period, RoomInfo roomInfo) {
        this.period = period;
        this.roomInfo = roomInfo;
    }

    ReservationInfoImpl(int reservationId, LocalDate startDate, LocalDate endDate, 
            int clientId, String roomName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Period getPeriod() {
        return period;
    }

    @Override
    public RoomInfo getRoomInfo() {
        return roomInfo;
    }

    @Override
    public long getClientId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
