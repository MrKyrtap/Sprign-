package com.example;

import com.example.dtos.Message;
import com.example.dtos.NameListDTO;
import com.example.dtos.NameShortDTO;
import com.example.entities.Name;
import com.example.repo.NameRepository;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by PatrykGrudnik on 12.03.2017.
 */

@Controller
public class AjaxController {
    public final NameRepository nameRepository ;
    public final Logger log = LoggerFactory.getLogger(AjaxController.class);

    private final NameService nameService;

    @Autowired
    public AjaxController(NameRepository nameRepository, NameService nameService) {
        this.nameRepository = nameRepository;
        this.nameService = nameService;
    }

    @RequestMapping(value = "/ajax/{myname}")
    @ResponseBody
    public NameListDTO index(@PathVariable String myname) {

        List<Name> names = nameService.getNames(myname);
        List<NameShortDTO> collect = names.stream()
                .map(name -> new NameShortDTO(name.getTitle()))
                .collect(Collectors.toList());
        NameListDTO nameListDTO = new NameListDTO();
        nameListDTO.setNames(collect);

        if (collect.isEmpty()) {

            nameListDTO.setMessage(new Message("brak"));
        } else {
            nameListDTO.setMessage(new Message("jest"));
        }

        return nameListDTO;
    }


    @RequestMapping(value = "ajax/add", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("name") Name name,
                        BindingResult bindingResult,
                        HttpServletRequest request,
                        RedirectAttributes redirectAttrs) {
        if (!bindingResult.hasErrors()) {
            log.info(name.toString());
            nameRepository.save(name);

        }
        String referer = request.getHeader("Referer");
        return "redirect:" + referer;
      }



}
