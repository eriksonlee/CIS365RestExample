package com.cis365.week5;

import com.cis365.week5.models.Starship;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;

@RestController
public class RepController {

    @GetMapping("/rep")
    public List<Starship> reps() {
        return DataStore.listReps();
    }

    @GetMapping("/rep/{id}")
    public Starship getRepById(@PathVariable(value = "id") String repNum) {
        return DataStore.findRepById(repNum);
    }

    @PostMapping(value="/rep/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE})
    public Starship addRep(@PathVariable(value = "id") String repNum, @RequestBody Starship starshipToUpdate) {
        return DataStore.updateRep(repNum, starshipToUpdate);
    }
}
