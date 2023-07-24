package com.app.clima.controller;

import com.app.clima.entities.Clima;
import com.app.clima.helpers.ViewRouteHelper;
import com.app.clima.services.IClimaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ClimaController {
    private final IClimaService climaService;

    @Autowired
    public ClimaController(IClimaService climaService) {
        this.climaService = climaService;
    }
    
    @GetMapping("/clima")
    public String getClima(@RequestParam(value = "ciudad", required = false) String ciudad, Model model) {
        if (ciudad != null && !ciudad.isEmpty()) {
            Clima clima = climaService.getClima(ciudad);
            model.addAttribute("clima", clima);
        }
        return ViewRouteHelper.CLIMA_INDEX;
    }
}
