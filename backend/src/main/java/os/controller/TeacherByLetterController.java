package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import os.osHibernate.PersonEntity;
import os.service11.PersonService;

import java.util.List;

@Controller
public class TeacherByLetterController {

    @Autowired
    private PersonService ps;

    @GetMapping(value = "/teacher_by_letter")
    public String teacherByLetter(Model model) {
        List<PersonEntity> pe = ps.teacherByLetter();
        model.addAttribute("teacher", pe);
        return "teacherByLetter";
    }
}


