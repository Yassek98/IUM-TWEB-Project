const mongoose = require('mongoose');

/**
 * Mongoose schema for reviews.
 * @typedef {Object} Review
 * @property {String} rotten_tomatoes_link - Link to the Rotten Tomatoes page.
 * @property {String} movie_title - Title of the movie.
 * @property {String} critic_name - Name of the critic.
 * @property {Boolean} top_critic - Whether the critic is a top critic.
 * @property {String} publisher_name - Name of the publisher.
 * @property {String} review_type - Type of the review.
 * @property {String} review_score - Score given in the review.
 * @property {Date} review_date - Date of the review.
 * @property {String} review_content - Content of the review.
 */
const reviewSchema = new mongoose.Schema({
    rotten_tomatoes_link: { type: String, required: true },
    movie_title: { type: String, required: true },
    critic_name: { type: String, required: true },
    top_critic: { type: Boolean },
    publisher_name: { type: String, required: true },
    review_type: { type: String },
    review_score: { type: String },
    review_date: { type: Date, required: true },
    review_content: { type: String }
});

const Review = mongoose.model('Review', reviewSchema);

module.exports = Review;