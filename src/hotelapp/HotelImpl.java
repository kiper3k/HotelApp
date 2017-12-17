package hotelapp;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;


/**
 * @author Marta Motyka
 * @since 21.11.2017
 */
public class HotelImpl implements Hotel {

    private final List<RoomInfo> roomInfoStore = new ArrayList<>();
    private final List<Client> clients = new ArrayList<>();
    private final List<Employee> employees = new ArrayList<>();
    private final List<ReservationInfo> reservations = new ArrayList<>();

    @Override
    public void loadRooms(CSVUtilsRooms csvUtilsRooms) throws IOException {
        roomInfoStore.clear();
        roomInfoStore.addAll(csvUtilsRooms.readCSV());
    }
    
    @Override
    public void saveRooms(CSVUtilsRooms csvUtilsRooms) throws IOException {
         csvUtilsRooms.saveCSV(roomInfoStore);
    }

    @Override
    public void addRoom(String name, int nOfBeds, float price) {
        boolean nameIsUnique = roomInfoStore
                .parallelStream()
                .noneMatch(nameEqualTo(name));
        

        if (nameIsUnique) {
            roomInfoStore.add(new RoomInfoImpl(name, nOfBeds, price));
        } else {
//            throw new ApplicationException("Nazwa pokoju '{0}' jest juz zajeta.", name);
            System.out.println("Podana nazwa pokoju istnieje juz w systemie.");
        }
    }

    @Override
    public void deleteRoom(String name) {
        roomInfoStore.removeIf(nameEqualTo(name));
    }
    
    @Override
    public void loadClients(CSVUtilsClients csvUtilsClients) {
        clients.clear();
        clients.addAll(csvUtilsClients.readCSV());
    }
    
    @Override
    public void saveClients(CSVUtilsClients csvUtilsClients){
        csvUtilsClients.saveCSV(clients);
    }
    
    @Override
    public void addClient(int id, String firstName, String lastName, 
            LocalDate birthDate, String login, String password, int nbOfReservations) {
        boolean idIsUnique = clients.
                parallelStream().
                noneMatch(clientIdEqualTo(id));
        
//        System.out.println(idIsUnique);
        
        if(idIsUnique) {
            clients.add(new Client(id, firstName, lastName, birthDate,
                    login, password, 0));
        }
    }
    
    @Override
    public void deleteClient(int id) {
        clients.removeIf(clientIdEqualTo(id));
    }
    
    @Override
    public void loadEmployees(CSVUtilsEmployees csvUtilsEmployees){
        employees.clear();
        employees.addAll(csvUtilsEmployees.readCSV());
    }
    
    @Override
    public void saveEmployees(CSVUtilsEmployees csvUtilsEmployees){
        csvUtilsEmployees.saveCSV(employees);
    }
    
    @Override
    public void addEmployees(int id, String firstName, String lastName, 
            LocalDate birthDate, String login, String password){
        boolean idIsUnique = employees.
                parallelStream().
                noneMatch(employeeIdEqualTo(id));
        
        if(idIsUnique) {
            employees.add(new Employee(id, firstName, lastName, birthDate,
                    login, password));
        }
    }
    
    @Override
    public void deleteEmployees(int id){
        employees.removeIf(employeeIdEqualTo(id));
    }
    
    @Override
    public void loadReservations(CVSUtilsReservations csvUtilsReservations){
        reservations.clear();
        reservations.addAll(csvUtilsReservations.readCSV());
    }
    
    @Override
    public void saveReservations(CVSUtilsReservations csvUtilsReservations){
        csvUtilsReservations.saveCSV(reservations);
    }
    
    @Override
    public void addReservation(int reservationId, LocalDate startDate, 
            LocalDate endDate, int clientId, String roomName){
        boolean idIsUnique = reservations.
                parallelStream().
                noneMatch(reservationIdEqualTo(reservationId));
        
        if(idIsUnique) {
            reservations.add(new ReservationInfoImpl(reservationId, startDate,
                    endDate, clientId, roomName));
        }
    }
    
    @Override
    public void deleteReservation(int id){
        reservations.removeIf(reservationIdEqualTo(id));
    }
    
    public List<RoomInfo> getRooms() {
        return roomInfoStore;
    }
    
    public List<Client> getClients() {
        return clients;
    }
    
    public List<Employee> getEmployees(){
        return employees;
    }
    
    public List<ReservationInfo> getReservations(){
        return reservations;
    }
    
    private Predicate<RoomInfo> nameEqualTo(String name) {
        return roomInfo -> Objects.equals(roomInfo.getRoomName(), name);
    }
    
    private Predicate<Client> clientIdEqualTo(int id) {
        return client -> Objects.equals(client.getSuperId(), id);
    }
    
    private Predicate<Employee> employeeIdEqualTo(int id){
        return employee -> Objects.equals(employee.getId(), id);
    }
    
    private Predicate<ReservationInfo> reservationIdEqualTo(int id){
        return reservationInfo -> Objects.equals(reservationInfo.getReservationId(), id);
    }
}