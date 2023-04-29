package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import os.osHibernate.PersonEntity;
import os.osHibernate.StudentOnCourse;
import os.repository.PersonRepository;
import os.service11.PersonService;

import java.util.List;

@Controller
public class StudentOnCourseController {
    @Autowired
    private PersonService ps;

    @GetMapping(value = "/student_on_course")
    public String StudentOnCourse(ModelMap model, @RequestParam("course_count")Integer cc) {
        List<StudentOnCourse> students = ps.studentOnCourses(cc);
        model.addAttribute("students", students);
        model.addAttribute("cc", cc);
        return "studentOnCourse";
    }
}
