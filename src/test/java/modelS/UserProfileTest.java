package modelS;

import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UserProfileTest {
    /**
     * Testing: {@link UserProfile#UserProfile()}
     */
    @Test
    void testUserProfile() {
        UserProfile actualUserProfile = new UserProfile();
        Assertions.assertEquals(0, actualUserProfile.getDateOfBirth());
        Assertions.assertNull(actualUserProfile.getGender());
        Assertions.assertEquals(0, actualUserProfile.getHeight());
        Assertions.assertEquals(0.0f, actualUserProfile.getWeight());
    }

    /**
     * Testing: {@link UserProfile#UserProfile(int, String, int, float)}
     */
    @Test
    void testUserProfileArgs() {
        UserProfile actualUserProfile = new UserProfile(1, "Gender", 1, 10.0f);

        Assertions.assertEquals(1, actualUserProfile.getDateOfBirth());
        Assertions.assertEquals("Gender", actualUserProfile.getGender());
        Assertions.assertEquals(1, actualUserProfile.getHeight());
        Assertions.assertEquals(10.0f, actualUserProfile.getWeight());
    }
}

