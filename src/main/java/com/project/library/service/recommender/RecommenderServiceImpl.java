package com.project.library.service.recommender;

import com.project.library.entities.Item;
import com.project.library.service.entityServices.ItemService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.impl.model.jdbc.MySQLJDBCDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.NearestNUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericBooleanPrefUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.LogLikelihoodSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import org.apache.mahout.cf.taste.similarity.UserSimilarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecommenderServiceImpl implements RecommenderService {

    // Autowire required services
    private DataSource dataSource;
    private ItemService itemService;
    @Autowired
    public RecommenderServiceImpl(DataSource theDataSource, ItemService theItemService){
        dataSource = theDataSource;
        itemService = theItemService;
    }

    // returns list of recommended items
    @Override
    public List<Item> getRecommendedBooks(int userId) throws TasteException {

        // Create DataModel with review data
        DataModel model = new MySQLJDBCDataModel(dataSource, "review", "user_id", "item_id", "preference", null);

        // Create similarity
        // This object is used by the recommender for its algorithm for comparing two numbers
        UserSimilarity similarity = new LogLikelihoodSimilarity(model);

        // Create neighborhood
        // Determines which users and how many to compare the current user to
        // Similar to KNN.
        UserNeighborhood neighborhood = new NearestNUserNeighborhood(5, similarity, model); //Adjust N to adjust how many similar users to compare the current user to

        // Create recommender
        // uses our model, neighborhood, and similarity to create a recommender
        UserBasedRecommender recommender = new GenericBooleanPrefUserBasedRecommender(model, neighborhood, similarity);

        // Get list of recommended items
        List<RecommendedItem> recommendations = recommender.recommend(userId, 10); // adjust i to change number of recommended items

        // create list of Items from list of RecommendedItem (a Mahout specific object, not an actual Item object)
        List<Item> recommendedItems = new ArrayList<>();
        for (RecommendedItem recommendation : recommendations){
            int itemId = (int) recommendation.getItemID();
            recommendedItems.add(itemService.findById(itemId));
        }


        // return list
        return recommendedItems;
    }
}
