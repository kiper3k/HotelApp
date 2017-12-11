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

    @Override
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }
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
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientId = clientId;
        this.roomName = roomName;
        
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
        return clientId;
    }
    
    public String toString(){
        return "Id: " + this.reservationId + this.startDate + this.endDate;
    }
}
