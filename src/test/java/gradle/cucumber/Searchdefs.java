package gradle.cucumber;

import Application.Model.User;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class Searchdefs extends AbstractStepdefs {

    private User user1;
    private User user2;
    private User user3;
    private List<User> getResponse;

    @Before
    public void setUp() {
        user1 = new User();
        user1.setUsername("pepita1");
        user1.setDeporte("Pato");

        user2 = new User();
        user2.setUsername("pepita2");
        user2.setDeporte("Pato");

        user3 = new User();
        user3.setUsername("pepita3");
        user3.setDeporte("Football");
    }


    @Given("^Three users in db$")
    public void aLogedUserAndThreeUsersInDb() throws Throwable {
        List<User> users = Arrays.asList(user1, user2, user3);

        for (User user : users) {
            HttpEntity<User> request = new HttpEntity<>(user);
            restTemplate.postForEntity(url + "User", request, String.class);
        }
    }

    @When("^I search for Tenis players$")
    public void iSearchForTenisPlayers() throws Throwable {
        getResponse = restTemplate.getForObject(url + "User/search?deporte="+"Pato", List.class);
    }

    @Then("^I should get only two users from db$")
    public void iShouldGetOnlyTwoUsersFromDb() throws Throwable {
        Assert.assertThat(getResponse.size(), is(2));
    }
}
