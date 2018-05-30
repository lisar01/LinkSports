package UnitTests;

import Application.Model.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.notNullValue;

public class UserControllerTest {
    private RestTemplate restTemplate;
    private String url;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        url = "http://localhost:8080/User";
    }

    @Test
    public void test_add_user_and_check_if_it_has_been_saved() {
        HttpEntity<User> request = new HttpEntity<>(new User("foo"));
        User user = restTemplate.postForObject(url, request, User.class);

        Assert.assertThat(user, notNullValue());
        Assert.assertTrue(user.getId() > 0);
        Assert.assertThat(user.getUsername(), is("foo"));
    }
}
