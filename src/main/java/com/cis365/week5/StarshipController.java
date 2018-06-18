package com.cis365.week5;

import com.cis365.week5.models.Planet;
import com.cis365.week5.models.Starship;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class StarshipController {

    @RequestMapping("/starship")
    public List<Starship> starships()
    {
        return DataStore.listStarships();
    }

    @GetMapping("/starship/{id}")
    public Starship starshipById(@PathVariable(value = "id") String starshipId) {
        return DataStore.findStarshipById(starshipId);
    }


    @PostMapping(value="/starship/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Starship addStarship(@PathVariable(value = "id") String starshipId, @RequestBody Starship starshipToUpdate) {
        return DataStore.updateStarship(starshipId, starshipToUpdate);
    }
}
