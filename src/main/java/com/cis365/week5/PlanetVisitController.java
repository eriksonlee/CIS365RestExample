package com.cis365.week5;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.PlanetVisit;
import com.cis365.week5.models.Starship;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetVisitController {

    @RequestMapping("/planetvisit")
    public List<PlanetVisit> planetvisits()
    {
        return DataStore.listPlanetVisits();
    }


    @GetMapping("/planetvisit/{id}")
    public Starship starshipById(@PathVariable(value = "id") String starshipId) {
        return DataStore.findStarshipById(starshipId);
    }

    @PostMapping(value="/planetvisit/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Starship addStarship(@PathVariable(value = "id") String starshipId, @RequestBody Starship starshipToUpdate) {
        return DataStore.updateStarship(starshipId, starshipToUpdate);
    }

}
