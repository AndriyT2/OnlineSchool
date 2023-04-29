package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import os.osHibernate.AdditionalMaterialsWithLectures;
import os.osHibernate.PersonEntity;
import os.repository.AdditionalMaterialsRepository;
import os.repository.PersonRepository;

import java.util.List;

@Controller
public class StudentByLastnameController {
    @Autowired
    private PersonRepository pr;

    @GetMapping(value = "/student_by_lastname")
    public String StudentByLastname(Model model) {
        List<PersonEntity> pl = pr.findAllByRoleOrderByLastname("student");
        model.addAttribute("students", pl);
        return "studentByLastname";
    }
}
