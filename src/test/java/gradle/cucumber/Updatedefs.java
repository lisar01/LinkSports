package gradle.cucumber;

import Application.Model.User;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.Is.is;

public class Updatedefs extends AbstractStepdefs {
    @Given("^A user$")
    public void aUser() throws Throwable {
        user = new User("pep01", "qwerty", "pepilla", "pepillo", "Golf", "Coach");
        HttpEntity<User> request = new HttpEntity<>(user);
        restTemplate.postForEntity(url + "User", request, String.class);
    }

    @When("^I update that user$")
    public void iUpdateThatUser() throws Throwable {
        user.setDeporte("Karate");
        user.setNombre("nombre");
        user.setApellido("apellido");
        restTemplate.put(url + "User/update", user);
    }

    @Then("^I should update the user in db and get it back$")
    public void iShouldUpdateTheUserInDbAndGetItBack() throws Throwable {
        HttpEntity<User> request = new HttpEntity<>(user);
        User userMod = restTemplate.postForEntity(url + "User/login", request, User.class).getBody();
        Assert.assertThat(userMod.getDeporte(), is("Karate"));
        Assert.assertThat(userMod.getNombre(), is("nombre"));
        Assert.assertThat(userMod.getApellido(), is("apellido"));
    }
}
