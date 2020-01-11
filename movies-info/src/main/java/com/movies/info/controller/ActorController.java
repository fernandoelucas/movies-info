package com.movies.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.info.dto.ActorDTO;
import com.movies.info.entity.Actor;
import com.movies.info.service.ActorService;

@RestController
@RequestMapping(value = "/actor ")
public class ActorController {

    private final ActorService actorService;

    @Autowired
    public ActorController(ActorService actorService) {
        this.actorService = actorService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Actor> createActor(@RequestBody ActorDTO actorDTO) {
        Actor actor = actorService.createActor(actorDTO);
        return ResponseEntity.ok(actor);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Actor> getActorById(@PathVariable("id") Long id) {
        Actor actor = actorService.getActorById(id);
        return ResponseEntity.ok(actor);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Actor> deleteActorById(@PathVariable("id") Long id) {
        Actor actor = actorService.deleteActorById(id);
        return ResponseEntity.ok(actor);
    }
}
