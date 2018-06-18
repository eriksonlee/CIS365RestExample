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
    public PlanetVisit planetVisitById(@PathVariable(value = "id") String planetVisitId) {
        return DataStore.findPlanetVisitById(planetVisitId);
    }

    @PostMapping(value="/planetvisit/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public PlanetVisit addPlanetVisit(@PathVariable(value = "id") String planetId, @RequestBody PlanetVisit planetVisitToUpdate) {
        return DataStore.updatePlanetVisit(planetId, planetVisitToUpdate);
    }
}
