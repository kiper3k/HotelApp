package hotelapp;

import java.time.LocalDate;

/**
 * @author Marta Motyka
 * @since 25.11.2017
 */
public class ReservationInfoImpl implements ReservationInfo {

//    private Period period;
//    private RoomInfo roomInfo;
    
    private int reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private int clientId;
    private String roomName;
    
    @Override
    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    @Override
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Override
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }
    
    @Override
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    

//    public ReservationInfoImpl(Period period, RoomInfo roomInfo) {
//        this.period = period;
//        this.roomInfo = roomInfo;
//    }

    ReservationInfoImpl(int reservationId, LocalDate startDate, LocalDate endDate, 
            int clientId, String roomName) {
        this.reservationId = reservationId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.clientId = clientId;
        this.roomName = roomName;
        
    }
    
    @Override
    public String toString(){
        return "Id: " + this.reservationId + "\tStart date: " + this.startDate 
                + "\tEnd date: " + this.endDate + "\tClient id: " 
                + this.clientId + "\tRoom: " + this.roomName;
    }
}
