package com.movies.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.movies.info.dto.GenreDTO;
import com.movies.info.entity.Genre;
import com.movies.info.service.GenreService;
@RestController
@RequestMapping(value = "/genre")
public class GenreController {
	
    private final GenreService genreService;
	
    @Autowired
    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

	
    @PreAuthorize("hasRole('USER')")
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<Genre> createGenre(@RequestBody GenreDTO genreDTO) {
        Genre genre = genreService.createGenre(genreDTO);
        return ResponseEntity.ok(genre);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Genre> getGenreById(@PathVariable("id") Long id) {
        Genre genre = genreService.getGenreById(id);
        return ResponseEntity.ok(genre);
    }

    @PreAuthorize("hasRole('USER')")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Genre> deleteGenreById(@PathVariable("id") Long id) {
        Genre genre = genreService.deleteGenreById(id);
        return ResponseEntity.ok(genre);
    }

}
