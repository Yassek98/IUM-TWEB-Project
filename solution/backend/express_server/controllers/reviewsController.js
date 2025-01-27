const Review = require('../models/reviews');
/**
 * Retrieves reviews by movie title.
 * @param {String} movieTitle - Title of the movie.
 * @returns {Promise} - A promise that resolves with the reviews of the movie or rejects with an error.
 */
function getTenReviewsByMovieTitle(movieTitle) {
    console.log(`Searching for reviews with movie title: ${movieTitle}`);
    return new Promise((resolve, reject) => {
        Review.find({ movie_title: { $regex: new RegExp(movieTitle, 'i') } })
            .limit(10) // Limit the number of reviews to 10
            .then(results => {
                console.log(`Found ${results.length} reviews for movie title: ${movieTitle}`);
                if (results.length > 0) {
                    resolve(results);
                } else {
                    resolve([]);
                }
            })
            .catch(error => {
                console.error(`Error fetching reviews for movie title: ${movieTitle}`, error);
                reject(error);
            });
    });
}

module.exports = { getTenReviewsByMovieTitle };