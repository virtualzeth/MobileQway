import handlers.ValidationHandler;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class ValidationHandlerTest {
    @Test
    public void validPhoneNumbersMatch() {
        String[] validNumbersArray = new String[] {"11001100", "99999999", "00000000"};
        for (String s : validNumbersArray) {
            Assertions.assertTrue(ValidationHandler.validatePhoneNumber(s));
        }
    }
    @Test
    public void validPasswordMatch() {
        String[] validPasswordsArray = new String[] {"Password1234", "passWord1234", "4321wordPass", "Ab345678"};
        for (String s : validPasswordsArray) {
            Assertions.assertTrue(ValidationHandler.validatePassword(s));
        }
    }
    @Test
    public void invalidPasswordMatch() {
        String[] validPasswordsArray = new String[] {"12345678", "abcdefgh", "ABCDEFGH", "password1234", "PASSWORD1234",
        "1Pa4567"};
        for (String s : validPasswordsArray) {
            Assertions.assertFalse(ValidationHandler.validatePassword(s));
        }
    }
}
