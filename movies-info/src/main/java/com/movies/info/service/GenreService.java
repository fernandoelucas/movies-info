package com.movies.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.movies.info.dto.GenreDTO;
import com.movies.info.entity.Genre;
import com.movies.info.repository.GenreRepository;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre createGenre(GenreDTO genreDTO) {
        Genre genre = new Genre();
        genre.setName(genreDTO.getName());
        genre.setName(genreDTO.getName());


        return createGenre(genre);
    }

    private Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    public Genre getGenreById(Long id) {
        return genreRepository.getOne(id);
    }

    public Genre deleteGenreById(Long id) {
        Genre genre = getGenreById(id);
        genreRepository.delete(genre);
        return genre;
    }

    @Cacheable("genre")
    public List<Genre> getAllGenre() {
        return genreRepository.findAll();
    }
}
