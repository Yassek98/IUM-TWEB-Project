var express = require('express');
var router = express.Router();
const reviewController = require('../controllers/reviewsController');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/**
 * Route to get reviews by movie title.
 * @name GET/reviews/:movieTitle
 * @function
 * @param {string} path - Endpoint of the route ("/reviews/:movieTitle").
 * @param {callback} middleware - Asynchronous function to handle the request and response.
 * @throws {Error} - Returns a 500 status if an error occurs during the request.
 */
router.get('/reviews/:movieTitle', (req, res) => {
  const movieTitle = req.params.movieTitle;
  reviewController.getTenReviewsByMovieTitle(movieTitle)
      .then(reviews => {
        if (reviews && reviews.length > 0) {
          res.status(200).json(reviews);
        } else {
          res.status(404).json({ error: 'No reviews found for the specified movie title' });
        }
      })
      .catch(error => {
        console.error('Error fetching reviews:', error);
        res.status(500).json({ error: 'An error occurred while fetching the reviews' });
      });
});

module.exports = router;






/* GET reviews from MongoDB by movie title with fuzzy search.
router.get('/reviews/:movieTitle', async (req, res, next) => {
  try {
    const movieTitle = req.params.movieTitle;
    const reviews = await Review.find({
      movie_title: { $regex: new RegExp(movieTitle, 'i') }
    });
    res.json(reviews);
  } catch (err) {
    next(err);
    res.status(500).json({ error: err.message });
  }
}); */

/* POST a new review to MongoDB. */
router.post('/reviews', async (req, res, next) => {
  try {
    const newReview = new Review(req.body);
    await newReview.save();
    res.json(newReview);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;
