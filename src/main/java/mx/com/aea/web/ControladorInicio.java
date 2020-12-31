
package mx.com.aea.web;

import java.util.ArrayList;
import java.util.Arrays;
import mx.com.aea.dao.PersonaDao;
import mx.com.aea.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorInicio {
    
    @Autowired
    private PersonaDao personaDao;
    
    @GetMapping("/")
    public String inicio(Model model){
        var personas = personaDao.findAll();
        model.addAttribute("personas", personas);
        return "index";
    }
}
