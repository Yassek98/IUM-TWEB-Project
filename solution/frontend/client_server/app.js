const express = require('express');
const exphbs = require('express-handlebars');
const path = require('path');
const logger = require('morgan');

var indexRouter = require('./routes/index');

const app = express();

// Configura Handlebars come view engine
app.engine('hbs', exphbs.engine({
    extname: '.hbs',
    layoutsDir: path.join(__dirname, 'views/layouts'),
    defaultLayout: 'main',  // layout di default
    partialsDir: path.join(__dirname, 'views/partials') // Directory per i partials
}));
app.set('view engine', 'hbs');
app.set('views', path.join(__dirname, 'views'));

// Middleware
app.use(logger('dev')); // Log di Morgan per lo sviluppo
app.use(express.json());
app.use(express.urlencoded({ extended: false }));
app.use('/static', express.static(path.join(__dirname, 'public')));

// Routes
app.use('/', indexRouter);

// Error handling
app.use(function(req, res, next) {
    const err = new Error('Not Found');
    err.status = 404;
    next(err);
});

// error handler
app.use(function(err, req, res, next) {
    res.locals.message = err.message;
    res.locals.error = req.app.get('env') === 'development' ? err : {};

    // render the error page
    res.status(err.status || 500);
    res.render('error');
});

module.exports = app;
