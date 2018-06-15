package gradle.cucumber;

import Application.Model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;

public class Logindef extends AbstractStepdefs{
    private User admin;
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080/User";
    private ResponseEntity<String> response;

    @Given("^An admin user saved in db")
    public void An_admin_user() {
        admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        HttpEntity<User> request = new HttpEntity<>(admin);
        response = restTemplate.postForEntity(url, request, String.class);
    }

    @When("^I login with admin user")
    public void I_login_with_admin_user() throws Throwable{
        HttpEntity<User> request = new HttpEntity<>(admin);
        response = restTemplate.postForEntity(url + "/login", request, String.class);
    }
    @Then("^I should get Login exitoso message")
    public void I_should_get_Login_exitoso_message() {
        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}
