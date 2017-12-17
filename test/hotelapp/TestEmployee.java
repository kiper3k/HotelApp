package hotelapp;
import java.time.LocalDate;
import org.junit.Assert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kiper
 */
public class TestEmployee {

    public TestEmployee() {
    }
     public void testSetPrivileges(){
        Employee employee = new Employee(1, "Jan", "Kowalski", 
                LocalDate.parse("1984-05-20"), "janko", "876");
        Assert.assertEquals(Privileges.ADMIN, employee.getPrivileges());
    }
    
    
    
}
