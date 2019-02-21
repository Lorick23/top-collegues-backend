package dev.top.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import dev.top.entities.Collegue;
import dev.top.service.CollegueService;
import dev.top.utils.Action;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

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
    public Collegue updateScore(@PathVariable String name, @RequestBody Action action) {
        return this.collegueService.updateScore(name, action.getAction());
    }

    @PostMapping
    public void postMethodName(@RequestBody String matricule) {
        System.out.println(matricule);
        // RestTemplate restTemplate = new RestTemplate();
        // String fooResourceUrl = "https://tommy-sjava.cleverapps.io/collegues?matricule="+matricule;
        //ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
       
    }

}
