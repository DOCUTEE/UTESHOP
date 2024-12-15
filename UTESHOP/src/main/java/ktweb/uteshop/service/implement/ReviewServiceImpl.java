package ktweb.uteshop.service.implement;

import ktweb.uteshop.DAO.implement.ReviewDAOImpl;
import ktweb.uteshop.entity.Review;
import ktweb.uteshop.service.interfaces.IReviewService;

import java.util.List;

public class ReviewServiceImpl implements IReviewService {


    @Override
    public List<Review> findReviewsAll(int productId) {
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl();
        return reviewDAO.findReviewsAll(productId);
    }
    @Override
    public void insert(Review review) {
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl();
        reviewDAO.insert(review);
    }

    @Override
    public void update(Review review) {
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl();
        reviewDAO.update(review);
    }

    @Override
    public void delete(int reviewId) {
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl();
        reviewDAO.delete(reviewId);
    }

    @Override
    public Review findById(int reviewId) {
        ReviewDAOImpl reviewDAO = new ReviewDAOImpl();
        return reviewDAO.findById(reviewId);
    }
}
