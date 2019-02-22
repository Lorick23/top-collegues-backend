package dev.top.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import dev.top.entities.Collegue;
import dev.top.service.CollegueService;
import dev.top.utils.Action;
import dev.top.utils.CollegueAPI;
import dev.top.utils.CollegueFront;

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
    public ResponseEntity<List<Collegue>> findAll() {
        //ResponseEntity.ok().body(collegueService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(collegueService.findAll());
    }

    @PatchMapping("/{name}")
    public Collegue updateScore(@PathVariable String name, @RequestBody Action action) {
        return this.collegueService.updateScore(name, action.getAction());
    }

    @PostMapping
    public ResponseEntity<?> postMethodName(@Valid @RequestBody CollegueFront colFront, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return ResponseEntity.badRequest().build();
        }
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "https://tommy-sjava.cleverapps.io/collegues?matricule=" + colFront.getMatricule();
        ResponseEntity<CollegueAPI[]> response = restTemplate.getForEntity(fooResourceUrl, CollegueAPI[].class);
        if (response != null) {
            CollegueAPI colapi = response.getBody()[0];
            colapi.setNom(colFront.getPseudo());
            if(colFront.getPhoto() != null){
                colapi.setPhoto(colFront.getPhoto());
            }
            Collegue col = new Collegue(colapi);
            this.collegueService.save(col);
            return ResponseEntity.ok().build();
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    // @PostMapping
    // public void postMethodName(@RequestBody String matricule) {
    //     RestTemplate restTemplate = new RestTemplate();
    //     String fooResourceUrl = "https://tommy-sjava.cleverapps.io/collegues?matricule=" + matricule;
    //     ResponseEntity<CollegueAPI[]> response = restTemplate.getForEntity(fooResourceUrl, CollegueAPI[].class);
    // }
    

}
