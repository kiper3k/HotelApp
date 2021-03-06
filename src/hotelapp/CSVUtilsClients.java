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
public class CSVUtilsClients implements CSVUtils {
    BufferedReader br = null;
    
    String csvFile;
    String cvsSplitBy;
    
    String line;
    List list;
    
    
    BufferedWriter bw;
    
    public CSVUtilsClients(){
        this.csvFile = "resources/clients.csv";
        this.cvsSplitBy = ",";
    }
    
    public List readCSV(){
        List<Client> clients = new ArrayList<>();
        
        int id;
        String firstName;
        String lastName;
        LocalDate birthDate;
        String login;
        String password;
        int nbOfReservations;
        
        try {

            br = new BufferedReader(new FileReader(csvFile));
            br.readLine(); // reads the header line
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] client = line.split(cvsSplitBy);
                id = Integer.parseInt(client[0]);
                firstName = client[1];
                lastName = client[2];
                birthDate = LocalDate.parse(client[3]);
                login = client[4];
                password = client[5];
                nbOfReservations = Integer.parseInt(client[6]);
//                System.out.println(client[0] + client[2]);
                
                clients.add(new Client(id, firstName, lastName, birthDate,
                        login, password, nbOfReservations));

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
        
        return clients;
        
    }
    
    
    public void saveCSV(List<Client> clients){
        
        int id;
        String firstName;
        String lastName;
        LocalDate birthDate;
        String login;
        String password;
        int nbOfReservations;
        
        String line;
        
        try {

            bw = new BufferedWriter(new FileWriter(csvFile));
            line = "id,firstName,lastName,birthDate,login,password,nbOfReservations";
            bw.write(line, 0, line.length());
            bw.newLine();
            for (int i=0; i<clients.size(); i++){
                id = clients.get(i).getId();
                firstName = clients.get(i).getFirstName();
                lastName = clients.get(i).getLastName();
                birthDate = clients.get(i).getBirthDate();
                login = clients.get(i).getLogin();
                password = clients.get(i).getPassword();
                nbOfReservations = clients.get(i).getNbOfReservations();
                
                line = Integer.toString(id) + "," + firstName + "," + lastName
                        + "," + birthDate + "," + login + "," + password
                        + "," + nbOfReservations;
                
                
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
