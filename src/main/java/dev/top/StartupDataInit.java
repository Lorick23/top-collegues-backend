package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Component
public class StartupDataInit {

    @Autowired
    CollegueRepo collegueRepo;

    @EventListener(ContextRefreshedEvent.class)
    public void init() {

        this.collegueRepo.save(new Collegue("Mario",
                "http://media.topito.com/wp-content/uploads/2015/01/kim-jong-un-pop-culture-2.jpg", 0));
        this.collegueRepo.save(new Collegue("Double-Face",
                "http://redbuzz.fr/wp-content/uploads/2015/01/kim-jong-un-pop-culture-24.jpg", 0));
        this.collegueRepo
                .save(new Collegue("Spider-Man", "http://static.mensup.fr/photos/150582/carre-spider-kim.jpg", 0));
        this.collegueRepo.save(new Collegue("Pikachu",
                "https://i.pinimg.com/originals/03/d9/d7/03d9d7937f6e40670e68f01f352fc425.png", 0));

    }
}
