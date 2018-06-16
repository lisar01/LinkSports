package gradle.cucumber;

import Application.Model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.Is.is;

public class Signupdef extends AbstractStepdefs {

    @Given("^An user")
    public void An_admin_user_saved_in_db() {
        user.setUsername("nico");
        user.setPassword("nico");
    }

    @When("^I Register that user")
    public void I_Register_that_user() throws Throwable{
        HttpEntity<User> request = new HttpEntity<>(user);
        response = restTemplate.postForEntity(url + "User", request, String.class);
    }
    @Then("^I should get http status OK for signup")
    public void I_should_get_http_status_OK_for_signup() {
        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}
