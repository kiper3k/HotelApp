/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiper
 */
public class HotelApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandlerImpl());
        
        HotelImpl hotel = new HotelImpl();
        
        CSVUtilsRooms csvUtilsRooms = new CSVUtilsRooms();
        CSVUtilsClients csvUtilsClients = new CSVUtilsClients();
        CSVUtilsEmployees csvUtilsEmployees = new CSVUtilsEmployees();
        
        hotel.loadRooms(csvUtilsRooms);
        hotel.loadClients(csvUtilsClients);
        hotel.loadEmployees(csvUtilsEmployees);
        
//        List<RoomInfo> rooms = new ArrayList<>();
//        rooms = hotel.getRooms();
//        for(int i=0; i<rooms.size(); i++){
//            System.out.println(rooms.get(i));
//        } 

//        List<Client> clients = new ArrayList<>();
//        clients = hotel.getClients();
//        for(int i=0; i<clients.size(); i++){
//            System.out.println(clients.get(i));
//        }
        
//        List<Employee> employees = new ArrayList<>();
//        employees = hotel.getEmployees();
//        for(int i=0; i<employees.size(); i++){
//            System.out.println(employees.get(i));
//        }
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] room;
        String[] client;
        OUTER:
        while (true) {
            input = br.readLine();
            switch (input) {
                case "add room":
                    System.out.println("Enter room info:");
                    room = br.readLine().split(" ");
//                    hotel.addRoom("Room4", 3, 500);
                    hotel.addRoom(room[0], Integer.parseInt(room[1]), Float.parseFloat(room[2]));
                    break;
                case "remove room":
                    System.out.println("Enter room name:");
                    room = br.readLine().split(" ");
                    hotel.deleteRoom(room[0]);
                    break;
                case "rooms":
//                    rooms = hotel.getRooms();
                    for(int i=0; i<hotel.getRooms().size(); i++){
                        System.out.println(hotel.getRooms().get(i));
                    }   
                    break;
                case "add client":
                    System.out.println("Enter client info:");
                    client = br.readLine().split(" ");
                    hotel.addClient(Integer.parseInt(client[0]), client[1], client[2], 
                            LocalDate.parse(client[3]), client[4], client[5], 0);
                    break;
                case "clients":
                    for(int i=0; i<hotel.getClients().size(); i++) {
                        System.out.println(hotel.getClients().get(i));
                    }
                    break;
                case "employees":
                    for(int i=0; i<hotel.getEmployees().size(); i++) {
                        System.out.println(hotel.getEmployees().get(i));
                    }
                    break;
                case "exit":
                    hotel.saveRooms(csvUtilsRooms);
                    break OUTER;
                default:
                    break;
            }
        }
    }
    
}
