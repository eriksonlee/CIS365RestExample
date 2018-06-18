package com.cis365.week5;

import com.cis365.week5.models.Planet;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlanetVisitController {

    @RequestMapping("/planetvisit")
    public List<Planet> planetvisits()
    {
        return DataStore.listPlanetVisits();
    }
}
