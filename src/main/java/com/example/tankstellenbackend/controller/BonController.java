package com.example.tankstellenbackend.controller;

import com.example.tankstellenbackend.model.Bon;
import com.example.tankstellenbackend.service.BonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class BonController {

    private static final Logger log = LoggerFactory.getLogger(BonController.class);

    private BonService bonService;

    @Autowired
    public BonController(BonService bonService) {
        this.bonService = bonService;
    }

    @RequestMapping(value = "/bons", method = RequestMethod.GET)
    public String neuErschaffen(Bon bon) {
        return "bonCreatePage";
    }

    @RequestMapping(value = "/bonis", method = RequestMethod.POST)
    public String saveBon(@Valid Bon bon, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            log.error("Binding result hat Fehler {}", bindingResult.getAllErrors());
            return "redirect:/bons";
        } else {
            bonService.add(bon);
            model.addAttribute("createdBon", bon);
        }
        return "successedBon";
    }

    @RequestMapping(value = "/graphics")
    public String showGraphs(Model model) {
        List<Bon> bons = bonService.findAll();
        model.addAttribute("bons", bons);
        return "graphics";
    }

    @RequestMapping(value = "/bearbeiten")
    public String bearbeiten(Model model) {
        List<Bon> bons = bonService.findAll();
        model.addAttribute("bons", bons);
        return "bonEditPage";
    }
}
