package rabbit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/logs")
public class LogController {

    //    https://spring.io/guides/gs/rest-service/
    //    http://www.baeldung.com/spring-request-response-body
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> log(@RequestBody Log input) {
        try {
            Send.send(input.getContent());
        } catch(Exception e) {
            return ResponseEntity.ok(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(HttpStatus.OK);
    }



}

