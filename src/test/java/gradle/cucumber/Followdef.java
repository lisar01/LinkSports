package gradle.cucumber;

import Application.Controllers.DTOs.FollowDTO;
import Application.Model.User;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.core.Is.is;

public class Followdef extends AbstractStepdefs {
    private FollowDTO dto;
    private User toFollow = new User();

    @Transactional
    @Given("^A logged user and a user to follow")
    public void A_logged_user_and_a_user_to_follow() {
        user.setUsername("follower");
        toFollow.setUsername("test");
        //Save users
        userDAO.save(user); userDAO.save(toFollow);
        dto = new FollowDTO(user.getUsername(), userDAO.getByUsername("test"));
    }
    @Transactional
    @When("^I follow that user")
    public void I_Follow_that_user() throws Throwable{
        HttpEntity<FollowDTO> request = new HttpEntity<FollowDTO>(dto);
        response = restTemplate.postForEntity(url + "User/follow", request, String.class);
    }
    @Transactional
    @Then("^I should appear in his followers list")
    public void I_should_appear_in_his_followers_list() {
        User persistedFollowed = userDAO.getByUsername("test");

        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
        Assert.assertThat(persistedFollowed.getFollowers().size(), is(1));
        Assert.assertThat(persistedFollowed.getFollowers().get(0).getUsername(), is("follower"));
    }
}
