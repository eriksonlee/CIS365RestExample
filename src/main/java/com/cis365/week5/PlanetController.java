package com.cis365.week5;


import com.cis365.week5.models.Planet;
import com.cis365.week5.models.PlanetVisit;
import com.cis365.week5.models.Starship;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetController {

    @RequestMapping("/planet")
    public List<Planet> planets()
    {
        return DataStore.listPlanets();
    }

    @GetMapping("/planet/{id}")
    public Planet planetById(@PathVariable(value = "id") String planetId) {
        return DataStore.findPlanetById(planetId);
    }

    @PostMapping(value="/planet/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Planet addPlanet(@PathVariable(value = "id") String planetId, @RequestBody Planet planetToUpdate) {
        return DataStore.updatePlanet(planetId, planetToUpdate);
    }
}
