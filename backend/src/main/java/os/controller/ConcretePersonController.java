package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import os.osHibernate.PersonEntity;
import os.service11.PersonService;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class ConcretePersonController {
    @Autowired
    private PersonService ps;

    @GetMapping(value = "/concretePerson")
    public String ConcretePerson(Model model, @RequestParam("personId")Integer personId) {
        PersonEntity pe = ps.findById(personId);
        model.addAttribute("conPersons", pe);
        return "concretePerson";
    }
}
