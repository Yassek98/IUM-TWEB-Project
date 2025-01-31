var express = require('express');
var router = express.Router();

/* GET home page. */
router.get('/', function(req, res, next) {
  const featuredMovies = [
    { id: 1, title: 'Inception', poster: 'images/image2.jpg', rating: 8.8 },
    { id: 2, title: 'The Dark Knight', poster: 'images/image 3.jpg', rating: 9.0 },
    { id: 3, title: 'Interstellar', poster: 'images/image 4.jpg', rating: 8.6 }
  ];
  res.render('pages/home', { title: 'Movie Platform', featuredMovies });
});

// Esempio routing verso Spring Boot
router.get('/api/movies', async (req, res) => {
  try {
    const resp = await axios.get('http://localhost:8080/movies');
    res.json(resp.data);
  } catch(err) {
    res.status(500).json({ error: err.message });
  }
});

// Esempio routing verso mongo_service
router.get('/api/reviews/:filmId', async (req, res) => {
  try {
    const resp = await axios.get(`http://localhost:3001/reviews/${req.params.filmId}`);
    res.json(resp.data);
  } catch(err) {
    res.status(500).json({ error: err.message });
  }
});

module.exports = router;