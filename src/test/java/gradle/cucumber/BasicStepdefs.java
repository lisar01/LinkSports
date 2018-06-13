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

public class BasicStepdefs {
    private RestTemplate restTemplate = new RestTemplate();
    private String url = "http://localhost:8080";
    ResponseEntity<String> response;

    @When("^I do a GET request to Test controller")
    public void I_do_a_GET_request_to_Test_controller() throws Throwable{
        response = restTemplate.getForEntity(url + "/Test", String.class);
    }
    @Then("^I should get OK Response")
    public void I_should_get_a_OK_Response() {
        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}
