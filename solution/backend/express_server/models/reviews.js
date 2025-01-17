const mongoose = require('mongoose');

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
}, { timestamps: true });

const Review = mongoose.model('Review', reviewSchema);

module.exports = Review;