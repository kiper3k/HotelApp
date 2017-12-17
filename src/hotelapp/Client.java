package hotelapp;

import java.time.LocalDate;
import java.util.Objects;

/**
 * @author Marta Motyka
 * @since 14.11.2017
 */
public class Client extends User {
    
//    private int id;
//    private String firstName;
//    private String lastName;
//    private LocalDate birthDate;
//    private String login;
//    private String password;
//    User user;
    private Privileges privileges;
    private int nbOfReservations;
    
    
//    private String email;
//    private String address;

    
    public Client(int id, String firstName, String lastName, LocalDate birthDate,
            String login, String password, int nbOfReservations) {
        super(id, firstName, lastName, birthDate, login, password);
        this.privileges = Privileges.CLIENT;
        this.nbOfReservations = nbOfReservations;
    }
    
    
//    public int getId(){
//        return id;
//    }
//    
//    public void setId(int id){
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//    
//    public LocalDate getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(LocalDate birthDate) {
//        this.birthDate = birthDate;
//    }
//    
//    public String getLogin(){
//        return this.login;
//    }
//    
//    public void setLogin(String login){
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
    
    public Privileges getPrivileges(){
        return this.privileges;
    }
    
    public void setPrivileges(Privileges privileges){
        this.privileges = privileges;
    }
    
    public int getNbOfReservations(){
        return nbOfReservations;
    }
    
    public void setNbOfReservations(int nbOfReservations){
        this.nbOfReservations = nbOfReservations;
    }

    
    @Override
    public String toString() {
        return "Client{" +
                "id=" + getId() + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                '}';
    }
    
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Client client = (Client) o;
//        return Objects.equals(this.getFirstName(), client.getFirstName()) &&
//                Objects.equals(this.getFirstName(), client.getLastName()) &&
//                Objects.equals(this.getLogin(), client.getLogin());
//    }
}

