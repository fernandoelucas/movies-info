package com.movies.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.info.dto.DirectorDTO;
import com.movies.info.entity.Director;
import com.movies.info.service.DirectorService;

@RestController
@RequestMapping(value = "/director")
public class DirectorController {

    private final DirectorService directorService;

    @Autowired
    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Director> createDirector(@RequestBody DirectorDTO directorDTO) {
        Director director = directorService.createDirector(directorDTO);
        return ResponseEntity.ok(director);
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Director> getDirectorById(@PathVariable("id") Long id) {
        Director director = directorService.getDirectorById(id);
        return ResponseEntity.ok(director);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Director> deleteDirectorById(@PathVariable("id") Long id) {
        Director director = directorService.deleteDirectorById(id);
        return ResponseEntity.ok(director);
    }
}
