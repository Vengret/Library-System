package com.project.library.DAOs;

import com.project.library.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByTitleContainingIgnoreCase(String search);
    List<Item> findByAuthorContainingIgnoreCase(String search);
    List<Item> findByGenreContainingIgnoreCase(String search);
}
