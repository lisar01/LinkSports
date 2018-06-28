package gradle.cucumber;

import Application.Model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.hamcrest.core.Is.is;

public class FailesLogindefs extends AbstractStepdefs {
    private HttpStatus statusCode;

    @Given("^A user not saved in db$")
    public void aUserNotSavedInDb() throws Throwable {
        user.setUsername("pepita");
        user.setPassword("1234");
    }

    @When("^I login with the user$")
    public void iLoginWithTheUser() throws Throwable {
        HttpEntity<User> request = new HttpEntity<>(user);
        try {
            restTemplate.postForEntity(url + "User/login", request, String.class);
        }
        catch (HttpClientErrorException exp) {
            statusCode = exp.getStatusCode();
        }
    }

    @Then("^I should get http status BAD REQUEST for login$")
    public void iShouldGetHttpStatusBADREQUESTForLogin() throws Throwable {
        Assert.assertThat(statusCode, is(HttpStatus.BAD_REQUEST));
    }
}
