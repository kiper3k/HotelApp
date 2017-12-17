/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kiper
 */
public class CVSUtilsReservations implements CSVUtils {
    
    BufferedReader br = null;
    
    String csvFile;
    String cvsSplitBy;
    
    String line;
    List list;
    
    
    BufferedWriter bw;
    
    public CVSUtilsReservations(){
        this.csvFile = "resources/reservations.csv";
        this.cvsSplitBy = ",";
    }

    @Override
    public List readCSV() {
        List<ReservationInfo> reservations = new ArrayList<>();

        int reservationId;
        LocalDate startDate;
        LocalDate endDate;
        int clientId;
        String roomName;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // reads the header line
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] reservation = line.split(cvsSplitBy);
                reservationId = Integer.parseInt(reservation[0]);
                startDate = LocalDate.parse(reservation[1]);
                endDate = LocalDate.parse(reservation[2]);
                clientId = Integer.parseInt(reservation[3]);
                roomName = reservation[4];
//                System.out.println(new Room(Integer.parseInt(room[0]),
//                        Integer.parseInt(room[1]), 
//                        Float.parseFloat(room[2])));
                
                reservations.add(new ReservationInfoImpl(reservationId, startDate,
                        endDate, clientId, roomName));

            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        return reservations;
    }
    
    public void saveCSV(List<ReservationInfo> reservations){
        
        int reservationId;
        LocalDate startDate;
        LocalDate endDate;
        int clientId;
        String roomName;
        
        String line;
        
        try {

            bw = new BufferedWriter(new FileWriter(csvFile));
            line = "reservationId,startDate,endDat,clientId,roomName";
            bw.write(line, 0, line.length());
            bw.newLine();
            for (int i=0; i<reservations.size(); i++){
                reservationId = reservations.get(i).getReservationId();
                startDate = reservations.get(i).getStartDate();
                endDate = reservations.get(i).getEndDate();
                clientId = reservations.get(i).getClientId();
                roomName = reservations.get(i).getRoomName();
                
                line = reservationId + "," + startDate  + ","  + endDate + "," 
                       + clientId + "," + roomName;
                
                bw.write(line, 0, line.length());
                bw.newLine();
            }
            bw.close();
            

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    
    
}
