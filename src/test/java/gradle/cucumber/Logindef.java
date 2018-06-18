package gradle.cucumber;

import Application.Model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import static org.hamcrest.core.Is.is;

public class Logindef extends AbstractStepdefs {

    @Given("^An admin user saved in db")
    public void An_admin_user_saved_in_db() {
        user.setUsername("admin1");
        user.setPassword("admin1");
        HttpEntity<User> request = new HttpEntity<>(user);
        response = restTemplate.postForEntity(url + "User", request, String.class);
    }

    @When("^I login with admin user")
    public void I_login_with_admin_user() throws Throwable{
        HttpEntity<User> request = new HttpEntity<>(user);
        response = restTemplate.postForEntity(url + "User/login", request, String.class);
    }
    @Then("^I should get http status OK for login")
    public void I_should_get_http_status_OK_for_login() {
        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}
