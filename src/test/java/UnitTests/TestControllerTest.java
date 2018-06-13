package UnitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.core.Is.is;

public class TestControllerTest {
    private RestTemplate restTemplate;
    private String url;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        url = "http://localhost:8080/Test";
    }

    @Test
    public void test_do_get_request_to_test_controller_and_receive_ok_response() {
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        Assert.assertThat(response.getStatusCode(), is(HttpStatus.OK));
    }
}
