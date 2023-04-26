package os;

import config.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@RestController

public class OsApplication {

    public static void main(String[] args) {
        SpringApplication.run(OsApplication.class, args);}

        @Autowired
        Environment env;
//    @GetMapping(value = "/")
    @RequestMapping(value = "/", method = RequestMethod.GET, path = "src/main/resources/templates/indexhtml.html")

    public String firstPage(){
        return "indexhtml";

    }

    @RequestMapping(value = "/ex", method = RequestMethod.GET)

    public String Exception() throws CustomException {
        throw new CustomException();

    }

}
