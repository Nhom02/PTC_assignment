package helpers;
import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "InvalidLoginData")
    public Object[][] provideInvalidLoginData() {
        return new Object[][] {
                {"user1@example.com", "password1"},
                {"user2@example.com", "password2"},
                {"user3@example.com", "password3"}
        };
    }

    @DataProvider(name = "ValidLoginData")
    public Object[][] provideValidLoginData() {
        return new Object[][] {
                {"user1@example.com", "password1"},
                {"user2@example.com", "password2"},
                {"user3@example.com", "password3"}
        };
    }

}