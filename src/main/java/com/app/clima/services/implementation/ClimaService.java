package com.app.clima.services.implementation;

import com.app.clima.entities.Clima;
import com.app.clima.helpers.ViewRouteHelper;
import com.app.clima.services.IClimaService;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("climaService")
public class ClimaService implements IClimaService {

	public Clima getClima(String ciudad) {
        RestTemplate restTemplate = new RestTemplate();
        
        String url = ViewRouteHelper.API_URL + "?q=" + ciudad + "&appid=" + ViewRouteHelper.API_KEY + "&units=metric";
        String jsonResponse = restTemplate.getForObject(url, String.class);
        
        //Filtro datos para solo obtener ciudad y temperatura con JSONPath
        DocumentContext jsonContext = JsonPath.parse(jsonResponse);
        String cityName = jsonContext.read("$.name");
        Double temperature = jsonContext.read("$.main.temp");
        
        return new Clima(cityName, temperature);
    }
    
}

