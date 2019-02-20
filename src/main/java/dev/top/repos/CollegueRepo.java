package dev.top.repos;

import dev.top.entities.Collegue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegueRepo extends JpaRepository<Collegue, Integer> {

    public Collegue findByName(String name);
}
