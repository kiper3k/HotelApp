/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelapp;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author kiper
 */
public class Employee extends User {
        
    private int id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String login;
    private String password;

    Privileges privileges;

    public Employee(int id, String firstName, String lastName, LocalDate birthDate,
            String login, String password) {
        super(id, firstName, lastName, birthDate, login, password);
        this.privileges = Privileges.ADMIN;
        
    }
    
    public Privileges getPrivileges(){
        return this.privileges;
    }
    
    public void setPrivileges(Privileges privileges){
        this.privileges = privileges;
    }
    
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + this.id + '\'' +
                ", firstName='" + this.firstName + '\'' +
                ", lastName='" + this.lastName + '\'' +
                '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }
    
}
