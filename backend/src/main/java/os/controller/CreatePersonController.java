package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import os.service11.PersonService;

@Controller
public class CreatePersonController {

    @GetMapping(value = "/createPerson")
    public String NewPerson(){
        return "createPerson";
    }

    @Autowired
    private PersonService ps;
    @PostMapping(value = "/createPerson")
    public String CreatePerson(@RequestParam("firstname")String firstname,
                               @RequestParam("lastname")String lastname,
                               @RequestParam("phone")String phone,
                               @RequestParam("email")String email,
                               @RequestParam("role")String role){

        ps.addPerson(lastname, firstname, phone, email, role);

        return "redirect:/person";
    }
}
