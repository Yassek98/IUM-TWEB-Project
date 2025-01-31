var express = require('express');
var router = express.Router();
var axios = require('axios'); // Assicurati di avere axios installato per le chiamate API

/* GET home page. */
router.get('/', function(req, res, next) {
  const featuredMovies = [
    { id: 1, title: 'Inception', poster: '/images/image 5.jpg', rating: 8.8 },
    { id: 2, title: 'The Dark Knight', poster: '/images/image 3.jpg', rating: 9.0 },
    { id: 3, title: 'Interstellar', poster: '/images/image 4.jpg', rating: 8.6 }
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

// Aggiungi route per la pagina del Film
router.get('/film/:movieId', function(req, res, next) {
  res.render('film', { movieId: req.params.movieId }); // Passa movieId alla vista del film
});

// Aggiungi route per la pagina dell'Attore
router.get('/actor/:actorId', function(req, res, next) {
  res.render('actor', { actorId: req.params.actorId }); // Passa actorId alla vista dell'attore
});

module.exports = router;