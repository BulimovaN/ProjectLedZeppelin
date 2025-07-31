import com.javarush.bulimova.constants.UserStore;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserStoreTest {

    @Test
    void testValidUser() {
        assertTrue(UserStore.isValid("admin", "12345"));
        assertTrue(UserStore.isValid("user", "11111"));
    }

    @Test
    void testInvalidUser() {
        assertFalse(UserStore.isValid("admin", "wrong"));
        assertFalse(UserStore.isValid("unknown", "12345"));
    }

    @Test
    void testRegisterNewUser() {
        boolean result = UserStore.register("newUser", "pass");
        assertTrue(result);
        assertTrue(UserStore.isValid("newUser", "pass"));
    }

    @Test
    void testRegisterExistingUser() {
        boolean result = UserStore.register("admin", "newPass");
        assertFalse(result);
        // пароль не меняется
        assertTrue(UserStore.isValid("admin", "12345"));
    }
}

