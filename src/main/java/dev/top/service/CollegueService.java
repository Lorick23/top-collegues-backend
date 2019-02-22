package dev.top.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;
import dev.top.utils.Avis;

@Service
public class CollegueService{

    @Autowired
    CollegueRepo collegueRepo;

    

    public List<Collegue> findAll(){
        return collegueRepo.findAll();
    }

    public Collegue save(Collegue collegue){
        return collegueRepo.save(collegue);
    }

    public Collegue updateScore(String name, Avis avis){
        Collegue collegue = collegueRepo.findByName(name);
        if(avis == Avis.AIMER){
            collegue.setScore((collegue.getScore()+1));
        }else{
            collegue.setScore((collegue.getScore()-1));
        }
        return collegueRepo.save(collegue);
    }

}