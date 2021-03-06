package hotelapp;

import java.time.LocalDate;

/**
 * @author Marta Motyka
 * @since 21.11.2017
 */
public abstract class User {
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String login;
    private String password;
//    private Privileges privileges = Privileges.ADMIN;
    
    public User(int id, String firstName, String lastName,LocalDate birthDate,
            String login, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.login = login;
        this.password = password;
//        this.privileges = privileges;
    }
    
    public int getSuperId(){
        return this.id;
    }
    
    public String getSuperFirstName(){
        return this.firstName;
    }
    
    public String getSuperLastName(){
        return this.lastName;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    
    public String getLogin(){
        return this.login;
    }
    
    public void setLogin(String login){
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}
