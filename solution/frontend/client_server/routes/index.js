var express = require('express');
var router = express.Router();
var axios = require('axios'); // Assicurati di avere axios installato per le chiamate API

/* GET home page. */
router.get('/', function(req, res, next) {
  const featuredMovies = [
    { id: 1, title: 'Inception', poster: '/images/image 5.jpg', rating: 8.8, tagline: 'Your mind is the scene of the crime.', year: 2010, duration: 148, description: 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.' },
    { id: 2, title: 'The Dark Knight', poster: '/images/image 3.jpg', rating: 9.0, tagline: 'Why So Serious?', year: 2008, duration: 152, description: 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.' },
    { id: 3, title: 'Interstellar', poster: '/images/image 4.jpg', rating: 8.6, tagline: 'Mankind was born on Earth. It was never meant to die here.', year: 2014, duration: 169, description: 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.' },
    { id: 4, title: 'The Matrix', poster: '/images/image 6.jpg', rating: 8.7, tagline: 'Welcome to the Real World.', year: 1999, duration: 136, description: 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.' },
    { id: 5, title: 'Fight Club', poster: '/images/image 7.jpg', rating: 8.8, tagline: 'Mischief. Mayhem. Soap.', year: 1999, duration: 139, description: 'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into something much, much more.' },
    { id: 6, title: 'Pulp Fiction', poster: '/images/image 8.jpg', rating: 8.9, tagline: 'Just because you are a character doesn\'t mean you have character.', year: 1994, duration: 154, description: 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.' },
    { id: 7, title: 'Forrest Gump', poster: '/images/image 9.jpg', rating: 8.8, tagline: 'Life is like a box of chocolates...you never know what you\'re gonna get.', year: 1994, duration: 142, description: 'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other historical events unfold from the perspective of an Alabama man with an IQ of 75.' },
    { id: 8, title: 'The Lord of the Rings: The Return of the King', poster: '/images/image 10.jpg', rating: 8.9, tagline: 'The eye of the enemy is moving.', year: 2003, duration: 201, description: 'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.' },
    { id: 9, title: 'The Shawshank Redemption', poster: '/images/image 11.jpg', rating: 9.3, tagline: 'Fear can hold you prisoner. Hope can set you free.', year: 1994, duration: 142, description: 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.' },
    { id: 10, title: 'The Godfather', poster: '/images/image 12.jpg', rating: 9.2, tagline: 'An offer you can\'t refuse.', year: 1972, duration: 175, description: 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.' }
  ];
  function groupArray(array, groupSize) {
    const groups = [];
    for (let i = 0; i < array.length; i += groupSize) {
      groups.push(array.slice(i, i + groupSize));
    }
    // Se l'ultimo gruppo non è completo, riempilo con i primi elementi
    if (groups.length && groups[groups.length - 1].length < groupSize) {
      const needed = groupSize - groups[groups.length - 1].length;
      groups[groups.length - 1] = groups[groups.length - 1].concat(array.slice(0, needed));
    }
    return groups;
  }
  const groupedFeaturedMovies = groupArray(featuredMovies, 4);
  res.render('pages/home', { title: 'Movie Platform', groupedFeaturedMovies });
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
  const featuredMovies = [
    { id: 1, title: 'Inception', poster: '/images/image 5.jpg', rating: 8.8, tagline: 'Your mind is the scene of the crime.', year: 2010, duration: 148, description: 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.' },
    { id: 2, title: 'The Dark Knight', poster: '/images/image 3.jpg', rating: 9.0, tagline: 'Why So Serious?', year: 2008, duration: 152, description: 'When the menace known as the Joker emerges from his mysterious past, he wreaks havoc and chaos on the people of Gotham.' },
    { id: 3, title: 'Interstellar', poster: '/images/image 4.jpg', rating: 8.6, tagline: 'Mankind was born on Earth. It was never meant to die here.', year: 2014, duration: 169, description: 'A team of explorers travel through a wormhole in space in an attempt to ensure humanity\'s survival.' },
    { id: 4, title: 'The Matrix', poster: '/images/image 6.jpg', rating: 8.7, tagline: 'Welcome to the Real World.', year: 1999, duration: 136, description: 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.' },
    { id: 5, title: 'Fight Club', poster: '/images/image 7.jpg', rating: 8.8, tagline: 'Mischief. Mayhem. Soap.', year: 1999, duration: 139, description: 'An insomniac office worker and a devil-may-care soap maker form an underground fight club that evolves into something much, much more.' },
    { id: 6, title: 'Pulp Fiction', poster: '/images/image 8.jpg', rating: 8.9, tagline: 'Just because you are a character doesn\'t mean you have character.', year: 1994, duration: 154, description: 'The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.' },
    { id: 7, title: 'Forrest Gump', poster: '/images/image 9.jpg', rating: 8.8, tagline: 'Life is like a box of chocolates...you never know what you\'re gonna get.', year: 1994, duration: 142, description: 'The presidencies of Kennedy and Johnson, the events of Vietnam, Watergate, and other historical events unfold from the perspective of an Alabama man with an IQ of 75.' },
    { id: 8, title: 'The Lord of the Rings: The Return of the King', poster: '/images/image 10.jpg', rating: 8.9, tagline: 'The eye of the enemy is moving.', year: 2003, duration: 201, description: 'Gandalf and Aragorn lead the World of Men against Sauron\'s army to draw his gaze from Frodo and Sam as they approach Mount Doom with the One Ring.' },
    { id: 9, title: 'The Shawshank Redemption', poster: '/images/image 11.jpg', rating: 9.3, tagline: 'Fear can hold you prisoner. Hope can set you free.', year: 1994, duration: 142, description: 'Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.' },
    { id: 10, title: 'The Godfather', poster: '/images/image 12.jpg', rating: 9.2, tagline: 'An offer you can\'t refuse.', year: 1972, duration: 175, description: 'The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.' }
  ];
  const movie = featuredMovies.find(m => m.id == req.params.movieId);
  const reviews = [
    { title: 'Amazing!', content: 'This movie was absolutely amazing!', author: 'John Doe' },
    { title: 'Loved it', content: 'I loved every moment of this movie.', author: 'Jane Smith' }
  ];
  // Passa dei dati fittizi per il cast (senza immagini)
  const cast = [
    { name: 'Leonardo DiCaprio', character: 'Cobb' },
    { name: 'Joseph Gordon-Levitt', character: 'Arthur' },
    { name: 'Elliot Page', character: 'Ariadne' },
    { name: 'Tom Hardy', character: 'Eames' },
    { name: 'Ken Watanabe', character: 'Saito' },
    { name: 'Dileep Rao', character: 'Yusuf' },
    { name: 'Cillian Murphy', character: 'Robert Fischer' },
    { name: 'Marion Cotillard', character: 'Mal' },
    { name: 'Michael Caine', character: 'Miles' },
    { name: 'Pete Postlethwaite', character: 'Maurice Fischer' }
  ];
  // Aggiungi dati fittizi per la crew (senza immagini)
  const crew = [
    { name: 'Christopher Nolan', job: 'Director' },
    { name: 'Hans Zimmer', job: 'Music Composer' },
    { name: 'Lee Smith', job: 'Editor' },
    { name: 'Wally Pfister', job: 'Cinematographer' },
    { name: 'Emma Thomas', job: 'Producer' },
    { name: 'Jordan Goldberg', job: 'Executive Producer' },
    { name: 'Lynda Obst', job: 'Producer' },
    { name: 'Chris Brigham', job: 'Executive Producer' },
    { name: 'Thomas Tull', job: 'Executive Producer' },
    { name: 'Zakaria Alaoui', job: 'Line Producer' }
  ];
  // Aggiungi dati fittizi per gli Oscar
  const oscars = [
    { category: 'Best Picture', year: 2010, result: 'Won' },
    { category: 'Best Director', year: 2010, result: 'Nominated' },
    { category: 'Best Original Screenplay', year: 2010, result: 'Nominated' }
  ];
  res.render('pages/film', { movie, reviews, cast, crew, oscars });
});

// Aggiungi route per la pagina dell'Attore
router.get('/actor/:actorId', function(req, res, next) {
  res.render('actor', { actorId: req.params.actorId }); // Passa actorId alla vista dell'attore
});

// Aggiungi route per la pagina delle statistiche
router.get('/statistics', function(req, res, next) {
  res.render('pages/statistics', { title: 'Statistics' });
});

module.exports = router;