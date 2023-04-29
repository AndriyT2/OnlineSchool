package os.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import os.osHibernate.AdditionalMaterialsEntity;
import os.osHibernate.PersonEntity;
import os.service11.AdditionalMaterialsService;
import os.service11.PersonService;

import java.util.List;

@Controller
public class AdditionalMaterialsController {
    @Autowired
    private AdditionalMaterialsService as;

    @GetMapping(value = "/additional_materials")
    public String getAll(Model model) {
        List<Object[]> type = as.amType();
        model.addAttribute("am", type);
        return "am";
    }
}
