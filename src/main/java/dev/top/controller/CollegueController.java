package dev.top.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.top.entities.Collegue;
import dev.top.service.CollegueService;
import dev.top.utils.Action;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


@RestController()
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueController {

    @Autowired
    private CollegueService collegueService;

    @GetMapping
    public List<Collegue> findAll() {
        return this.collegueService.findAll();
    }

    @PatchMapping("/{name}")
    public Collegue updateScore(@PathVariable String name, @RequestBody Action action){
        return this.collegueService.updateScore(name, action.getAction());
    }


}
