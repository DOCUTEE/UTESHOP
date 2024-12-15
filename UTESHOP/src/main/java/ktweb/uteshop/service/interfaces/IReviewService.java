package ktweb.uteshop.service.interfaces;

import ktweb.uteshop.entity.Review;
import java.util.List;

public interface IReviewService{

        List<Review> findReviewsAll(int productId);
        void insert(Review review);
        void update(Review review);
        void delete(int reviewId);
        Review findById(int reviewId);

}