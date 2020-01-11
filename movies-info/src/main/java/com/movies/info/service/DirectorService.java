package com.movies.info.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.info.dto.DirectorDTO;
import com.movies.info.entity.Director;
import com.movies.info.repository.DirectorRepository;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Director createDirector(DirectorDTO directorDTO) {
        Director director = new Director();
        director.setName(directorDTO.getName());
        director.setBirthYear(directorDTO.getBirthYear());
        director.setBirthPlace(directorDTO.getBirthPlace());
        director.setMovies(new ArrayList<>());

        return createDirector(director);
    }

    private Director createDirector(Director director) {
        return directorRepository.save(director);
    }

    public Director getDirectorById(Long id) {
        return directorRepository.getOne(id);
    }

    public Director deleteDirectorById(Long id) {
        Director director = getDirectorById(id);
        directorRepository.delete(director);
        return director;
    }

    public List<Director> getAllDirector() {
        return directorRepository.findAll();
    }
}
