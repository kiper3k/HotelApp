package hotelapp;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.List;

/**
 * @author kiper
 * @author Marta Motyka
 */
public interface Hotel {

    void loadRooms(CSVUtilsRooms csvUtilsRooms) throws IOException;
    void saveRooms(CSVUtilsRooms csvUtilsRooms) throws IOException;
    void addRoom(String name, int nOfBeds, float price);
    void deleteRoom(String name);
    
    void loadClients(CSVUtilsClients csvUtilsClients);
    void saveClients(CSVUtilsClients csvUtilsClients);
    void addClient(int id, String firstName, String lastName, 
            LocalDate birthDate, String login, String password, int nbOfReservations);
    void deleteClient(int id);
    
    void loadEmployees(CSVUtilsEmployees csvUtilsEmployees);
    void saveEmployees(CSVUtilsEmployees csvUtilsEmployees);
    void addEmployees(int id, String firstName, String lastName, 
            LocalDate birthDate, String login, String password);
    void deleteEmployees(int id);
    
    public void loadReservations(CVSUtilsReservations csvUtilsReservations);
    public void saveReservations(CVSUtilsReservations csvUtilsReservations);
    public void addReservations(int reservationId, LocalDate startDate, 
            LocalDate endDate, int clientId);
    public void deleteReservations(int id);

//    List<ReservationInfo> findFreeRooms(Period period, List<Integer> rooms);

//    boolean makeReservation(Client client, ReservationInfo request);

}
