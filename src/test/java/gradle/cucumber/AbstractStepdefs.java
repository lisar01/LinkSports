package gradle.cucumber;

import Application.Model.User;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

@ContextConfiguration
@SpringBootTest(classes = {Application.Application.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public abstract class AbstractStepdefs {
    public RestTemplate restTemplate = new RestTemplate();
    public String url = "http://localhost:8080/";
    public ResponseEntity<String> response;
    public User user = new User();
}
