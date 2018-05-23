package com.cis365.week5;


import com.cis365.week5.models.Planet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetController {

    @RequestMapping("/planet")
    public List<Planet> planets()
    {
        return DataStore.listPlanets();
    }
}
