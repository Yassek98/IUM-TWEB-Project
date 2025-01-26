var express = require('express');
var router = express.Router();
const Review = require('../models/reviews');

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
});

/* GET reviews from MongoDB. */
router.get('/reviews', async function(req, res, next) {
  try {
    const reviews = await Review.find().limit(10);
    res.json(reviews);
  } catch (error) {
    next(error);
  }
});

module.exports = router;
