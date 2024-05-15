package tests;

import models.User;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {
    @BeforeMethod
    public void preCondition() {
        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000) + 1000;
        System.out.println(i);

        //*************************************

        System.out.println(System.currentTimeMillis());
        int z = (int) (System.currentTimeMillis() / 1000) % 3600;
        System.out.println(z);

        User user = new User()
                .withFirstName("Lusy")
                .withLastName("Bridge")
                .setEmail("bridge" + z + "@gmail.com")
                .setPassword("Bbr123456$");

        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().submitRegistration();
        app.getHelperUser().fillRegistrationForm(user);
        app.getHelperUser().submit();
    }
}
