package com.example.repo;

import com.example.entities.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by PatrykGrudnik on 12.03.2017.
 */
@Repository
public interface NameRepository extends JpaRepository<Name,Integer> {
    List<Name> findByTitleStartingWith(String title);
}
