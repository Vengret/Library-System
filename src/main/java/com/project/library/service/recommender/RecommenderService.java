package com.project.library.service.recommender;

import com.project.library.entities.Item;
import org.apache.mahout.cf.taste.common.TasteException;

import java.util.List;

public interface RecommenderService {
    List<Item> getRecommendedBooks(int userId) throws TasteException;
}
