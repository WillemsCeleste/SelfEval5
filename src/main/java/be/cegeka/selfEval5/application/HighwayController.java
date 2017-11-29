package be.cegeka.selfEval5.application;

import be.cegeka.selfEval5.domain.highway.Highway;
import be.cegeka.selfEval5.domain.highway.HighwayService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(path = "/highway")
@Transactional
public class HighwayController {

    @Inject
    private HighwayService highwayService;

    @PostMapping
    public void addHighway(@RequestParam(value = "name", required = true) String name,
                           @RequestParam(value = "length", required = true) int length) {
        highwayService.addHighway(name, length);
    }

    @GetMapping
    public Highway getHighwayDetails(@RequestParam(value = "id", required = true) int id) {
        return highwayService.getHighwayDetails(id);
    }

    @GetMapping(path = "/all")
    public List<Highway> getAllHighways() {
        return highwayService.getAllHighways();
    }
}
