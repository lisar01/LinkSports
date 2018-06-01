package gradle.cucumber;

import Application.Model.User;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;

public class Logindef {
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080";
    private ResponseEntity<String> response;

    @When("^I login with user admin")
    public void I_login_with_user_admin() throws Throwable{
        HttpEntity<User> request = new HttpEntity<>(new User("admin", "admin"));
        response = restTemplate.postForEntity(url + "/User/login", request, String.class);
    }
    @Then("^I get Login exitoso text")
    public void I_get_login_exitoso_text() {
        Assert.assertThat(response.getBody(), is("Login exitoso!"));
    }
}
