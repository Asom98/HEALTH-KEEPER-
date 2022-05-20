package modelS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;


class UserTest {

    @Test
    public void testAddUser(){
        User user = new User("1",
                "1",
                "12345678");
        Assertions.assertEquals("Tim", user.getName());
        Assertions.assertEquals("Tim@live.com", user.getEmail());
        Assertions.assertEquals("12345678", user.getPassword());

    }

}

