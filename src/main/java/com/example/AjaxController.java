package com.example;

import com.example.entities.Name;
import com.example.repo.NameRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * Created by PatrykGrudnik on 12.03.2017.
 */

@RestController
public class AjaxController {
    public final NameRepository nameRepository ;

    public AjaxController(NameRepository nameRepository) {
        this.nameRepository = nameRepository;
    }

    @RequestMapping(value = "/ajax/{myname}")
    public List<Name> index(@PathVariable String myname) {
        return nameRepository.findByNameStartingWith(myname);
    }


}
