package com.example.repo;

import com.example.entities.Name;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by PatrykGrudnik on 12.03.2017.
 */
public interface NameRepository extends JpaRepository<Name,Integer> {
    List<Name> findByNameStartingWith(String name);
}
