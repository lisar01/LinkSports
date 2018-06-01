package Application.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.resource.HttpResource;

@CrossOrigin
@RestController
@RequestMapping("/Test")
public class TestController {

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "OK";
    }
}
