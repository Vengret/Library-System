package com.project.library.service.entityServices;

import com.project.library.entities.Item;

import java.util.List;

public interface ItemService {
    Item findById(int itemId);
    List<Item> findAll();
    List<Item> findByTitleContainingIgnoreCase(String search);
    List<Item> findByAuthorContainingIgnoreCase(String search);
    List<Item> findByGenreContainingIgnoreCase(String search);
}
