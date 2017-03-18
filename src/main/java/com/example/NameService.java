package com.example;

import com.example.entities.Name;
import com.example.repo.NameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NameService {
    private final NameRepository repository;

    @Autowired
    public NameService(NameRepository repository) {
        this.repository = repository;
    }

    List<Name> getNames(String myname) {
        return repository.findByTitleStartingWith(myname);
    }
}