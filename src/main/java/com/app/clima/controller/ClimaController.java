package com.app.clima.controller;

import com.app.clima.entities.Clima;
import com.app.clima.helpers.ViewRouteHelper;
import com.app.clima.services.IClimaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ClimaController {
    private final IClimaService climaService;

    public ClimaController(IClimaService climaService) {
        this.climaService = climaService;
    }
    
    @GetMapping("/clima")
    public String getClima(@RequestParam(value = "ciudad", required = false) String ciudad, Model model) {
        if (ciudad != null && !ciudad.isEmpty()) {
            //Climas mas buscados
            List<Clima> listaClimas = new ArrayList<>();
            listaClimas.add(climaService.getClima("Nueva York"));
            listaClimas.add(climaService.getClima("Londres"));
            listaClimas.add(climaService.getClima("Madrid"));
            listaClimas.add(climaService.getClima("Tokyo"));

            model.addAttribute("climas", listaClimas);

            //Busqueda del usuario
            Clima clima = climaService.getClima(ciudad);
            model.addAttribute("clima", clima);
        }
        return ViewRouteHelper.CLIMA_INDEX;
    }
}
