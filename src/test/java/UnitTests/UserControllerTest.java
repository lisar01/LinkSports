package UnitTests;

import Application.Controllers.DTOs.FollowDTO;
import Application.DAOs.UserDAO;
import Application.Model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class UserControllerTest {
    private RestTemplate restTemplate;
    private String url;
    @Autowired
    private UserDAO userDAO;
    private ResponseEntity<String> response;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        url = "http://localhost:8080/User";
    }

    @Test
    public void test_add_user_and_check_if_it_has_been_saved() {
        User user = new User();
        user.setUsername("test"); user.setPassword("test");
        HttpEntity<User> request = new HttpEntity<>(user);
        //Http request
        User result = restTemplate.postForObject(url, request, User.class);

        Assert.assertThat(result, notNullValue());
        Assert.assertThat(result.getUsername(), is("test"));
        Assert.assertThat(result.getPassword(), is("test"));
    }

}
