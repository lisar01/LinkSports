package gradle.cucumber;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class BasicStepdefs {

    @When("^I do a GET request to Test controller")
    public void I_do_a_GET_request_to_Test_controller() throws Throwable{
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/Test", String.class);
    }
    /*@Then("^I should get a Ok response$")
    public void I_should_get_a_Ok_response(String responseExpected) {
        Assert.assertTrue(responseExpected != null);
    }*/
}
