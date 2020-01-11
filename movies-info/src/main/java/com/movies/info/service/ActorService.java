package com.movies.info.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.info.dto.ActorDTO;
import com.movies.info.entity.Actor;
import com.movies.info.repository.ActorRepository;

@Service
public class ActorService {
	
    private static final Logger logger = LoggerFactory.getLogger(ActorService.class);

    private final ActorRepository actorRepository;

    @Autowired
    public ActorService(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    public Actor createActor(ActorDTO actorDTO) {    	
    	logger.info("createActor:"+actorDTO.getName());
        Actor actor = new Actor();
        actor.setName(actorDTO.getName());
        actor.setBirthYear(actorDTO.getBirthYear());
        actor.setBirthPlace(actorDTO.getBirthPlace());
        actor.setMovies(new ArrayList<>());

        return createActor(actor);
    }

    private Actor createActor(Actor actor) {
    	logger.info("createActor:"+actor.getName());
        return actorRepository.save(actor);
    }

    public Actor getActorById(Long id) {
    	logger.info("getActorById:"+id);
        return actorRepository.getOne(id);
    }

    public Actor deleteActorById(Long id) {
    	logger.info("deleteActorById:"+id);    	
        Actor actor = getActorById(id);        
        actorRepository.delete(actor);
        return actor;
    }

    public List<Actor> getAllActor() {
    	logger.info("getAllActor");   
        return actorRepository.findAll();
    }
}
