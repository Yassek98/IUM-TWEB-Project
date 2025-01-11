const express = require('express');
const cors = require('cors');

const app = express();
app.use(cors());
app.use(express.json());

app.use(express.static('frontend/public'));

const moviesRouter = require('./routes/movies');
const reviewsRouter = require('./routes/reviews');

app.use('/movies', moviesRouter);
app.use('/reviews', reviewsRouter);

app.get('/', (req, res) => {
    res.send({ status: 'Server is running' });
});

app.listen(3000, () => console.log('Server running on http://localhost:3000'));