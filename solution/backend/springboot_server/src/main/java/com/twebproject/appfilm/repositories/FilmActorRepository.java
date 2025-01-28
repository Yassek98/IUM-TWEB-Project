package com.twebproject.appfilm.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.twebproject.appfilm.models.filmactors.FilmActor;
import com.twebproject.appfilm.models.filmactors.FilmActorId;

/**
 * Repository interface for accessing FilmActor entities from the database.
 */
@Repository
public interface FilmActorRepository extends JpaRepository<FilmActor, FilmActorId> {

    /**
     * Finds FilmActor entities by actor name containing the specified string, ignoring case.
     *
     * @param actorName the string to search for in actor names
     * @return a list of FilmActor entities with actor names containing the specified string
     */
    List<FilmActor> findByIdActorName(String actorName);

    
}