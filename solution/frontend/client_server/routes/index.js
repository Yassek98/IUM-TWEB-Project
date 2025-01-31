var express = require('express');
var router = express.Router();

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

module.exports = router;