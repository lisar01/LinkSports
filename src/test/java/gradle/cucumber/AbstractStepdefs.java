package gradle.cucumber;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@SpringBootTest(classes = {Application.Application.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AbstractStepdefs {
}
