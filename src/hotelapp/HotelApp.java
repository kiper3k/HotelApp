/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
//        rooms = csvUtilsRooms.readCSV();
        hotel.loadRooms(csvUtilsRooms);
        
        List<RoomInfo> rooms = new ArrayList<>();
        rooms = hotel.getRooms();
        for(int i=0; i<rooms.size(); i++){ 
            System.out.println(rooms.get(i));
        }
        
        hotel.saveRooms(csvUtilsRooms);
        
        

        CSVUtilsUsers csvUtilsUsers = new CSVUtilsUsers();
        List<User> users = new ArrayList<>();
        users = csvUtilsUsers.readCSV();
        
        users = csvUtilsUsers.readCSV();
        for(int i=0; i<users.size(); i++){
            System.out.println(users.get(i));
        }
        
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        String[] room;
        OUTER:
        while (true) {
            input = br.readLine();
            switch (input) {
                case "add":
                    System.out.println("Enter room info:");
                    room = br.readLine().split(" ");
//                    hotel.addRoom("Room4", 3, 500);
                    hotel.addRoom(room[0], Integer.parseInt(room[1]), Float.parseFloat(room[2]));
                    break;
                case "remove":
                    room = br.readLine().split(" ");
                    hotel.deleteRoom(room[0]);
                case "rooms":
                    rooms = hotel.getRooms();
                    for(int i=0; i<rooms.size(); i++){
                        System.out.println(rooms.get(i));
                    }   break;
                case "exit":
                    hotel.saveRooms(csvUtilsRooms);
                    break OUTER;
                default:
                    break;
            }
        }
    }
    
}
