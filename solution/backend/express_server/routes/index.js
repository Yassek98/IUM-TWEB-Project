var express = require('express');
var router = express.Router();
const Review = require('../models/reviews');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/* GET reviews from MongoDB by movie title with fuzzy search. */
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
});

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
