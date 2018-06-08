package Application.Controllers.ResponseModel;

import org.springframework.http.HttpStatus;

public class ResponseModel {
    public String body;

    public ResponseModel(String body) {
        this.body = body;
    }
}
