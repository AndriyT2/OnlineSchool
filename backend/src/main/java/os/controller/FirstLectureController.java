package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import os.osHibernate.AdditionalMaterialsWithLectures;
import os.osHibernate.LectureEntity;
import os.osHibernate.PersonEntity;
import os.repository.AdditionalMaterialsRepository;
import os.repository.LectureRepository;
import os.service11.PersonService;

import java.util.List;

@Controller
public class FirstLectureController {
    @Autowired
    private LectureRepository lr;
    @GetMapping(value = "/first_lecture")
    public String FirstLecture(Model model){
        LectureEntity lecture = lr.firstLecture();
        model.addAttribute("lecture", lecture);
        return "firsLecture";

    }
}
