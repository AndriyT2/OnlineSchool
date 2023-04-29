package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import os.osHibernate.AdditionalMaterialsWithLectures;
import os.repository.AdditionalMaterialsRepository;

import java.util.List;

@Controller
public class LectureBefore2023Controller {

    @Autowired
    private AdditionalMaterialsRepository am;

    @GetMapping(value = "/lecture_before_2023")
    public String LectureBefore2023(Model model) {
        List<AdditionalMaterialsWithLectures> aml = am.lectureBefore2023();
        model.addAttribute("lectures", aml);
        return "lectureBefore2023";
    }
}
