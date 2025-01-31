var express = require('express');
var router = express.Router();
var axios = require('axios'); // Assicurati di avere axios installato per le chiamate API

/* GET home page. */
router.get('/', function(req, res, next) {
  res.render('index', { title: 'Express' });
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