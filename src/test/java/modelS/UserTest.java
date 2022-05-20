package modelS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


class UserTest {
    /**
     * Testing:
     *
     * <ul>
     *   <li>{@link User#User()}
     *   <li>{@link User#setDateOfBirth(String)}
     *   <li>{@link User#setEmail(String)}
     *   <li>{@link User#setGender(String)}
     *   <li>{@link User#setHeight(int)}
     *   <li>{@link User#setName(String)}
     *   <li>{@link User#setPassword(String)}
     *   <li>{@link User#setWeight(int)}
     * </ul>
     */
    @Test
    void testSetters() {
        User actualUser = new User();
        actualUser.setDateOfBirth("2020-03-01");
        actualUser.setEmail("email@email.com");
        actualUser.setGender("Gender");
        actualUser.setHeight(1);
        actualUser.setName("Name");
        actualUser.setPassword("password");
        actualUser.setWeight(3);

        Assertions.assertEquals("2020-03-01", actualUser.getDateOfBirth());
        Assertions.assertEquals("email@email.com", actualUser.getEmail());
        Assertions.assertEquals("Gender", actualUser.getGender());
        Assertions.assertEquals(1, actualUser.getHeight());
        Assertions.assertEquals("Name", actualUser.getName());
        Assertions.assertEquals("password", actualUser.getPassword());
    }

    /**
     * Testing: {@link User#getWeight()}
     */
    @Test
    void testGetWeight() {
        Assertions.assertEquals(0.0f, (new User("Name", "email@email.com", "password")).getWeight());
    }
}

